package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe représentant un composé chimique d'un ou plusieurs éléments avec indice
 * ex: H2, (NaCl)2
 */
public class ChemicalCompoundExponent implements ChemicalCompound
{
    /**
     * Le composé chimique ayant un indice
     */
    private ChemicalCompound compound;
    /**
     * L'indice du composé chimique
     */
    private int exponent;

    /**
     * Constructeur d'un composé chimique avec indice
     * @param compound instance de ChemicalCompound ou ChemicalElement sans son indice
     * @param exponent l'indice du ChemicalCompound ou du ChemicalElement
     */
    public ChemicalCompoundExponent(ChemicalCompound compound,int exponent)
    {
        this.compound = compound;
        this.exponent = exponent;
    }
    /**
     * Acesseur de la masse totale du composé chimique avec indice
     * @return la masse totale en grammes/mole
     */
    public double getWeight(){return exponent*compound.getWeight();}
}
