package com.example._26_progress_be.controller;

import com.example._26_progress_be.model.Mark;
import com.example._26_progress_be.model.Student;
import com.example._26_progress_be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students/{id}/edit")
    public String editStudent(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        model.addAttribute("student", student.orElse(null));
        return "edit-student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {
        student.setId(id);
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/students/{id}/delete")
    public String deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/";
    }

    @PostMapping("/marks")
    public String saveMark(@ModelAttribute("mark") Mark mark) {
        studentService.saveMark(mark);
        return "redirect:/";
    }

    @GetMapping("/marks/{id}/edit")
    public String editMark(@PathVariable Long id, Model model) {
        Optional<Mark> mark = studentService.getMarkById(id);
        model.addAttribute("mark", mark.orElse(null));
        return "edit-mark";
    }

    @PostMapping("/marks/{id}")
    public String updateMark(@PathVariable Long id, @ModelAttribute("mark") Mark mark) {
        mark.setId(id);
        studentService.saveMark(mark);
        return "redirect:/";
    }

    @GetMapping("/marks/{id}/delete")
    public String deleteMarkById(@PathVariable Long id) {
        studentService.deleteMarkById(id);
        return "redirect:/";
    }
}
