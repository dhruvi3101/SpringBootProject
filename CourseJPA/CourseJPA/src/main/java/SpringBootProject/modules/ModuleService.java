package SpringBootProject.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import SpringBootProject.Courses.Course;
import SpringBootProject.Exception.IdNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {
	
	@Autowired
	private ModuleRepository moduleRepo;
	
	@Autowired
	private ModulePagingRepository modulePageRepo;

	
public List<Module> getAllModules(int CourseId)
{
	List<Module> modules = new ArrayList<>();
	
    moduleRepo.findByCourseId(CourseId).forEach(modules::add);
    
    return modules;
}


public Module getModule(int id) throws IdNotFoundException
{
	
	Optional<Module> op = moduleRepo.findById(id);
	
	if(op.isPresent())
	{
		return op.get();
	}
	else
	{
		throw new IdNotFoundException();
	}
	
	
}

public void addModule(Module module)
{
    moduleRepo.save(module);
}

public void updateModule(Module module) throws IdNotFoundException
{
	if(moduleRepo.findById(module.getId()) != null)
	{
		moduleRepo.save(module);
	}
	else
	{
		throw new IdNotFoundException();
	}
	
		
}


public void deleteModule(int id) throws IdNotFoundException {
	
	if(moduleRepo.findById(id) != null)
	{
		moduleRepo.deleteById(id);
	}
	
	else
	{
		throw new IdNotFoundException();
	}
	
}

public Page<Module> paginationOnModule(int offset, int pagesize){
	
	Page<Module> modulePage= modulePageRepo.findAll(PageRequest.of(offset, pagesize));
	return modulePage;

}

}