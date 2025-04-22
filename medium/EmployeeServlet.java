package com.example.servlet;

import com.example.dao.EmployeeDAO;
import com.example.model.Employee;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    private EmployeeDAO employeeDAO;

    @Override
    public void init() {
        employeeDAO = new EmployeeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empId = request.getParameter("employeeId");
        if (empId != null && !empId.isEmpty()) {
            int id = Integer.parseInt(empId);
            Employee emp = employeeDAO.getEmployeeById(id);
            request.setAttribute("employee", emp);
        } else {
            List<Employee> employees = employeeDAO.getAllEmployees();
            request.setAttribute("employees", employees);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
        dispatcher.forward(request, response);
    }
}
