
public class Testcal {
    // 9
    public static void main(String[] args) {
        try {
            Calendrier20 cal = new Calendrier20();
            System.out.println(cal.toString());
            System.out.println(cal.nomJour(02));
            System.out.println(cal.nomMois(02));
            System.out.println(cal.PremierJ());
            System.out.println(cal.bisextille(2020));
            System.out.println(cal.nbJours(05, 2022));
            cal.affichetete();
            cal.affichecal();

            System.out.println("Calendrier affiché");

            cal.affichecalAnnee();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}