import java.util.Scanner;

public class NombreMystere{
    public static void main(String[] args) {
        jeu();
    }

    public static void jeu() {
        boolean partieGagnee = false;
        int nbMaxi = 100;
        int nombreMystere = (int)(Math.random()*nbMaxi);
        int nombreMaxiDessai = 4;
        Scanner entreeUtilisateur = new Scanner(System.in);
        System.out.println("Merci de saisir un nombre entre 0 et " +
                nbMaxi + " en " + nombreMaxiDessai + " tentatives :");
        for(int essai = 0; essai< nombreMaxiDessai; essai++) {
            int nombreSaisiParLutilisateur = entreeUtilisateur.nextInt();
            if (nombreSaisiParLutilisateur == nombreMystere) {
                partieGagnee = true;
            } else if (nombreSaisiParLutilisateur > nombreMystere) {
                System.out.println("Trop Grand ! Il vous reste " +
                        (nombreMaxiDessai-essai-1) + "essai");
            } else {
                System.out.println("Trop Petit ! Il vous reste " +
                        (nombreMaxiDessai-essai-1) + "essai");
            }
        }
        messageDeFin(partieGagnee, nombreMystere);
        int continueDeJouer = refairePartie();
        if (continueDeJouer == 1) {
            jeu();
        }
    }
    public static void messageDeFin(boolean pG, int numeroATrouver) {

        if(!pG) {// partieGagnee == false
            System.out.println("Perdu. Le numéro était : " + numeroATrouver);
        } else {
            System.out.println("Bravo");
        }
    }
    public static int refairePartie() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Voulez vous rejouer ? 1 = oui / 2 = non");
        int choix = scan.nextInt();
        return choix;
    }
}
