package lab_7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Yatzy {
    private final int MAX_DICE = 5;
    private final int MIN_DICE = 1;
    private Integer[] dice = new Integer[MAX_DICE];
    Random rand = new Random();

    public Yatzy() {
        rollDice();
    }

    public void rollDice() {
        for (int i = 0; i < MAX_DICE; i++) {
            dice[i] = getRandomInt();
        }
    }

    public void rollDice(boolean rollAgain_1, boolean rollAgain_2, boolean rollAgain_3, boolean rollAgain_4, boolean rollAgain_5) {
        boolean[] rollAgainArr = {rollAgain_1, rollAgain_2, rollAgain_3, rollAgain_4, rollAgain_5};
        for (int i = 0; i < rollAgainArr.length; i++) {
            if (rollAgainArr[i] == true) {
                dice[i] = getRandomInt();
            }
        }
    }

    private int getRandomInt() {
        //return (int) (Math.random() * (MAX_DICE - MIN_DICE + 1) + MIN_DICE);
        return rand.nextInt(6) + 1;
    }

    public boolean isYatzy() {
        int next;
        for (int i = 0; i < dice.length - 1; i++){
            next = i + 1;
            if (dice[i] != dice[next]) {
                return false;
            }
        }
        return true;
    }

    public void sort() {
        Arrays.sort(dice, Collections.reverseOrder());
    }

    @Override
    public String toString() {
        StringBuilder sequence = new StringBuilder();
        for (int die: dice) {
            sequence.append(die + " ");
        }
        return sequence.toString();
    }

    public Integer[] getDice() {
        return dice;
    }
}
