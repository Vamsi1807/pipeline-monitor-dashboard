package com.vamsi.pipeline.dto;

import java.time.LocalDateTime;

public class LatestBuildDTO {

    private Long id;
    private String jobName;
    private Integer buildNumber;
    private String status;
    private String branch;
    private String commitId;
    private LocalDateTime buildTime;
    private Long duration;

    public LatestBuildDTO() {
    }

    public LatestBuildDTO(Long id,
                          String jobName,
                          Integer buildNumber,
                          String status,
                          String branch,
                          String commitId,
                          LocalDateTime buildTime,
                          Long duration) {

        this.id = id;
        this.jobName = jobName;
        this.buildNumber = buildNumber;
        this.status = status;
        this.branch = branch;
        this.commitId = commitId;
        this.buildTime = buildTime;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getJobName() {
        return jobName;
    }

    public Integer getBuildNumber() {
        return buildNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getBranch() {
        return branch;
    }

    public String getCommitId() {
        return commitId;
    }

    public LocalDateTime getBuildTime() {
        return buildTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setBuildNumber(Integer buildNumber) {
        this.buildNumber = buildNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setCommitId(String commitId) {
        this.commitId = commitId;
    }

    public void setBuildTime(LocalDateTime buildTime) {
        this.buildTime = buildTime;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }
}