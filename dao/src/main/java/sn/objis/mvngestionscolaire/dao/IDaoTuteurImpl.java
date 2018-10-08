package sn.objis.mvngestionscolaire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.mvngestionscolaire.metier.Tuteur;
import sn.objis.mvngestionscolaire.utils.MysqlConnexion;

/**
 * class IDaoTuteurImpl
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */

public class IDaoTuteurImpl implements IDaoTuteur {

	Connection connexion = MysqlConnexion.getInstanceConnexion();
	
	@Override
	public void ajouter(Tuteur t) {

		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "INSERT INTO tuteur VALUES(NULL,?,?,?,?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setInt(3, t.getTelephone());
			preparedStatement.setString(4, t.getEmail());
			preparedStatement.setString(5, t.getAdresse());
					
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			System.out.println("Insertion du tuteur : "+ t.getPrenom()+" "+ t.getNom()+" r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de l'insertion du tuteur : "+ t.getPrenom()+" "+ t.getNom()+".");
		}
	
	}

	@Override
	public List<Tuteur> lire() {
		List<Tuteur> listeTuteur = new ArrayList<>();
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "SELECT * FROM tuteur";
			Statement statement = connexion.createStatement();
			
			//Etape2: Ex�cution de la requ�te
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du r�sultat
			while (resultSet.next()) {
				
				Tuteur t = new Tuteur();
				
				t.setIdTuteur(resultSet.getInt("id_tuteur")); 
				t.setNom(resultSet.getString("nom_tuteur")); 
				t.setPrenom(resultSet.getString("prenom_tuteur")); 
				t.setAdresse(resultSet.getString("adresse_tuteur"));  
				t.setTelephone(resultSet.getInt("telephonne_tuteur")); 
				t.setEmail(resultSet.getString("email_tuteur")); 
				
				listeTuteur.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la pr�paration de la liste des tuteurs.");
		}
		return listeTuteur;
	}

	@Override
	public void modifier(Tuteur t) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "UPDATE tuteur SET prenom_tuteur = ?, nom_tuteur=?, telephonne_tuteur =?, email_tuteur =?, adresse_tuteur =? WHERE id_tuteur=?";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setString(1, t.getNom());
			preparedStatement.setString(2, t.getPrenom());
			preparedStatement.setInt(3, t.getTelephone());
			preparedStatement.setString(4, t.getEmail());
			preparedStatement.setString(5, t.getAdresse());
			preparedStatement.setInt(6, t.getIdTuteur());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Modification des informations du tuteur : " + t.getPrenom() + " " + t.getNom() + " r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification des informations du tuteur : "+ t.getPrenom()+" "+ t.getNom()+".");
		}
		
	}

	@Override
	public void supprimer(Tuteur t) {

		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "DELETE FROM tuteur where id_tuteur=?";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setInt(1, t.getIdTuteur());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression du tuteur : "+ t.getPrenom()+" "+ t.getNom()+" r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
		
	}

	@Override
	public  Tuteur dernierenregistrement() {
		Tuteur t = new Tuteur();
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "Select * from tuteur where id_tuteur = (SELECT MAX(id_tuteur)  from tuteur)";
			Statement statement = connexion.createStatement();
			
			//Etape2: Ex�cution de la requ�te
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du r�sultat
			while (resultSet.next()) {
					t.setIdTuteur(resultSet.getInt("id_tuteur")); 
				t.setNom(resultSet.getString("nom_tuteur")); 
				t.setPrenom(resultSet.getString("prenom_tuteur")); 
				t.setAdresse(resultSet.getString("adresse_tuteur"));  
				t.setTelephone(resultSet.getInt("telephonne_tuteur")); 
				t.setEmail(resultSet.getString("email_tuteur")); 
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la pr�paration de la liste des tuteurs.");
		}
		return t;
		
	}

	@Override
	public Tuteur lire(Tuteur t) {
		Tuteur tuteur = new Tuteur();
		try {
		//Etape1 : Cr�ation de la requ�te
		String sql = "Select * from tuteur where id_tuteur = ?";
		PreparedStatement preparedStatement = connexion.prepareStatement(sql);
		
		//Etape2 : transmission de la valeur aux param�tres de la requ�te
		preparedStatement.setInt(1, t.getIdTuteur());
		
		//Etape3 : ex�cution de la requ�te
		ResultSet resultSet = preparedStatement.executeQuery();
		
		
		
		//Etape3 : Traitement du r�sultat
		while (resultSet.next()) {
			
			tuteur.setIdTuteur(resultSet.getInt("id_tuteur")); 
			tuteur.setNom(resultSet.getString("nom_tuteur")); 
			tuteur.setPrenom(resultSet.getString("prenom_tuteur")); 
			tuteur.setAdresse(resultSet.getString("adresse_tuteur"));  
			tuteur.setTelephone(resultSet.getInt("telephonne_tuteur")); 
			tuteur.setEmail(resultSet.getString("email_tuteur")); 
			
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
		System.out.println("Echec de la r�cup�ration du tuteur.");
	}
		return tuteur;
	}

	

}
