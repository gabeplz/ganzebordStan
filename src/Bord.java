import java.util.ArrayList;

public class Bord {
    private ArrayList<Vakje> vakjeArrayList = new ArrayList<>();


    public void fillVakjeArraylist(){
        for (int i = 0; i < 65; i++){
            if (i == 80){

            } else {
                Vakje defaultVakje = new Vakje();
                StartVakje defaultVakje3 = new StartVakje();
                //defaultVakje3.
                vakjeArrayList.add(defaultVakje);
            }
        }
    }
    public Vakje getVakje(int index){
        return this.vakjeArrayList.get(index);
    }
}

