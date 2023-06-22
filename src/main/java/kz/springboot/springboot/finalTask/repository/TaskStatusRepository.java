package kz.springboot.springboot.finalTask.repository;

import kz.springboot.springboot.finalTask.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}
