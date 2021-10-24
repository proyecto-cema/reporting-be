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
public class DiseaseReport {

    @Singular("disease")
    private List<Disease> diseaseList;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Disease {

        @ApiModelProperty(notes = "The year for this data", example = "2015")
        private Integer year;
        @ApiModelProperty(notes = "The number of infections if this disease", example = "72")
        private Integer infections;
        @ApiModelProperty(notes = "The name of the disease", example = "Aftosa")
        private String name;
    }


}
