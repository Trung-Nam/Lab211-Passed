/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS G731G
 */
class Student {
    private String ID;
    private String name;
    private String semester;
    private String courseName;

    public Student() {
    }

    public Student(String ID, String name, String semester, String courseName) {
        this.ID = ID;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    
}
