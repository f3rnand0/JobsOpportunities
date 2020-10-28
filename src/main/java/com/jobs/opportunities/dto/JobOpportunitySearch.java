package com.jobs.opportunities.dto;

import lombok.Getter;
import lombok.Setter;

public class JobOpportunitySearch {
    @Getter
    @Setter
    private String searchTerm;
    @Getter
    @Setter
    private String size;
    @Getter
    @Setter
    private Boolean remote;
    @Getter
    @Setter
    private Number minAmmount;
    @Getter
    @Setter
    private Number maxAmmount;
}
