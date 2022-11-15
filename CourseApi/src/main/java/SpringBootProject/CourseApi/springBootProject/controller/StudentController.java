package SpringBootProject.CourseApi.springBootProject.controller;

import SpringBootProject.CourseApi.springBootProject.entity.Student;
import SpringBootProject.CourseApi.springBootProject.service.StudentService;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


        @Autowired
        StudentService studentService;

        //get all
        @GetMapping("/all")
        public List<Student> getAllStudents()
        {
            return studentService.getAllStudents();
        }

        @GetMapping("/{id}")
        public Student getStudent(@PathVariable int id) throws IdNotFoundException {
            return studentService.getStudentById(id);
        }

        @PostMapping()
        public ResponseEntity<String> addStudent(@RequestBody Student student)
        {
            studentService.AddStudent(student);
            return new ResponseEntity<>("The student is successfully added to the database", HttpStatus.OK);
        }


        @PutMapping("/{id}")
        public ResponseEntity<String> updateStudent(@RequestBody Student student, @PathVariable int id) throws IdNotFoundException {
            studentService.UpdateStudent(student,id);
            return new ResponseEntity<>("The student's information was updated successfully", HttpStatus.OK);
        }

        @DeleteMapping()
        public ResponseEntity<String> deleteStudent(@PathVariable int id) throws IdNotFoundException {
            studentService.DeleteStudent(id);
            return new ResponseEntity<>("The student is successfully removed from the database", HttpStatus.OK);

        }


    }





