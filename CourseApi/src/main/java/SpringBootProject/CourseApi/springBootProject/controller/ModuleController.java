package SpringBootProject.CourseApi.springBootProject.controller;

import SpringBootProject.CourseApi.springBootProject.entity.Module;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import SpringBootProject.CourseApi.springBootProject.exception.NameNotFoundException;
import SpringBootProject.CourseApi.springBootProject.service.CourseService;
import SpringBootProject.CourseApi.springBootProject.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses/{courseId}/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Module> getAllModules(@PathVariable int courseId) {
        return moduleService.getAllModules(courseId);
    }

    @GetMapping("/{moduleName}")
    public Module getModuleByName(@PathVariable int courseId, @PathVariable String moduleName) throws IdNotFoundException {

        return moduleService.getModuleByName(courseId, moduleName);

    }

//    @RequestMapping("/courses/{id}/modules/page/{offset}/{pageSize}")
//    public Page<Module> getAllModulesWithPage(@PathVariable int offset, @PathVariable int pageSize)
//    {
//        return moduleService.paginationOnModule(offset, pageSize);
//    }

    @PostMapping
    public ResponseEntity<String> addModule(@RequestBody @Valid Module module, @PathVariable int courseId) throws IdNotFoundException {
        moduleService.addModule(courseId, module);
        return new ResponseEntity<>("The module was successfully added", HttpStatus.OK);
    }

    @PutMapping("/{moduleName}")
    public ResponseEntity<String> updateModules(@RequestBody @Valid Module module, @PathVariable int courseId, @PathVariable String moduleName) throws IdNotFoundException, NameNotFoundException {
        moduleService.updateModule(courseId, module, moduleName);
        return new ResponseEntity<>("The module was updated successfully", HttpStatus.OK);

    }

    @DeleteMapping("/{moduleName}")
    public void deleteModule(@PathVariable String moduleName) throws IdNotFoundException {

        moduleService.deleteModule(moduleName);


    }
}
