package com.example.dao;

import com.example.model.Student;
import java.sql.*;
import java.util.*;

public class AttendanceDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/attendance_db";
    private String jdbcUser = "root";
    private String jdbcPass = "your_password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Student(rs.getInt("id"), rs.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveAttendance(int studentId, String date, String status) {
        String sql = "INSERT INTO attendance (student_id, date, status) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentId);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setString(3, status);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
