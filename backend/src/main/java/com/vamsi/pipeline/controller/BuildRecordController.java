package com.vamsi.pipeline.controller;

import com.vamsi.pipeline.dto.BuildRecordRequest;
import com.vamsi.pipeline.dto.BuildRecordResponse;
import com.vamsi.pipeline.service.BuildRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/builds")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BuildRecordController {

    private final BuildRecordService buildRecordService;

    @PostMapping
    public ResponseEntity<BuildRecordResponse> saveBuild(
            @Valid @RequestBody BuildRecordRequest request) {

        BuildRecordResponse response = buildRecordService.saveBuild(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BuildRecordResponse>> getAllBuilds() {

        return ResponseEntity.ok(buildRecordService.getAllBuilds());

    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildRecordResponse> getBuildById(
            @PathVariable Long id) {

        return ResponseEntity.ok(buildRecordService.getBuildById(id));

    }

}