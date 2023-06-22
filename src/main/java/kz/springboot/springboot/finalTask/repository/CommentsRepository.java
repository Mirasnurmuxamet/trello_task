package kz.springboot.springboot.finalTask.repository;

import kz.springboot.springboot.finalTask.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    List<Comments>   findAllByTasks_Id(Long tasksId);

}
