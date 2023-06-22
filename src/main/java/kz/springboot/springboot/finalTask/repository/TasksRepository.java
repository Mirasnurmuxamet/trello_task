package kz.springboot.springboot.finalTask.repository;

import kz.springboot.springboot.finalTask.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Long> {

    List<Tasks> findAllByFolder_Id (Long folderId);

}
