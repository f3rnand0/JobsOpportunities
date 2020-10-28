package com.jobs.opportunities.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class JsonHolder {
    @Getter
    @Setter
    private List<JobOpportunity> results;
}
