package polymorphisme;

public class Livre { 
	// Attributs 
	private String titre; 
	private String auteur; 
	private String isbn; 
	private String genre; 
	private boolean disponible; 
	private int anneePublication;
	
	public Livre(String titre,String auteur,String isbn, String genre, int anneePublication ) {
		this.titre=titre;
		this.auteur=auteur;
		this.isbn=isbn;
		this.genre=genre;
		this.disponible=true;
		this.anneePublication=anneePublication;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getAnneePublication() {
		return anneePublication;
	}

	public void setAnneePublication(int anneePublication) {
		this.anneePublication = anneePublication;
	}

	public String toString() {
		return "Livre [titre=" + titre + ", auteur=" + auteur + ", isbn=" + isbn + ", genre=" + genre + ", disponible="
				+ (disponible?"disponible":"non disponible") + ", anneePublication=" + anneePublication + "]";
	}
	
	public void emprunter(Livre L) {
		if(L.disponible) {
			L.disponible = false;
		}
	}
	public void retourner(Livre L) {
		L.disponible = true;
		
	}
	
	
	
	
}
