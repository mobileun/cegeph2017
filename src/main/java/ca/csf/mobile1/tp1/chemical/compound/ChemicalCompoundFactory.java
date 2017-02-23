package ca.csf.mobile1.tp1.chemical.compound;

import ca.csf.mobile1.tp1.chemical.element.ChemicalElement;
import ca.csf.mobile1.tp1.chemical.element.ChemicalElementRepository;

/**
 * Created by Fredgag on 2017-02-21.
 */

/**
 * Classe générant un arbre par composition d'objets ayant l'interface
 * ChemicalCompound qui sert à représenter un composé chimique complexe.
 */
public class ChemicalCompoundFactory
{
    /**
     * Un répsertoire d'éléments chimiques avec leur masse
     */
    private ChemicalElementRepository elements;

    /**
     * Constructeur de la classe
     * @param elements un instance non nulle de ChemicalElementRepository
     */
    public ChemicalCompoundFactory(ChemicalElementRepository elements)
    {
        this.elements = elements;
    }

    /**
     * Méthode créant la représentation d'un composé chimique
     * à partir d'une formule donnée valide
     * ex: NaCl, H2, (H20)2
     * Les parenthèses doivent balancées (())
     * les indices numériques au bon endroit
     * Lss éléments existants
     *
     * @param string formule chimique valide
     * @return un ChemicalCompund valide soit :
     *         ChemicalCompoundBasic, ChemicalCompoundGroup, ChemicalCompoundExponent
     * @throws EmptyFormulaException si formule vide en paramètre
     * @throws MisplacedExponentException si indice numérique mal plaçé
     * @throws UnknownChemicalElementException si élément chimique inexistant
     * @throws IllegalCharacterException si formule contant des caractères
     * autre que lettres, parenthèses ou valeur numérique
     * @throws IllegalClosingParenthesisException si des parathèses fermées sont seules
     * @throws MissingClosingParenthesisException si les parenthèses ne sont pas balançées
     * @throws EmptyParenthesisException si des parenthèses balançées ne contiennent rien
     */
    public ChemicalCompound createFromString(String string) throws EmptyFormulaException, MisplacedExponentException
            ,UnknownChemicalElementException,IllegalCharacterException,IllegalClosingParenthesisException
            ,MissingClosingParenthesisException,EmptyParenthesisException
    {


        //Cas chaînes vides
        if (string.length() <1 )
        {
            throw new EmptyFormulaException();
        }
        String stringTemp = string;
        stringTemp =stringTemp.replaceAll("\\s","");
        stringTemp =stringTemp.replaceAll("\\\t","");
        stringTemp =stringTemp.replaceAll("\\\n","");
        if (stringTemp.length() <1)
        {
            throw new EmptyFormulaException();
        }
        //Cas exponent misplaced and invalid parenthesis
        if (Character.isDigit(string.charAt(0)))
        {
            throw new MisplacedExponentException();
        }
        if (string.charAt(0) == ')')
        {
            throw new IllegalClosingParenthesisException();
        }


        String element = "";

        //Cas sans parathèses
        if (string.charAt(0) != '(')
        {
            if (string.length() > 1
                    && !Character.isDigit(string.charAt(0))
                    && Character.isLowerCase(string.charAt(1)))
            {
               element = string.substring(0,2);
                if(string.length() >= element.length())
                {
                  string = string.substring(2);

                }

            }
            else
            {
                element = string.substring(0,1);
                if(string.length() >= element.length())
                {
                    string = string.substring(1);
                }
            }

        }
        //Vérification caractères illégaux
        if (element.length() > 0)
        {
            for (Character character:element.toCharArray())
            {
                if (!Character.isAlphabetic(character))
                {
                    throw new IllegalCharacterException(character);
                }
            }
        }
       //Recherche élément
        Boolean onReturn = Boolean.FALSE;
        ChemicalCompound compound = null;
        if(element.length() > 0)
        {
        try {

                ChemicalElement chemicalElement = this.elements.get(element);
                compound = new ChemicalCompoundBasic(chemicalElement);
                if (compound.equals(null) || (this.elements.get(element)).equals(null))
                {
                    throw new UnknownChemicalElementException(element);
                }
            }
            catch (NullPointerException exception)
            {
                throw new UnknownChemicalElementException(element);
            }


           if (string.length()>0)
           {
           if (!Character.isDigit(string.charAt(0)))
           {
               ChemicalCompound subCompound = createFromString(string);
               ChemicalCompoundGroup chemicalCompoundGroup = new ChemicalCompoundGroup(compound,subCompound);
               compound = chemicalCompoundGroup;
           }
           else
           {
               int numberOfDigit = 0;
               for (int i = 0;i < string.length();i++)
                {
                    if (Character.isDigit(string.charAt(i)))
                    {
                        numberOfDigit++;
                    }
                    else
                    {
                        break;
                    }
                }
               String exponentString = string.substring(0,numberOfDigit);
               string = string.substring(numberOfDigit);
               int exponent = 0;
               try
               {
                   exponent = Integer.parseInt(exponentString);
               }
               catch (Exception exception)
               {
                   throw new IllegalArgumentException("Exponent of chemical compund is illegal number");
               }

               ChemicalCompoundExponent chemicalCompoundExponent = new ChemicalCompoundExponent(compound,exponent);
               compound = chemicalCompoundExponent;
               if (string.length()>0)
               {
               ChemicalCompound subCompound = createFromString(string);
               ChemicalCompoundGroup chemicalCompoundGroup = new ChemicalCompoundGroup(compound,subCompound);
               compound = chemicalCompoundGroup;
               }
           }
           }
            onReturn = Boolean.TRUE;
        }

        //Traitement des parenthèses
        if (string.length()>1 && !onReturn)
        {
            if (string.charAt(0) == '(')
            {
                int openingParathesisCount = 0;
                String subString ="";
                for (int position = 0;position<string.length();position++)
                {
                    if (string.charAt(position) == '(')
                    {
                       openingParathesisCount++;
                    }
                    if (string.charAt(position) == ')')
                    {
                        openingParathesisCount--;
                    }
                    if (openingParathesisCount == 0)
                    {
                        //store string et subdivide
                        //clean parenthesis
                        subString = string.substring(0,position+1);
                        string = string.substring(position+1);
                        if (subString.length() == 2)
                        {
                            throw new EmptyParenthesisException();
                        }
                        subString = subString.substring(1,position);
                        break;
                    }
                }
                if (openingParathesisCount > 0)
                {
                    throw new MissingClosingParenthesisException();
                }
                if (openingParathesisCount < 0)
                {
                    throw new IllegalClosingParenthesisException();
                }

                 //Ok subString entre parenthèse
                //Process le reste de string s'il y a lieu
                if (string.length() > 0)
                {

                    //cas exponent
                    if (Character.isDigit(string.charAt(0)))
                    {
                    //Extraction exponent
                    int numberOfDigit = 0;
                    for (int i = 0;i < string.length();i++)
                    {
                        if (Character.isDigit(string.charAt(i)))
                        {
                            numberOfDigit++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    String exponentString = string.substring(0,numberOfDigit);
                    string = string.substring(numberOfDigit);
                    int exponent = 0;
                    try
                    {
                        exponent = Integer.parseInt(exponentString);
                    }
                    catch (Exception exception)
                    {
                        throw new IllegalArgumentException("Exponent of chemical compund is illegal number");
                    }
                        //substring inner parenthesis
                        //string reste sans exponent

                        // cas exponent et autres choses apres exponent
                        if (string.length()>0)
                        {
                            ChemicalCompound subCompoundLeft = createFromString(subString);
                            ChemicalCompoundExponent chemicalCompoundExponent = new ChemicalCompoundExponent(subCompoundLeft,exponent);
                            ChemicalCompound subCompoundRight = createFromString(string);
                            ChemicalCompoundGroup chemicalCompoundGroup = new ChemicalCompoundGroup(chemicalCompoundExponent,subCompoundRight);
                            compound = chemicalCompoundGroup;
                        }
                        else
                        {
                            //cas exponant possible et rien apres expoenent
                            ChemicalCompound subCompound = createFromString(subString);
                            ChemicalCompoundExponent chemicalCompoundExponent = new ChemicalCompoundExponent(subCompound,exponent);
                            compound = chemicalCompoundExponent;
                        }
                    }
                     else
                    {
                        //no exponent
                        //other things still there
                        ChemicalCompound subCompoundLeft = createFromString(subString);
                        ChemicalCompound subCompoundRight = createFromString(string);
                        ChemicalCompoundGroup chemicalCompoundGroup = new ChemicalCompoundGroup(subCompoundLeft,subCompoundRight);
                        compound = chemicalCompoundGroup;
                    }
                }
                else
                {
                    //rien après parenthese
                    ChemicalCompound subCompound = createFromString(subString);
                    compound = subCompound;
                }

            }

        }


        return compound;

    }
}
