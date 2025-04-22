package com.example.dao;

import com.example.model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/employee_db";
    private String jdbcUsername = "root";
    private String jdbcPassword = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("position"), rs.getString("department")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("id"), rs.getString("name"), rs.getString("position"), rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
