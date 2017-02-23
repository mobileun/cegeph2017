package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe de l'exception gérant une formule chimique vide
 * ex: \n
 */
public class EmptyFormulaException extends Exception
{
    /**
     * Constructeur de l'exception
     */
    EmptyFormulaException(){super();}

    /**
     * Acesseur du message d'erreur
     * @return le message d'erreur de l'exception
     */
    public String getMessage(){return "Chemical compound formula is empty.";}
}
