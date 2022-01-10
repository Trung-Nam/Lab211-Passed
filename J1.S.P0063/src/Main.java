/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS G731G
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonInformation  PersonInfor = new  PersonInformation();
        // step 1:input information of person
        Person[]  PersonInformationArray = PersonInfor.inputPersonInformation();
        //step 2:display input information of person
        PersonInfor.displayPersonInformation(PersonInformationArray);
        //step 3:sort the information of person by salary ascending
        PersonInfor.SortPersonBySalaryAscending(PersonInformationArray);
        //step 4:display array person information after sort
        PersonInfor.DisplayPersonInfoAfterSort(PersonInformationArray);
    }
    
}
