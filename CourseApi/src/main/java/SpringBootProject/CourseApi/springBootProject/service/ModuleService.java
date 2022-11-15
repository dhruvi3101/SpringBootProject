package SpringBootProject.CourseApi.springBootProject.service;

import SpringBootProject.CourseApi.springBootProject.entity.Module;
import SpringBootProject.CourseApi.springBootProject.exception.IdNotFoundException;
import SpringBootProject.CourseApi.springBootProject.exception.NameNotFoundException;
import SpringBootProject.CourseApi.springBootProject.repository.CourseRepository;
import SpringBootProject.CourseApi.springBootProject.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepo;
    @Autowired
    private CourseRepository courseRepo;


    public List<Module> getAllModules(int CourseId) {
        List<Module> modules = new ArrayList<>();

        moduleRepo.findByCourseId(CourseId).forEach(modules::add);

        return modules;
    }


    public Module getModuleByName(int courseId, String moduleTitle) throws IdNotFoundException {
        if (courseRepo.findById(courseId).isPresent()) {
            if (moduleRepo.findByTitle(moduleTitle) != null) {
                return moduleRepo.findByTitle(moduleTitle);
            } else {
                throw new IdNotFoundException();
            }
        } else {
            throw new IdNotFoundException();
        }

    }

    public void addModule(int courseId, Module module) throws IdNotFoundException {


        if (courseRepo.findById(courseId).isPresent()) {
            module.setCourse(courseRepo.findById(courseId).get());
            moduleRepo.save(module);
        } else {
            throw new IdNotFoundException();
        }

    }

    public void updateModule(int courseId, Module module, String moduleTitle) throws IdNotFoundException, NameNotFoundException {

        if (courseRepo.findById(courseId).isPresent()) {
            if (moduleRepo.findByTitle(moduleTitle) != null) {
                moduleRepo.save(module);
            } else {
                throw new NameNotFoundException();
            }
        } else {
            throw new IdNotFoundException();
        }
    }


    public void deleteModule(String moduleTitle) throws IdNotFoundException {

        if (moduleRepo.findByTitle(moduleTitle) != null) {
            moduleRepo.deleteByTitle(moduleTitle);
        } else {
            throw new IdNotFoundException();
        }

    }

//public Page<Module> paginationOnModule(int offset, int pagesize){
//
//	return modulePageRepo.findAll(PageRequest.of(offset, pagesize));
//
//}

}