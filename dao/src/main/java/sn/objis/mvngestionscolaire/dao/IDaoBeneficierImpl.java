package sn.objis.mvngestionscolaire.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.mvngestionscolaire.metier.Beneficier;
import sn.objis.mvngestionscolaire.metier.Eleve;
import sn.objis.mvngestionscolaire.metier.ServicesSup;
import sn.objis.mvngestionscolaire.utils.MysqlConnexion;

/**
 * class IDaoBeneficierImpl
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public class IDaoBeneficierImpl implements IDaoBeneficier{

	/**
	 * Obtention de l'unique instance de connexion avec la base
	 */  
	Connection connexion = MysqlConnexion.getInstanceConnexion();
	
	@Override
	public void ajouter(Beneficier b) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "INSERT INTO beneficier VALUES(?,?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setInt(1, b.getEleve().getIdEleve());
			preparedStatement.setInt(2, b.getServiceSup().getId_servicessup());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			System.out.println("Prise en compte du service pour: l'�l�ve "+ b.getEleve().getPrenom()+" "+ b.getEleve().getNom()+" r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la prise en compte du service pour l'�l�ve : "+b.getEleve().getPrenom()+" "+ b.getEleve().getNom()+".");
		}
		
	}

	@Override
	public List<Beneficier> lire() {
		
		List<Beneficier> liste = new ArrayList<>();
		
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "SELECT * FROM beneficier";
			Statement statement = connexion.createStatement();
			
			//Etape2: Ex�cution de la requ�te
			ResultSet resultSet = statement.executeQuery(sql);
			
			//Etape3 : Traitement du r�sultat
			while (resultSet.next()) {
				
				Beneficier b = new Beneficier();
				Eleve e = new Eleve();
				ServicesSup s = new ServicesSup();
				
				e.setIdEleve(resultSet.getInt("id_eleve"));
				s.setId_servicessup(resultSet.getInt("id_servicessup"));
				b.setEleve(e);
				b.setServiceSup(s);
				
				liste.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Echec de la pr�paration de la liste des �l�ves b�n�ficiaires.");
		}
		return liste;
	}

	
	@Override
	public void supprimer(Beneficier b) {

		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "DELETE FROM beneficier where (id_eleve=? && id_servicessup=?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission de la valeur aux param�tres de la requ�te
			preparedStatement.setInt(1, b.getEleve().getIdEleve());
			preparedStatement.setInt(2,b.getServiceSup().getId_servicessup());
			
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Suppression r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
	}

	
	@Override
	public void modifier(Beneficier b1, Beneficier b2) {
		try {
			//Etape1 : Cr�ation de la requ�te
			String sql = "UPDATE beneficier SET id_eleve=?, id_servicessup=? WHERE (id_eleve=? && id_servicessup=?)";
			PreparedStatement preparedStatement = connexion.prepareStatement(sql);
			
			//Etape2 : transmission des valeurs aux param�tres de la requ�te
			preparedStatement.setInt(1, b2.getEleve().getIdEleve());
			preparedStatement.setInt(2,b2.getServiceSup().getId_servicessup());
			preparedStatement.setInt(3, b1.getEleve().getIdEleve());
			preparedStatement.setInt(4,b1.getServiceSup().getId_servicessup());
						
			//Etape3 : ex�cution de la requ�te
			preparedStatement.executeUpdate();
			
				System.out.println("Modification r�ussit.");
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			System.out.println("Echec de la modification.");
		}	
		
	}
	
	@Override
	public Beneficier dernierenregistrement() {
		// pas besoin :)
		return null;
	}

	@Override
	public Beneficier lire(Beneficier e) {
		// pas besoin :)
		return null;
	}
	@Override
	public void modifier(Beneficier b) {
		// pas besoin :)
	}


}
