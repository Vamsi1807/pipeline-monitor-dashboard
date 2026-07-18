package com.vamsi.pipeline.dto;

public class DashboardSummaryDTO {

    private long totalBuilds;
    private long successfulBuilds;
    private long failedBuilds;
    private double successRate;
    private double failureRate;

    public DashboardSummaryDTO() {
    }

    public DashboardSummaryDTO(long totalBuilds,
                               long successfulBuilds,
                               long failedBuilds,
                               double successRate,
                               double failureRate) {

        this.totalBuilds = totalBuilds;
        this.successfulBuilds = successfulBuilds;
        this.failedBuilds = failedBuilds;
        this.successRate = successRate;
        this.failureRate = failureRate;
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

    public double getFailureRate() {
        return failureRate;
    }

    public void setFailureRate(double failureRate) {
        this.failureRate = failureRate;
    }

}