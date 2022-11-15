package SpringBootProject.CourseApi.springBootProject.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoursePostDto {

    private int id;
    private String name;
    private String description;
}
