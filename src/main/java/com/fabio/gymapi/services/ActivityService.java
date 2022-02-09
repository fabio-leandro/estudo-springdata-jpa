package com.fabio.gymapi.services;

import com.fabio.gymapi.dtos.ActivityDto;
import com.fabio.gymapi.exceptions.ActivityNotFoundException;

import java.util.List;

public interface ActivityService {

    ActivityDto saveActivity(ActivityDto activityDto);
    List<ActivityDto> getAllActivities();
    ActivityDto getActivityByName(String name) throws ActivityNotFoundException;
    ActivityDto getActivityById(Integer id) throws ActivityNotFoundException;
    ActivityDto updateActivityById(Integer id, ActivityDto activityDto) throws ActivityNotFoundException;
    void deleteActivityById(Integer id) throws ActivityNotFoundException;

}
