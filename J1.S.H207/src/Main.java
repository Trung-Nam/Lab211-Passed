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
    public static int secondHalfLetters(String str) {
        int numberChar = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'n' && str.charAt(i) <= 'z'
                    || str.charAt(i) >= 'N' && str.charAt(i) <= 'Z') {
                numberChar++;
            }
        }
        System.out.println("Number of second halt letters is: " + numberChar);

        return numberChar;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        secondHalfLetters("ruminates");
    }

}
