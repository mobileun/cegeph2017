package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

public class ChemicalCompoundExponent implements ChemicalCompound
{
    private ChemicalCompound compound;
    private int exponent;
    public ChemicalCompoundExponent(ChemicalCompound compound,int exponent)
    {
        this.compound = compound;
        this.exponent = exponent;
    }

    public double getWeight(){return exponent*compound.getWeight();}
}
