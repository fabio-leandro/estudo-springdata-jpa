package com.fabio.gymapi.services.impl;

import com.fabio.gymapi.dtos.RegistrationDto;
import com.fabio.gymapi.entities.Activity;
import com.fabio.gymapi.entities.Registration;
import com.fabio.gymapi.entities.Student;
import com.fabio.gymapi.exceptions.ActivityNotFoundException;
import com.fabio.gymapi.exceptions.RegistrationNotFoundException;
import com.fabio.gymapi.exceptions.StudentNotFoundException;
import com.fabio.gymapi.repositories.ActivityRepository;
import com.fabio.gymapi.repositories.RegistrationRepository;
import com.fabio.gymapi.repositories.StudentRepository;
import com.fabio.gymapi.services.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {

        @Autowired
        private RegistrationRepository registrationRepository;

        @Autowired
        private ActivityRepository activityRepository;

        @Autowired
        private StudentRepository studentRepository;

        @Autowired
        private ModelMapper modelMapper;

        @Override
        public RegistrationDto saveRegistrationByStudent(Long idStudent, Integer idActivity) throws StudentNotFoundException, ActivityNotFoundException {
                Student student = studentRepository.findById(idStudent).orElseThrow(()-> new StudentNotFoundException(idStudent));
                Activity activity = activityRepository.findById(idActivity).orElseThrow(()-> new ActivityNotFoundException(idActivity));
                Registration registration = new Registration();
                registration.setStudent(student);
                registration.setActivity(activity);
                Registration registrationSaved = registrationRepository.save(registration);
                return modelMapper.map(registrationSaved,RegistrationDto.class);
        }

        @Override
        public List<RegistrationDto> getAllRegistration() {
                List<Registration> registrationList = registrationRepository.findAll();
            return registrationList.stream().map(r -> modelMapper.map(r,RegistrationDto.class))
                    .collect(Collectors.toList());
        }

        @Override
        public RegistrationDto getRegistrationById(Long id) throws RegistrationNotFoundException {
                Registration registration = registrationRepository.findById(id).orElseThrow(()-> new RegistrationNotFoundException(id));
                return modelMapper.map(registration, RegistrationDto.class);
        }

        @Override
        public void deleteRegistrationById(Long id) throws RegistrationNotFoundException {
                getRegistrationById(id);
                registrationRepository.deleteById(id);
        }

        @Override
        public List<RegistrationDto> getRegistrationByActivity(Integer idActivity) {
                List<Registration> registrations = registrationRepository.findByActivityId(idActivity);
                return registrations.stream().map(r-> modelMapper.map(r,RegistrationDto.class))
                        .collect(Collectors.toList());
        }


}
