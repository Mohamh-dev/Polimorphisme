package polymorphisme;

public class Bibliotheque {
    private Catalogue catalogue;
    private Utilisateur[] utilisateurs;
    private int nombreUtilisateurs;
    private static final int MAX_UTILISATEURS = 50;

    public Bibliotheque() {
        this.catalogue = new Catalogue();
        this.utilisateurs = new Utilisateur[MAX_UTILISATEURS];
        this.nombreUtilisateurs = 0;
    }

    public boolean inscrireUtilisateur(Utilisateur utilisateur) {
        if (nombreUtilisateurs >= MAX_UTILISATEURS) {
            System.out.println("La bibliothèque ne peut plus accepter de nouveaux utilisateurs");
            return false;
        }

        if (utilisateur == null) {
            System.out.println("Utilisateur invalide");
            return false;
        }

        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(utilisateur.getNumeroId())) {
                System.out.println("Un utilisateur avec cet ID existe déjà");
                return false;
            }
        }

        utilisateurs[nombreUtilisateurs] = utilisateur;
        nombreUtilisateurs++;
        System.out.println("Utilisateur inscrit avec succès : " + utilisateur.getPrenom() + " " + utilisateur.getNom());
        return true;
    }

    public boolean effectuerEmprunt(String numeroId, String titreLivre) {
        Utilisateur utilisateur = null;
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(numeroId)) {
                utilisateur = utilisateurs[i];
                break;
            }
        }

        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé");
            return false;
        }

        Livre livre = catalogue.rechercher(titreLivre);
        if (livre == null) {
            System.out.println("Livre non trouvé");
            return false;
        }

        return utilisateur.emprunterLivre(livre);
    }

    public boolean effectuerRetour(String numeroId, String titreLivre) {
        Utilisateur utilisateur = null;
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(numeroId)) {
                utilisateur = utilisateurs[i];
                break;
            }
        }

        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé");
            return false;
        }

        return utilisateur.retournerLivre(titreLivre);
    }

    public void afficherStatistiquesEmprunts() {
        int empruntsEtudiants = 0;
        int empruntsProfesseurs = 0;
        int nombreEtudiants = 0;
        int nombreProfesseurs = 0;

        for (int i = 0; i < nombreUtilisateurs; i++) {
            Utilisateur user = utilisateurs[i];

            if (user instanceof Etudiant) {
                empruntsEtudiants += user.getNombreEmprunts();
                nombreEtudiants++;
            } else if (user instanceof Professeur) {
                empruntsProfesseurs += user.getNombreEmprunts();
                nombreProfesseurs++;
            }
        }

        System.out.println("=== Statistiques des Emprunts ===");
        System.out.println("Étudiants : " + nombreEtudiants + " inscrits, " + empruntsEtudiants + " emprunts");
        System.out.println("Professeurs : " + nombreProfesseurs + " inscrits, " + empruntsProfesseurs + " emprunts");
        System.out.println("Total : " + (empruntsEtudiants + empruntsProfesseurs) + " emprunts");
    }

    public void afficherTousLesUtilisateurs() {
        if (nombreUtilisateurs == 0) {
            System.out.println("Aucun utilisateur inscrit");
            return;
        }

        System.out.println("=== Liste des Utilisateurs ===");
        for (int i = 0; i < nombreUtilisateurs; i++) {
            System.out.println((i + 1) + ". " + utilisateurs[i].toString());
        }
    }

    public Utilisateur rechercherUtilisateur(String numeroId) {
        for (int i = 0; i < nombreUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroId().equals(numeroId)) {
                return utilisateurs[i];
            }
        }
        return null;
    }

    public void afficherDetailsUtilisateur(String numeroId) {
        Utilisateur user = rechercherUtilisateur(numeroId);
        if (user == null) {
            System.out.println("Utilisateur non trouvé");
            return;
        }

        System.out.println("\n=== Détails de l'utilisateur ===");
        System.out.println(user.toString());
        user.afficherLivresEmpruntes();
    }

    public Catalogue getCatalogue() {
        return catalogue;
    }

    public int getNombreUtilisateurs() {
        return nombreUtilisateurs;
    }
}
