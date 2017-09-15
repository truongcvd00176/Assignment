/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaconsole.entity.Student;

/**
 *
 * @author daolinh
 */
public class StudentModel {

    private static ArrayList<Student> listStudent;

    public ArrayList<Student> getList() {
        return listStudent;
    }

    public void insert(Student student) {
        long startTime = System.currentTimeMillis();
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("INSERT INTO student (id, name, email, roll_number, class_name, status) VALUE (?,?,?,?,?,?);");
            preStt.setInt(1, (int) student.getId());
            preStt.setString(2, student.getName());
            preStt.setString(3, student.getEmail());
            preStt.setString(4, student.getRollNumber());
            preStt.setString(5, student.getClassName());
            preStt.setInt(6, (int) student.getStatus());

            if (preStt.executeUpdate() > 0) {
                System.out.println("INSERT Success!!!");
            } else {
                System.err.println("INSERT Failed");
            }
        } catch (SQLException e) {
            System.err.println("ERROR" + e.getMessage());
        }
    }

    public ArrayList<Student> getlistStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            Statement stt = DAO.getConnection().createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setRollNumber(rs.getString("roll_number"));
                student.setClassName(rs.getString("class_name"));
                student.setStatus(rs.getInt("status"));
                listStudent.add(student);

            }

        } catch (SQLException ex) {
            System.err.println("ERROR " + ex.getMessage());
        }
        return listStudent;
    }

    public void update(Student student) {

        try {

            String sqlQuery = "update student set name=?, email=?, roll_number=?, class_name=?, status=? where id=?";
            PreparedStatement stm = DAO.getConnection().prepareStatement(sqlQuery);
            stm.setString(1, student.getName());
            stm.setString(2, student.getEmail());
            stm.setString(3, student.getRollNumber());
            stm.setString(4, student.getClassName());
            stm.setInt(5, student.getStatus());
            stm.setInt(6, student.getId());

            if (stm.executeUpdate() > 0) {
                System.out.println("INSERT Success!!!");
            } else {
                System.err.println("INSERT Failed");
            }
        } catch (SQLException ex) {
            System.err.println("ERROR " + ex.getMessage());
        }

    }

    public void delete(int id) {
        try {
            Connection conn = DAO.getConnection();
            PreparedStatement preStt = conn.prepareStatement("DELETE FROM student where id=?");
            preStt.setInt(1, id);
            if (preStt.executeUpdate() > 0) {
                System.out.println("DELETE Success!!!");
            } else {
                System.out.println("DELETE Failed");
            }
        } catch (Exception e) {
            System.err.println("ERROR " + e.getMessage());
        }
    }

    public Student getById(int id) {
        try {
            Connection cnn = DAO.getConnection();
            PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM student WHERE id = ?");
            preStt.setInt(1, id);
            ResultSet rs = preStt.executeQuery();
            if (rs.next()) {
                Student stu = new Student();
                stu.setId(rs.getInt("id"));
                stu.setName(rs.getString("name"));
                stu.setEmail(rs.getString("email"));
                stu.setRollNumber(rs.getString("roll_number"));
                stu.setClassName(rs.getString("class_name"));
                stu.setStatus(rs.getInt("status"));
                return stu;
            } else {
                System.err.println("No Student Has Id = " + id);
            }
        } catch (SQLException e) {
            System.err.println("ERROR " + e.getMessage());
        }

        return null;
    }





}
