package com.ai.ats;


import com.ai.ats.dto.JobDTO;
import com.ai.ats.mapper.JobMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ai.ats.repository")
public class AtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtsApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		ModelMapper modelMapperBean = new ModelMapper();
		modelMapperBean.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapperBean;
	}



}

