package com.vamsi.pipeline.service;

import com.vamsi.pipeline.dto.DashboardSummaryDTO;
import com.vamsi.pipeline.dto.LatestBuildDTO;
import com.vamsi.pipeline.dto.ProjectSummaryDTO;

import java.util.List;

public interface DashboardService {

    DashboardSummaryDTO getDashboardSummary();

    LatestBuildDTO getLatestBuild();

    List<LatestBuildDTO> getRecentBuilds();

    List<LatestBuildDTO> getRecentFailures();

    ProjectSummaryDTO getProjectSummary(String projectName);

    List<LatestBuildDTO> getProjectBuildHistory(String projectName);

}