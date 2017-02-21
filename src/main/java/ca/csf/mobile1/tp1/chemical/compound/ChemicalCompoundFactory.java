package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElementRepository;

/**
 * Created by Fredgag on 2017-02-21.
 */

public class ChemicalCompoundFactory
{
    private ChemicalElementRepository elements;
    public ChemicalCompoundFactory(ChemicalElementRepository elements)
    {
        this.elements = elements;
    }
    public ChemicalCompound createFromString(String string)
    {

        ChemicalCompound compound = new ChemicalCompoundBasic(elements.get("H"));
        return compound;

    }
}
