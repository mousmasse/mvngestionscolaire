package sn.objis.mvngestionscolaire.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class MysqlConnection
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */

public class MysqlConnexion {

	private static  String url="jdbc:mysql://localhost/gestionscolaire?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String userBd = "root";
	private static String pwdBd = "Bouchra#05";
	private static Connection connexion = null;

	/**
	 * Constructeur priv� pour entraver la cr�ation d'instance de la classe
	 */
	private MysqlConnexion() {
		super();
	}

	public static Connection getInstanceConnexion() {

		if (connexion==null) {

			try {
				connexion = DriverManager.getConnection(url, userBd, pwdBd);
				System.out.println("Connexion �tablie avec la base.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Ech�que de la tentative de connexion avec la base");
			}

		}

		return connexion;

	}

}
