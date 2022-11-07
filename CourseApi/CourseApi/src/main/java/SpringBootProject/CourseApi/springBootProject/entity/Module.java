package SpringBootProject.CourseApi.springBootProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MODULES")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modSeqGen")
    @SequenceGenerator(name = "modSeqGen", sequenceName = "modSeq", allocationSize = 1)
    @Column(name = "MODULE_ID")
    @NotNull
    private int id;

    @NotBlank(message = "Module title is mandatory")
    @Size(min = 5, message = "Module title should be at-least 5 characters long")
    @Column(name = "MODULE_TITLE")
    private String title;


    @NotBlank(message = "Module name is mandatory")
    @Size(min = 5, message = "Module name should be at-least 5 characters long")
    @Column(name = "MODULE_NAME")
    private String name;


    @NotBlank(message = "Module description is mandatory")
    @Column(name = "MODULE_DESCRIPTION")
    @Size(min = 5, max = 50, message = "Module description should be between 5 and 20 character length")
    private String description;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID_FK", referencedColumnName = "COURSE_ID")
    private Course course;


}
