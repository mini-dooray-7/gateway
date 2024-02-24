package com.nhnacademy.mini.dooray.task.domain.dto;

import com.nhnacademy.mini.dooray.task.domain.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectMemberInfoDto {
    String userId;
    RoleType projectUserRole;
}
