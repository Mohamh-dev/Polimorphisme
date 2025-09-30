package polymorphisme;
public class TestBibliotheque {
    public static void main(String[] args) {
        // TODO 5.1 : Créer une instance de Bibliothèque
        Bibliotheque biblio = new Bibliotheque();

        // TODO 5.2 : Ajouter des livres
        biblio.getCatalogue().ajouterLivre(new Livre("Java Basics", "Author A", "111", "Programmation", 2020));
        biblio.getCatalogue().ajouterLivre(new Livre("Design Patterns", "Author B", "222", "Informatique", 2018));
        biblio.getCatalogue().ajouterLivre(new Livre("Harry Potter", "J.K. Rowling", "333", "Fantasy", 1997));
        biblio.getCatalogue().ajouterLivre(new Livre("L'Étranger", "Camus", "444", "Roman", 1942));
        biblio.getCatalogue().ajouterLivre(new Livre("Data Science", "Author C", "555", "Science", 2021));

        // TODO 5.3 : Créer et inscrire des utilisateurs
        Utilisateur etu1 = new Etudiant("Ali", "Karim", "E001", "Licence");
        Utilisateur etu2 = new Etudiant("Sara", "Ben", "E002", "Master");
        Utilisateur prof1 = new Professeur("Mohamed", "Omar", "P001", "Informatique", true);
        Utilisateur prof2 = new Professeur("Nadia", "Hassan", "P002", "Maths", false);

        biblio.inscrireUtilisateur(etu1);
        biblio.inscrireUtilisateur(etu2);
        biblio.inscrireUtilisateur(prof1);
        biblio.inscrireUtilisateur(prof2);

        // TODO 5.4 : Tester les emprunts
        biblio.effectuerEmprunt("E001", "Java Basics");     // valide
        biblio.effectuerEmprunt("E001", "Harry Potter");    // valide
        biblio.effectuerEmprunt("E001", "Data Science");    // valide
        biblio.effectuerEmprunt("E001", "Design Patterns"); // invalide, limite dépassée

        biblio.effectuerEmprunt("P001", "L'Étranger");      // prof titulaire

        // TODO 5.5 : Tester les recherches
        Livre found = biblio.getCatalogue().rechercher("Harry Potter");
        if (found != null) {
            System.out.println("Livre trouvé : " + found);
        }

        // TODO 5.6 : Afficher les statistiques
        biblio.afficherStatistiquesEmprunts();
        biblio.afficherTousLesUtilisateurs();

        // TODO 5.7 : Tester les limites
        biblio.effectuerEmprunt("E002", "Design Patterns");
        biblio.effectuerEmprunt("E002", "Java Basics"); // déjà emprunté
    }

    // TODO 5.8 : Méthode utilitaire
    public static void creerDonneesTest(Bibliotheque biblio) {
        for (int i = 1; i <= 5; i++) {
            biblio.getCatalogue().ajouterLivre(
                new Livre("Livre" + i, "Auteur" + i, "ISBN" + i, "Genre" + i, 2000 + i)
            );
        }
    }
}
