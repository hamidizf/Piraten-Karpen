package pk;


import java.util.Random;

public class Game {
    Players players=new Players();
    Random Boolean = new Random();

    public void start(String strategy1, String strategy2){
        String winner="";
        int player1=0;
        int player2=0;
        double percentage1, percentage2;
        for(int i=0; i<42;i++){
            if (i==0){
                winner=players.play(Boolean.nextBoolean(), strategy1,strategy2);
            }else{
                if (winner=="Player1"){

                    winner= players.play(true,strategy1,strategy2);
                }else{
                    winner= players.play(false,strategy1,strategy2);
                }
            }
            if (winner=="Player1"){
                player1++;
            }else {
                player2++;
            }
        }
        percentage1=(player1/42.0)*100;
        percentage2=(player2/42.0)*100;
        System.out.printf("The percentage of win for player1 is %.2f%% and the percentage of win for player2 is %.2f%%.\n",percentage1,percentage2 );


    }

}
