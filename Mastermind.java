package mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    public static void main(String[] args) {
  
        int[] solution = numberGenerator();	//Cr�er un code automatiquement
        
        //Initialise variable permettant d'afficher bon resultat final
        String validation = "NON";
                
        //initialise le compteur d'essais
        int compteur = 0;
        
        //Tabeleau permettant d'afficher le r�sultat de la comparaison � l'utilisateur
        String[] resultat = new String[4];
                
        do {
        	
        	int code[] = userCode(null, compteur);
        	            
            // Comparaison des deux codes        
        	resultat = compare(solution, code);
	        
	        //Affiche le r�sultat finale
	        validation = showResult(resultat, compteur);
	                
	        //incr�mente le compteur
	        compteur++;
	        
    } while(compteur < 8 && validation != "OK");
        
    //Propose � l'utiisateur de relancer le jeu
    newGame(null);
             
  }

        
   //FONCTIONS UTILIS�ES DANS LE MAIN***********************************************
    
 // code al�atoire---------------------------------------------------------
    public static int[] numberGenerator() {

        // chiffre al�atoire
        Random randy = new Random();

        // int�gartion du code dans un tableau 
        int[] randArray = new int[4];

        // utilisation de varaible pour remplir le tableau
        int a = randy.nextInt(9);
        int b = randy.nextInt(9);
        int c = randy.nextInt(9);
        int d = randy.nextInt(9);

        
        randArray[0] = a;
        randArray[1] = b;
        randArray[2] = c;
        randArray[3] = d;
        
        return randArray;
    }
    
    //Saisie code utilisateur----------------------------------------------
    public static int[] userCode(String input, int compteur) {
    	do {
        // La saisie du code de l'utilisateur
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Veuillez entrer un code de 4 chiffres pour votre essai num�ro " + (compteur + 1) + " :");
        input = keyboard.nextLine();
    	} while(input.length() != 4);
        //g�n�re un le code saisie dans un tabeleau
        int[] code = new int[4];
        for (int i = 0; i < 4; i++) {
        	code[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return code;
    }
    
  //permet d'afficher le r�sulat ------------------------------------------
    public static String showResult(String[] resultat, int compteur) {
    	String validation = "NON";
        //Affiche le r�sultat finale
        if (resultat[0] == "OK" && resultat[1] == "OK" && resultat[2] == "OK" && resultat[3] == "OK") {
        	System.out.println("VICTOIRE !!");
        	validation = "OK";
        }
        
        if (compteur == 7) {
        	System.out.println("D�FAITE !!");
        }
        
        return validation;
    }
    
  //Comparaison des deux codes -------------------------------------------
  public static String[] compare(int[] solution, int[] code){
	  
	String[] resultat =  new String[4];
	
    if(solution[0] == code[0]) //premier chiffre
    {
    	resultat[0] = "OK";
    } else {
    	if(code[0] == solution[1] || code[0] == solution[2] || code[0] == solution[3]) {
    		//System.out.println("Mal plac�");
    		resultat[0] = "Mal plac�";
    } else {resultat[0] = "Faux";}
    }
    
    if(solution[1] == code[1]) // deuxi�me chiffre
    {
    	resultat[1] = "OK";
    } else {
    	if(code[1] == solution[0] || code[1] == solution[2] || code[1] == solution[3]) {
    		//System.out.println("Mal plac�");
    		resultat[1] = "Mal plac�";
    } else {resultat[1] = "Faux";}
    }
    
    if(solution[2] == code[2]) //troisi�me chiffre
    {
    	resultat[2] = "OK";
    } else {
    	if(code[2] == solution[1] || code[2] == solution[0] || code[2] == solution[3]) {
    		//System.out.println("Mal plac�");
    		resultat[2] = "Mal plac�";
    } else {resultat[2] = "Faux";}
    }
    
    if(solution[3] == code[3]) //quatri�me chiffre
    {
    	resultat[3] = "OK";
    } else {
    	if(code[3] == solution[1] || code[3] == solution[2] || code[3] == solution[0]) {
    		//System.out.println("Mal plac�");
    		resultat[3] = "Mal plac�";
    } else {resultat[3] = "Faux";}
    }

    //Affiche le r�sultat
    System.out.println(Arrays.toString(code));
    System.out.println(Arrays.toString(resultat));
    
    return resultat;
   }    
  
  //Lance une nouvelle partie selon le choix du joueur -------------------------
  public static void newGame(String input){
  	do {
        // La saisie du code de l'utilisateur
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Souhaitez vous refaire une partie ? (OK/NO)");
        input = keyboard.nextLine();
    	} while(!input.equals("OK") && !input.equals("NO") && !input.equals("ok") && !input.equals("no"));
  	
  	if(input.equals("OK") && input.equals("ok")) {
  		System.out.println("Bonne chance !!");
  		main(null);
  	} else { System.out.println("Aurevoir !"); }
  }
        
}