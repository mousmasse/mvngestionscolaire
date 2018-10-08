package sn.objis.mvngestionscolaire.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.mvngestionscolaire.metier.Administration;
import sn.objis.mvngestionscolaire.utils.MysqlConnexion;

/**
 * class IDaoAdministrationImpl
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public class IDaoAdministrationImpl implements IDaoAdministration{

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();
	
	
	@Override
	public void ajouter(Administration a) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "INSERT INTO administration VALUES(NULL,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setString(1, a.getPrenom());
			preparedStatement.setString(2, a.getNom());
			preparedStatement.setDate(3, Date.valueOf(a.getDateNaissance()));
			preparedStatement.setString(4, a.getLieuNaissance());
			preparedStatement.setString(5, String.valueOf(a.getSexe()));
			preparedStatement.setString(6, a.getAdresse());
			preparedStatement.setInt(7, a.getTelephone());
			preparedStatement.setString(8, a.getEmail());
			preparedStatement.setDate(9, Date.valueOf(a.getDateRecrutementAdministration()));
			preparedStatement.setInt(10, a.getIdProfession());
			preparedStatement.setInt(11, a.getIdDiplome());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			System.out.println("Insertion de lagent de l'administration :  r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de l'insertion de lagent de l'administration.");
		}
		
	}

	@Override
	public Administration lire(Administration a) {
		Administration admin = new Administration();
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "SELECT * FROM administration where id_administration = ?";
			 
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setInt(1, a.getIdAdministration());
			
			//Etape3 : ex�cution de la requ�te
			ResultSet resultSet = preparedStatement.executeQuery();
			
			 
			//Etape3 : Traitement du r�sultat
			while (resultSet.next()) {
								
				
				
				admin.setIdAdministration(resultSet.getInt("id_administration")); 
				admin.setNom(resultSet.getString("nom_administration")); 
				admin.setPrenom(resultSet.getString("prenom_administration")); 
				Date date = resultSet.getDate("date_naissance_administration");
				admin.setDateNaissance(date.toLocalDate()); 
				admin.setLieuNaissance(resultSet.getString("lieu_naissance_administration"));   
				admin.setSexe( resultSet.getString("sexe_administration").charAt(0));  
				admin.setAdresse(resultSet.getString("adresse_administration"));  
				admin.setTelephone(resultSet.getInt("telephonne_administration")); 
				admin.setEmail(resultSet.getString("email_administration")); 
				date = resultSet.getDate("date_recrutement_administration");
				admin.setDateRecrutementAdministration(date.toLocalDate()); 
				admin.setIdProfession(resultSet.getInt("id_profession"));
				admin.setIdDiplome(resultSet.getInt("id_diplome"));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la pr�paration des informations de l'agent de l'administration.");
		}
		
		return admin;
	}

	@Override
	public List<Administration> lire() {
List<Administration> listeAdmin = new ArrayList<>();
		
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "SELECT * FROM administration";
			Statement statement = connexion.createStatement();
			
			//Etape2: Ex�cution de la requ�te
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du r�sultat
			while (resultSet.next()) {
				
				Administration admin = new Administration(); 
				
				admin.setIdAdministration(resultSet.getInt("id_administration")); 
				admin.setNom(resultSet.getString("nom_administration")); 
				admin.setPrenom(resultSet.getString("prenom_administration")); 
				Date date = resultSet.getDate("date_naissance_administration");
				admin.setDateNaissance(date.toLocalDate()); 
				admin.setLieuNaissance(resultSet.getString("lieu_naissance_administration"));   
				admin.setSexe( resultSet.getString("sexe_administration").charAt(0));  
				admin.setAdresse(resultSet.getString("adresse_administration"));  
				admin.setTelephone(resultSet.getInt("telephonne_administration")); 
				admin.setEmail(resultSet.getString("email_administration")); 
				date = resultSet.getDate("date_recrutement_administration");
				admin.setDateRecrutementAdministration(date.toLocalDate()); 
				admin.setIdProfession(resultSet.getInt("id_profession"));
				admin.setIdDiplome(resultSet.getInt("id_diplome"));
				
				listeAdmin.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la pr�paration de la liste des agents de l'administration.");
		}
		return listeAdmin;
	}

	@Override
	public void modifier(Administration a) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "UPDATE administration SET prenom_administration = ?, nom_administration=?, date_naissance_administration =?, lieu_naissance_administration =?, sexe_administration =?, adresse_administration =?, telephonne_administration =?, email_administration =?, date_recrutement_administration =?, id_profession=?, id_diplome=? WHERE id_administration=?";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setString(1, a.getPrenom());
			preparedStatement.setString(2, a.getNom());
			preparedStatement.setDate(3, Date.valueOf(a.getDateNaissance()));
			preparedStatement.setString(4, a.getLieuNaissance());
			preparedStatement.setString(5, String.valueOf(a.getSexe()));
			preparedStatement.setString(6, a.getAdresse());
			preparedStatement.setInt(7, a.getTelephone());
			preparedStatement.setString(8, a.getEmail());
			preparedStatement.setDate(9, Date.valueOf(a.getDateRecrutementAdministration()));
			preparedStatement.setInt(10, a.getIdProfession());
			preparedStatement.setInt(11, a.getIdDiplome());
			preparedStatement.setInt(12, a.getIdAdministration());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Modification des informations de l'agent de l'administration r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification des informations de l'agent de l'administration.");
		}	
		
	}

	@Override
	public void supprimer(Administration a) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "DELETE FROM administration where id_administration=?";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setInt(1, a.getIdAdministration());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression de l'agent de l'administration r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
	}

	@Override
	public Administration dernierenregistrement() {
		Administration adminlast = new Administration();
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "Select * from administration where id_administration = (SELECT MAX(id_administration)  from administration)";
			Statement statement = connexion.createStatement();
			
			//Etape2: Ex�cution de la requ�te
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du r�sultat
			while (resultSet.next()) {
				
			
				adminlast.setIdAdministration(resultSet.getInt("id_administration")); 
				adminlast.setNom(resultSet.getString("nom_administration")); 
				adminlast.setPrenom(resultSet.getString("prenom_administration")); 
				Date date = resultSet.getDate("date_naissance_administration");
				adminlast.setDateNaissance(date.toLocalDate()); 
				adminlast.setLieuNaissance(resultSet.getString("lieu_naissance_administration"));   
				adminlast.setSexe( resultSet.getString("sexe_administration").charAt(0));  
				adminlast.setAdresse(resultSet.getString("adresse_administration"));  
				adminlast.setTelephone(resultSet.getInt("telephonne_administration")); 
				adminlast.setEmail(resultSet.getString("email_administration")); 
				date = resultSet.getDate("date_recrutement_administration");
				adminlast.setDateRecrutementAdministration(date.toLocalDate()); 
				adminlast.setIdProfession(resultSet.getInt("id_profession"));
				adminlast.setIdDiplome(resultSet.getInt("id_diplome"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la r�cup�ration du dernier eleve enregistr�.");
		}

		return adminlast;
	}

}
