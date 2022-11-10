package SpringBootProject.CourseApi.springBootProject.repository;

import SpringBootProject.CourseApi.springBootProject.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

    public List<Module> findByCourseId(int courseId);

    public Module findByTitle(String title);

    public void deleteByTitle(String title);


}
