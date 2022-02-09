package com.fabio.gymapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    private Long id;

    @NotNull
    private StudentDto student;

    @NotNull
    private ActivityDto activity;

    private LocalDate dateRegistration;

}
