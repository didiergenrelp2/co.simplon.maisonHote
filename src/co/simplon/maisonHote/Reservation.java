package co.simplon.maisonHote;

public class Reservation {

	private String nom;
	private String prenom;
	private String telephone;
	private String email;
	private String nbNuit;
	private String nbPersonne;
	private String typeSejour;
	private String animal;
	private String fumeur;
	private String parking;
	
	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getFumeur() {
		return fumeur;
	}

	public void setFumeur(String fumeur) {
		this.fumeur = fumeur;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getNbNuit() {
		return nbNuit;
	}

	public void setNbNuit(String nbNuit) {
		this.nbNuit = nbNuit;
	}

	public String getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(String nbPersonne) {
		this.nbPersonne = nbPersonne;
	}

	public String getTypeSejour() {
		return typeSejour;
	}

	public void setTypeSejour(String typeSejour) {
		this.typeSejour = typeSejour;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
