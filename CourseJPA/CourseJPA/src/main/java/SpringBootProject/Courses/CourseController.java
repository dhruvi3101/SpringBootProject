package SpringBootProject.Courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import SpringBootProject.Exception.IdNotFoundException;

import java.util.List;

import javax.validation.Valid;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping("/courses")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }
    
    @RequestMapping("/courses/page/{offset}/{pageSize}")
    public Page<Course> getAllCoursesWithPage(@PathVariable int offset, @PathVariable int pageSize)
    {
        return courseService.paginationOnCourse(offset, pageSize);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id) throws IdNotFoundException
    {
    	
    	return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCourse(@RequestBody @Valid Course course)
    {
        courseService.addCourse(course);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public void updateCourse(@RequestBody @Valid Course course, @PathVariable int id) throws IdNotFoundException
    {
    	
           courseService.updateCourse(id,course);
    	
       
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable int id) throws IdNotFoundException
    {
    	
	courseService.deleteCourse(id);

    	
    
    }
}
