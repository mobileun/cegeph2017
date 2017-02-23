package ca.csf.mobile1.tp1.chemical.compound;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe d'exception pour un élément chimique inconnu
 */
public class UnknownChemicalElementException extends Exception
{
    /**
     * Message d'erreur formaté avec l'élément chimique inconnu
     */
    private String message;
    /**
     * Élément chimique inconnu
     */
    private String element;

    /**
     * Constructeur de l'exception pour les éléments chimiques inconnus
     * @param message est l'éléments chimique inconnu
     */
    UnknownChemicalElementException(String message)
    {
        this.element = message;
        this.message = "Chemical element \"" +message+"\" is unknown.";
    }

    /**
     * Acesseur de l'élément chimique inconnu
     * @return l'élément chimique inconnu
     */
    public String getElement()
    {
        return this.element;
    }

    /**
     * Acesseur du message d'erreur
     * @return message d'erreur incluant l'élément chimique inconnus
     */
    public String getMessage()
    {return this.message;}
}
