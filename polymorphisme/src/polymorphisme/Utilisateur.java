package polymorphisme;



public abstract class Utilisateur {
    protected String nom;
    protected String prenom;
    protected String numeroId;
    protected Livre[] livresEmpruntes;
    protected int nombreEmprunts;
    private static final int MAX_EMPRUNTS = 10; // Limite maximale absolue

    public Utilisateur(String nom, String prenom, String numeroId) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroId = numeroId;
        this.livresEmpruntes = new Livre[MAX_EMPRUNTS];
        this.nombreEmprunts = 0;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumeroId() {
        return numeroId;
    }

    public Livre[] getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public int getNombreEmprunts() {
        return nombreEmprunts;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }

    public abstract boolean peutEmprunter();
    public abstract int getLimiteEmprunt();


    public boolean emprunterLivre(Livre livre) {
                if (!peutEmprunter()) {
            System.out.println("Limite d'emprunts atteinte pour " + prenom + " " + nom);
            System.out.println("Limite : " + getLimiteEmprunt() + " livres");
            return false;
        }

        if (livre == null) {
            System.out.println("Livre invalide");
            return false;
        }

        if (!livre.isDisponible()) {
            System.out.println("Le livre '" + livre.getTitre() + "' n'est pas disponible");
            return false;
        }

        
        livresEmpruntes[nombreEmprunts] = livre;
        nombreEmprunts++;
        livre.setDisponible(false);
        
        System.out.println(prenom + " " + nom + " a emprunté : " + livre.getTitre());
        return true;
    }


    public boolean retournerLivre(String titreLivre) {
        for (int i = 0; i < nombreEmprunts; i++) {
            if (livresEmpruntes[i].getTitre().equalsIgnoreCase(titreLivre)) {
                livresEmpruntes[i].setDisponible(true);
                
                for (int j = i; j < nombreEmprunts - 1; j++) {
                    livresEmpruntes[j] = livresEmpruntes[j + 1];
                }
                
                livresEmpruntes[nombreEmprunts - 1] = null;
                nombreEmprunts--;
                
                System.out.println(prenom + " " + nom + " a retourné : " + titreLivre);
                return true;
            }
        }
        
        System.out.println("Livre non trouvé dans les emprunts de " + prenom + " " + nom);
        return false;
    }


    public void afficherLivresEmpruntes() {
        if (nombreEmprunts == 0) {
            System.out.println(prenom + " " + nom + " n'a aucun livre emprunté");
            return;
        }

        System.out.println("Livres empruntés par " + prenom + " " + nom + " :");
        for (int i = 0; i < nombreEmprunts; i++) {
            System.out.println("  - " + livresEmpruntes[i].getTitre());
        }
    }

    public String toString() {
        return "Utilisateur: " + prenom + " " + nom + 
               " (ID: " + numeroId + ") - Emprunts: " + nombreEmprunts + "/" + getLimiteEmprunt();
    }
}
