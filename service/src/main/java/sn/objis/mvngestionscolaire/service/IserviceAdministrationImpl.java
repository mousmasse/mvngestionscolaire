package sn.objis.mvngestionscolaire.service;

import java.util.List;

import sn.objis.mvngestionscolaire.dao.IDaoAdministrationImpl;
import sn.objis.mvngestionscolaire.metier.Administration;

/**
 * Class IserviceAdministrationImpl
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public class IserviceAdministrationImpl implements IserviceAdministration{

	private IDaoAdministrationImpl iDaoAdminImpl = new IDaoAdministrationImpl();
	
	@Override
	public void ajouter(Administration a) {
		
		iDaoAdminImpl.ajouter(a);		
	}

	@Override
	public List<Administration> lire() {
		
		return iDaoAdminImpl.lire();
	}

	@Override
	public void modifier(Administration a) {
		
		iDaoAdminImpl.modifier(a);
		
	}

	@Override
	public void supprimer(Administration a) {
		
		iDaoAdminImpl.supprimer(a);
		
	}

	@Override
	public Administration dernierenregistrement() {

		return iDaoAdminImpl.dernierenregistrement();
	}

	@Override
	public Administration lire(Administration a) {
		// TODO Auto-generated method stub
		return null;
	}

}
