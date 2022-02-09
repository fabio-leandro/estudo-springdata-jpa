package com.fabio.gymapi.services;

import com.fabio.gymapi.dtos.RegistrationDto;
import com.fabio.gymapi.exceptions.ActivityNotFoundException;
import com.fabio.gymapi.exceptions.RegistrationNotFoundException;
import com.fabio.gymapi.exceptions.StudentNotFoundException;

import java.util.List;

public interface RegistrationService {

    RegistrationDto saveRegistrationByStudent(Long idStudent, Integer idActivity) throws StudentNotFoundException, ActivityNotFoundException;
    List<RegistrationDto> getAllRegistration();
    RegistrationDto getRegistrationById(Long id) throws RegistrationNotFoundException;
    void deleteRegistrationById(Long id) throws RegistrationNotFoundException;
    List<RegistrationDto> getRegistrationByActivity(Integer idActivity);


}
