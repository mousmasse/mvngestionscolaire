package sn.objis.mvngestionscolaire.service;

import java.util.List;

import sn.objis.mvngestionscolaire.dao.IDaoEleveImpl;
import sn.objis.mvngestionscolaire.metier.Eleve;

/**
 * Class IServiceEleveImpl
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */

public class IServiceEleveImpl implements IServiceEleve {

	private IDaoEleveImpl iDaoEleve = new IDaoEleveImpl();
	
	@Override
	public void ajouter(Eleve e) {

		iDaoEleve.ajouter(e);
		
	}

	@Override
	public List<Eleve> lire() {

		return iDaoEleve.lire();
	}

	@Override
	public void modifier(Eleve e) {
		
		iDaoEleve.modifier(e);
		
	}

	@Override
	public void supprimer(Eleve e) {
		
		iDaoEleve.supprimer(e);
		
	}

	@Override
	public Eleve dernierenregistrement() {
		
		return iDaoEleve.dernierenregistrement();
	}

	@Override
	public Eleve lire(Eleve e) {

		return iDaoEleve.lire(e);
	}

	
	
}
