
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
public class EmployeeManager {

    public static void displayMenu() {
        System.out.println("1. Add employees");
        System.out.println("2. Update employees");
        System.out.println("3. Remove employees");
        System.out.println("4. Search employees");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Exit");
    }

    //add new employee
    public void addEmployee(ArrayList<Employee> Elist) {
        //data of new employee
        String newId;
        String newFirstName;
        String newLastName;
        String newPhone;
        String newEmail;
        String newAddress;
        String newDOB;
        String newSex;
        double newSalary;
        String newAgency;

        //user input id
        do {
            newId = Inputter.inputStringId("Enter id of employee: ", "[a-zA-z0-9 ]+");
            if (isDuplicate(Elist, newId) == true) {
                System.out.println("ID is duplicated !.Please enter another ID");
            }
        } while (isDuplicate(Elist, newId) == true);
        //input first name
        newFirstName = Inputter.inputStringName("Enter first name of employee: ",
                "First name is only digits", "[a-zA-z ]+");
        newFirstName = newFirstName.toUpperCase();
        //input last name
        newLastName = Inputter.inputStringName("Enter last name of employee: ",
                "Last name is only digits", "[a-zA-z ]+");
        newLastName = newLastName.toUpperCase();
        //input phone number
        newPhone = Inputter.inputStringPhone("Enter phone number of employee: ", "[0-9]{3,}");
        //input email
        newEmail = Inputter.inputStringRegex("Enter new email of employee: ",
                "Your email is invalid fomat.Example: Example@gmail.com",
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        //input address
        newAddress = Inputter.inputString("Enter address of employee: ");
        //input date of birth
        newDOB = Inputter.inputDate("Birth of new employee following dd/MM/yyyy: ");
        //input sex
        newSex = Inputter.inputSex("Enter sex of employee [Male] or [Female] or [Other]: ");
        //input salary
        newSalary = Inputter.inputDouble("Enter salary of employee: ");
        //input agency
        newAgency = Inputter.inputString("Enter agency of employee: ");

        Employee employee = new Employee(newId, newFirstName, newLastName, newPhone, newEmail, newAddress, newDOB, newSex, newSalary, newAgency);
        //create a employee list when we have many employee
        Elist.add(employee);
        //when user input completed display a message employee have been added
        System.out.println("Employee " + newId + " has been added.");
        //show information of employee
        showListEmployee(Elist);
    }

    //checking whether a id is duplicated or not ?
    private boolean isDuplicate(ArrayList<Employee> Elist, String id) {
        //use for-each to over employee list
        for (Employee E : Elist) {
            //if id user input the same id have exist then return true
            if (id.equalsIgnoreCase(E.getId())) {
                return true;
            }
        }
        //if id is not exist return false
        return false;
    }

    //search a employee based on employee's id
    public int indexID(ArrayList<Employee> Elist, String id) {
        //Traverse through all elements in array
        for (int i = 0; i < Elist.size(); i++) {
            //when id input exist in list then return index of this id
            if (Elist.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    //show information of employee
    public void showListEmployee(ArrayList<Employee> Elist) {
        //check list empty or not
        if (Elist.isEmpty()) {
            System.out.println("Empty list !!!");
        } else {
            System.out.println("Employee list:");
            System.out.format("%-10s%-15s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n",
                    "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
            for (Employee E : Elist) {
                System.out.println(E);
            }
            System.out.println("Total: " + Elist.size() + " employee!!!");
        }
    }

    public void updateEmployee(ArrayList<Employee> Elist) {
        Scanner sc = new Scanner(System.in);
        //check list empty
        if (Elist.isEmpty()) {
            System.out.println("Empty list. No update can be performed!");
        } else {
            // Search student based on inputted id
            System.out.println("Input employee id for search:");
            String uId = sc.nextLine().trim();
            int index = indexID(Elist, uId);
            //if user input a id not exit then display a message for user 
            if (indexID(Elist, uId) == -1) {
                System.out.println("Employee " + uId + " doesn't exist!");
            } else {
                //update eployee id
                String oldId = Elist.get(index).getId();
                String msgId = "Old id: " + oldId;
                System.out.println(msgId);
                String newId;
                do {
                    newId = Inputter.inputStringId("Enter id of employee: ", "[a-zA-z0-9 ]+");
                    if (isDuplicate(Elist, newId) == true) {
                        System.out.println("ID is duplicated !.Please enter another ID");
                    }
                } while (isDuplicate(Elist, newId) == true);
                Elist.get(index).setId(newId);
                //update employee first name
                String oldFisrtName = Elist.get(index).getFirstName();
                String msg = "Old fisrt name: " + oldFisrtName;
                System.out.println(msg);
                String newFisrtName = Inputter.inputStringName("Enter new first name of employee: ", "First name is only digits", "[a-zA-z ]+");
                Elist.get(index).setFirstName(newFisrtName);
                //update employee last name
                String oldLastName = Elist.get(index).getLastName();
                String msg2 = "Old last name: " + oldLastName;
                System.out.println(msg2);
                String newLastName = Inputter.inputStringName("Enter new last name of employee: ", "Last name is only digits", "[a-zA-z ]+");
                Elist.get(index).setLastName(newLastName);
                //update employee phone number
                String oldPhone = Elist.get(index).getPhone();
                String msg3 = "Old phone number: " + oldPhone;
                System.out.println(msg3);
                String newPhone = Inputter.inputStringPhone("Enter phone number of employee: ", "[0-9]{3,}");
                Elist.get(index).setPhone(newPhone);
                //update employee email
                String oldEmail = Elist.get(index).getEmail();
                String msg4 = "Old email: " + oldEmail;
                System.out.println(msg4);
                String newEmail = Inputter.inputStringRegex("Enter new email of employee: ", "Your email is invalid fomat.Example: Example@gmail.com",
                        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Elist.get(index).setEmail(newEmail);
                //update employee address
                String oldAddress = Elist.get(index).getAddress();
                String msg5 = "Old address: " + oldAddress;
                System.out.println(msg5);
                String newAddress = Inputter.inputString("Enter new address of employee: ");
                Elist.get(index).setAddress(newAddress);
                //update employee DOB
                String oldDOB = Elist.get(index).getDOB();
                String msg6 = "Old DOB: " + oldDOB;
                System.out.println(msg6);
                String newDOB = Inputter.inputDate("New Birth of employee following dd/MM/yyyy: ");
                Elist.get(index).setDOB(newDOB);
                //update employee sex
                String oldSex = Elist.get(index).getSex();
                String msg7 = "Old Sex: " + Elist.get(index).getSex();
                System.out.println(msg7);
                String newSex = Inputter.inputSex("Enter new sex of employee [Male] or [Female] or [Other]: ");
                Elist.get(index).setSex(newSex);
                //update employee salary
                double oldSalary = Elist.get(index).getSalary();
                String msg8 = "Old salary: " + oldSalary;
                System.out.println(msg8);
                double newSalary = Inputter.inputDouble("Enter salary of employee: ");
                Elist.get(index).setSalary(newSalary);
                //update employee agency
                String oldAgency = Elist.get(index).getAgency();
                String msg9 = "Old agency: " + oldAgency;
                System.out.println(msg9);
                String newAgency = Inputter.inputString("Enter new agency of employee: ");
                Elist.get(index).setAgency(newAgency);
                //when user input completed then display a msg update successfully
                System.out.println("Employee " + uId + " has been updated!!!");

                //show information of employee after update
                showListEmployee(Elist);
            }
        }
    }

    //remove employee
    public void removeEmployee(ArrayList<Employee> Elist) {
        //check list empty
        if (Elist.isEmpty()) {
            System.out.println("List employee is empty !");
        }
        //input id employee want to remove
        String id = Inputter.inputStringId("Enter id of employee: ", "[a-zA-z0-9 ]+");
        //if empployee base id exist then remove it 
        if (indexID(Elist, id) != -1) {
            Elist.remove(indexID(Elist, id));
            System.out.println("Remove employee " + id + " successfully");
            //show list employee
            showListEmployee(Elist);
        } else {
            //if id user input is not exist then display a message that employee in this id is not exist
            System.out.println("Employee id is not exist !");
        }
    }

    //search employee
    public void searchEmployeeByName(ArrayList<Employee> Elist) {
        //input name employee want search
        String keyWord = Inputter.inputStringRegex("Enter First Name,Last Name or a part of name: ",
                "Your input in valid!Please enter again:", "[a-zA-z ]+");
        if (CheckNameExist(Elist, keyWord) == true) {
            //display of data fields
            System.out.format("%-10s%-15s%-15s%-15s%-25s%-15s%-15s%-15s%-15s%-15s\n",
                    "Id", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
            //Traverse through all elements in array
            for (int i = 0; i < Elist.size(); i++) {
                //creat a string fullname of employee by firstname with last name
                String fullName = Elist.get(i).getFirstName().concat(Elist.get(i).getLastName());
                //if in index i last name or first name contain name or a part of name the contain in keyword
                if (fullName.toLowerCase().replaceAll(" ", "").contains(keyWord.toLowerCase().replaceAll(" ", ""))) {
                    //then display employee in index i
                    System.out.println(Elist.get(i));
                }
            }
        } else {

            System.out.println("Your employee name does not exist!");
        }
    }

    //sort employee
    public void sortEmployeeBySalary(ArrayList<Employee> Elist) {
        //Traversal element from 0 to size - 1
        for (int i = 0; i < Elist.size() - 1; i++) {
            //Traversal element from j=i+1 to size
            for (int j = i + 1; j < Elist.size(); j++) {
                //check if employee salary in index i more than employee salary in index j  
                if (Elist.get(i).getSalary() > Elist.get(j).getSalary()) {
                    //swap index 2 employee i and j
                    Collections.swap(Elist, i, j);
                }
            }
        }
        //show list employee after sort
        showListEmployee(Elist);
    }

    public boolean CheckNameExist(ArrayList<Employee> Elist, String keyWord) {
        // Check if country is empty
        if (Elist.isEmpty()) {
            System.out.println("List is empty!");
        }
        //Traverse through all elements in array
        for (int i = 0; i < Elist.size(); i++) {
            //creat a string fullname of employee by firstname with last name
            String fullName = Elist.get(i).getFirstName().concat(Elist.get(i).getLastName());
            //if in index i last name or first name contain name or a part of name the contain in keyword
            if (fullName.toLowerCase().replaceAll(" ", "").contains(keyWord.toLowerCase().replaceAll(" ", ""))) {
                return true;
            }

        }
        return false;
    }
}
