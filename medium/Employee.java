package com.example.model;

public class Employee {
    private int id;
    private String name;
    private String position;
    private String department;

    // Constructors, Getters and Setters
    public Employee(int id, String name, String position, String department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public String getDepartment() { return department; }
}
