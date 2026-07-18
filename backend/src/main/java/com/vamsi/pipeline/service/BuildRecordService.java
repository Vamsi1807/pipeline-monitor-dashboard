package com.vamsi.pipeline.service;

import com.vamsi.pipeline.dto.BuildRecordRequest;
import com.vamsi.pipeline.dto.BuildRecordResponse;

import java.util.List;

public interface BuildRecordService {

    BuildRecordResponse saveBuild(BuildRecordRequest request);

    List<BuildRecordResponse> getAllBuilds();

    BuildRecordResponse getBuildById(Long id);

}