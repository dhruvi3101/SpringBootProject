package SpringBootProject.CourseApi.springBootProject.modelMapper;

import SpringBootProject.CourseApi.springBootProject.DTO.CourseGetDto;
import SpringBootProject.CourseApi.springBootProject.DTO.CoursePostDto;
import SpringBootProject.CourseApi.springBootProject.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course DtoToCourse(CoursePostDto coursePostDto);
    CourseGetDto CourseToDto(Course course);



}
