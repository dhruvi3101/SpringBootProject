package SpringBootProject.CourseApi.springBootProject.service;

import SpringBootProject.CourseApi.springBootProject.entity.Course;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import SpringBootProject.CourseApi.springBootProject.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepo;

	
public List<Course> getAllCourses()
{
	List<Course> courses = new ArrayList<>();
	
    courseRepo.findAll().forEach(courses::add);
    
    return courses;
}


public Course getCourse(int id) throws IdNotFoundException
{
	
		Optional<Course> op = courseRepo.findById(id);
		
		if(op.isPresent())
		{
			return op.get();
		}
		else
		{
			throw new IdNotFoundException();
		}
	
}

public void addCourse(Course course)
{
    courseRepo.save(course);
}

public void updateCourse(int id,Course course) throws IdNotFoundException
{
	if(courseRepo.findById(id) != null)
	{
		courseRepo.save(course);	
	}
	else
	{
		throw new IdNotFoundException();
	}
	
}


public void deleteCourse(int id) throws IdNotFoundException {
	
	if(courseRepo.findById(id) != null)
	{
		courseRepo.deleteById(id);
	}
	else
	{
		throw new IdNotFoundException();
	}
	
}

//public Page<Course> paginationOnCourse(int offset, int pagesize){
//
//	Page<Course> coursePage= pageRepo.findAll(PageRequest.of(offset, pagesize));
//	return coursePage;
//
//}
}