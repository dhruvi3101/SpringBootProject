package SpringBootProject.CourseApi.springBootProject.repository;

import SpringBootProject.CourseApi.springBootProject.entity.Course;
import SpringBootProject.CourseApi.springBootProject.entity.Registration;
import SpringBootProject.CourseApi.springBootProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Integer> {

    public List<Registration> findAllByCourse(Course course);
    public List<Registration> findAllByStudent(Student student);

    public Registration findByCourseAndStudent(Course course, Student student);

    public void deleteByCourseAndStudent(Course course, Student student);








}
