
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS G731G
 */
class StudentManager {

    public static void DisplayMenu() {
        System.out.println("*********WELCOME TO STUDENT MANAGERMENT********");
        System.out.println("1.Create");
        System.out.println("2.Find and Sort");
        System.out.println("3.Update/Delete");
        System.out.println("4.Report");
        System.out.println("5.Exit");
        System.out.println("***********************************************");
    }

    public static void CreateStudent(ArrayList<Student> StudentList) {
        boolean match = false;
        String StudentName = "";
        // loop count number student in list student
        for (int i = 1; i <= StudentList.size(); i++) {
            if (i == 5) {
                System.out.print("Do you want to continue(Y/N): ");
                String choice = Inputter.inputChoiceYorN();
                if (choice.equalsIgnoreCase("N")) {
                    return;
                }
            }
        }
        //input student id
        String StudentID = Inputter.inputStringId("Enter Student ID:", "[a-zA-z0-9 ]+").toUpperCase();
        while (match != true) {
            StudentName = Inputter.inputStringName("Enter Student Name:").toUpperCase();
            match = CheckIdMatchName(StudentID, StudentName, StudentList);
        }
        String StudentSemester = Inputter.inputStudentSemester("Enter Student Semester:").toUpperCase();
        String StudentCourse = Inputter.inputStudentCourse("Enter Student Course(Java, .Net, C/C++):").toUpperCase();
        if (CheckDuplicate(StudentID, StudentSemester, StudentCourse, StudentList) == true) {
            System.out.println("Student was existed in list!");
            return;
        }
        Student student = new Student(StudentID, StudentName, StudentSemester, StudentCourse);
        StudentList.add(student);
        System.out.println("Create student successfull!");
        DisplayList(StudentList);
    }

    public static void FindAndSortStudentByName(ArrayList<Student> StudentList) {
        if (StudentList.isEmpty()) {
            System.out.println("List empty can not find and sort!");
        } else {
            ArrayList<Student> listStudentFindByName = new ArrayList<>();
            String name = Inputter.inputStringName("Enter student name:");
            if (CheckNameExist(name, StudentList)) {
                System.out.println("Find successfull!");
                // loop travese all student in list
                for (int i = 0; i < StudentList.size(); i++) {
                    // if name student contain the name user input
                    if (StudentList.get(i).getName().toUpperCase().contains(name.toUpperCase())) {
                        //then add a new student list 
                        listStudentFindByName.add(StudentList.get(i));
                    }
                }
                //sort student by name after found
                SortByName(listStudentFindByName);
                System.out.println("--------------- List After Sort ---------------");
                System.out.format("%-20s%-15s%-15s\n", "Student Name", "Semester", "Course Name");
                //loop taverse through all element in list countries
                for (int i = 0; i < listStudentFindByName.size(); i++) {
                    System.out.format("%-20s%-15s%-15s\n", listStudentFindByName.get(i).getName(), listStudentFindByName.get(i).getSemester(), listStudentFindByName.get(i).getCourseName());
                }
            } else {
                System.out.println("Name does not exist in list!");
            }
        }

    }

    public static void UpdateOrDeleteStudentById(ArrayList<Student> StudentList) {
        // check if list empty
        if (StudentList.isEmpty()) {
            System.out.println("list empty can not update or delete!");
        }
        //show list student
        DisplayList(StudentList);
        //input student id
        String StudentID = Inputter.inputStringId("Enter Student ID:", "[a-zA-z0-9 ]+");
        //if id student exist in list
        if (CheckIdExistInList(StudentID, StudentList)) {
            ArrayList<Student> listStudentFindByID = new ArrayList<>();
            // loop travese all student in list
            for (int i = 0; i < StudentList.size(); i++) {
                // if name student contain the mane user input
                if (StudentID.equalsIgnoreCase(StudentList.get(i).getID())) {
                    //add student result in a new list
                    listStudentFindByID.add(StudentList.get(i));
                }
            }
            //show list result
            DisplayList(listStudentFindByID);
            System.out.print("Enter student No: ");
            int studentNo = EnterStudentNo(listStudentFindByID);
            Student getStudent = listStudentFindByID.get(studentNo - 1);
            System.out.print("Do you want to update (U) or delete (D) student:");
            String choice = Inputter.inputChoiceUorD();
            //if user want to update
            if (choice.equalsIgnoreCase("U")) {
                String ID = Inputter.inputStringId("Enter new Student ID: ", "[a-zA-z0-9 ]+").toUpperCase();
                String studentName = Inputter.inputStringName("Enter new Student Name:").toUpperCase();
                String studentSemester = Inputter.inputStudentSemester("Enter new Student Semester:").toUpperCase();
                String studentCourse = Inputter.inputStudentCourse("Enter new Student Course(Java, .Net, C/C++):").toUpperCase();
                //if id,semester,course of student exist cant update
                if (CheckDuplicate(ID, studentSemester, studentCourse, StudentList)) {
                    System.out.println("Can not update because student exist in list");
                    return;
                }
                // loop traversal all student in list
                for (int i = 0; i < StudentList.size(); i++) {
                    // if name student contain the mane user input
                    if (getStudent.getID().equalsIgnoreCase(StudentList.get(i).getID())
                            && getStudent.getSemester().equalsIgnoreCase(StudentList.get(i).getSemester())
                            && getStudent.getCourseName().equalsIgnoreCase(StudentList.get(i).getCourseName())) {
                        StudentList.get(i).setID(ID);
                        StudentList.get(i).setName(studentName);
                        StudentList.get(i).setSemester(studentSemester);
                        StudentList.get(i).setCourseName(studentCourse);
                        System.out.println("update successfull");
                    }
                }
                // loop traversal all student in list
                for (int i = 0; i < StudentList.size(); i++) {
                    // if old id equal new id but name not euqal new name
                    if (ID.equalsIgnoreCase(StudentList.get(i).getID())
                            && studentName.equalsIgnoreCase(StudentList.get(i).getName()) == false) {
                        StudentList.get(i).setName(studentName);
                    }

                }
            } else {
                StudentList.remove(getStudent);
                System.out.println("remove student successfull!");
            }
            DisplayList(StudentList);
        } else {
            System.out.println("ID not exist in list");
        }
    }

    public static void ReportStudentInfo(ArrayList<Student> StudentList) {
        // check if list empty
        if (StudentList.isEmpty()) {
            System.out.println("list empty can not report");
        }
        ArrayList<Report> ReportList = new ArrayList<>();
        //loop traversal all student in list
        for (int i = 0; i < StudentList.size(); i++) {
            int count = 0;
            // loop traversal all student in list
            for (int j = 0; j < StudentList.size(); j++) {
                //if student exist in list
                if (StudentList.get(i).getID().equalsIgnoreCase(StudentList.get(j).getID())
                        && StudentList.get(i).getCourseName().equalsIgnoreCase(StudentList.get(j).getCourseName())) {
                    count++;
                }
            }
            // if name student and course not exist in list
            if (CheckDuplicateReport(StudentList.get(i).getName(), StudentList.get(i).getCourseName(), ReportList) == false) {
                Report StudentReport = new Report(StudentList.get(i).getName(), StudentList.get(i).getCourseName(), count);
                ReportList.add(StudentReport);
            }
        }
        System.out.println("--------------- List Report ---------------");
        System.out.format("%-15s|%-10s|%-7s\n", "Student Name", "Course", "Total");
        // loop traversal all report in list report
        for (int i = 0; i < ReportList.size(); i++) {
            System.out.format("%-15s|%-10s|%-7s\n", ReportList.get(i).getStudentName(), ReportList.get(i).getCourseName(), ReportList.get(i).getTotalCourse());
        }

    }

    // check duplicate student in the report
    public static boolean CheckDuplicateReport(String name, String courseName, ArrayList<Report> ReportList) {
        // loop travese all student in list
        for (int i = 0; i < ReportList.size(); i++) {
            // if name and course exist in list
            if (name.equalsIgnoreCase(ReportList.get(i).getStudentName())
                && courseName.equalsIgnoreCase(ReportList.get(i).getCourseName())) {
                return true;
            }
        }
        return false;
    }

    // check id match name 
    public static boolean CheckIdMatchName(String id, String name, ArrayList<Student> StudentList) {
        // loop count number student in list student
        for (int i = 0; i < StudentList.size(); i++) {
            // if id equal id in list but name not equal name of id
            if (id.equalsIgnoreCase(StudentList.get(i).getID()) && name.equalsIgnoreCase(StudentList.get(i).getName()) == false) {
                System.out.println("Please enter name match to id");
                return false;
            }
        }
        return true;
    }

    // check duplicate student
    public static boolean CheckDuplicate(String id, String semester, String course, ArrayList<Student> StudentList) {
        // loop travese all student in list
        for (int i = 0; i < StudentList.size(); i++) {
            // if id, semester and course is exist in list
            if (id.equalsIgnoreCase(StudentList.get(i).getID())
                    && semester.equalsIgnoreCase(StudentList.get(i).getSemester())
                    && course.equalsIgnoreCase(StudentList.get(i).getCourseName())) {
                return true;
            }
        }
        return false;
    }

    // display list student
    public static void DisplayList(ArrayList<Student> StudentList) {
        System.out.println("----------------------- List Student ------------------------------");
        System.out.format("%-8s%-15s%-20s%-15s%-15s\n", "No", "Student ID", "Student Name", "Semester", "Course Name");
        //loop taverse through all element in list countries
        for (int i = 0; i < StudentList.size(); i++) {
            System.out.format("%-8s%-15s%-20s%-15s%-15s\n", i + 1, StudentList.get(i).getID(),
                    StudentList.get(i).getName(), StudentList.get(i).getSemester(), StudentList.get(i).getCourseName());
        }
        System.out.println("");
    }

    // check name user input is exist in list or not
    public static boolean CheckNameExist(String name, ArrayList<Student> StudentList) {
        // loop travese all student in list
        for (int i = 0; i < StudentList.size(); i++) {
            // if name student exists
            if (StudentList.get(i).getName().toUpperCase().contains(name.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    //Sort list student by name ascending 
    public static void SortByName(ArrayList<Student> StudentList) {
        // loop taverse all students in list student
        for (int i = 0; i < StudentList.size(); i++) {
            //loop traverse the array list of unsorted student
            for (int j = 0; j < StudentList.size() - i - 1; j++) {
                //if character of first student name greater next student name in the alphabet
                if (StudentList.get(j).getName().compareToIgnoreCase(StudentList.get(j + 1).getName()) > 0) {
                    Student temp = StudentList.get(j);
                    StudentList.set(j, StudentList.get(j + 1));
                    StudentList.set(j + 1, temp);
                }
            }
        }
    }

    // Check id user input exist in list or not
    public static boolean CheckIdExistInList(String id, ArrayList<Student> StudentList) {
        // loop travese all student in list
        for (int i = 0; i < StudentList.size(); i++) {
            // if name student exists
            if (StudentList.get(i).getID().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    // get a student in list student
    public static int EnterStudentNo(ArrayList<Student> listStudentFiindByID) {
        Scanner sc = new Scanner(System.in);
        // loop until number of student is correct
        while (true) {
            // if try error the program will run catch
            try {
                int StudentNo = Integer.parseInt(sc.nextLine());
                // if choice is positive number 
                if (StudentNo > 0 && StudentNo <= listStudentFiindByID.size()) {
                    return StudentNo;
                } else {
                    System.err.println("Student is rage 1 to " + listStudentFiindByID.size());
                    System.out.print("Please enter again: ");
                }
            } catch (NumberFormatException e) {
                System.err.println("You must enter number of student is digit");
                System.out.print("Please enter again: ");
            }
        }
    }
}
