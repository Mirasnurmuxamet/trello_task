package kz.springboot.springboot.finalTask.controller;

import kz.springboot.springboot.finalTask.model.Comments;
import kz.springboot.springboot.finalTask.model.Folders;
import kz.springboot.springboot.finalTask.model.TaskCategories;
import kz.springboot.springboot.finalTask.model.Tasks;
import kz.springboot.springboot.finalTask.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final FoldersService foldersService;
    private final TasksService tasksService;
    private final TaskStatusService taskStatusService;
    private final CommentsService commentsService;
    private final TaskCategoriesService taskCategoriesService;

    @GetMapping(value = "/")
    private String indexPage(Model model) {
        model.addAttribute("folders", foldersService.getAllFolders());
        return "index";
    }

    @PostMapping(value = "/add_folder")
    private String addFolder(Folders folder) {
        foldersService.saveFolder(folder);
        return "redirect:/";
    }

    @GetMapping(value = "/folder_details/{id}")
    private String folderDetails(@PathVariable(name = "id") Long id, Model model){

        model.addAttribute("taskList", tasksService.getTasksByFolderId(id));

        Folders folder = foldersService.getFolderById(id);
        model.addAttribute("folder", folder);

        List<TaskCategories> taskCategories = taskCategoriesService.getAllCategories();
        taskCategories.removeAll(folder.getCategories());
        model.addAttribute("categoriesList", taskCategories);

        return "folderDetails";
    }


    @PostMapping(value = "/add_categories")
    private String addCategories(@RequestParam(name = "categories_id") Long categoriesId,
                                 @RequestParam(name = "folder_id") Long folderId){
        Folders folder = foldersService.getFolderById(folderId);
        TaskCategories taskCategories = taskCategoriesService.getTaskCategoriesById(categoriesId);
        if(folder.getCategories() != null && folder.getCategories().size()>0){
            folder.getCategories().add(taskCategories);

        }
        else {
            List<TaskCategories> categoriesList  = new ArrayList<>();
            categoriesList.add(taskCategories);
            folder.setCategories(categoriesList);
        }
        foldersService.saveFolder(folder);

        return "redirect:/folder_details/"+folderId;

    }

    @PostMapping(value = "/delete_categories")
    private String deleteCategories(@RequestParam(name = "categories_id") Long categoriesId,
                                    @RequestParam(name = "folder_id") Long folderId){
        Folders folder = foldersService.getFolderById(folderId);
        TaskCategories taskCategory = taskCategoriesService.getTaskCategoriesById(categoriesId);
        if(folder.getCategories()!=null && folder.getCategories().size()>0){
            folder.getCategories().remove(taskCategory);
        }
        foldersService.saveFolder(folder);
        return "redirect:/folder_details/"+folderId;


    }


    @PostMapping(value = "/add_task")
    private String addTask(Tasks task) {
        tasksService.addTask(task);
        return "redirect:/folder_details/"+task.getFolder().getId();
    }

    @GetMapping(value = "/task_details/{id}")
    private String taskDetails(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("task", tasksService.getTaskById(id));
        model.addAttribute("statusList",taskStatusService.getAllTaskStatus());
        model.addAttribute("commentList", commentsService.getAllCommentByTasksId(id));
        return "taskDetails";
    }

    @PostMapping(value = "/update_task")
    private String updateTask(Tasks task) {
        tasksService.updateTask(task);
        return "redirect:/task_details/"+task.getId();
    }

    @PostMapping(value = "/delete_task")
    private String deleteTask(@RequestParam(name = "task_id") Long taskId,
                              @RequestParam(name = "folder_id") Long folderId){
        tasksService.deleteTask(taskId);
        return "redirect:/folder_details/"+folderId;
    }

    @PostMapping(value = "/add_comment")
    private String addComment(Comments comment){
        commentsService.addComment(comment);
        return "redirect:/task_details/"+comment.getTasks().getId();
    }

    @PostMapping(value = "/delete_comment")
    private String deleteComment(@RequestParam(name = "commentId") Long commentId,
                                 @RequestParam(name = "taskId") Long taskId){
        commentsService.deleteComment(commentId);
        return "redirect:/task_details/"+taskId;
    }
    @PostMapping(value = "/delete_folder")
    private String deleteTask(@RequestParam(name = "folder_id") Long id){
        foldersService.deleteFolder(id);
        return "redirect:/";
    }


}