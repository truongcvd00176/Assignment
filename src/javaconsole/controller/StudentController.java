/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaconsole.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javaconsole.entity.Student;
import javaconsole.model.StudentModel;

/**
 *
 * @author daolinh
 */
public class StudentController {
    // 1. getList.
    // 2. add.
    // 3. edit.
    // 4. delete.

    private StudentModel studentModel = new StudentModel();

    // Hàm này sẽ phải trả về danh sách sinh viên.
    public void getList() {
        System.out.println("+--------------------------------+");
        System.out.println("→ 1.Student List ");
        studentModel.getlistStudent();
        ArrayList<Student> listStudent = studentModel.getlistStudent();
        int i = 1;
        System.out.print("+--ID--+------------Name--------------+------------Email-------------+-----Roll-Number----+--Class-Name--+");
        for (Student student : listStudent) {
            i = student.getId();
            String n = student.getName();
            String e = student.getEmail();
            String r = student.getRollNumber();
            String c = student.getClassName();

            if (i < 10) {
                System.out.print("\n|" + student.getId());
                for (int x = 1; x < 6; x++) {
                    System.out.print(" ");
                }

            } else if (i >= 10 && i < 100) {
                System.out.print("\n|" + student.getId());
                for (int x = 2; x < 6; x++) {
                    System.out.print(" ");
                }

            } else if (i >= 100 && i < 1000) {
                System.out.print("\n|" + student.getId());
                for (int x = 3; x < 6; x++) {
                    System.out.print(" ");
                }

            }
            System.out.print("|" + student.getName());
            for (int x = n.length(); x < 30; x++) {
                System.out.print(" ");
            }

            System.out.print("|" + student.getEmail());
            for (int x = e.length(); x < 30; x++) {
                System.out.print(" ");
            }

            System.out.print("|" + student.getRollNumber());
            for (int x = r.length(); x < 20; x++) {
                System.out.print(" ");
            }

            System.out.print("|" + student.getClassName());
            for (int x = c.length(); x < 14; x++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("\n+------+------------------------------+------------------------------+--------------------+--------------+");

        }
        if (listStudent.size() == 0) {
            System.out.print("\n+------+------------------------------+------------------------------+--------------------+--------------+");
            System.err.println("List Student Null!!! Plese Enter To Back Menu And Choice 2.Add Student");
        }
//                
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

    }

    // Thêm mới sinh viên, thực hiện việc lấy dữ liệu từ người dùng,
    // validate dữ liệu đó, tiến hành lưu thông tin.
    public void addStudent() {
        int hi = 1;
        while (hi == 1) {
            System.out.println("+--------------------------------+");
            System.out.println("→ 2.Add Student");
            Scanner scanner = new Scanner(System.in);
            System.out.println("» Please enter student information.");
            System.out.println("• Please enter name: ");
            String name = scanner.nextLine();
            System.out.println("• Please enter email: ");
            String email = scanner.nextLine();
            System.out.println("• Please enter roll number");
            String rollNumber = scanner.nextLine();
            System.out.println("• Please enter class name");
            String className = scanner.nextLine();
            System.out.println("+--------------------------------+");
            // Validate dữ liệu ở đây.

            if (name.length() > 1
                    && name.length() <= 30
                    && email.length() > 1
                    && email.length() <= 30
                    && rollNumber.length() <= 20
                    && className.length() > 1
                    && className.length() <= 14) {
                Student student = new Student();
                student.setName(name);
                student.setEmail(email);
                student.setRollNumber(rollNumber);
                student.setClassName(className);
                student.setStatus(1);
                studentModel.insert(student);
                hi++;

            } else if (name.length() <= 1 || name.length() > 30) {
                System.err.println("Please Enter Length Of Name From 1 to 30 Characters");
                System.out.println("» Would You Like To Continue Add Student?");
                hi = 2;
                while (hi == 2) {
                    System.out.println("» Yes(Y)/No(N):");
                    String choicee = scanner.nextLine();
                    switch (choicee) {
                        case "y":
                        case "Y":
                            hi = 1;
                            break;
                        case "n":
                        case "N":
                            hi++;
                            break;
                        default:
                            System.err.println("Please Choice Yes(Y)/No(N):");
                            break;
                    }
                }

            } else if (email.length() <= 1 || email.length() > 30) {
                System.err.println("Please Enter Length Of Email From 1 to 30 Characters");
                System.out.println("» Would You Like To Continue Add Student?");
                hi = 2;
                while (hi == 2) {
                    System.out.println("» Yes(Y)/No(N):");
                    String choicee = scanner.nextLine();
                    switch (choicee) {

                        case "y":
                        case "Y":
                            hi = 1;
                            break;
                        case "n":
                        case "N":
                            hi++;
                            break;
                        default:
                            System.err.println("Please Choice Yes(Y)/No(N):");
                            break;

                    }
                }
            } else if (rollNumber.length() <= 1 || rollNumber.length() > 20) {
                System.err.println("Please Enter Length Of Roll Number From 1 to 20 Characters");
                System.out.println("» Would You Like To Continue Add Student?");
                hi = 2;
                while (hi == 2) {
                    System.out.println("» Yes(Y)/No(N):");
                    String choicee = scanner.nextLine();
                    switch (choicee) {

                        case "y":
                        case "Y":
                            hi = 1;
                            break;
                        case "n":
                        case "N":
                            hi++;
                            break;
                        default:
                            System.err.println("Please Choice Yes(Y)/No(N):");
                            break;

                    }
                }
            } else if (className.length() <= 1 || className.length() > 14) {
                System.err.println("Please Enter Length Of Class Name From 1 to 14 Characters");
                System.out.println("» Would You Like To Continue Add Student?");
                hi = 2;
                while (hi == 2) {
                    System.out.println("» Yes(Y)/No(N):");
                    String choicee = scanner.nextLine();
                    switch (choicee) {

                        case "y":
                        case "Y":
                            hi = 1;
                            break;
                        case "n":
                        case "N":
                            hi++;
                            break;
                        default:
                            System.err.println("Please Choice Yes(Y)/No(N):");
                            break;

                    }
                }
            }
        }
    }

    public void editStudent() {
        System.out.println("+--------------------------------+");
        System.out.println("→ 3.Edit Student");
        System.out.print(" » What Records Do You Want Edit Student Has ID = ");
        Scanner scanner = new Scanner(System.in);
        String strSeach = scanner.nextLine();
        int id = 0;
        try {
            id = Integer.parseInt(strSeach);
            Student student = studentModel.getById(id);

            if (student != null) {
                System.out.println(" » Do You Want Edit This Student: ");
                System.out.print("+--ID--+------------Name--------------+------------Email-------------+-----Roll-Number----+--Class-Name--+");
                int i = student.getId();
                String n = student.getName();
                String e = student.getEmail();
                String r = student.getRollNumber();
                String c = student.getClassName();
                if (i < 10) {
                    System.out.print("\n|" + student.getId());
                    for (int x = 1; x < 6; x++) {
                        System.out.print(" ");
                    }

                } else if (i >= 10 && i < 100) {
                    System.out.print("\n|" + student.getId());
                    for (int x = 2; x < 6; x++) {
                        System.out.print(" ");
                    }

                } else if (i >= 100 && i < 1000) {
                    System.out.print("\n|" + student.getId());
                    for (int x = 3; x < 6; x++) {
                        System.out.print(" ");
                    }

                }
                System.out.print("|" + student.getName());
                for (int x = n.length(); x < 30; x++) {
                    System.out.print(" ");
                }

                System.out.print("|" + student.getEmail());
                for (int x = e.length(); x < 30; x++) {
                    System.out.print(" ");
                }

                System.out.print("|" + student.getRollNumber());
                for (int x = r.length(); x < 20; x++) {
                    System.out.print(" ");
                }

                System.out.print("|" + student.getClassName());
                for (int x = c.length(); x < 14; x++) {
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print("\n+------+------------------------------+------------------------------+--------------------+--------------+");
                int hi = 1;
                while (hi == 1) {
                    System.out.print("\n» Yes(Y)/No(N):");
                    String choice = scanner.nextLine();

                    switch (choice) {
                        case "y":
                        case "Y":
                            while (hi == 1) {
                                System.out.println(" » Please enter student information.");
                                System.out.println("• Please enter name: ");
                                String name = scanner.nextLine();
                                System.out.println("• Please enter email: ");
                                String email = scanner.nextLine();
                                System.out.println("• Please enter roll number");
                                String rollNumber = scanner.nextLine();
                                System.out.println("• Please enter class name");
                                String className = scanner.nextLine();
                                System.out.println("+--------------------------------+");

                                if (name.length() > 1
                                        && name.length() <= 30
                                        && email.length() > 1
                                        && email.length() <= 30
                                        && rollNumber.length() <= 20
                                        && className.length() > 1
                                        && className.length() <= 14) {

                                    student.setName(name);
                                    student.setEmail(email);
                                    student.setRollNumber(rollNumber);
                                    student.setClassName(className);
                                    student.setStatus(1);
                                    studentModel.update(student);
                                    hi++;
                                    System.out.println("+------------------------------+");
                                    System.out.println("|» Please Enter To Back Menu!!!|");
                                    System.out.println("+------------------------------+");
                                    String string = scanner.nextLine();

                                } else if (name.length() <= 1 || name.length() > 30) {
                                    System.err.println("Please Enter Length Of Name From 1 to 30 Characters");
                                    System.out.println("» Would You Like To Continue Edit This Student?");
                                    hi = 2;
                                    while (hi == 2) {
                                        System.out.println("» Yes(Y)/No(N):");
                                        String choicee = scanner.nextLine();
                                        switch (choicee) {

                                            case "y":
                                            case "Y":
                                                hi = 1;
                                                break;
                                            case "n":
                                            case "N":
                                                hi++;
                                                break;
                                            default:
                                                System.err.println("Please Choice Yes(Y)/No(N):");
                                                break;

                                        }
                                    }

                                } else if (email.length() <= 1 || email.length() > 30) {
                                    System.err.println("Please Enter Length Of Email From 1 to 30 Characters");
                                    System.out.println("» Would You Like To Continue Edit This Student?");
                                    hi = 2;
                                    while (hi == 2) {
                                        System.out.println("» Yes(Y)/No(N):");
                                        String choicee = scanner.nextLine();
                                        switch (choicee) {

                                            case "y":
                                            case "Y":
                                                hi = 1;
                                                break;
                                            case "n":
                                            case "N":
                                                hi++;
                                                break;
                                            default:
                                                System.err.println("Please Choice Yes(Y)/No(N):");
                                                break;

                                        }
                                    }
                                } else if (rollNumber.length() <= 1 || rollNumber.length() > 20) {
                                    System.err.println("Please Enter Length Of Roll Number From 1 to 20 Characters");
                                    System.out.println("» Would You Like To Continue Edit This Student?");
                                    hi = 2;
                                    while (hi == 2) {
                                        System.out.println("» Yes(Y)/No(N):");
                                        String choicee = scanner.nextLine();
                                        switch (choicee) {

                                            case "y":
                                            case "Y":
                                                hi = 1;
                                                break;
                                            case "n":
                                            case "N":
                                                hi++;
                                                break;
                                            default:
                                                System.err.println("Please Choice Yes(Y)/No(N):");
                                                break;

                                        }
                                    }
                                } else if (className.length() <= 1 || className.length() > 14) {
                                    System.err.println("Please Enter Length Of Class Name From 1 to 14 Characters");
                                    System.out.println("» Would You Like To Continue Edit This Student?");
                                    hi = 2;
                                    while (hi == 2) {
                                        System.out.println("» Yes(Y)/No(N):");
                                        String choicee = scanner.nextLine();
                                        switch (choicee) {

                                            case "y":
                                            case "Y":
                                                hi = 1;
                                                break;
                                            case "n":
                                            case "N":
                                                hi++;
                                                break;
                                            default:
                                                System.err.println("Please Choice Yes(Y)/No(N):");
                                                break;

                                        }
                                    }
                                }
                            }
                            break;

                        case "n":
                        case "N":
                            System.out.println("+---------------------+");
                            System.out.println("|You Choice No Edit!!!|");
                            System.out.println("+---------------------+");
                            System.out.println("+------------------------------+");
                            System.out.println("|» Please Enter To Back Menu!!!|");
                            System.out.println("+------------------------------+");
                            String string = scanner.nextLine();
                            hi++;
                            break;

                        default:
                            System.err.println("Please Choice Yes(Y)/No(N):");
                            break;
                    }
                }

            }
        } catch (java.lang.NumberFormatException e) {
            System.err.println("Please Enter A Number.");
        }

    }

    public void deleteStudent() {
        System.out.println("+--------------------------------+");
        System.out.println("→ 4.Delete Student");
        System.out.println("What Records Do You Want To Delete?");
        System.out.print("Id = ");
        Scanner scanner = new Scanner(System.in);
        String strSeach = scanner.nextLine();

        int id = 0;
        try {
            id = Integer.parseInt(strSeach);
        } catch (java.lang.NumberFormatException e) {
            System.err.println("Please Enter A Number.");
        }

        Student student = studentModel.getById(id);
        if (student != null) {
            System.out.println(" » Do You Want Delete This Student?:");
            System.out.print("+--ID--+------------Name--------------+------------Email-------------+-----Roll-Number----+--Class-Name--+");
            int i = student.getId();
            String n = student.getName();
            String e = student.getEmail();
            String r = student.getRollNumber();
            String c = student.getClassName();
            if (i < 10) {
                System.out.print("\n|" + student.getId());
                for (int x = 1; x < 6; x++) {
                    System.out.print(" ");
                }

            } else if (i >= 10 && i < 100) {
                System.out.print("\n|" + student.getId());
                for (int x = 2; x < 6; x++) {
                    System.out.print(" ");
                }

            } else if (i >= 100 && i < 1000) {
                System.out.print("\n|" + student.getId());
                for (int x = 3; x < 6; x++) {
                    System.out.print(" ");
                }

            }
            System.out.print("|" + student.getName());
            for (int x = n.length(); x < 30; x++) {
                System.out.print(" ");
            }

            System.out.print("|" + student.getEmail());
            for (int x = e.length(); x < 30; x++) {
                System.out.print(" ");
            }

            System.out.print("|" + student.getRollNumber());
            for (int x = r.length(); x < 20; x++) {
                System.out.print(" ");
            }

            System.out.print("|" + student.getClassName());
            for (int x = c.length(); x < 14; x++) {
                System.out.print(" ");
            }
            System.out.print("|");
            System.out.print("\n+------+------------------------------+------------------------------+--------------------+--------------+");

            System.out.print("\nYes(Y)/No(N):");
            String choice = scanner.nextLine();
            switch (choice) {
                case "y":
                case "Y":
                    studentModel.delete(id);
                    break;
                case "n":
                case "N":
                    System.out.println("+--------------------+");
                    System.out.println("|You Choice No Delete|");
                    System.out.println("+--------------------+");
                    break;

                default:
                    System.err.println("\nPlease Choice Yes(Y)/No(N):");
            }

        }
        System.out.println("+------------------------------+");
        System.out.println("|» Please Enter To Back Menu!!!|");
        System.out.println("+------------------------------+");
        String string = scanner.nextLine();

    }

    public void exportStudent() {
        System.out.println("+--------------------------------+");
        System.out.println("→ 5.Export Student");

        try {
            ArrayList<Student> listStudent = studentModel.getlistStudent();

            BufferedWriter b = new BufferedWriter(new FileWriter("text.txt"));
            b.write("» Student List From File text.txt");
            b.newLine();
            b.write("+--ID--+------------Name--------------+------------Email-------------+-----Roll-Number----+--Class-Name--+");

            for (Student student : listStudent) {
                int i = student.getId();
                String n = student.getName();
                String e = student.getEmail();
                String r = student.getRollNumber();
                String c = student.getClassName();
                if (i < 10) {
                    b.newLine();
                    b.write("|" + student.getId());
                    for (int x = 1; x < 6; x++) {
                        b.write(" ");
                    }

                } else if (i >= 10 && i < 100) {
                    b.newLine();
                    b.write("|" + student.getId());
                    for (int x = 2; x < 6; x++) {
                        b.write(" ");
                    }

                } else if (i >= 100 && i < 1000) {
                    b.newLine();
                    b.write("|" + student.getId());
                    for (int x = 3; x < 6; x++) {
                        b.write(" ");
                    }

                }
                b.write("|" + student.getName());
                for (int x = n.length(); x < 30; x++) {
                    b.write(" ");
                }

                b.write("|" + student.getEmail());
                for (int x = e.length(); x < 30; x++) {
                    b.write(" ");
                }

                b.write("|" + student.getRollNumber());
                for (int x = r.length(); x < 20; x++) {
                    b.write(" ");
                }

                b.write("|" + student.getClassName());
                for (int x = c.length(); x < 14; x++) {
                    b.write(" ");
                }
                b.write("|");
                b.newLine();
                b.write("+------+------------------------------+------------------------------+--------------------+--------------+");

            }
            b.close();
            System.out.println("EXPORT Success");
        } catch (IOException e) {
            System.err.println("ERROR" + e.getMessage());
        }
        System.out.println("+------------------------------+");
        System.out.println("|» Please Enter To Back Menu!!!|");
        System.out.println("+------------------------------+");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
    }

    public void importStudent() {
        System.out.println("+--------------------------------+");
        System.out.println("→ 6.Import Student");
        try (
                FileReader read = new FileReader("text.txt");
                BufferedReader br = new BufferedReader(read)) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File is not found!!!");
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("+------------------------------+");
        System.out.println("|» Please Enter To Back Menu!!!|");
        System.out.println("+------------------------------+");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
    }

}
