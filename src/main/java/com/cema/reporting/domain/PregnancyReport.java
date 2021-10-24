package com.cema.reporting.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class PregnancyReport {

    @Singular("year")
    private List<Pregnancy> pregnancyList;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Pregnancy {

        @ApiModelProperty(notes = "The year for this data", example = "2015")
        private Integer year;
        @ApiModelProperty(notes = "The percentage of pregnant cows", example = "72")
        private Integer percentage;
    }
}
