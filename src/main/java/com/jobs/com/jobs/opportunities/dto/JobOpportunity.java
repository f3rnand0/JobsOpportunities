package com.jobs.com.jobs.opportunities.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@ToString
public class JobOpportunity {

    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String objective;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private List<Organization> organizations;
    @Getter
    @Setter
    private List<String> locations;
    @Getter
    @Setter
    private Boolean remote;
    @Getter
    @Setter
    private String deadline;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private Compensation compensation;
    @Getter
    @Setter
    private List<Skill> skills;
}
