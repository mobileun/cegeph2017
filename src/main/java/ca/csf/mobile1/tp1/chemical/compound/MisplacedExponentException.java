package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Class d'exception pour un exposant mal plaçé dans une formule chimique
 * ex: 2NaCl
 */
public class MisplacedExponentException extends Exception
{
    /**
     * Constructeur de l'exception
     */
    MisplacedExponentException(){super();}

    /**
     * Acesseur du message d'erreur
     * @return le message d'erreur de l'exception
     */
    public String getMessage(){return "Exponent found before any other chemical element or parenthesis.";}
}
