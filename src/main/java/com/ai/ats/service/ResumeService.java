package com.ai.ats.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.ai.ats.entities.Resume;
import com.ai.ats.models.ResumeDto;
import com.ai.ats.models.ResumeSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ResumeService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    private static final String RESUME_INDEX = "resumes";

    public boolean bulkInsertResumes(List<Resume> resumeList) throws IOException {
        BulkRequest.Builder builder = new BulkRequest.Builder();
        resumeList.forEach(resume -> builder.operations(op -> op
                .index(i -> i
                        .index(RESUME_INDEX)
                        .id(String.valueOf(resume.getId()))
                        .document(resume)))
        );
        BulkResponse bulkResponse = elasticsearchClient.bulk(builder.build());


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

        SearchRequest searchRequest = SearchRequest.of(s -> s
                .index(RESUME_INDEX)
                .query(q -> q
                        .multiMatch(t -> t
                                .fields("name")
                                .query(search)
                        )
                )
        );
        SearchResponse<Resume> searchResponse = elasticsearchClient.search(searchRequest, Resume.class);
        long total_size_count = 0;
        if (null != searchResponse) {
            total_size_count = searchResponse.hits().total().value();
            List<Hit<Resume>> hits = searchResponse.hits().hits();
            for (Hit<Resume> object : hits) {
                log.info("page id -> {}", object.id());
                log.info("page score -> {}", object.score());
                ResumeSearchResponse dto = new ResumeSearchResponse(object.id(), object.source().getName(), object.source().getEmail(),
                        object.source().getPhone(), object.source().getSkills(), object.source().getExperiences(), object.source().getEducations());
                matchedResumeList.add(dto);
            }
        }

        return matchedResumeList;

    }
}
