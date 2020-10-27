package com.jobs.com.jobs.opportunities.dto;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Data {
    @Getter
    @Setter
    private String currency;
    @Getter
    @Setter
    private Number minAmount;
    @Getter
    @Setter
    private Number maxAmount;
    @Getter
    @Setter
    private String periodicity;
}
