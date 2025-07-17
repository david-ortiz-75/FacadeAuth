package com.task.takehome.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Permission {

    private Integer userId;
    private String action;
    private String resource;
}
