package sn.objis.mvngestionscolaire.service;

import java.util.List;

import sn.objis.mvngestionscolaire.dao.IDaoServicessupImpl;
import sn.objis.mvngestionscolaire.metier.ServicesSup;


/**
 * Class IServiceServicessupImpl
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public class IServiceServicessupImpl implements IServiceServicessup{
	
	private IDaoServicessupImpl iDaoServicessupImpl = new IDaoServicessupImpl();

	@Override
	public void ajouter(ServicesSup s) {

		iDaoServicessupImpl.ajouter(s);
	}

	@Override
	public List<ServicesSup> lire() {

		return iDaoServicessupImpl.lire();
	}

	@Override
	public void modifier(ServicesSup s) {
		
		iDaoServicessupImpl.modifier(s);
		
	}

	@Override
	public void supprimer(ServicesSup s) {

		iDaoServicessupImpl.supprimer(s);
		
	}

	@Override
	public ServicesSup dernierenregistrement() {

		return iDaoServicessupImpl.dernierenregistrement();
	}

	@Override
	public ServicesSup lire(ServicesSup e) {

		return iDaoServicessupImpl.lire(e);
	}

}
