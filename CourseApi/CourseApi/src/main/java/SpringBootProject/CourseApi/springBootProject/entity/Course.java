package SpringBootProject.CourseApi.springBootProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "COURSES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {

    @Id
    @Min(value = 1000, message = "Value should be greater than or equal to 1000")
    @Max(value = 9999, message = "Value should be smaller than or equal to 9999")
    @NotNull(message = "Column Id cannot be NULL")
    @Column(name = "COURSE_ID")
    private int id;

    @NotBlank(message = "Course name is a mandatory field")
    @Size(min = 5, message = "Course name should be at least 5 characters long")
    @Column(name = "COURSE_NAME")
    private String name;

    @Size(min = 5, max = 50, message = "Course description should be between 5 and 20 character length")
    @NotBlank(message = "Course description is a mandatory field")
    @Column(name = "COURSE_DESCRIPTION")
    private String description;

//    @OneToMany(targetEntity = Module.class, cascade = CascadeType.ALL, mappedBy = "course")
//    private List<Module> modules;


//    TODO LATER
//    @OneToMany(mappedBy = "student")
//    private List<Registration> registrationList;

}
