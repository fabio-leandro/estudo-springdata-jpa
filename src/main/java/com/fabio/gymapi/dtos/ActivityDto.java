package com.fabio.gymapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {

    private Integer id;
    @NotBlank(message = "The field cannot be blank.")
    @Size(min = 3, max = 100, message = "'${validateValue}'The field must have between {min} and {max} characters.")
    private String name;
}
