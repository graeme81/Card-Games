package example.codeclan.com.cardgame;

/**
 * Created by user on 22/01/2017.
 */

public class Score {
    private int num;


    public Score(int num){
        this.num = num;
    }

    public int getScore(int num){
        if(num == 1)
            return 11;
        else if (num < 10)
            return num;
        else
            return 10;
    }
}
