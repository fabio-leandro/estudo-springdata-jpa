package com.fabio.gymapi.services.impl;

import com.fabio.gymapi.dtos.ActivityDto;
import com.fabio.gymapi.entities.Activity;
import com.fabio.gymapi.exceptions.ActivityNotFoundException;
import com.fabio.gymapi.repositories.ActivityRepository;
import com.fabio.gymapi.services.ActivityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ActivityDto saveActivity(ActivityDto activityDto) {
        Activity activity = modelMapper.map(activityDto, Activity.class);
        return modelMapper.map(activityRepository.save(activity), ActivityDto.class);
    }

    @Override
    public List<ActivityDto> getAllActivities() {
        List<Activity> activityList = activityRepository.findAll();
        return activityList.stream().map(a -> modelMapper.map(a, ActivityDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ActivityDto getActivityByName(String name) throws ActivityNotFoundException {
        Activity activity = activityRepository.findByName(name)
                .orElseThrow(()-> new ActivityNotFoundException(name));
        return modelMapper.map(activity, ActivityDto.class);
    }

    @Override
    public ActivityDto getActivityById(Integer id) throws ActivityNotFoundException {
        Activity activity = activityRepository.findById(id).orElseThrow(()-> new ActivityNotFoundException(id));
        return modelMapper.map(activity, ActivityDto.class);
    }

    @Override
    public ActivityDto updateActivityById(Integer id, ActivityDto activityDto) throws ActivityNotFoundException {
        getActivityById(id);
        Activity activity = modelMapper.map(activityDto, Activity.class);
        return modelMapper.map(activityRepository.save(activity),ActivityDto.class);
    }

    @Override
    public void deleteActivityById(Integer id) throws ActivityNotFoundException {
        getActivityById(id);
        activityRepository.deleteById(id);
    }

}
