package peaksoft.springboot_lms_project.service;

import org.springframework.stereotype.Service;
import peaksoft.springboot_lms_project.entities.Task;
import peaksoft.springboot_lms_project.entities.Video;
import peaksoft.springboot_lms_project.repository.VideoRepository;

import java.util.List;

@Service
public class VideoService {

    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    public void save(Video video){
        videoRepository.save(video);
    }

    public Video getById(Long id){
        return videoRepository.getById(id);
    }

    public void delete(Long id){
        videoRepository.deleteById(id);
    }
}
