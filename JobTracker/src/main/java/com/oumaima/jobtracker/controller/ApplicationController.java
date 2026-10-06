package com.oumaima.jobtracker.controller;

import com.oumaima.jobtracker.application.Application;
import com.oumaima.jobtracker.application.ApplicationRequest;
import com.oumaima.jobtracker.application.Status;
import com.oumaima.jobtracker.service.ApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/applications")
@CrossOrigin("*")
public class ApplicationController {
    private final ApplicationService applicationService;

    @GetMapping()
    public ResponseEntity<List<Application>> filterApplication(
            @RequestParam(required = false) String search){
        return ResponseEntity.ok(applicationService.filterApplication(search));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplication(@PathVariable int id){
        return ResponseEntity.ok(applicationService.getApplication(id));
    }
    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody  ApplicationRequest applicationRequest){
        return ResponseEntity.ok(applicationService.createApplication(applicationRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable int id,@RequestBody @Valid ApplicationRequest applicationRequest){
        return ResponseEntity.ok(applicationService.updateApplication(id,applicationRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable int id){
            applicationService.deleteApplication(id);
            return ResponseEntity.noContent().build();
    }
}
