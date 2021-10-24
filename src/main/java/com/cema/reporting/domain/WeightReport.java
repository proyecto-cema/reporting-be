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
public class WeightReport {

    @Singular("weight")
    private List<Weight> weightList;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Weight {

        @ApiModelProperty(notes = "The year for this data", example = "2015")
        private Integer year;
        @ApiModelProperty(notes = "The measures weight of the animal", example = "300")
        private Integer value;
        @ApiModelProperty(notes = "The category of the measured animal", example = "Vaca")
        private String category;
    }


}
