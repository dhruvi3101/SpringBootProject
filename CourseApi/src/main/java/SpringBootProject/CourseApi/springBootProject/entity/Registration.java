package SpringBootProject.CourseApi.springBootProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REGISTRATION")
public class Registration {


        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modSeqGen")
        @SequenceGenerator(name = "modSeqGen", sequenceName = "modSeq", allocationSize = 1)
        @Column(name = "REGISTRATION_ID")
        private Long id;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "STUDENT_ROLL_NO")
        private Student student;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "COURSES_ID")
        private Course course;


        @Column(name = "REGISTRATION_TIME")
        @Temporal(TemporalType.TIMESTAMP)
        private Date registeredAt;


        //TODO
        //Make Enum
//        @Column(name = "GRADE_OBTAINED")
//        private char grade;

        @PrePersist
        private void onCreate()
        {
                registeredAt = new Date();
        }

}
