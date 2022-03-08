package lab_7;

public class testYatsy {

    public static void main(String[] args) {
        System.out.println("creating Yatsy and rolling all dice...");
        Yatzy yatzy = new Yatzy();
        System.out.println(yatzy);

        System.out.println("Rolling all dice...");
        yatzy.rollDice();
        System.out.println(yatzy);

        System.out.println("Rolling dice 2 and 3...");
        yatzy.rollDice(false, true, true, false, false);
        System.out.println(yatzy);

        System.out.println("Sorting the dice...");
        yatzy.sort();
        System.out.println(yatzy);

        System.out.println("Checking for yatzy...");

        System.out.println("is " + yatzy + " yatzy: " + yatzy.isYatzy());

        for (int i = 0; i < 100; i++){
            yatzy.rollDice();
            System.out.println(yatzy);
        }
    }
}
