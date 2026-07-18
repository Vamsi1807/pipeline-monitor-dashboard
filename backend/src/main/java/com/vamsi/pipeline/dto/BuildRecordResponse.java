package com.vamsi.pipeline.dto;

import com.vamsi.pipeline.enums.BuildStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BuildRecordResponse {

    private Long id;

    private String jobName;

    private Integer buildNumber;

    private BuildStatus status;

    private Long duration;

    private String branch;

    private String commitId;

    private LocalDateTime buildTime;

    private String buildUrl;

    private String consoleUrl;

    private String message;
}