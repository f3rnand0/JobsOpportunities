package com.jobs.opportunities;

import com.jobs.opportunities.dto.JobOpportunityRequest;
import com.jobs.opportunities.dto.JsonHolder;
import com.jobs.opportunities.dto.SkillRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@SpringBootApplication
public class JobsOpportunitiesApplication {

	private static final Logger log = LoggerFactory.getLogger(JobsOpportunitiesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JobsOpportunitiesApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String url = "https://search.torre.co/opportunities/_search/?size=20&aggregate=false&offset=0";
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

			JobOpportunityRequest request = new JobOpportunityRequest();
			request.setSkillRole(new SkillRole("java", "potential-to-develop"));

			HttpEntity<JobOpportunityRequest> httpEntity = new HttpEntity<>(request, headers);
			JsonHolder response = restTemplate.postForObject(url, httpEntity, JsonHolder.class);

			System.out.println(response.getResults());
//			log.info(response.getResults().toString());
		};
	}
}
