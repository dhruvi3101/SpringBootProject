package SpringBootProject.CourseApi.springBootProject.modelMapper;

import SpringBootProject.CourseApi.springBootProject.DTO.CourseGetDto;
import SpringBootProject.CourseApi.springBootProject.DTO.CoursePostDto;
import SpringBootProject.CourseApi.springBootProject.entity.Course;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-14T21:31:29+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
)
@Component
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course DtoToCourse(CoursePostDto coursePostDto) {
        if ( coursePostDto == null ) {
            return null;
        }

        Course course = new Course();

        return course;
    }

    @Override
    public CourseGetDto CourseToDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseGetDto courseGetDto = new CourseGetDto();

        return courseGetDto;
    }
}
