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
public class FeedReport {

    @Singular("feed")
    private List<Feed> feedList;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Feed {

        @ApiModelProperty(notes = "The year for this data", example = "2015")
        private Integer year;
        @ApiModelProperty(notes = "The amount of food eaten by this animal in kilograms", example = "7000")
        private Integer value;
        @ApiModelProperty(notes = "The category of the measured animal", example = "Vaca")
        private String category;
    }


}
