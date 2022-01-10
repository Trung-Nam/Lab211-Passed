/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS G731G
 */
public class Task {
    private int id;
    private String RequirementName;
    private String TaskType;
    private String date;
    private double PlanFrom;
    private double PlanTo;
    private String Assignee;
    private String Reviewer;

    public Task() {
    }

    public Task(int id, String RequirementName, String TaskType, String date, double PlanFrom, double PlanTo, String Assignee, String Reviewer) {
        this.id = id;
        this.RequirementName = RequirementName;
        this.TaskType = TaskType;
        this.date = date;
        this.PlanFrom = PlanFrom;
        this.PlanTo = PlanTo;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequirementName() {
        return RequirementName;
    }

    public void setRequirementName(String RequirementName) {
        this.RequirementName = RequirementName;
    }

    public String getTaskType() {
        return TaskType;
    }

    public void setTaskType(String TaskType) {
        this.TaskType = TaskType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return PlanFrom;
    }

    public void setPlanFrom(double PlanFrom) {
        this.PlanFrom = PlanFrom;
    }

    public double getPlanTo() {
        return PlanTo;
    }

    public void setPlanTo(double PlanTo) {
        this.PlanTo = PlanTo;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }
    
}
