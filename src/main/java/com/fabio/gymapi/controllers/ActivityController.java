package com.fabio.gymapi.controllers;

import com.fabio.gymapi.dtos.ActivityDto;
import com.fabio.gymapi.exceptions.ActivityNotFoundException;
import com.fabio.gymapi.services.impl.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/${api.version}/gym/activities")
public class ActivityController {

        @Autowired
        private ActivityServiceImpl activityService;

        @PostMapping
        public ResponseEntity<ActivityDto> saveActivity(@Valid @RequestBody ActivityDto activityDto){
            return ResponseEntity.status(HttpStatus.CREATED).body(activityService.saveActivity(activityDto));
        }

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<ActivityDto> getAllActivities(){
            return activityService.getAllActivities();
        }

        @GetMapping("/activityName")
        public ResponseEntity<ActivityDto> getActivityByName(@RequestParam(value = "name") String name)
                throws ActivityNotFoundException {
             return ResponseEntity.ok().body(activityService.getActivityByName(name));
        }

        @GetMapping("/activityId")
        public ResponseEntity<ActivityDto> getActivityById(@RequestParam(value = "id") Integer id)
                throws ActivityNotFoundException {
            return ResponseEntity.ok(activityService.getActivityById(id));
        }

        @PutMapping("/{id}")
        public ResponseEntity<ActivityDto> updateActivityById(@PathVariable Integer id, @Valid @RequestBody
                ActivityDto activityDto) throws ActivityNotFoundException {
            return ResponseEntity.ok(activityService.updateActivityById(id,activityDto));
        }

        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById(@PathVariable Integer id) throws ActivityNotFoundException {
            activityService.deleteActivityById(id);
        }


}
