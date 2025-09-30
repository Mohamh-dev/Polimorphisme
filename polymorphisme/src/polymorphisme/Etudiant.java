package polymorphisme;


	public class Etudiant extends Utilisateur {
	    private String niveauEtude; // "Licence", "Master", "Doctorat"
	    private static final int LIMITE_EMPRUNT = 3;

	    public Etudiant(String nom, String prenom, String numeroId, String niveauEtude) {
	        super(nom, prenom, numeroId);
	        this.niveauEtude = niveauEtude;
	    }

	    public String getNiveauEtude() {
	        return niveauEtude;
	    }

	    public void setNiveauEtude(String niveauEtude) {
	        this.niveauEtude = niveauEtude;
	    }

	    public boolean peutEmprunter() {
	        return nombreEmprunts < LIMITE_EMPRUNT;
	    }

	    public int getLimiteEmprunt() {
	        return LIMITE_EMPRUNT;
	    }

	    @Override
	    public String toString() {
	        return "Étudiant " + niveauEtude + ": " + prenom + " " + nom + 
	               " (ID: " + numeroId + ") - Emprunts: " + nombreEmprunts + "/" + LIMITE_EMPRUNT;
	    }
	}

