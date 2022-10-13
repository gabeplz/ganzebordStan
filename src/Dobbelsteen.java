import java.util.Random;

public class Dobbelsteen {
    public int roll(){
        Random rn = new Random();
        int worp = rn.nextInt(6 - 1 + 1) + 1;
        return worp;
    }

}
