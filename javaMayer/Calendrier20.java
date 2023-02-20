import java.util.Scanner;

public class Calendrier20 {
    private int annee;
    private int mois;

    public Calendrier20() throws ErrAnnee, ErrMois {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Saisissez l'année : ");
            this.annee = sc.nextInt();
            System.out.print("Saisissez le mois : ");
            this.mois = sc.nextInt();
        } catch (Exception e1) {
            System.out.println("Annee ou mois pas en format numerique");
        }

        if (this.annee > 2022 || this.annee < 2020) {
            throw new ErrAnnee();
        }

        if (this.mois > 12 || this.mois < 1) {
            throw new ErrMois();
        }

    }

    public Calendrier20(int mois, int annee) {
        this.annee = annee;
        this.mois = mois;
    }

    // 3a
    public String toString() {
        return "Mois: " + this.mois + ", Annee: " + this.annee;
    }

    // 3b
    public String nomJour(int jour) {
        switch (jour) {
            case 0:
                return "Dimanche";
            case 1:
                return "Lundi";
            case 2:
                return "Mardi";
            case 3:
                return "Mercredi";
            case 4:
                return "Jeudi";
            case 5:
                return "Vendredi";
            case 6:
                return "Samedi";
            default:
                return "Impossible";
        }
    }

    public String nomMois(int mois) {
        switch (mois) {
            case 1:
                return "Janvier";
            case 2:
                return "Fevrier";
            case 3:
                return "Mars";
            case 4:
                return "Avril";
            case 5:
                return "Mai";
            case 6:
                return "Juin";
            case 7:
                return "Juillet";
            case 8:
                return "Aout";
            case 9:
                return "Septembre";
            case 10:
                return "Octobre";
            case 11:
                return "Novembre";
            case 12:
                return "Decembre";
            default:
                return "Impossible";
        }
    }

    // 4
    public boolean bisextille(int an) {
        if (an % 4 == 0)
            return true;
        else
            return false;
    }

    // 5
    public int nbJours(int m, int a) {
        if (m == 2 && bisextille(a))
            return 29;
        else if (m == 2)
            return 28;

        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
            return 31;
        else if (m > 0 && m < 12)
            return 30;
        return -1;
    }

    // 6
    public int PremierJ() {
        return (this.annee - 2000 - 1 + (int) ((this.annee - 2000 - 1) / 4) - 6) % 7;
    }

    // 7
    public void affichetete() {
        System.out.println(this.nomMois(this.mois) + " " + this.annee);

        System.out.println("  D  L  M  M  J  V  S");
    }

    // 8
    public void affichecal() {
        int premierJ = this.PremierJ();

        for (int i = 0; i < this.mois - 1; i++) {
            premierJ += this.nbJours(i + 1, this.annee);
        }

        for (int i = 0; i < premierJ % 7; i++) {
            System.out.print("   ");
        }

        for (int i = 0; i < this.nbJours(this.mois, this.annee); i++) {
            premierJ += 1;
            if (i + 1 < 10)
                System.out.print("  " + (i + 1));
            else
                System.out.print(" " + (i + 1));

            if (premierJ % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public void affichecalAnnee() {
        for (int j = 0; j < 12; j++) {
            System.out.println(this.nomMois(j + 1) + " " + this.annee);
            System.out.println("  D  L  M  M  J  V  S");

            int premierJ = this.PremierJ();

            for (int i = 0; i < (j + 1) - 1; i++) {
                premierJ += this.nbJours(i + 1, this.annee);
            }

            for (int i = 0; i < premierJ % 7; i++) {
                System.out.print("   ");
            }

            for (int i = 0; i < this.nbJours((j + 1), this.annee); i++) {
                premierJ += 1;
                if (i + 1 < 10)
                    System.out.print("  " + (i + 1));
                else
                    System.out.print(" " + (i + 1));

                if (premierJ % 7 == 0)
                    System.out.println();
            }
            System.out.println();
        }
    }
}