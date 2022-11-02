package SpringBootProject.modules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import SpringBootProject.Courses.Course;
import SpringBootProject.Exception.IdNotFoundException;

import java.util.List;

import javax.validation.Valid;

@RestController
public class ModuleController {

    @Autowired
    private ModuleService moduleService;


    @RequestMapping("/courses/{id}/modules")
    public List<Module> getAllModules(@PathVariable int id)
    {
        return moduleService.getAllModules(id);
    }

    @RequestMapping("/courses/{CourseId}/modules/{id}")
    public Module getModule(@PathVariable int id) throws IdNotFoundException
    {
    	
    	
        return moduleService.getModule(id);
    	

    }
    
    @RequestMapping("/courses/{id}/modules/page/{offset}/{pageSize}")
    public Page<Module> getAllModulesWithPage(@PathVariable int offset, @PathVariable int pageSize)
    {
        return moduleService.paginationOnModule(offset, pageSize);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses/{id}/modules")
    public void addModule(@RequestBody @Valid Module module,@PathVariable int id)
    {
    	module.setCourse(new Course(id,"",""));
        moduleService.addModule(module);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/courses/{CourseId}/modules/{id}")
    public void updateModules(@RequestBody @Valid Module module, @PathVariable int CourseId, @PathVariable int id) throws IdNotFoundException
    {
    	
    		module.setCourse(new Course(CourseId,"",""));
            moduleService.updateModule(module);
    	    	
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/{CourseId}/modules/{id}")
    public void deleteModule(@PathVariable int id) throws IdNotFoundException
    {
    	
    		moduleService.deleteModule(id);

        
    }
}
