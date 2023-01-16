import pk.Dice;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.println(myDice.roll());
        System.out.println("That's all folks!");
        int n,i;
        i=0;
        for (int j=0; j<42; j++){
            if (j==0){
                n=8;
            }else{
                n=8-i;
            }
            myDice.roll(n);
            
        }

    }
    
}
