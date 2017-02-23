package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Interface d'implantation de composés et éléments chimiques
 */
public interface ChemicalCompound
{
   /**
    * Interface garantissant que l'objet a une masse acessible
    * @return la masse en grammes/mol
     */
   public double getWeight();
}
