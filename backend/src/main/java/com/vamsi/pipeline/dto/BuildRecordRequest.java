package com.vamsi.pipeline.dto;

import com.vamsi.pipeline.enums.BuildStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BuildRecordRequest {

    @NotBlank
    private String jobName;

    @NotNull
    private Integer buildNumber;

    @NotNull
    private BuildStatus status;

    @NotNull
    private Long duration;

    @NotBlank
    private String branch;

    @NotBlank
    private String commitId;

    @NotBlank
    private String buildUrl;

    @NotBlank
    private String consoleUrl;
}