import java.util.ArrayList;
import java.util.Scanner;

public class GestionVisites {
    private ArrayList<VisiteVeterinaire> visites;
    private Scanner scanner;

    public GestionVisites(Scanner scanner) {
        visites = new ArrayList<>();
        this.scanner = scanner;
    }

    // Ajouter visite
    public void ajouterVisite(VisiteVeterinaire v) {
        visites.add(v);
        System.out.println("✓ Veterinary visit added successfully!");
    }

    // Afficher toutes les visites
    public void afficherVisites() {
        if (visites.isEmpty()) {
            System.out.println("No veterinary visits recorded.");
            return;
        }
        System.out.println("\n=== ALL VETERINARY VISITS ===");
        System.out.println("Total visits: " + visites.size());
        System.out.println("------------------------");
        for (int i = 0; i < visites.size(); i++) {
            System.out.println("Visit #" + (i + 1));
            visites.get(i).afficherVisite();
        }
    }

    // Supprimer visite
    public void supprimerVisite(int index) {
        if (index >= 0 && index < visites.size()) {
            VisiteVeterinaire removed = visites.remove(index);
            System.out.println("✓ Visit removed successfully!");
            System.out.println("Removed: " + removed.getNomVeterinaire() + " - Date: " + removed.getDate());
        } else {
            System.out.println("✗ Invalid visit number!");
        }
    }

    // Rechercher visite par date
    public void rechercherParDate(String date) {
        ArrayList<VisiteVeterinaire> results = new ArrayList<>();
        for (VisiteVeterinaire v : visites) {
            if (v.getDate().contains(date)) {
                results.add(v);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("✗ No visits found for date: " + date);
        } else {
            System.out.println("\n✓ Found " + results.size() + " visit(s) for date: " + date);
            System.out.println("------------------------");
            for (VisiteVeterinaire v : results) {
                v.afficherVisite();
            }
        }
    }

    // Rechercher visite par vétérinaire
    public void rechercherParVeterinaire(String nomVeterinaire) {
        ArrayList<VisiteVeterinaire> results = new ArrayList<>();
        for (VisiteVeterinaire v : visites) {
            if (v.getNomVeterinaire().toLowerCase().contains(nomVeterinaire.toLowerCase())) {
                results.add(v);
            }
        }
        
        if (results.isEmpty()) {
            System.out.println("✗ No visits found for veterinarian: " + nomVeterinaire);
        } else {
            System.out.println("\n✓ Found " + results.size() + " visit(s) by: " + nomVeterinaire);
            System.out.println("------------------------");
            for (VisiteVeterinaire v : results) {
                v.afficherVisite();
            }
        }
    }

    // Get number of visits
    public int getVisitesCount() {
        return visites.size();
    }
}