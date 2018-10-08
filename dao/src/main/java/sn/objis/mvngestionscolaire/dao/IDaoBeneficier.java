package sn.objis.mvngestionscolaire.dao;

import sn.objis.mvngestionscolaire.metier.Beneficier;

/**
 * Interface IDaoBeneficier
 * @author Moustapha M. NDIAYE
 * @version 3.0
 * @since 30/05/2018 
 */
public interface IDaoBeneficier  extends IDaoGenerique<Beneficier>{

	/**
	 * @param e : Méthode générique pour la modification d'informations 
	 */
	public void modifier(Beneficier b1, Beneficier b2);
	
}