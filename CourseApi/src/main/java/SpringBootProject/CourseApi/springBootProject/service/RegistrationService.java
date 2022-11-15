package SpringBootProject.CourseApi.springBootProject.service;



import SpringBootProject.CourseApi.springBootProject.entity.Registration;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import SpringBootProject.CourseApi.springBootProject.repository.CourseRepository;
import SpringBootProject.CourseApi.springBootProject.repository.RegistrationRepository;
import SpringBootProject.CourseApi.springBootProject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {


    @Autowired
    RegistrationRepository registrationRepo;

    @Autowired
    CourseRepository courseRepo;

    @Autowired
    StudentRepository studentRepo;

    public List<Registration> getAllRegisteredStudents(int courseId) throws IdNotFoundException {
        if (courseRepo.findById(courseId).isPresent()) {
            return registrationRepo.findAllByCourse(courseRepo.findById(courseId).get());
        }

        else
        {
            throw new IdNotFoundException();
        }

    }
    public List<Registration> getAllRegisteredCourses(int rollNo) throws IdNotFoundException {
        if(studentRepo.findById(rollNo).isPresent())
        {
            return registrationRepo.findAllByStudent(studentRepo.findById(rollNo).get());
        }

        else
        {
            throw new IdNotFoundException();
        }

    }

    public void createRegistration(Registration newRegistration, int courseId, int studentId) throws IdNotFoundException
    {
//        Registration newRegistration = new Registration();
        newRegistration.setCourse(courseRepo.findById(courseId).get());
        newRegistration.setStudent(studentRepo.findById(studentId).get());
        if(courseRepo.findById(newRegistration.getCourse().getId()).isPresent())
        {
            if (studentRepo.findById(studentId).isPresent())
            {

                registrationRepo.save(newRegistration);

            }
            else
            {
                throw new IdNotFoundException();
            }
        }

        else {
            throw new IdNotFoundException();
        }

    }

//    public void createRegistration(int studentId, int courseId) throws IdNotFoundException
//    {
//        Registration newRegistration = new Registration();
//
//        if(courseRepo.findById(courseId).isPresent())
//        {
//            if (studentRepo.findById(studentId).isPresent())
//            {
//                newRegistration.setCourse(courseRepo.findById(courseId).get());
//                newRegistration.setStudent(studentRepo.findById(studentId).get());
//                registrationRepo.save(newRegistration);
//            }
//            else
//            {
//                throw new IdNotFoundException();
//            }
//        }
//
//        else {
//            throw new IdNotFoundException();
//        }
//
//    }

    //TODO
    //Make grade as null when first initialized and then update grade using this method
//    public void UpdateRegistration(Student student) throws IdNotFoundException
//    {
//        if (studentRepo.findById(student.getRollNo()).isPresent())
//        {
//            studentRepo.save(student);
//        }
//        else
//        {
//            throw new IdNotFoundException();
//        }
//        }

//    public void deleteRegistration(int courseId, int studentId) throws IdNotFoundException {
//
//        if(courseRepo.findById(courseId).isPresent())
//        {
//            if (studentRepo.findById(studentId).isPresent())
//            {
//
//
//                registrationRepo.deleteByCourseAndStudent(courseRepo.findById(courseId).get(), studentRepo.findById(studentId).get());
//
//            }
//            else
//            {
//                throw new IdNotFoundException();
//            }
//        }
//
//        else {
//            throw new IdNotFoundException();
//        }
//    }

}
