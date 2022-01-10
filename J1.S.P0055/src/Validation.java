
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
class Validation {
    Scanner sc = new Scanner(System.in);
    
    int getInt(String msg, String err, int min, int max) {
        while(true){
            try {
                int num;
                System.out.println(msg);
                num = Integer.parseInt(sc.nextLine());
                
                if(num<min || num>max){
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (Exception e) {
                System.out.println(err);
            }
        }
    } 
    
    
    String getString(String msg, String err, String regex){
        while (true) {            
            try {
                String str;
                System.out.println(msg);
                str = sc.nextLine();
                if(str.matches(regex)){
                    return str;
                }else{
                    System.out.println(err);
                }
            } catch (Exception e) {
            }
        }
    }
}
