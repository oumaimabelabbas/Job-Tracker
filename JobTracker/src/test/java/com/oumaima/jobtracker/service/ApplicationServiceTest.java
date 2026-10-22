
package com.oumaima.jobtracker.service;

import com.oumaima.jobtracker.application.Application;
import com.oumaima.jobtracker.application.ApplicationRequest;
import com.oumaima.jobtracker.exception.ApplicationException;
import com.oumaima.jobtracker.repository.ApplicationRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {

    @Mock
    private ApplicationRepository repository;

    @Mock
    private ApplicationMapper mapper;

    @InjectMocks
    private ApplicationService service;

    @Test
    void shouldGetApplicationWhenIdExists() {
        int id = 1;
        Application application = new Application();
        when(repository.findById(id))
                .thenReturn(Optional.of(application));
        Application result = service.getApplication(id);
        assertNotNull(result);
        assertSame(application, result);
        verify(repository).findById(id);
    }

    @Test
    void shouldThrowExceptionWhenApplicationDoesNotExist() {
        int id = 99;
        when(repository.findById(id))
                .thenReturn(Optional.empty());
        assertThrows(
                ApplicationException.class,
                () -> service.getApplication(id)
        );
        verify(repository).findById(id);
    }

    @Test
    void shouldCreateApplication() {
        ApplicationRequest request = mock(ApplicationRequest.class);
        Application application = new Application();
        Application savedApplication = new Application();
        when(mapper.toApplication(request)).thenReturn(application);
        when(repository.save(application)).thenReturn(savedApplication);
        Application result = service.createApplication(request);
        assertNotNull(result);
        assertSame(savedApplication, result);
        verify(mapper).toApplication(request);
        verify(repository).save(application);
    }
}
