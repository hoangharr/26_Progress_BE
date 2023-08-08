package com.example._26_progress_be.service;

import com.example._26_progress_be.model.Mark;
import com.example._26_progress_be.model.Student;
import com.example._26_progress_be.repository.MarkRepository;
import com.example._26_progress_be.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MarkRepository markRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }


    public List<Mark> getAllMarks() {
        return markRepository.findAll();
    }

    public Optional<Mark> getMarkById(Long id) {
        return markRepository.findById(id);
    }

    public Mark saveMark(Mark mark) {
        return markRepository.save(mark);
    }

    public void deleteMarkById(Long id) {
        markRepository.deleteById(id);
    }
}
