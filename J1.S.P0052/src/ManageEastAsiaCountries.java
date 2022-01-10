
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
class ManageEastAsiaCountries {

    public static void displayMenu() {
        System.out.println("                               MENU                                       ");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
    }

    void addCountryInformation(ArrayList<EastAsiaCountries> countryList) {
        int count = 3;
        while (count > 0) {
            //input code of country and check code exist
            String code;
            do {
                code = Inputter.inputStringRegex("Enter code of country: ", "Code invalid", "^[a-zA-Z ]+$");
                if (isExist(countryList, code)) {
                    System.out.println("Code is exist! Please enter another code.");
                }
            } while (isExist(countryList, code));
            //input name of country
            String name = Inputter.inputStringRegex("Enter name of country: ", "Country Name invalid!Country Name is only digits.", "^[a-zA-Z ]+$");
            //input total area of country
            float totalArea = Inputter.inputFloatNumber("Enter total area: ");
            //input terrain of country
            String terrain = Inputter.inputStringRegex("Enter terrain of country: ", "Terrain invalid", "^[a-zA-Z ]+$");
            EastAsiaCountries country = new EastAsiaCountries(code, name, totalArea, terrain);
            //add countries in list
            countryList.add(country);
            count--;
            //If count = 0 then display a message that user add enough country
            if (count == 0) {
                System.out.println("The country list has been " + countryList.size() + " East Asian added!");
            }
        }
    }

    // Display already information of country you're just input
    void getRecentlyEnteredInformation(ArrayList<EastAsiaCountries> countryList) {
        // Check if country is empty
        if (countryList.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
            //Traverse through all elements of country list
            for (EastAsiaCountries eastAsiaCountries : countryList) {
                eastAsiaCountries.display();
            }
        }
    }

    // Search the information of country by user-entered name
    void searchInformationByName(ArrayList<EastAsiaCountries> countryList) {
        //user input keyword country name
        String keyword = Inputter.inputStringRegex("Enter the name you want to search for: ", "Name invalid", "^[a-zA-Z ]+$");
        if (CheckNameExist(countryList, keyword)==true) {
            System.out.format("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
            // loop traverse all countries in list countries
            for (EastAsiaCountries listCountry : countryList) {
                // if name user input is exist in list
                if (listCountry.getCountryName().toLowerCase().replaceAll(" ", "").contains(keyword.toLowerCase().replaceAll(" ", ""))) {
                    //then display countries 
                    listCountry.display();
                }
            }
        } else {
            System.out.println("Cann't find the country in list");
        }
    }

    void sortInformationByAscendingOrder(ArrayList<EastAsiaCountries> countryList) {
        Collections.sort(countryList, new Comparator<EastAsiaCountries>() {
            @Override
            // Compare the names of countries with each other
            public int compare(EastAsiaCountries country1, EastAsiaCountries country2) {
                return country1.getCountryName().compareToIgnoreCase(country2.getCountryName());
            }
        });
        //display list after sort
        getRecentlyEnteredInformation(countryList);
    }

    // Check if the country exists in the list of countries 
    boolean isExist(ArrayList<EastAsiaCountries> countryList, String code) {
        // Traverse through all elements of country list
        for (EastAsiaCountries eastAsiaCountries : countryList) {
            // if the input country code is equal to the country code that already exists
            if (eastAsiaCountries.getCountryCode().equalsIgnoreCase(code)) {
                //then return true that is exist
                return true;
            }
        }
        return false;
    }

    // check name country is exist in list or not
    public boolean CheckNameExist(ArrayList<EastAsiaCountries> countryList, String keyword) {
        // Check if country is empty
        if (countryList.isEmpty()) {
            System.out.println("List is empty!");
        }
        //loop taverse through all element in list countries
        for (int i = 0; i < countryList.size(); i++) {
            // check if name of country exsit in list countries
            if (countryList.get(i).getCountryName().toLowerCase().replaceAll(" ", "").contains(keyword.toLowerCase().replaceAll(" ", ""))) {
                return true;
            }
        }
        return false;
    }

}
