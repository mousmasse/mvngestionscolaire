package sn.objis.mvngestionscolaire.metier;

import java.time.LocalDate;


/**
 * Classe Eleve 
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */

public class Eleve extends Personne{
	
	protected int idEleve;
	protected int idTuteur;

	/**
	 * Constructeur sans param�tre
	 */
	public Eleve() {
		super();
	}
	
	/**
	 * @param idEleve
	 * @param idTuteur
	 * @param sexe
	 * @param prenom
	 * @param nom
	 * @param dateNaissance
	 * @param lieuNaissance
	 * @param adresse
	 * @param telephone
	 * @param email
	 */
	public Eleve(int idEleve, int idTuteur, char sexe, String prenom, String nom, LocalDate dateNaissance, String lieuNaissance, String adresse,
			int telephone, String email) {
		super(sexe, prenom, nom, dateNaissance, lieuNaissance, adresse, telephone, email);
		this.idEleve = idEleve;
		this.idTuteur = idTuteur;
	}
	

	/**
	 * @return : Retourne la valeur de la propri�t� idEleve
	 */
	public int getIdEleve() {
		return idEleve;
	}

	/**
	 * @param idEleve : Mutation de la propri�t� idEleve 
	 */
	public void setIdEleve(int idEleve) {
		this.idEleve = idEleve;
	}

	/**
	 * @return : Retourne la valeur de la propri�t� idTuteur
	 */
	public int getIdTuteur() {
		return idTuteur;
	}

	/**
	 * @param idTuteur : Mutation de la propri�t� idTuteur  
	 */
	public void setIdTuteur(int idTuteur) {
		this.idTuteur = idTuteur;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Eleve [ idEleve="+ idEleve+", prenom=" + prenom + ", nom=" + nom + ", dateNaissance=" + dateNaissance+", sexe=" + sexe  
				+ ", lieuNaissance=" + lieuNaissance + ", adresse=" + adresse + ", telephone=" + telephone + ", email="
				+ email + "idTuteur= "+idTuteur+" ]";
	}
	
	
	
	
	
	
	
	
	
	

}
