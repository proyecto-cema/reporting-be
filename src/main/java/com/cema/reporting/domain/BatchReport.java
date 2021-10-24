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
public class BatchReport {

    @Singular("batch")
    private List<Batch> batchList;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Batch {

        @ApiModelProperty(notes = "The year for this data", example = "2015")
        private Integer year;
        @ApiModelProperty(notes = "The measures weight of the animal", example = "300")
        private Integer value;
        @ApiModelProperty(notes = "The name for the batch", example = "vacas_negras")
        private String batchName;
    }


}
