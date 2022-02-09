package com.fabio.gymapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;
    @NotBlank(message = "The name field is not valid.")
    @Size(min = 3, max = 100, message = "'${validateValue}'The name field must have between {min} and {max} characters")
    private String name;
    @NotBlank(message = "The cpf field was not validate.")
    @CPF(message = "The cpf field is invalid.")
    private String cpf;
    @NotBlank(message = "The neighborhood is not valid.")
    private String neighborhood;
    @NotNull(message = "The birth date field is not valid.")
    @Past(message = "The birth date field is not valid.")
    private LocalDate birthDate;

}
