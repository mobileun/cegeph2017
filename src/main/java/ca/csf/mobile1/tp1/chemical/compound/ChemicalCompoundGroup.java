package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe générant des objets représentant une groupe d'éléments chimique
 * pouvant être un élément chimique, un groupe d'élément chimiques
 * Les éléments ou groupe d'éléments  peuvent possiblement avoir des
 * indices numériques de molarité.
 * ex: Na et Cl, NaCl et H2
 */
public class ChemicalCompoundGroup implements ChemicalCompound
{
    /**
     * Tableau stockant les composés chimiques ou éléments
     */
    private ChemicalCompound[] compounds;

    /**
     * Constructeur de la classe
     * @param compounds un tableau de combinaisons de ChemicalElement,
     *                  ChemicalCompound et ChemicalCompoundExponent
     *                  ou sous forme d'arguments multiples
     */
    ChemicalCompoundGroup(ChemicalCompound... compounds)
    {
      this.compounds = compounds;
    }

    /**
     * Acesseur de la masse totale du composé chimique
     * @return la masse totale en grammes/mole
     */
    public double getWeight()
    {
        double weight = 0.0;
        for (ChemicalCompound compound:compounds)
        {
            weight = weight + compound.getWeight();
        }
        return weight;
    }
}
