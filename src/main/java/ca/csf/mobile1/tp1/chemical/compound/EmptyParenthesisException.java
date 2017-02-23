package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe de l'exception pour une formule chimique ayant des parenthèses vides
 * ex: NaCl()2
 */
public class EmptyParenthesisException extends Exception
{
    /**
     * Constructeur de l'exception
     */
    EmptyParenthesisException(){super();}

    /**
     * Acesseur du message d'erreur
     * @return le message d'erreur de l'exception
     */
    public String getMessage(){return"Chemical compound contains an illegal empty parenthesis.";}
}
