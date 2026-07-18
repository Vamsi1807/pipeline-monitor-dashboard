package com.vamsi.pipeline.service.impl;

import com.vamsi.pipeline.dto.DashboardSummaryDTO;
import com.vamsi.pipeline.dto.LatestBuildDTO;
import com.vamsi.pipeline.dto.ProjectSummaryDTO;
import com.vamsi.pipeline.entity.BuildRecord;
import com.vamsi.pipeline.enums.BuildStatus;
import com.vamsi.pipeline.repository.BuildRecordRepository;
import com.vamsi.pipeline.service.DashboardService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final BuildRecordRepository buildRecordRepository;

    public DashboardServiceImpl(BuildRecordRepository buildRecordRepository) {
        this.buildRecordRepository = buildRecordRepository;
    }

    @Override
    public DashboardSummaryDTO getDashboardSummary() {

        List<BuildRecord> builds = buildRecordRepository.findAll();

        long totalBuilds = builds.size();

        long successfulBuilds = builds.stream()
                .filter(build -> build.getStatus() == BuildStatus.SUCCESS)
                .count();

        long failedBuilds = builds.stream()
                .filter(build -> build.getStatus() == BuildStatus.FAILURE)
                .count();

        double successRate = totalBuilds == 0 ? 0 :
                (successfulBuilds * 100.0) / totalBuilds;

        double failureRate = totalBuilds == 0 ? 0 :
                (failedBuilds * 100.0) / totalBuilds;

        return new DashboardSummaryDTO(
                totalBuilds,
                successfulBuilds,
                failedBuilds,
                successRate,
                failureRate
        );
    }

    @Override
    public LatestBuildDTO getLatestBuild() {

        return buildRecordRepository.findAll()
                .stream()
                .max(Comparator.comparing(BuildRecord::getBuildTime))
                .map(this::mapToLatestBuildDTO)
                .orElse(null);

    }

    @Override
    public List<LatestBuildDTO> getRecentBuilds() {

        return buildRecordRepository
                .findTop10ByOrderByBuildTimeDesc()
                .stream()
                .map(this::mapToLatestBuildDTO)
                .toList();

    }

    @Override
    public List<LatestBuildDTO> getRecentFailures() {

        return buildRecordRepository
                .findTop5ByStatusOrderByBuildTimeDesc(BuildStatus.FAILURE)
                .stream()
                .map(this::mapToLatestBuildDTO)
                .toList();

    }

    @Override
    public ProjectSummaryDTO getProjectSummary(String projectName) {

        List<BuildRecord> builds =
                buildRecordRepository.findByJobName(projectName);

        long totalBuilds = builds.size();

        long successfulBuilds =
                buildRecordRepository.countByJobNameAndStatus(
                        projectName,
                        BuildStatus.SUCCESS
                );

        long failedBuilds =
                buildRecordRepository.countByJobNameAndStatus(
                        projectName,
                        BuildStatus.FAILURE
                );

        double successRate = totalBuilds == 0 ? 0 :
                (successfulBuilds * 100.0) / totalBuilds;

        long averageDuration =
                Math.round(
                        builds.stream()
                                .mapToLong(BuildRecord::getDuration)
                                .average()
                                .orElse(0)
                );

        return new ProjectSummaryDTO(
                projectName,
                totalBuilds,
                successfulBuilds,
                failedBuilds,
                successRate,
                averageDuration
        );

    }

    @Override
    public List<LatestBuildDTO> getProjectBuildHistory(String projectName) {

        return buildRecordRepository
                .findTop20ByJobNameOrderByBuildTimeDesc(projectName)
                .stream()
                .map(this::mapToLatestBuildDTO)
                .toList();

    }

    private LatestBuildDTO mapToLatestBuildDTO(BuildRecord build) {

        return new LatestBuildDTO(
                build.getId(),
                build.getJobName(),
                build.getBuildNumber(),
                build.getStatus().name(),
                build.getBranch(),
                build.getCommitId(),
                build.getBuildTime(),
                build.getDuration()
        );

    }

}