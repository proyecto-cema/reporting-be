package com.cema.reporting.controllers;

import com.cema.reporting.constants.Messages;
import com.cema.reporting.domain.BatchReport;
import com.cema.reporting.domain.DiseaseReport;
import com.cema.reporting.domain.Establishment;
import com.cema.reporting.domain.FeedReport;
import com.cema.reporting.domain.FoodPerformanceReport;
import com.cema.reporting.domain.PregnancyReport;
import com.cema.reporting.domain.WeightReport;
import com.cema.reporting.entities.CemaEstablishment;
import com.cema.reporting.exceptions.NotFoundException;
import com.cema.reporting.exceptions.UnauthorizedException;
import com.cema.reporting.mapping.EstablishmentMapping;
import com.cema.reporting.repositories.EstablishmentRepository;
import com.cema.reporting.services.authorization.AuthorizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Api(produces = "application/json", value = "Generates data reports for CEMA. V1")
@Validated
public class ReportingController {

    private static final String BASE_URL = "/reporting/";

    private final Logger LOG = LoggerFactory.getLogger(ReportingController.class);

    private final EstablishmentRepository establishmentRepository;
    private final EstablishmentMapping establishmentMapping;
    private final AuthorizationService authorizationService;

    public ReportingController(EstablishmentRepository establishmentRepository, EstablishmentMapping establishmentMapping,
                               AuthorizationService authorizationService) {
        this.establishmentRepository = establishmentRepository;
        this.establishmentMapping = establishmentMapping;
        this.authorizationService = authorizationService;
    }

    @PreAuthorize("hasRole('PATRON')")
    @ApiOperation(value = "Get a report of the pregnancy level over the years and for the current year")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Report returned."),
            @ApiResponse(code = 401, message = "You are not allowed to get this report")
    })
    @GetMapping(value = BASE_URL + "/pregnancy", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PregnancyReport> getPregnancyReport(
            @ApiParam(
                    value = "The number of years in the past to look.",
                    example = "5")
            @RequestParam(value = "years", required = false, defaultValue = "3") int yearsInThePast) {

        LOG.info("Request to create pregnancy report");

        PregnancyReport pregnancyReport = PregnancyReport.builder()
                .year(new PregnancyReport.Pregnancy(2018, 67))
                .year(new PregnancyReport.Pregnancy(2019, 75))
                .year(new PregnancyReport.Pregnancy(2019, 80))
                .year(new PregnancyReport.Pregnancy(2019, 82))
                .build();


        return new ResponseEntity<>(pregnancyReport, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('PATRON')")
    @ApiOperation(value = "Get a report of the disease level over the years and for the current year")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Report returned."),
            @ApiResponse(code = 401, message = "You are not allowed to get this report")
    })
    @GetMapping(value = BASE_URL + "/disease", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DiseaseReport> getDiseaseReport(
            @ApiParam(
                    value = "The number of years in the past to look.",
                    example = "5")
            @RequestParam(value = "years", required = false, defaultValue = "3") int yearsInThePast) {

        LOG.info("Request to create disease report");

        DiseaseReport diseaseReport = DiseaseReport.builder()
                .disease(new DiseaseReport.Disease(2016, 123, "Aftosa"))
                .disease(new DiseaseReport.Disease(2017, 200, "Aftosa"))
                .disease(new DiseaseReport.Disease(2018, 250, "Aftosa"))
                .disease(new DiseaseReport.Disease(2019, 101, "Aftosa"))
                .disease(new DiseaseReport.Disease(2020, 115, "Aftosa"))
                .disease(new DiseaseReport.Disease(2021, 150, "Aftosa"))
                .disease(new DiseaseReport.Disease(2016, 40, "Leptospirosis"))
                .disease(new DiseaseReport.Disease(2017, 20, "Leptospirosis"))
                .disease(new DiseaseReport.Disease(2018, 5, "Leptospirosis"))
                .disease(new DiseaseReport.Disease(2019, 50, "Leptospirosis"))
                .disease(new DiseaseReport.Disease(2020, 55, "Leptospirosis"))
                .disease(new DiseaseReport.Disease(2021, 10, "Leptospirosis"))
                .disease(new DiseaseReport.Disease(2016, 13, "Brucelosis"))
                .disease(new DiseaseReport.Disease(2017, 3, "Brucelosis"))
                .disease(new DiseaseReport.Disease(2018, 15, "Brucelosis"))
                .disease(new DiseaseReport.Disease(2019, 2, "Brucelosis"))
                .disease(new DiseaseReport.Disease(2020, 0, "Brucelosis"))
                .disease(new DiseaseReport.Disease(2021, 3, "Brucelosis"))
                .build();


        return new ResponseEntity<>(diseaseReport, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('PATRON')")
    @ApiOperation(value = "Get a report of the weight level over the years and for the current year")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Report returned."),
            @ApiResponse(code = 401, message = "You are not allowed to get this report")
    })
    @GetMapping(value = BASE_URL + "/weight", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<WeightReport> getWeightReport(
            @ApiParam(
                    value = "The number of years in the past to look.",
                    example = "5")
            @RequestParam(value = "years", required = false, defaultValue = "3") int yearsInThePast) {

        LOG.info("Request to create weight report");

        WeightReport weightReport = WeightReport.builder()
                .weight(new WeightReport.Weight(2016, 123, "Ternero"))
                .weight(new WeightReport.Weight(2017, 200, "Ternero"))
                .weight(new WeightReport.Weight(2018, 250, "Ternero"))
                .weight(new WeightReport.Weight(2019, 150, "Ternero"))
                .weight(new WeightReport.Weight(2020, 170, "Ternero"))
                .weight(new WeightReport.Weight(2021, 150, "Ternero"))
                .weight(new WeightReport.Weight(2016, 700, "Vaca"))
                .weight(new WeightReport.Weight(2017, 731, "Vaca"))
                .weight(new WeightReport.Weight(2018, 715, "Vaca"))
                .weight(new WeightReport.Weight(2019, 720, "Vaca"))
                .weight(new WeightReport.Weight(2020, 722, "Vaca"))
                .weight(new WeightReport.Weight(2021, 723, "Vaca"))
                .weight(new WeightReport.Weight(2016, 1100, "Toro"))
                .weight(new WeightReport.Weight(2017, 1115, "Toro"))
                .weight(new WeightReport.Weight(2018, 1200, "Toro"))
                .weight(new WeightReport.Weight(2019, 1221, "Toro"))
                .weight(new WeightReport.Weight(2020, 1150, "Toro"))
                .weight(new WeightReport.Weight(2021, 1200, "Toro"))
                .build();


        return new ResponseEntity<>(weightReport, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('PATRON')")
    @ApiOperation(value = "Get a report of the weight level over the years and for the current year by batch")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Report returned."),
            @ApiResponse(code = 401, message = "You are not allowed to get this report")
    })
    @GetMapping(value = BASE_URL + "/batch", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BatchReport> getBatchReport(
            @ApiParam(
                    value = "The number of years in the past to look.",
                    example = "5")
            @RequestParam(value = "years", required = false, defaultValue = "3") int yearsInThePast) {

        LOG.info("Request to create batch report");

        BatchReport batchReport = BatchReport.builder()
                .batch(new BatchReport.Batch(2016, 712, "las_vacas_negras"))
                .batch(new BatchReport.Batch(2017, 715, "las_vacas_negras"))
                .batch(new BatchReport.Batch(2018, 760, "las_vacas_negras"))
                .batch(new BatchReport.Batch(2019, 750, "las_vacas_negras"))
                .batch(new BatchReport.Batch(2020, 700, "las_vacas_negras"))
                .batch(new BatchReport.Batch(2021, 712, "las_vacas_negras"))
                .batch(new BatchReport.Batch(2016, 711, "batch_2"))
                .batch(new BatchReport.Batch(2017, 712, "batch_2"))
                .batch(new BatchReport.Batch(2018, 730, "batch_2"))
                .batch(new BatchReport.Batch(2019, 750, "batch_2"))
                .batch(new BatchReport.Batch(2020, 722, "batch_2"))
                .batch(new BatchReport.Batch(2021, 723, "batch_2"))
                .batch(new BatchReport.Batch(2016, 1100, "toros"))
                .batch(new BatchReport.Batch(2017, 1115, "toros"))
                .batch(new BatchReport.Batch(2018, 1200, "toros"))
                .batch(new BatchReport.Batch(2019, 1221, "toros"))
                .batch(new BatchReport.Batch(2020, 1150, "toros"))
                .batch(new BatchReport.Batch(2021, 1200, "toros"))
                .build();


        return new ResponseEntity<>(batchReport, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('PATRON')")
    @ApiOperation(value = "Get a report of the food consumed by bovines each year separated by category")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Report returned."),
            @ApiResponse(code = 401, message = "You are not allowed to get this report")
    })
    @GetMapping(value = BASE_URL + "/feed", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FeedReport> getFeedReport(
            @ApiParam(
                    value = "The number of years in the past to look.",
                    example = "5")
            @RequestParam(value = "years", required = false, defaultValue = "3") int yearsInThePast) {

        LOG.info("Request to create batch report");

        FeedReport feedReport = FeedReport.builder()
                .feed(new FeedReport.Feed(2016, 2500, "Ternero"))
                .feed(new FeedReport.Feed(2017, 2250, "Ternero"))
                .feed(new FeedReport.Feed(2018, 2100, "Ternero"))
                .feed(new FeedReport.Feed(2019, 2500, "Ternero"))
                .feed(new FeedReport.Feed(2020, 2200, "Ternero"))
                .feed(new FeedReport.Feed(2021, 2000, "Ternero"))
                .feed(new FeedReport.Feed(2016, 7500, "Vaca"))
                .feed(new FeedReport.Feed(2017, 7250, "Vaca"))
                .feed(new FeedReport.Feed(2018, 7500, "Vaca"))
                .feed(new FeedReport.Feed(2019, 7100, "Vaca"))
                .feed(new FeedReport.Feed(2020, 7000, "Vaca"))
                .feed(new FeedReport.Feed(2021, 7100, "Vaca"))
                .feed(new FeedReport.Feed(2016, 8500, "Toro"))
                .feed(new FeedReport.Feed(2017, 8500, "Toro"))
                .feed(new FeedReport.Feed(2018, 8000, "Toro"))
                .feed(new FeedReport.Feed(2019, 8250, "Toro"))
                .feed(new FeedReport.Feed(2020, 8100, "Toro"))
                .feed(new FeedReport.Feed(2021, 8100, "Toro"))
                .build();


        return new ResponseEntity<>(feedReport, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('PATRON')")
    @ApiOperation(value = "Get a report of the food consumed vs the weight of the bovines")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Report returned."),
            @ApiResponse(code = 401, message = "You are not allowed to get this report")
    })
    @GetMapping(value = BASE_URL + "/performance", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<FoodPerformanceReport> getFoodPerformanceReport(
            @ApiParam(
                    value = "The number of years in the past to look.",
                    example = "5")
            @RequestParam(value = "years", required = false, defaultValue = "3") int yearsInThePast) {

        LOG.info("Request to create batch report");

        FoodPerformanceReport performanceReport = FoodPerformanceReport.builder()
                .performance(new FoodPerformanceReport.Performance(2016, 11.5))
                .performance(new FoodPerformanceReport.Performance(2017, 10.32))
                .performance(new FoodPerformanceReport.Performance(2018, 15.4))
                .performance(new FoodPerformanceReport.Performance(2019, 12.77))
                .performance(new FoodPerformanceReport.Performance(2020, 11.4))
                .performance(new FoodPerformanceReport.Performance(2021, 11.6))
                .build();


        return new ResponseEntity<>(performanceReport, HttpStatus.CREATED);
    }


}
