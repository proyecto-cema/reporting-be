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
public class FoodPerformanceReport {

    @Singular("performance")
    private List<Performance> performanceList;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Performance {

        @ApiModelProperty(notes = "The year for this data", example = "2015")
        private Integer year;
        @ApiModelProperty(notes = "Rendimiento del alimento en Kg por Kg vivo", example = "11.5")
        private Double value;
    }


}
