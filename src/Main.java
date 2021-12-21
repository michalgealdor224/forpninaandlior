import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    }
    public static void main () {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter 1 for create account" +
                "2 for login to your account" +
                "3 for finish");
        int choose = scanner.nextInt();
        RealEstate realEstate = new RealEstate();
        if (choose==1) {
            realEstate.createUser();
        }
        if (choose==2) {
            realEstate.login();
            if (realEstate.login() == null) {
                main();
            }
            if (realEstate.login() != null) {
                System.out.println("enter 1 for post a new property" +
                        "2 for remove property" +
                        "3 for view all assets in the system" +
                        "4 for view all user-posted assets" +
                        "5 for search property by parameters" +
                        "6 for disconnect and return to the main program");
                int chooseOfUser = scanner.nextInt();
                switch (1) {


                }

            }

        }


    }

}
