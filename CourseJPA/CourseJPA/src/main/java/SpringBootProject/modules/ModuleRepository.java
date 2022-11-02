package SpringBootProject.modules;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ModuleRepository extends CrudRepository<Module, Integer >{
	
	public List<Module> findByCourseId(int courseId);
	
	
	
	
	
	

}
