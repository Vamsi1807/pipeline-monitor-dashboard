package com.vamsi.pipeline.controller;

import com.vamsi.pipeline.dto.DashboardSummaryDTO;
import com.vamsi.pipeline.dto.LatestBuildDTO;
import com.vamsi.pipeline.dto.ProjectSummaryDTO;
import com.vamsi.pipeline.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/summary")
    public ResponseEntity<DashboardSummaryDTO> getDashboardSummary() {
        return ResponseEntity.ok(dashboardService.getDashboardSummary());
    }

    @GetMapping("/latest")
    public ResponseEntity<LatestBuildDTO> getLatestBuild() {
        return ResponseEntity.ok(dashboardService.getLatestBuild());
    }

    @GetMapping("/recent")
    public ResponseEntity<List<LatestBuildDTO>> getRecentBuilds() {
        return ResponseEntity.ok(dashboardService.getRecentBuilds());
    }

    @GetMapping("/failures")
    public ResponseEntity<List<LatestBuildDTO>> getRecentFailures() {
        return ResponseEntity.ok(dashboardService.getRecentFailures());
    }

    @GetMapping("/project/{projectName}")
    public ResponseEntity<ProjectSummaryDTO> getProjectSummary(
            @PathVariable String projectName) {

        return ResponseEntity.ok(
                dashboardService.getProjectSummary(projectName)
        );
    }

    @GetMapping("/project/{projectName}/builds")
    public ResponseEntity<List<LatestBuildDTO>> getProjectBuildHistory(
            @PathVariable String projectName) {

        return ResponseEntity.ok(
                dashboardService.getProjectBuildHistory(projectName)
        );
    }
}