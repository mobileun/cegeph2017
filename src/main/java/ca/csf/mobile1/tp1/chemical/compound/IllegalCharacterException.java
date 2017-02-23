package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe de l'exception gérant les caractères illégaux d'une formule chimique
 * ex: $NaCl
 */
public class IllegalCharacterException extends Exception
{
    /**
     * Le caractère illégal
     */
    private char character;
    /**
     * Le message d'erreur formaté avec le caractère illégal
     */
    private String message;

    /**
     * Constructeur de l'exception
     * @param character le caractère illégal
     */
    IllegalCharacterException(char character)
    {
        this.character = character;
        this.message = "Illegal character \""+character+"\"found in chemical compound formula.";
    }

    /**
     * Acesseur du caractère illégale
     * @return le caractère illégale de l'exception lançée
     */
    public char getCharacter()
    {
        return this.character;
    }

    /**
     * Acesseur du message d'erreur
     * @return message d'erreur de l'exception incluant le caractère illégal
     */
    public String getMessage()
    {return this.message;}
}
