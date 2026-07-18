package com.vamsi.pipeline.dto;

public class ProjectSummaryDTO {

    private String projectName;

    private long totalBuilds;

    private long successfulBuilds;

    private long failedBuilds;

    private double successRate;

    private long averageDuration;

    public ProjectSummaryDTO() {
    }

    public ProjectSummaryDTO(
            String projectName,
            long totalBuilds,
            long successfulBuilds,
            long failedBuilds,
            double successRate,
            long averageDuration) {

        this.projectName = projectName;
        this.totalBuilds = totalBuilds;
        this.successfulBuilds = successfulBuilds;
        this.failedBuilds = failedBuilds;
        this.successRate = successRate;
        this.averageDuration = averageDuration;

    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public long getTotalBuilds() {
        return totalBuilds;
    }

    public void setTotalBuilds(long totalBuilds) {
        this.totalBuilds = totalBuilds;
    }

    public long getSuccessfulBuilds() {
        return successfulBuilds;
    }

    public void setSuccessfulBuilds(long successfulBuilds) {
        this.successfulBuilds = successfulBuilds;
    }

    public long getFailedBuilds() {
        return failedBuilds;
    }

    public void setFailedBuilds(long failedBuilds) {
        this.failedBuilds = failedBuilds;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public long getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(long averageDuration) {
        this.averageDuration = averageDuration;
    }

}