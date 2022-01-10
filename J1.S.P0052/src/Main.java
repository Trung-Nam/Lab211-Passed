
import static java.lang.System.exit;
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
public class Main {

    public static void main(String[] args) {
        Inputter Inputter = new Inputter();
        ManageEastAsiaCountries Manager = new ManageEastAsiaCountries();
        ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
        while (true) {
            //step 1:display menu
            Manager.displayMenu();
            //step 2: ask user select an option in menu
            int choice = Inputter.inputChoice();
            switch (choice) {
                case 1:
                    //step 3: when user choice 1 then Enter the information for 11 countries in Southeast Asia.
                    Manager.addCountryInformation(countryList);
                    break;
                case 2:
                    //step 4: when user choice 2 then display already information.
                    Manager.getRecentlyEnteredInformation(countryList);
                    break;
                case 3:
                    //step 5: when user choice 3 then Search the country according to the entered country's name.
                    Manager.searchInformationByName(countryList);
                    break;
                case 4:
                    //step 6: when user choice 4 then Display the information increasing with the country name.
                    Manager.sortInformationByAscendingOrder(countryList);
                    break;
                case 5:
                    //step 7: when user choice 5 then exit
                    exit(0);
            }

        }
    }
}
