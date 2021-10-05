import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class Adventure {
    private int noAdventure;
    private static Random rnd = new Random();

    public Adventure(){

    }

    public static void GoAdventure(Player p1){

        Scanner sc = new Scanner(System.in);
        // if rnNumber less than 10, no adventure :(
        int rnNumber = rnd.nextInt(100);
        boolean activeAdventure;


        // If number 1-100 is less than 10 no adventure, else adventure starts
        if(rnNumber <= 10){
            System.out.println("You see nothing but swaying grass all around you...");
        } else {
            // Spanws monster
            SpecificMonster monster = spawnMonster();

            //Sets adventure to true
            activeAdventure = true;
            System.out.println("Uh oh! A wild " + monster.getName() + " appeared");
            while(activeAdventure) {
                // Monster attack
                p1.attack(monster);
                // Player attack
                monster.giveDamage(5, p1);

                // If both player and monster alive
                if(p1.getHp() > 0 && monster.getHp() > 0 ) {
                // Show HP
                System.out.println(p1.getName() + ":" + p1.getHp() + " hp");
                System.out.println(monster.getName() + ":" + monster.getHp() + " hp");
                // Press enter to attack again
                System.out.println("[Press any key to continue]");
                sc.nextLine();
                }

                // if monster dies
                else if (monster.getHp() <= 0){
                    System.out.println("You killed the monster, gaining "+ p1.gainExp(100) +" experience!");
                    System.out.println("You are level " + p1.getLevel() + ", and you have " + p1.getExp() + "exp and " + p1.getHp() + " hp." );
                    activeAdventure = false;
                }
                // if player dies
                if (p1.getHp() <= 0) {
                    System.out.println("You were killed by the monster.");
                    TheGame.game = false;
                }

                // Ends game if player reaches level 10
                if(p1.getLevel() >= 10) {
                    System.out.println("You won The Game!");
                    TheGame.game = false;
                }
            }
        }
    }

    public static SpecificMonster spawnMonster(){

        // Spaws monster, if I had enough time I would add more types of monster which would spawn randomly
        return new SpecificMonster("Worm", 100, 10);
    }



}
