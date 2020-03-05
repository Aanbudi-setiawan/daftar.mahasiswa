package com.daftarmahasiswa.thymeleaf.controller;

import com.daftarmahasiswa.thymeleaf.entity.Student;
import com.daftarmahasiswa.thymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<Student> daftarMahasiswa = studentService.showAll();
        model.addAttribute("daftarMahasiswa",daftarMahasiswa);
        return "index";
    }

    @RequestMapping("/baru")
    public String newPage(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "mahasiswa_baru";
    }

    @RequestMapping("/kindex")
    public String backHome(){
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveMahasiswa(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editMahasiswa(@PathVariable(name = "id")int id){
        ModelAndView mav = new ModelAndView("edit_mahasiswa");
        Student student = studentService.findId(id);
        mav.addObject("student",student);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteMahasiswa(@PathVariable(name = "id") int id){
        studentService.delete(id);
        return "redirect:/";
    }
}
