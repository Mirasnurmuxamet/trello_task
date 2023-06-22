package kz.springboot.springboot.finalTask.repository;

import kz.springboot.springboot.finalTask.model.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories, Long> {
}
