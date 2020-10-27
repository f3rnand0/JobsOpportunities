package com.jobs.com.jobs.opportunities.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

public class JsonHolder {
    @Getter
    @Setter
    private List<JobOpportunity> results;
//    private Object paging; // You can use custom type too.
}
