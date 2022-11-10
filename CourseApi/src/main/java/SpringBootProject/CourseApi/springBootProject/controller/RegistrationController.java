package SpringBootProject.CourseApi.springBootProject.controller;

import SpringBootProject.CourseApi.springBootProject.entity.Registration;
import SpringBootProject.CourseApi.springBootProject.entity.Student;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import SpringBootProject.CourseApi.springBootProject.service.RegistrationService;
import SpringBootProject.CourseApi.springBootProject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {


    @Autowired
    RegistrationService registrationService;


    @GetMapping("/{courseId}/allStudents")
    public List<Registration> getAllRegisteredStudents(@PathVariable int courseId) throws IdNotFoundException {
        return registrationService.getAllRegisteredStudents(courseId);
    }

    @GetMapping("/{rollNo}/allCourses")
    public List<Registration> getAllRegisteredCourses(@PathVariable int rollNo) throws IdNotFoundException {
        return registrationService.getAllRegisteredCourses(rollNo);
    }


    @PostMapping("/newRegistration/{rollNo}/{courseId}")
    public ResponseEntity<String> addNewRegistration(@RequestBody Registration registration, @PathVariable int rollNo, @PathVariable int courseId) throws IdNotFoundException {
        registrationService.createRegistration(registration,courseId,rollNo);
        return new ResponseEntity<>("The student is successfully added to the database", HttpStatus.OK);
    }
//    @PostMapping()
//    public ResponseEntity<String> addNewRegistration(@RequestBody int studentId, @RequestBody int courseId) throws IdNotFoundException {
//        registrationService.createRegistration(studentId, courseId);
//        return new ResponseEntity<>("The student is successfully added to the database", HttpStatus.OK);
//    }


    //TODO
    //To change grades nothing else
//    @PutMapping("/UpdateStudent")
//    public ResponseEntity<String> updateStudent(@PathVariable int id)
//    {
//        return new ResponseEntity<>("The student's information was updated successfully", HttpStatus.OK);
//    }

//    @DeleteMapping("/deleteRegistration/{rollNo}/{courseId}")
//    public ResponseEntity<String> deleteStudent(@PathVariable int rollNo, @PathVariable int courseId) throws IdNotFoundException {
//        registrationService.deleteRegistration(courseId,rollNo);
//        return new ResponseEntity<>("The student is successfully removed from the database", HttpStatus.OK);
//
//    }




}
