package com.example.servlet;

import com.example.dao.AttendanceDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AttendanceServlet extends HttpServlet {
    private AttendanceDAO dao;

    public void init() {
        dao = new AttendanceDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        dao.saveAttendance(studentId, date, status);

        request.setAttribute("message", "Attendance saved successfully.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }
}
