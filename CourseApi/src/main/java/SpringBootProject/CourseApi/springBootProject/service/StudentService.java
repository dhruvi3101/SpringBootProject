package SpringBootProject.CourseApi.springBootProject.service;

import SpringBootProject.CourseApi.springBootProject.entity.Student;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import SpringBootProject.CourseApi.springBootProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepo;

    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }

    public Student getStudentById(int rollNo) throws IdNotFoundException {
        if(studentRepo.findById(rollNo).isPresent())
        {
            return studentRepo.findById(rollNo).get();

        }

        else
        {
            throw new IdNotFoundException();
        }

    }

    public void AddStudent(Student student)
    {

            studentRepo.save(student);

    }

    public void UpdateStudent(Student student, int rollNo) throws IdNotFoundException
    {
        if (studentRepo.findById(rollNo).isPresent())
        {
            studentRepo.save(student);
        }
        else
        {
            throw new IdNotFoundException();
        }
    }

    public void DeleteStudent(int rollNo) throws IdNotFoundException
    {
        if (studentRepo.findById(rollNo).isPresent())
        {
            studentRepo.deleteById(rollNo);
        }
        else
        {
            throw new IdNotFoundException();
        }

    }






}
