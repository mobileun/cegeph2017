package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

public class IllegalCharacterException extends Exception
{
    private Character character;
    IllegalCharacterException(Character character){super(character.toString());}

    public String getCharacter()
    {
        return this.getMessage();
    }
}
