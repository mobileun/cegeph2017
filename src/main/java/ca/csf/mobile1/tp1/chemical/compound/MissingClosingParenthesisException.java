package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe d'exception pour l'absence d'une parenthèse fermente
 * d'une formule chimique ex: ((NaCl)4
 */
public class MissingClosingParenthesisException extends Exception
{
    /**
     * Constructeur de l'exception
     */
    MissingClosingParenthesisException(){super();}

    /**
     * Acesseur du message d"erreur
     * @return le message d'erreur
     */
    public String getMessage(){return"Chemical compound contains is missing a closing parenthesis.";}
}
