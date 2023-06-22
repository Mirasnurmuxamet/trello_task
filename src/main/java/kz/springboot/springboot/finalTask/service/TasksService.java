package kz.springboot.springboot.finalTask.service;

import kz.springboot.springboot.finalTask.model.TaskStatus;
import kz.springboot.springboot.finalTask.model.Tasks;
import kz.springboot.springboot.finalTask.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TasksService {
    private final TasksRepository tasksRepository;

    public List<Tasks> getTasksByFolderId(Long folderId){
        return tasksRepository.findAllByFolder_Id(folderId);
    }

    public void addTask(Tasks task){
        TaskStatus taskStatus  = new TaskStatus();
        taskStatus.setId(1L);
        task.setTaskStatus(taskStatus);
        tasksRepository.save(task);
    }

    public Tasks getTaskById(Long id){
        return tasksRepository.findById(id).orElse(null);
    }

    public void updateTask(Tasks tasks){
        tasksRepository.save(tasks);
    }

    public void deleteTask(Long id){
        tasksRepository.deleteById(id);
    }
}
