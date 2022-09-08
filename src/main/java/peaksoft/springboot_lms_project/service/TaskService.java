package peaksoft.springboot_lms_project.service;

import org.springframework.stereotype.Service;
import peaksoft.springboot_lms_project.entities.Student;
import peaksoft.springboot_lms_project.entities.Task;
import peaksoft.springboot_lms_project.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void save(Task task){
        taskRepository.save(task);
    }

    public Task getById(Long id){
        return taskRepository.getById(id);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
