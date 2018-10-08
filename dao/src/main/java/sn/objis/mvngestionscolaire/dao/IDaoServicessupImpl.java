package sn.objis.mvngestionscolaire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import sn.objis.mvngestionscolaire.metier.ServicesSup;
import sn.objis.mvngestionscolaire.utils.MysqlConnexion;

/**
 * IDaoServicessupImpl IDaoEleve
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public class IDaoServicessupImpl implements IDaoServicessup {
	
	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */
	Connection connexion = MysqlConnexion.getInstanceConnexion();

	@Override
	public void ajouter(ServicesSup s) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "INSERT INTO servicessup VALUES(NULL,?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setString(1, s.getLibelle_servicessup());
			preparedStatement.setDouble(2, s.getPrix_servicessup());
		
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			System.out.println("Insertion du service : "+ s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+" r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de l'insertion du service : " +s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+".");
		}
		
	}

	@Override
	public List<ServicesSup> lire() {
		List<ServicesSup> liste = new ArrayList<>();
		
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "SELECT * FROM servicessup";
			Statement statement = connexion.createStatement();
			
			//Etape2: Ex�cution de la requ�te
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du r�sultat
			while (resultSet.next()) {
				
				ServicesSup s = new ServicesSup();
				
				s.setId_servicessup(resultSet.getInt("id_servicessup"));
				s.setLibelle_servicessup(resultSet.getString("libelle_servicessup"));
				s.setPrix_servicessup(resultSet.getDouble("prix_servicessup"));
								
				liste.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la pr�paration de la liste des services suppl�mentaires.");
		}
		return liste;
	}

	@Override
	public void modifier(ServicesSup s) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "UPDATE servicessup SET libelle_servicessup = ?, prix_servicessup=? WHERE id_servicessup=?";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setString(1, s.getLibelle_servicessup());
			preparedStatement.setDouble(2, s.getPrix_servicessup());
			preparedStatement.setInt(3, s.getId_servicessup());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Modification des informations de services suppl�mentaires : " +s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+ " r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification de services suppl�mentaires : "+ s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+".");
		}	
		
	}

	@Override
	public void supprimer(ServicesSup s) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "DELETE FROM servicessup where id_servicessup=?";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setInt(1, s.getId_servicessup());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression du service suppl�mentaire : "+ s.getLibelle_servicessup()+" "+ s.getPrix_servicessup()+" r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
	}

	@Override
	public ServicesSup dernierenregistrement() {
		ServicesSup s = new ServicesSup();
		try {
		//Etape1 : Cr�ation de la requ�te
		String sql = "Select * from servicessup where id_servicessup = (SELECT MAX(id_servicessup)  from servicessup)";
		Statement statement = connexion.createStatement();
		
		//Etape2: Ex�cution de la requ�te
		ResultSet resultSet = statement.executeQuery(sql);
		
		//Etape3 : Traitement du r�sultat
		while (resultSet.next()) {
			
			s.setId_servicessup(resultSet.getInt("id_servicessup"));
			s.setLibelle_servicessup(resultSet.getString("libelle_servicessup"));
			s.setPrix_servicessup(resultSet.getDouble("prix_servicessup"));
			
		}
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Echec de la r�cup�ration du dernier service enregistr�.");
	}
		return s;
	}

	@Override
	public ServicesSup lire(ServicesSup s) {
		ServicesSup serviceSup = new ServicesSup();
		try {
		//Etape1 : Cr�ation de la requ�te
		String sql = "Select * from servicessup where libelle_servicessup = ?";
		PreparedStatement preparedStatement = connexion.prepareStatement(sql);
		
		//Etape2 : transmission de la valeur aux param�tres de la requ�te
		preparedStatement.setString(1, s.getLibelle_servicessup());
		
		//Etape3 : ex�cution de la requ�te
		ResultSet resultSet = preparedStatement.executeQuery();
		
		//Etape3 : Traitement du r�sultat
		while (resultSet.next()) {
			
			serviceSup.setId_servicessup(resultSet.getInt("id_servicessup"));
			serviceSup.setLibelle_servicessup(resultSet.getString("libelle_servicessup"));
			serviceSup.setPrix_servicessup(resultSet.getDouble("prix_servicessup"));
			
		}
	} catch (SQLException e1) {
		e1.printStackTrace();
		System.out.println("Echec de la r�cup�ration du service suppl�mentaire.");
	}
		return serviceSup;
	}

}
