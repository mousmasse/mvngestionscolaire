package sn.objis.mvngestionscolaire.service;

import java.util.List;


import sn.objis.mvngestionscolaire.dao.IDaoTuteurImpl;
import sn.objis.mvngestionscolaire.metier.Tuteur;

/**
 * Class IServiceTuteurImpl
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public class IServiceTuteurImpl implements IServiceTuteur{

	private IDaoTuteurImpl iDaoTuteurImpl = new IDaoTuteurImpl();
	
	@Override
	public void ajouter(Tuteur t) {
		iDaoTuteurImpl.ajouter(t);
		
	}

	@Override
	public List<Tuteur> lire() {
		return iDaoTuteurImpl.lire();
	}

	@Override
	public void modifier(Tuteur t) {
		
		iDaoTuteurImpl.modifier(t);
		
	}

	@Override
	public void supprimer(Tuteur t) {

		iDaoTuteurImpl.supprimer(t);
		
	}

	@Override
	public Tuteur dernierenregistrement() {

		return iDaoTuteurImpl.dernierenregistrement();
	}

	@Override
	public Tuteur lire(Tuteur t) {
		return iDaoTuteurImpl.lire(t);
	}

}
