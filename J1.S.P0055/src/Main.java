
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Validation validator = new Validation();
        Management manager = new Management();
        while(true){
            System.out.println("========== Doctor Management ==========");
            showMenu();
        int option = validator.getInt("Enter your option: ", "Option[1-5]",1,5);
        switch(option){
            case 1:
                manager.addDoctor();
                break;
            case 2:
                manager.updateDoctor();
                break;
            case 3:
                manager.deleteDoctor();
                break;
            case 4:
                manager.searchDoctor();
                break;
            case 5:
                System.exit(0);
        }
    }
}

    private static void showMenu() {
        System.out.println( "1.Add Doctor\n" +
                            "2.Update Doctor.\n" +
                            "3.Delete Doctor\n" +
                            "4.Search Doctor.\n" +
                            "5.Exit.");
    }
    
}
