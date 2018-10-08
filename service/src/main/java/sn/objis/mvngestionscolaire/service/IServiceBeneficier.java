package sn.objis.mvngestionscolaire.service;

import sn.objis.mvngestionscolaire.metier.Beneficier;

/**
 * interface IServiceBeneficier
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public interface IServiceBeneficier extends IServiceGenerique<Beneficier>{

	/**
	 * @param e : Méthode générique pour la modification d'informations 
	 */
	public void modifier(Beneficier b1, Beneficier b2);
	
}
