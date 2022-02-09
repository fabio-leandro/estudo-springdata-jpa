package com.fabio.gymapi.controllers;

import com.fabio.gymapi.dtos.RegistrationDto;
import com.fabio.gymapi.exceptions.ActivityNotFoundException;
import com.fabio.gymapi.exceptions.RegistrationNotFoundException;
import com.fabio.gymapi.exceptions.StudentNotFoundException;
import com.fabio.gymapi.services.impl.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/${api.version}/gym/registrations")
public class RegistrationController {

        @Autowired
        private RegistrationServiceImpl registrationService;

        @PostMapping
        public ResponseEntity<RegistrationDto> saveRegistrationByStudent(@RequestParam(name = "idStudent") Long idStudent,
                                                                         @RequestParam(name = "idActivity") Integer idActivity) throws ActivityNotFoundException, StudentNotFoundException {
                return ResponseEntity.status(HttpStatus.CREATED)
                        .body(registrationService.saveRegistrationByStudent(idStudent, idActivity));
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<RegistrationDto> getAllRegistrations() {
                return registrationService.getAllRegistration();
        }

        @GetMapping("/idRegistration")
        public ResponseEntity<RegistrationDto> getRegistrationById(@RequestParam(name = "id") Long id) throws RegistrationNotFoundException {
                return ResponseEntity.ok(registrationService.getRegistrationById(id));
        }

        @DeleteMapping("/idRegistration")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteRegistrationById(@RequestParam(name = "id") Long id) throws RegistrationNotFoundException {
                registrationService.deleteRegistrationById(id);
        }

        @GetMapping("/idActivity")
        public List<RegistrationDto> getRegistrationByActivity(@RequestParam(name = "id") Integer idActivity){
                return registrationService.getRegistrationByActivity(idActivity);
        }


}
