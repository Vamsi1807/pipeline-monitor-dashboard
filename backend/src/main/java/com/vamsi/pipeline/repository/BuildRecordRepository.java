package com.vamsi.pipeline.repository;

import com.vamsi.pipeline.entity.BuildRecord;
import com.vamsi.pipeline.enums.BuildStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildRecordRepository extends JpaRepository<BuildRecord, Long> {

    // Dashboard
    List<BuildRecord> findTop10ByOrderByBuildTimeDesc();

    List<BuildRecord> findTop5ByStatusOrderByBuildTimeDesc(BuildStatus status);

    // Project Summary
    List<BuildRecord> findByJobName(String jobName);

    long countByJobName(String jobName);

    long countByJobNameAndStatus(String jobName, BuildStatus status);

    // Project Build History
    List<BuildRecord> findTop20ByJobNameOrderByBuildTimeDesc(String jobName);

}