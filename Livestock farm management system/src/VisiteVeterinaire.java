public class VisiteVeterinaire {
    private String date;
    private String nomVeterinaire;
    private String diagnostic;
    private String traitement;
    private String animalType;
    private int animalId;

    // Constructor
    public VisiteVeterinaire(String date, String nomVeterinaire, String diagnostic, String traitement) {
        this.date = date;
        this.nomVeterinaire = nomVeterinaire;
        this.diagnostic = diagnostic;
        this.traitement = traitement;
        this.animalType = "Unknown";
        this.animalId = 0;
    }

    // Constructor with animal details
    public VisiteVeterinaire(String date, String nomVeterinaire, String diagnostic, String traitement, String animalType, int animalId) {
        this.date = date;
        this.nomVeterinaire = nomVeterinaire;
        this.diagnostic = diagnostic;
        this.traitement = traitement;
        this.animalType = animalType;
        this.animalId = animalId;
    }

    // Getters
    public String getDate() {
        return date;
    }

    public String getNomVeterinaire() {
        return nomVeterinaire;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public String getTraitement() {
        return traitement;
    }

    public String getAnimalType() {
        return animalType;
    }

    public int getAnimalId() {
        return animalId;
    }

    // Setters
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    // Affichage
    public void afficherVisite() {
        System.out.println("Date: " + date);
        System.out.println("Vétérinaire: " + nomVeterinaire);
        System.out.println("Animal Type: " + animalType);
        System.out.println("Animal ID: " + animalId);
        System.out.println("Diagnostic: " + diagnostic);
        System.out.println("Traitement: " + traitement);
        System.out.println("------------------------");
    }
}