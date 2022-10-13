import java.util.Random;

public class Dobbelsteen {
    int lastValue;
    public int roll(){
        Random rn = new Random();
        int worp = rn.nextInt(6 - 1 + 1) + 1;
        this.lastValue = worp;
        return worp;
    }

}
