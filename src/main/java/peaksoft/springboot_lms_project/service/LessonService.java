package peaksoft.springboot_lms_project.service;

import org.springframework.stereotype.Service;
import peaksoft.springboot_lms_project.entities.Lesson;
import peaksoft.springboot_lms_project.repository.LessonRepository;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }


    public List<Lesson> getAllLessons(){
        return lessonRepository.findAll();
    }

    public void save(Lesson lesson){
        lessonRepository.save(lesson);
    }

    public Lesson getById(Long id){
        return lessonRepository.getById(id);
    }

    public void delete(Long id){
        lessonRepository.deleteById(id);
    }


}
