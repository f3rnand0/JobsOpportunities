package com.jobs.opportunities.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class JobOpportunityRequest {
    @Getter
    @Setter
    private SkillRole skillRole;
    @Getter
    @Setter
    private List<SearchTerm> and;
}
