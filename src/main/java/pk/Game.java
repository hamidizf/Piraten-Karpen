package pk;
import java.util.Random;
import java.text.DecimalFormat;
public class Game {
    Players players=new Players();
    Random Boolean = new Random();
    DecimalFormat dFormat = new DecimalFormat("#%");
    public void start(){
        String winner="";
        int player1=0;
        int player2=0;
        double percentage1, percentage2;
        for(int i=0; i<42;i++){
            if (i==0){
                winner=players.play(Boolean.nextBoolean());
            }else{
                if (winner=="Player1"){

                    winner= players.play(true);
                }else{
                    winner= players.play(false);
                }
            }
            if (winner=="Player1"){
                player1++;
            }else {
                player2++;
            }
        }
        percentage1=player1/42.0;
        percentage2=player2/42.0;
        System.out.println("The percentage of win for player1 is "+dFormat.format(percentage1)+" and the percentage of win for player2 is "+dFormat.format(percentage2));

    }

}
