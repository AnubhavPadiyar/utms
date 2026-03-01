package com.gehu.utms;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String studentId;
    private String email;
    private String boardingStop;
    private int assignedBusNumber;

    public Student() {}

    public Student(String name, String studentId, String email, String boardingStop, int assignedBusNumber) {
        this.name = name;
        this.studentId = studentId;
        this.email = email;
        this.boardingStop = boardingStop;
        this.assignedBusNumber = assignedBusNumber;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public String getEmail() { return email; }
    public String getBoardingStop() { return boardingStop; }
    public int getAssignedBusNumber() { return assignedBusNumber; }
    public void setAssignedBusNumber(int assignedBusNumber) { this.assignedBusNumber = assignedBusNumber; }
}