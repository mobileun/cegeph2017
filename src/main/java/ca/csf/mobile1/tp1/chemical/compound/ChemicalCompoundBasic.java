package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe représentant un élément chimique
 * ex: H,Na
 */
public class ChemicalCompoundBasic implements ChemicalCompound
{
    /**
     * Élément chimique de base
     */
    private ChemicalElement element;

    /**
     * Constructeur de la classe
     * @param element instance de ChemicalElement
     */
    public ChemicalCompoundBasic(ChemicalElement element)
    {
       this.element = element;
    }

    /**
     * Acesseur de la masse de l'élément
     * @return la masse  en grammes/mole
     */
    public double getWeight(){return element.getWeight();}

}
