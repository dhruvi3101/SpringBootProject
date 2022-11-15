package SpringBootProject.CourseApi.springBootProject.controller;

import SpringBootProject.CourseApi.springBootProject.entity.Course;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import SpringBootProject.CourseApi.springBootProject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

//    @RequestMapping("/courses/page/{offset}/{pageSize}")
//    public Page<Course> getAllCoursesWithPage(@PathVariable int offset, @PathVariable int pageSize)
//    {
//        return courseService.paginationOnCourse(offset, pageSize);
//    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable int id) throws IdNotFoundException {

        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public ResponseEntity<String> addCourse(@RequestBody @Valid Course course) {
        courseService.addCourse(course);
        return new ResponseEntity<>("The course was added successfully", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public ResponseEntity<String> updateCourse(@RequestBody @Valid Course course, @PathVariable int id) throws IdNotFoundException {

        courseService.updateCourse(id, course);
        return new ResponseEntity<>("The course was updated successfully", HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) throws IdNotFoundException {

        courseService.deleteCourse(id);
        return new ResponseEntity<>("The course was deleted successfully", HttpStatus.OK);

    }
}
