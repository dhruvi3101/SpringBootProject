package SpringBootProject.modules;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import SpringBootProject.Courses.Course;

@Entity
@Table(name="Modules")
public class Module {
	
	@Id
	@NotNull(message = "Module Id cannot be NULL")
	
	@Min(value =1, message ="Value should be greater than or equal to 1")
	@Max(value =20, message ="Value should be smaller than or equal to 20")
   
    private int id;
	
	
	@NotBlank(message = "Module name is mandatory")
	@Size(min=5, message = "Module name should be atleast 5 characters long")
    private String name;
	
    private String description;
    
    @ManyToOne
    private Course course;

    public Module() {
    }

    public Module(int id, String name, String description, int courseID) {
        super();
    	this.id = id;
        this.name = name;
        this.description = description;
        this.course = new Course(courseID, "", "");
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


}
