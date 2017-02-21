package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

public class ChemicalCompoundGroup implements ChemicalCompound
{
    private ChemicalCompound[] compounds;
    ChemicalCompoundGroup(ChemicalCompound... compounds)
    {
      this.compounds = compounds;
    }

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
