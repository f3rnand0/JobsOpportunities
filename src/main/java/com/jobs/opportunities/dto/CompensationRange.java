package com.jobs.opportunities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class CompensationRange {
    @Getter
    @Setter
    private Number minAmmount;
    @Getter
    @Setter
    private Number maxAmmount;
    @Getter
    @Setter
    private String currency;
    @Getter
    @Setter
    private String periodicity;
}
