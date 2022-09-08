package peaksoft.springboot_lms_project.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "videos")
@Getter @Setter
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "video_gen")
    @SequenceGenerator(name = "video_gen", sequenceName = "video_seq", allocationSize = 1)
    private Long id;
    private String videoName;
    private String link;

    @OneToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private Lesson lesson;
}
