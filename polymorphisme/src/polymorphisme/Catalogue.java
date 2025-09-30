package polymorphisme;

public class Catalogue {
	 private Livre[] livres; 
	 private int nombreLivres; 
	 private static final int TAILLE_MAX = 100;
	 
	 public Catalogue() {
		 livres=new Livre[TAILLE_MAX];
	 }
	 public boolean ajouterLivre(Livre l) { 
			 if (nombreLivres<TAILLE_MAX) {
				nombreLivres++;
				livres[nombreLivres]=l;
				return true;
			 }
			 else 
			 {
			 return false;
			 }
	 }

	public Livre rechercher(String titre) { 
		for(int i=0;i<livres.length;i++) {
			if(livres[i].getTitre().equalsIgnoreCase(titre)) {
				return livres[i];
			}
		}
		return null;
	}
	public Livre rechercher(String titre,String auteur) { 
		for(int i=0;i<livres.length;i++) {
			if(livres[i].getTitre().equalsIgnoreCase(titre) && livres[i].getAuteur().equalsIgnoreCase(auteur) ) {
				return livres[i];
			}
		}
		return null;
	}
	 public Livre[] rechercher(int anneePublication) {
	        int compteur = 0;
	        for (int i = 0; i < nombreLivres; i++) {
	            if (livres[i].getAnneePublication() == anneePublication) {
	                compteur++;
	            }
	        }
	        
	        Livre[] resultat = new Livre[compteur];
	        
	        int index = 0;
	        for (int i = 0; i < nombreLivres; i++) {
	            if (livres[i].getAnneePublication() == anneePublication) {
	                resultat[index] = livres[i];
	                index++;
	            }
	        }
	        
	        return resultat;
	 }
	        public void afficherLivresDisponibles() {
	            System.out.println("=== Livres Disponibles ===");
	            boolean aucunDisponible = true;
	            
	            for (Livre livre : livres) {
	                if (livre != null && livre.isDisponible()) {
	                    System.out.println(livre);
	                    aucunDisponible = false;
	                }
	            }
	            
	            if (aucunDisponible) {
	                System.out.println("Aucun livre disponible pour le moment");
	            }
	        }

	        public void statistiquesParGenre() {
	            String[] genres = new String[nombreLivres];
	            int[] compteurs = new int[nombreLivres];
	            int nombreGenres = 0;
	            
	            for (int i = 0; i < nombreLivres; i++) {
	                String genre = livres[i].getGenre();
	                boolean genreTrouve = false;
	                
	                for (int j = 0; j < nombreGenres; j++) {
	                    if (genres[j].equalsIgnoreCase(genre)) {
	                        compteurs[j]++;
	                        genreTrouve = true;
	                        break;
	                    }
	                }
	                
	                if (!genreTrouve) {
	                    genres[nombreGenres] = genre;
	                    compteurs[nombreGenres] = 1;
	                    nombreGenres++;
	                }
	            }
	            
	            System.out.println("=== Statistiques par Genre ===");
	            for (int i = 0; i < nombreGenres; i++) {
	                System.out.println(genres[i] + " : " + compteurs[i] + " livre(s)");
	            }
	        }

	        
	        public void afficherCatalogue() {
	            if (nombreLivres == 0) {
	                System.out.println("Le catalogue est vide.");
	                return;
	            }
	            
	            System.out.println("=== Catalogue Complet ===");
	            for (int i = 0; i < nombreLivres; i++) {
	                System.out.println((i + 1) + ". " + livres[i]);
	            }
	        }

	        public int getNombreLivres() {
	            return nombreLivres;
	        }

	        public boolean estPlein() {
	            return nombreLivres >= TAILLE_MAX;
	        }

	        public boolean estVide() {
	            return nombreLivres == 0;
	        }
	    }
	
	
	



	

