package peaksoft.springboot_lms_project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import peaksoft.springboot_lms_project.entities.Lesson;
import peaksoft.springboot_lms_project.entities.Task;
import peaksoft.springboot_lms_project.entities.Video;
import peaksoft.springboot_lms_project.service.LessonService;
import peaksoft.springboot_lms_project.service.TaskService;
import peaksoft.springboot_lms_project.service.VideoService;

import java.util.List;

@Controller
@RequestMapping("/videos")
public class VideoController {

    private final LessonService lessonService;
    private final VideoService videoService;

    public VideoController(LessonService lessonService, VideoService videoService) {
        this.lessonService = lessonService;
        this.videoService = videoService;
    }

    @RequestMapping("/showVideos")
    public String showAllVideos(Model model){
        List<Video> videos = videoService.getAllVideos();
        model.addAttribute("videosAtr", videos);
        return "show-videos";
    }

    @RequestMapping("/new")
    public String displayVideoForm(Model model){

        List<Lesson> lessonList = lessonService.getAllLessons();
        Video video = new Video();
        model.addAttribute("newVideoAtr", video);
        model.addAttribute("lessonListAtr", lessonList);
        return "video-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNewVideo(@ModelAttribute("newVideoAtr") Video video){
        videoService.save(video);
        return "redirect:/videos/showVideos";
    }

    @RequestMapping("/edit/{id}")
    public String displayVideoEditForm(@PathVariable("id") Long id, Model model){
        Video video = videoService.getById(id);
        model.addAttribute("newVideoAtr", video);
        List<Lesson> lessonList = lessonService.getAllLessons();
        model.addAttribute("lessonListAtr", lessonList);
        return "video-form";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteVideo(@PathVariable("id") Long id){
        videoService.delete(id);
        return "redirect:/videos/showVideos";
    }

}
