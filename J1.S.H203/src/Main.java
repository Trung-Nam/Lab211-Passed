
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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reverse();
    }

    public static void Reverse() {
        //user input
        Scanner sc = new Scanner(System.in);
        String data = "";
        System.out.print("Input your string:");
        do {
            try {
                data = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error !");
            }
        } while (data.isEmpty());

        StringBuilder str = new StringBuilder();
        //cut each sentences from paragraph by dot
        String[] sents = data.trim().split("\\.");
        for (int i = sents.length - 1; i >= 0; i--) {
            String sub = "";
            StringBuilder sw = new StringBuilder();
            //cut each words from sentences by space
            String[] words = sents[i].split("\\s+");
            for (int j = words.length - 1; j >= 0; j--) {
                sw.append(words[j] + " ");
            }
            //Đổi từ stringBuilder qua string
            sub = sw.toString();
            //UpperCase character at first location
            String total = sub.substring(0, 1).toUpperCase() + sub.substring(1);
            str.append(total.trim() + ". ");
        }
//        System.out.println(str);
        if (data.trim().endsWith(".")) {
            data = str.toString().substring(0, str.toString().length() - 1);
        } else {
            data = str.toString().substring(0, str.toString().length() - 2);
        }
        System.out.println(data);

    }

}
