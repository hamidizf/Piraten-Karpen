import pk.Dice;
import pk.Game;


public class PiratenKarpen {


    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");
        Game game= new Game();
        game.start();

    }
}
