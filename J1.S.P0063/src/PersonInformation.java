/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS G731G
 */
class PersonInformation {

    public Person[] inputPersonInformation() {
        Person[] PersonInformationArray = new Person[3];
        Inputter inputter = new Inputter();
        System.out.println("====Management Person Program====");
        int numberPerson = 0;
        //loop until number of person equal 3
        while (numberPerson !=3 ) {
            System.out.println("Input Infomation of Person");
            System.out.print("Please input name:");
            String PersonName = inputter.inputStringName();
            System.out.print("Please input address:");
            String PersonAddress = inputter.inputStringAddress();
            System.out.print("Please input salary:");
            double PersonSalary = inputter.inputDoubleSalary();

            Person person = new Person(PersonName, PersonAddress, PersonSalary);
            PersonInformationArray[numberPerson] = person;
            numberPerson++;
        }
        return PersonInformationArray;
    }

    public void displayPersonInformation(Person[] PersonInformationArray) {
        System.out.println("-------------- List Person ----------------");
        //loop traverse through all person in array person
        for (Person person : PersonInformationArray) {
            System.out.println("Information of Person you have entered:");
            System.out.println(person + "\n");
        }
    }
    //Sort Person array by salary ascending.
    public void SortPersonBySalaryAscending(Person[] PersonInformationArray) {
        //loop traverse through all person in array person
        for (int i = 0; i < PersonInformationArray.length; i++) {
            //loop traverse the array of unsorted persons
            for (int j = 0; j < PersonInformationArray.length - i - 1; j++) {
                //if salary of person greater than next person
                if(PersonInformationArray[j].getSalary() > PersonInformationArray[j+1].getSalary()){
                    //swap 2 person
                    Person tmp = PersonInformationArray[j];
                    PersonInformationArray[j]= PersonInformationArray[j+1];
                    PersonInformationArray[j+1] = tmp;
                }
            }
        }
    }
    //display information of person in array after sort
    public void DisplayPersonInfoAfterSort(Person[] PersonInformationArray) {
        //loop traverse through all person in array person
        for (int i = 0; i < PersonInformationArray.length; i++) {
            System.out.println("\nInformation of person you have entered:");
            System.out.println(PersonInformationArray[i]);
        }
    }

}
