package com.oumaima.jobtracker.service;

import com.oumaima.jobtracker.application.Application;
import com.oumaima.jobtracker.application.ApplicationRequest;
import com.oumaima.jobtracker.exception.ApplicationException;
import com.oumaima.jobtracker.repository.ApplicationRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository repository;
    private final ApplicationMapper mapper;


    public List<Application> filterApplication(String search) {
        List<Application> applications = repository.findAll();
        return applications.stream()
                .filter(a->search==null || a.getCompany().toLowerCase().contains(search.toLowerCase()) || a.getPosition().toLowerCase().contains(search.toLowerCase())
                || a.getNotes().toLowerCase().contains(search.toLowerCase())).collect(Collectors.toList());
    }

    public Application getApplication(int id) {
        return  repository.findById(id).orElseThrow( ()-> new ApplicationException("Application not found"));
    }

    public Application createApplication(@Valid ApplicationRequest applicationRequest) {
        return repository.save(mapper.toApplication(applicationRequest));
    }

    public Application updateApplication(int id, @Valid ApplicationRequest applicationRequest) {
        var application = repository.findById(id).orElseThrow(()-> new ApplicationException("Application not found"));
        application.setCompany(applicationRequest.company());
        application.setNotes(applicationRequest.notes());
        application.setPosition(applicationRequest.position());
        application.setStatus(applicationRequest.status());
        application.setAppliedDate(applicationRequest.appliedDate());
        return repository.save(application);

    }
    public void deleteApplication ( int id){
        if(!repository.existsById(id)){
            throw new ApplicationException("Application not found");
        }
        repository.deleteById(id);
    }
}
