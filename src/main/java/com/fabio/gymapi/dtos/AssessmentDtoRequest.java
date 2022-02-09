package com.fabio.gymapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDtoRequest {

    @NotNull(message = "The weight cannot be null.")
    private double weight;
    @NotNull(message = "The height cannot be null.")
    private double height;

}
