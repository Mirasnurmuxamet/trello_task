package kz.springboot.springboot.finalTask.service;

import kz.springboot.springboot.finalTask.model.TaskStatus;
import kz.springboot.springboot.finalTask.repository.TaskStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskStatusService {

    private final TaskStatusRepository  taskStatusRepository;

    public List<TaskStatus> getAllTaskStatus(){
        return taskStatusRepository.findAll();
    }
}
