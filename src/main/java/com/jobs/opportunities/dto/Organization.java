package com.jobs.opportunities.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Organization {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String picture;
}
