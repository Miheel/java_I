package lab_7;

public class yatzyRollTest {
    public static final int MAX_THROWS = 10000000;

    public static void main(String[] args){
        Yatzy yatzy = new Yatzy();
        int nrOfYatzy = 0;
        float yatzyPercent = 0.0f;
        System.out.print("Rolling the dice " + MAX_THROWS + " times...");

        long startTime = System.currentTimeMillis();
        int j = 0;
        for (int i = 0; i < MAX_THROWS; i++){
            yatzy.rollDice();
            if (yatzy.isYatzy() == true){
                nrOfYatzy++;
            }
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime + " ms");
        yatzyPercent = ((float) nrOfYatzy/MAX_THROWS) * 100;
        System.out.printf("Number of Yatzy: %d (%.4f%%)",nrOfYatzy, yatzyPercent);
    }
}
