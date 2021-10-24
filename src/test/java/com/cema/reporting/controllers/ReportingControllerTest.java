package com.cema.reporting.controllers;


import com.cema.reporting.domain.Establishment;
import com.cema.reporting.entities.CemaEstablishment;
import com.cema.reporting.exceptions.AlreadyExistsException;
import com.cema.reporting.exceptions.NotFoundException;
import com.cema.reporting.mapping.EstablishmentMapping;
import com.cema.reporting.repositories.EstablishmentRepository;
import com.cema.reporting.services.authorization.AuthorizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ReportingControllerTest {

    @Mock
    private EstablishmentRepository establishmentRepository;
    @Mock
    private EstablishmentMapping establishmentMapping;
    @Mock
    private AuthorizationService authorizationService;

    private ReportingController reportingController;

    private final String cuig = "321";

    @BeforeEach
    public void setUp() {
        openMocks(this);
        when(authorizationService.isOnTheSameEstablishment(cuig)).thenReturn(true);
        when(authorizationService.getCurrentUserCuig()).thenReturn(cuig);
        reportingController = new ReportingController(establishmentRepository, establishmentMapping, authorizationService);
    }


}