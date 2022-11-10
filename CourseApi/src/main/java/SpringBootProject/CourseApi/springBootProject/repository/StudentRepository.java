package SpringBootProject.CourseApi.springBootProject.repository;


import SpringBootProject.CourseApi.springBootProject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
