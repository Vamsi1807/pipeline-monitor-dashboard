package com.vamsi.pipeline.service.impl;

import com.vamsi.pipeline.dto.BuildRecordRequest;
import com.vamsi.pipeline.dto.BuildRecordResponse;
import com.vamsi.pipeline.entity.BuildRecord;
import com.vamsi.pipeline.repository.BuildRecordRepository;
import com.vamsi.pipeline.service.BuildRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BuildRecordServiceImpl implements BuildRecordService {

    private final BuildRecordRepository repository;

    @Override
    public BuildRecordResponse saveBuild(BuildRecordRequest request) {

        BuildRecord buildRecord = BuildRecord.builder()
                .jobName(request.getJobName())
                .buildNumber(request.getBuildNumber())
                .status(request.getStatus())
                .duration(request.getDuration())
                .branch(request.getBranch())
                .commitId(request.getCommitId())
                .buildTime(LocalDateTime.now())
                .buildUrl(request.getBuildUrl())
                .consoleUrl(request.getConsoleUrl())
                .build();

        BuildRecord saved = repository.save(buildRecord);

        return mapToResponse(saved, "Build record saved successfully");
    }

    @Override
    public List<BuildRecordResponse> getAllBuilds() {

        return repository.findAll()
                .stream()
                .map(build -> mapToResponse(build, null))
                .collect(Collectors.toList());

    }

    @Override
    public BuildRecordResponse getBuildById(Long id) {

        BuildRecord build = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Build record not found"));

        return mapToResponse(build, null);

    }

    private BuildRecordResponse mapToResponse(BuildRecord build, String message) {

        return BuildRecordResponse.builder()
                .id(build.getId())
                .jobName(build.getJobName())
                .buildNumber(build.getBuildNumber())
                .status(build.getStatus())
                .duration(build.getDuration())
                .branch(build.getBranch())
                .commitId(build.getCommitId())
                .buildTime(build.getBuildTime())
                .buildUrl(build.getBuildUrl())
                .consoleUrl(build.getConsoleUrl())
                .message(message)
                .build();

    }

}