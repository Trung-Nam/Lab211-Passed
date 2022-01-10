
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS G731G
 */
public class TaskManager {

    public static void DisplayMenu() {
        System.out.println("========= Task program =========");
        System.out.println("1.Add Task");
        System.out.println("2.Delete Task");
        System.out.println("3.Display Task");
        System.out.println("4.Exit");
    }

    public static void AddTask(ArrayList<Task> TaskList, int[] idLast) {
        boolean planFromLessThanPlanTo = false;
        double planFrom = 0;
        double planTo = 0;
        System.out.println("----------------Add Task-----------------");
        //if length of array equal 0
        if (idLast.length == 0) {
            idLast[0] = 0;
        }
        int id = idLast[0] + 1;
        //user input requirement name
        System.out.print("Requirement Name:");
        String requirementName = Inputter.EnterRequirementName();
        //user input task type
        String taskType = Inputter.EnterTaskType();
        //user input date
        System.out.print("Date:");
        String date = Inputter.EnterDate();
        //loop until plan from less than plan to
        while (planFromLessThanPlanTo != true) {
            System.out.print("From:");
            planFrom = Inputter.EnterPlanFrom();
            System.out.print("To:");
            planTo = Inputter.EnterPlanTo();
            planFromLessThanPlanTo = CheckPlanFromLessThanPlanTo(planFrom, planTo);
        }
        //if task existed in list
        if (CheckTaskExist(requirementName, date, planFrom, planTo, TaskList)) {
            System.out.println("Task is existed in list");
            return;
        }
        //user input assignee
        System.out.print("Assignee:");
        String assignee = Inputter.EnterAssignee();
        //user input reviewer
        System.out.print("Reviewer:");
        String reviewer = Inputter.EnterReviewer();
        Task task = new Task(id, requirementName, taskType, date, planFrom, planTo, assignee, reviewer);
        TaskList.add(task);
        System.out.println("Add task successfull!");
        idLast[0] = id;
    }

    public static boolean CheckPlanFromLessThanPlanTo(double planFrom, double planTo) {
        //if time from less than time to
        if (planFrom < planTo) {
            return true;
        } else {
            System.out.println("Please enter plan from less than plan to");
            return false;
        }
    }

    //check intersection time in the list
    public static boolean CheckIntersectionTime(double planFrom, double planTo, double planFromInList, double planToInList) {
        //if from and to user input less than from task or greater than to task
        if ((planFrom < planFromInList && planTo < planFromInList)
                || (planFrom > planToInList && planTo > planToInList)) {
            return false;
        }
        return true;
    }

    // check task exist in list
    public static boolean CheckTaskExist(String name, String date, double planFrom, double planTo, ArrayList<Task> listTask) {
        // loop treversal all task in list
        for (int i = 0; i < listTask.size(); i++) {
            // if name, date exist and time is intersect
            if (name.equalsIgnoreCase(listTask.get(i).getRequirementName()) && date.equalsIgnoreCase(listTask.get(i).getDate())
                    && (CheckIntersectionTime(planFrom, planTo, listTask.get(i).getPlanFrom(), listTask.get(i).getPlanTo()))) {
                return true;
            }
        }
        return false;
    }

    public static void DeleteTask(ArrayList<Task> TaskList) {
        //if list is empty
        if (TaskList.isEmpty()) {
            System.out.println("Task list is empty");
        }
        System.out.println("-------------------Del Task------------------");
        System.out.print("ID:");
        int id = Inputter.EnterID();
        if (checkIdExist(id, TaskList)) {
            for (int i = 0; i < TaskList.size(); i++) {
                //if id exist in list
                if (id == TaskList.get(i).getId()) {
                    TaskList.remove(i);
                }
            }
            System.out.println("Delete task successfull!");
        } else {
            System.out.println("Task is not exist in list!");
        }
    }

    public static boolean checkIdExist(int id, ArrayList<Task> TaskList) {
        // loop treversal all task in list
        for (int i = 0; i < TaskList.size(); i++) {
            //if id exist in list
            if (id == TaskList.get(i).getId()) {
                return true;
            }
        }
        return false;
    }

    // show the all task in list
    public static void ShowTask(ArrayList<Task> TaskList) {
        // if list is empty
        if (TaskList.isEmpty()) {
            System.out.println("List task is empty");
        }
        System.out.println("------------------------------- Task ----------------------------------------");
        System.out.format("%-5s%-15s%-15s%-15s%-10s%-15s%-15s\n", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
        // loop treversal all task in list
        for (int i = 0; i < TaskList.size(); i++) {
            System.out.format("%-5s%-15s%-15s%-15s%-10.1f%-15s%-15s\n", TaskList.get(i).getId(), TaskList.get(i).getRequirementName(),
                    TaskList.get(i).getTaskType(), TaskList.get(i).getDate(), TaskList.get(i).getPlanTo() - TaskList.get(i).getPlanFrom(),
                    TaskList.get(i).getAssignee(), TaskList.get(i).getReviewer());
        }
    }

}
