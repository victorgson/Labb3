import java.util.Scanner;

public class TheGame {

    private static Scanner sc = new Scanner(System.in);
    static boolean game = true;
    private static Player player;

    public static void main(String[] args) {


        // Prints welcome screen
        System.out.println("""
                ************************
                * Welcome to The Game! *
                ************************
                Enter your name: """);
        String name = sc.nextLine();
        player = init(name);

        // while game is true, run the menu
        while(game){
            menu();
        }
    }

    // Init method, creates player
    public static Player init(String name) {
        return new Player(name);
    }


    static void menu() {
        System.out.println("""
                1. Go adventuring
                2. Show details about your character
                3. Go to shop
                4. Exit game
                """);
        String choice = sc.nextLine();

        switch(choice) {
            case "1":
                // Calls GoAdventure from Adventure class
                Adventure.GoAdventure(player);
                break;
            case "2":
                System.out.println("Name: " + player.getName());
                System.out.println("Level: " + player.getLevel());
                System.out.println("Hp: " + player.getHp() + "/" + player.getMaxHp());
                System.out.println("Exp: " + player.getExp() + "/" + player.getExpRequired());
                break;
            case "3":
                // No time to do this
                break;
            case "4":
                System.out.println("choice 3");
                game = false;
                break;

            default:
                    System.out.println("Wrong input, try again");
        }


    }
}
