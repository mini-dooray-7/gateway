package com.nhnacademy.mini.dooray.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Milestone {
    private Long milestoneId;
    private Long projectId;
    private String milestoneName;
}