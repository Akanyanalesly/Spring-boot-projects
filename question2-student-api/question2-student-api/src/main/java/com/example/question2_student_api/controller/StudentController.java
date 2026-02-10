package com.example.question2_student_api.controller;

import com.example.question2_student_api.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    
    public StudentController() {
        students.add(new Student(1L, "John", "Paul", "john@gmail.com", "Computer Science", 3.8));
        students.add(new Student(2L, "Mary", "Smith", "mary@gmail.com", "Information Systems", 3.2));
        students.add(new Student(3L, "Alex", "Brown", "alex@gmail.com", "Computer Science", 3.6));
        students.add(new Student(4L, "Linda", "White", "linda@gmail.com", "Business", 2.9));
        students.add(new Student(5L, "James", "Green", "james@gmail.com", "Computer Science", 3.9));
    }

  
    @GetMapping
    public List<Student> getAllStudents() {
        return students;
    }

    
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }

    
    @GetMapping("/major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable String major) {
        return students.stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }


    @GetMapping("/filter")
    public List<Student> filterByGpa(@RequestParam Double gpa) {
        return students.stream()
                .filter(s -> s.getGpa() >= gpa)
                .collect(Collectors.toList());
    }

    
    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        students.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    
    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long studentId,
            @RequestBody Student updatedStudent) {

        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setFirstName(updatedStudent.getFirstName());
                student.setLastName(updatedStudent.getLastName());
                student.setEmail(updatedStudent.getEmail());
                student.setMajor(updatedStudent.getMajor());
                student.setGpa(updatedStudent.getGpa());
                return ResponseEntity.ok(student);
            }
        }
        return ResponseEntity.notFound().build();
    }
}
