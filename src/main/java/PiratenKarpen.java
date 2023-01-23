import pk.Dice;
import pk.Game;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
public class PiratenKarpen {
static Logger LOGGER=LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {


        System.out.println("Welcome to Piraten Karpen Simulator!");
        LOGGER.info("I'm rolling a dice");
        //System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        LOGGER.debug(myDice.roll());
        //System.out.println(myDice.roll());
        System.out.println("That's all folks!");
        Game game= new Game();
        game.start();

    }
}
