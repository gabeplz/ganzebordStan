public class Gans {

    public String kleur;

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public int getPositie() {
        return positie;
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }

    public boolean isZitVast() {
        return zitVast;
    }

    public void setZitVast(boolean zitVast) {
        this.zitVast = zitVast;
    }

    public boolean isBeurtOverslaan() {
        return BeurtOverslaan;
    }

    public void setBeurtOverslaan(boolean beurtOverslaan) {
        BeurtOverslaan = beurtOverslaan;
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        this.speler = speler;
    }

    public int positie;
    public boolean zitVast;
    public boolean BeurtOverslaan;
    public Speler speler;

    public Gans(String kleur, Speler speler){
        this.kleur = kleur;
        this.speler = speler;
    }
}
