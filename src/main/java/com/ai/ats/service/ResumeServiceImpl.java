package com.ai.ats.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.analysis.TokenFilter;
import co.elastic.clients.elasticsearch._types.query_dsl.TextQueryType;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.AnalyzeResponse;
import co.elastic.clients.elasticsearch.indices.analyze.AnalyzeToken;
import com.ai.ats.entities.Resume;
import com.ai.ats.models.ResumeSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ResumeServiceImpl implements ResumeService {

    private final ElasticsearchClient elasticsearchClient;

    private static final String RESUME_INDEX = "resumes";

    @Autowired
    public ResumeServiceImpl(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    public boolean bulkInsertResumes(List<Resume> resumeList) throws IOException {
        BulkRequest.Builder br = new BulkRequest.Builder();
        for (Resume doc : resumeList) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index(RESUME_INDEX)
                            .id(doc.getId())
                            .document(doc))
            );
        }
        BulkResponse bulkResponse = elasticsearchClient.bulk(br.build());


        // Log errors, if any
        if (bulkResponse.errors()) {
            log.error("Bulk had errors");
            return false;
        } else {
            log.info("Bulk Indexing for document is successfully done.");
            return true;
        }
    }

    public List<ResumeSearchResponse> searchResumes(String search) throws IOException {

        List<ResumeSearchResponse> matchedResumeList = new ArrayList<>();

        List<TokenFilter> listoftokenfilter = new ArrayList<>();
        listoftokenfilter.add(TokenFilter.of(tf -> tf.definition(tfd -> tfd.stop(stopf -> stopf.stopwords("a", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is",
                "it", "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there",
                "these", "they", "this", "to", "was", "will", "with")))));
        listoftokenfilter.add(
                TokenFilter.of(tf -> tf
                        .definition(tfd -> tfd
                                .stemmer(stv -> stv
                                        .language("english")
                                )
                        )
                )

        );
//        listoftokenfilter.add(TokenFilter.of(tf -> tf
//                        .definition(tfd -> tfd
//                                .lowercase(lw -> lw
//                                        .language("")
//                                )
//                        )
//                )
//        );

        AnalyzeResponse analyzeResponse =
                elasticsearchClient.indices()
                        .analyze(ar -> ar
                                .text(search)
                                .tokenizer(tok -> tok.definition(tdf -> tdf.standard(stdt -> stdt.maxTokenLength(255))))
                                .filter(listoftokenfilter)
//                                .filter("lowercase")
                        );

        log.info(analyzeResponse.tokens().stream().map(AnalyzeToken::token).collect(Collectors.joining(", ")));

        SearchRequest searchRequest = SearchRequest.of(s -> s
                .index(RESUME_INDEX)
                .query(q -> q
                        .functionScore(fs -> fs
                                .query(qry -> qry
                                        .bool(b -> b
                                                .should(shd -> shd
                                                        .multiMatch(t -> t
                                                                .fields("skills", "experience.responsibilities")
                                                                .type(TextQueryType.MostFields)
                                                                .query(search)
                                                        )
                                                )
                                        )
                                )
                                .maxBoost(5.0)
                        )
                )
        );

        log.info(search);

        SearchResponse<Resume> searchResponse = elasticsearchClient.search(searchRequest, Resume.class);
        long totalSizeCount;
        if (null != searchResponse) {
            assert searchResponse.hits().total() != null;
            totalSizeCount = searchResponse.hits().total().value();
            log.info(String.valueOf(totalSizeCount));
            List<Hit<Resume>> hits = searchResponse.hits().hits();
            for (Hit<Resume> object : hits) {
                log.info("page id -> {}", object.id());
                log.info("page score -> {}", object.score());
                ResumeSearchResponse dto = new ResumeSearchResponse(
                        object.id(),
                        object.source().getName(),
                        object.source().getEmail(),
                        object.source().getPhone(),
                        object.source().getAddress(),
                        object.source().getSummary(),
                        object.source().getSkills(),
                        object.source().getExperience(),
                        object.source().getEducation()
                );
                matchedResumeList.add(dto);
            }
        }
        return matchedResumeList;
    }
}
