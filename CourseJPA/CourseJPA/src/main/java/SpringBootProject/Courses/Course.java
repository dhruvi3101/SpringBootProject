package SpringBootProject.Courses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Courses")
public class Course {
	
	@Id
	@NotNull(message = "Course Id cannot be NULL")
	@Min(value =1000, message ="Value should be greater than or equal to 1000")
	@Max(value =9999, message ="Value should be smaller than or equal to 9999")
    private int id;
	
	@NotBlank(message = "Course name is mandatory")
	@Size(min=5, message = "Course name should be atleast 5 characters long")
    private String name;
	
	
    private String description;
    

    public Course() {
    }

    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
