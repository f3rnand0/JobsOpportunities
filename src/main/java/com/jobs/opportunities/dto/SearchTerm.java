package com.jobs.opportunities.dto;

import lombok.Getter;
import lombok.Setter;

public class SearchTerm {
    @Getter
    @Setter
    private Remote remote;
    @Getter
    @Setter
    private CompensationRange compensationrange;

    public SearchTerm(Remote remote) {
        this.remote = remote;
    }

    public SearchTerm(CompensationRange compensationrange) {
        this.compensationrange = compensationrange;
    }
}
