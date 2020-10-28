package com.jobs.opportunities.controller;

import com.jobs.opportunities.dto.*;
import com.jobs.opportunities.utils.TransformData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class JobOpportunityController {
    @Autowired
    private RestTemplate restTemplate;

    public JobOpportunityController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("jobOpportunitySearch", new JobOpportunitySearch());
        return "main";
    }

    @PostMapping("/main")
    public String searchSubmit(@ModelAttribute JobOpportunitySearch request, Model model) {
        model.addAttribute("response", postJobOpportunities(request));
        return "result";
    }


    private JsonHolderResponse postJobOpportunities(JobOpportunitySearch search) {
        TransformData transformData = new TransformData();
        String url = "https://search.torre.co/opportunities/_search/?size=" + search.getSize() + "&aggregate=false&offset=0";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        JobOpportunityRequest request = new JobOpportunityRequest();
        request.setSkillRole(new SkillRole(search.getSearchTerm(), "potential-to-develop"));
        List<SearchTerm> searchTermsList = new ArrayList<>();
        searchTermsList.add(new SearchTerm(new Remote(search.getRemote())));
        searchTermsList.add(new SearchTerm(new CompensationRange(search.getMinAmmount(), search.getMaxAmmount(), "USD$", "hourly")));
        request.setAnd(searchTermsList);

        HttpEntity<JobOpportunityRequest> httpEntity = new HttpEntity<>(request, headers);
        JsonHolder response = restTemplate.postForObject(url, httpEntity, JsonHolder.class);
        String jsonResponse = transformData.transformString(response.getResults());
        JsonHolderResponse jsonHolderResponse = new JsonHolderResponse(jsonResponse);
        return jsonHolderResponse;
    }
}
