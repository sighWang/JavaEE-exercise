package com.tw.core.service;

import com.tw.core.dao.ScheduleDao;
import com.tw.core.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    public void addSchedule(Schedule schedule) {
        scheduleDao.addSchedule(schedule);
    }

    public List<Schedule> getSchedules() {
        return scheduleDao.getSchedules();
    }

    public void delete(int id) {
        scheduleDao.deleteSchedule(id);
    }

    public Schedule getSchedule(int id) {
        return scheduleDao.getSchedule(id);
    }
}
