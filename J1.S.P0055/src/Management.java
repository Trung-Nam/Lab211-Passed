
import java.util.ArrayList;
import java.util.List;
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
class Management {
    Validation validator = new Validation();
    List<Doctor>listDoctors;
    Scanner sc = new Scanner(System.in);
    int NOT_EXIST = -1;
    
    public Management() {
        listDoctors = new ArrayList<>();
    }
    
    
    void addDoctor() {
        String code = "";
        do{
            code = validator.getString("Enter Code: ", "Code include only letter and digits ", "[a-zA-Z0-9 ]+");
            if(indexCode(listDoctors, code) != NOT_EXIST){
                System.out.println("code is exist");
            }
        }while(indexCode(listDoctors, code) != NOT_EXIST);
        
        String name = validator.getString("Enter Name: ", "Name invalid", "[a-zA-Z ]+");
        String spec = validator.getString("Enter Specialization: ", "Invalid" , "[a-zA-Z0-9 ]+");
        int avai = validator.getInt("Enter Availability: ", "Invalid", 0, Integer.MAX_VALUE);
        Doctor doctor = new Doctor(code, name, spec, avai);
        listDoctors.add(doctor);
        System.out.println("Add Doctor Successfully!!!");
        
        for(Doctor listDoctor : listDoctors) {
            System.out.println(listDoctor);
        }
} 
    void updateDoctor() {
        if(listDoctors.isEmpty()){
            System.out.println("List Empty !");
        }
        
       String code = validator.getString("Enter Code: ", "Code include only letter and digits ", "[a-zA-Z0-9 ]+");
       int index = indexCode(listDoctors, code);
       if(index != NOT_EXIST){
           String newName = validator.getString("Enter Name: ", "Name invalid", "[a-zA-Z ]+");
           if(!newName.trim().equals("")){
               listDoctors.get(index).setName(newName);
           }
           
           String newSpec = validator.getString("Enter Specialization: ", "Invalid" , "[a-zA-Z0-9 ]+");
           if(!newSpec.trim().equals("")){
               listDoctors.get(index).setSpecialization(newName);
           }
           
           String newAvai = validator.getString("Enter Availability: ", "Invalid", "[0-9 ]+");
           if(!newAvai.trim().equals("")){
               listDoctors.get(index).setAvailability(Integer.parseInt(newAvai));
           }
           
        }else{
           System.out.println("Doctor not exit");
        }
       
       
    }

    void searchDoctor() {
        if(listDoctors.isEmpty()){
            System.out.println("List Empty !");
        }
        
        while(!listDoctors.isEmpty()){
            System.out.println("Enter string to search: ");
            String keyword = sc.nextLine();
            for (Doctor D : listDoctors) {
                if(D.getCode().toLowerCase().contains(keyword.toLowerCase()) || D.getName().toLowerCase().equalsIgnoreCase(keyword.toLowerCase())
                   || D.getSpecialization().toLowerCase().contains(keyword.toLowerCase()) || D.getAvailability() == Integer.parseInt(keyword)){
                    System.out.println(D); 
                }
                
            }
        }
    }

    void deleteDoctor() {
        if(listDoctors.isEmpty()){
            System.out.println("List Empty !");
        }
        
        String code = validator.getString("Enter Code: ", "Code include only letter and digits ", "[a-zA-Z0-9]+");
        int index = indexCode(listDoctors, code);
        if(index != NOT_EXIST){
           listDoctors.remove(index);
            System.out.println("Delete successfully !!!");
        }else{
            System.out.println("Code is not exist !");
        }
    }

    private int indexCode(List<Doctor> listDoctors, String code) {
        for (int i = 0; i < listDoctors.size(); i++) {
            Doctor D = listDoctors.get(i);
            if(D.getCode().equalsIgnoreCase(code)){
                return i;
            }
        }
        return NOT_EXIST;
        }
}
 
