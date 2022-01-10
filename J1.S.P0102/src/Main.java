
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Step1:user enter date with format dd/mm/yyyy
        System.out.print("Please enter date with format [dd/mm/yyyy]: "); 
        //Step2:when user entered then check date exist   
        Date date = null;
        date = checkDate();
        //Step3:determine day of week with date entered 
        getDayOfWeek(date);
    }

    

    public static Date checkDate() {
        //format date require user input: dd/MM/yyyy
        Date date = null;
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        // loop to check user input until they enter the correct format
        while (true) {
            //exception handing
            try {
                //may throw exception
                date = df.parse(sc.nextLine());
                break;
            } catch (Exception e) {
                //display an anouncement wrong user input format
                System.out.print("Invalid date, please input again: ");
            }
        }
        return date;
    }

    
    public static void getDayOfWeek(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("EEEE");
        System.out.println("Your day is " + df.format(date));
    }
}
