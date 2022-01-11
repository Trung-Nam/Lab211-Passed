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
    public static void printReverse(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        //create array to save each charactor
        String[] words = string.split("");
        //reverse and match sequence character
        for (int j = words.length - 1; j >= 0; j--) {
            stringBuilder.append(words[j]);
        }
        System.out.println("Reverse words: " + stringBuilder);
    }

    public static void main(String[] args) {
        // TODO code application logic here
//        String str="Fat";
//        String reverse = new StringBuffer(str).reverse().toString();
//        System.out.println("String=" + reverse);
        printReverse("hello there!");
    }

}
