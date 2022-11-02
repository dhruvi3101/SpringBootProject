package SpringBootProject.Courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursePagingRepository extends JpaRepository<Course, Integer> {
	
	

}
