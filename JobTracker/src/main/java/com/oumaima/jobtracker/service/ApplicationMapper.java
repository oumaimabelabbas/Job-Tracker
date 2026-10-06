package com.oumaima.jobtracker.service;

import com.oumaima.jobtracker.application.Application;
import com.oumaima.jobtracker.application.ApplicationRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ApplicationMapper {
    public Application toApplication(@Valid ApplicationRequest applicationRequest) {
        return Application.builder()
                .company(applicationRequest.company())
                .position(applicationRequest.position())
                .status(applicationRequest.status())
                .notes(applicationRequest.notes())
                .appliedDate(applicationRequest.appliedDate())
                .build();
    }
}
