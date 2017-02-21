package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

public class UnknownChemicalElementException extends Exception
{


    UnknownChemicalElementException(String message){super(message);}

    public String getElement()
    {
        return this.getMessage();
    }
}
