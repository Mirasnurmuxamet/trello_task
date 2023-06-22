package kz.springboot.springboot.finalTask.service;

import kz.springboot.springboot.finalTask.model.TaskCategories;
import kz.springboot.springboot.finalTask.repository.TaskCategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskCategoriesService {

    private final TaskCategoriesRepository taskCategoriesRepository;

    public List<TaskCategories> getAllCategories(){
        return taskCategoriesRepository.findAll();
    }


    public TaskCategories getTaskCategoriesById(Long id){
        return taskCategoriesRepository.findById(id).orElseThrow();
    }

}
