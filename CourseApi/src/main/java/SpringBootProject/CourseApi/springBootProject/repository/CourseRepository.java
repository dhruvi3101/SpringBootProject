package SpringBootProject.CourseApi.springBootProject.repository;

import SpringBootProject.CourseApi.springBootProject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {


	
	

}
