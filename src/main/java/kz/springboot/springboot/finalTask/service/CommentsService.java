package kz.springboot.springboot.finalTask.service;

import kz.springboot.springboot.finalTask.model.Comments;
import kz.springboot.springboot.finalTask.repository.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {

    private  final CommentsRepository commentsRepository;

    public void addComment(Comments comment){
        commentsRepository.save(comment);
    }
    public List<Comments> getAllCommentByTasksId(Long tasksId){
        return commentsRepository.findAllByTasks_Id( tasksId);
    }

    public void deleteComment(Long id){
        commentsRepository.deleteById(id);
    }

}
