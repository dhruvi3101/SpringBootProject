package SpringBootProject.CourseApi.springBootProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENTS")
public class Student {

    @Id
    @Min(value =1, message ="Value should be greater than or equal to 1")
    @Max(value =1000, message ="Value should be smaller than or equal to 1000")
    @NotNull(message = "Roll No. cannot be NULL")
    @Column(name ="STUDENT_ROLL_NO")
    private int rollNo;

    @NotBlank(message = "Student name is a mandatory field")
    @Size(min=5, message = "Student name should be at least 5 characters long")
    @Column(name ="STUDENT_NAME")
    private String name;


    @Min(value =18, message ="Value should be greater than or equal to 18")
    @Max(value =60, message ="Value should be smaller than or equal to 60")
    @NotNull(message = "Age cannot be NULL")
    @Column(name ="STUDENT_AGE")
    private int age;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Registration> CourseRegistration = new ArrayList<>();


}
