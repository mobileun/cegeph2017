package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Class de l'exception gérant l'erreur pour les parenthèse s illégales
 * ex: )NaCl
 */
public class IllegalClosingParenthesisException extends Exception
{
    /**
     * Constructeur de l'exception
     */
    IllegalClosingParenthesisException(){super();}

    /**
     * Acesseur du message d'erreur
     * @return le messge d'erreur de l'exception
     */
    public String getMessage(){return "Chemical compound contains an illegal closing parenthesis before any opening parenthesis.";}

}
