package com.surafel.studentregistration.controllers;

import com.surafel.studentregistration.Services.StudentService;
import com.surafel.studentregistration.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = {"/registerStudent", "eregistrar/searchOption"})
    public String showRegisterStudent(Model model) {
        model.addAttribute("student", new Student());
        return "/register_student";
    }

    @GetMapping(value = {"/searchOption", "eregistrar/searchOption"})
    public String showSearchOption()
    {
        return "search_option";
    }

//    @GetMapping(value = {"/searchStudent", "eregistrar/searchStudent"})
//    public String Search()
//    {
//        return "search_result";
//    }

    @PostMapping(value = "/saveStudent")
    public String addNewStudent(@Valid @ModelAttribute ("student")Student student
                                        , BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/register_student";
        }
            Student  savedStudent = studentService.registerStudent(student);
            return "redirect:/listStudents";
    }

    @RequestMapping(value = "/listStudents")
    public ModelAndView showAllStudents(@RequestParam(defaultValue = "0") int pageno)
    {
        ModelAndView modelAndView = new ModelAndView();
        Page<Student> page = studentService.findAllStudents(pageno);
        modelAndView.setViewName("/list_students");
        modelAndView.addObject("students",page);
        modelAndView.addObject("currentPageNo",pageno);
        return modelAndView;
    }

    @GetMapping(value = {"/editStudent/{studentId}"})
    public String editBook(@PathVariable Long studentId, Model model) {
        Student student = studentService.findByStudentId(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "/edit_student";
        }
        return "/list_students";
    }

    @PostMapping(value = {"/updateStudent"})
    public String updateBook(@Valid @ModelAttribute("student") Student student,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/editStudent";
        }
        studentService.registerStudent(student);
        return "redirect:/listStudents";
    }

    @GetMapping(value = {"/deleteStudent/{bookId}"})
    public String deleteBook(@PathVariable Long studentId, Model model) {
        studentService.deleteByStudentId(studentId);
        return "redirect:/listStudents";
    }

    @RequestMapping("/searchStudent")
    public ModelAndView searchByStudentName(@RequestParam(defaultValue = "0") int pageno, String studentName)
    {
        ModelAndView modelAndView = new ModelAndView();
        Page<Student> students = studentService.findByName(studentName, studentName, studentName);
        modelAndView.addObject("students", students);
        modelAndView.addObject("currentPageNo",pageno);
        modelAndView.setViewName("/list_students");
        return  modelAndView;

    }

}

