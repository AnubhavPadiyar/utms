package com.gehu.utms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private StopRepository stopRepository;

    // Register a new student and auto assign bus
    @PostMapping("/register")
    public Map<String, Object> registerStudent(@RequestBody Map<String, Object> request) {
        Map<String, Object> result = new HashMap<>();

        // Check if student already exists
        String studentId = (String) request.get("studentId");
        if (studentRepository.existsByStudentId(studentId)) {
            result.put("success", false);
            result.put("message", "Student ID already registered!");
            return result;
        }

        // Find buses that pass through the student's boarding stop
        String boardingStop = (String) request.get("boardingStop");
        Stop stop = stopRepository.findByName(boardingStop);

        int assignedBus = 0;
        if (stop != null) {
            List<Bus> busesAtStop = busRepository.findByCorridor(stop.getCorridor());
            if (!busesAtStop.isEmpty()) {
                assignedBus = busesAtStop.get(0).getBusNumber();
            }
        }

        // Save student
        Student student = new Student(
            (String) request.get("name"),
            studentId,
            (String) request.get("email"),
            boardingStop,
            assignedBus
        );
        studentRepository.save(student);

        result.put("success", true);
        result.put("message", "Registration successful!");
        result.put("assignedBus", assignedBus);
        result.put("student", student);
        return result;
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    @GetMapping("/{studentId}")
    public Map<String, Object> getStudent(@PathVariable String studentId) {
        Map<String, Object> result = new HashMap<>();
        Student student = studentRepository.findByStudentId(studentId);
        if (student == null) {
            result.put("success", false);
            result.put("message", "Student not found!");
        } else {
            result.put("success", true);
            result.put("student", student);
        }
        return result;
    }
}