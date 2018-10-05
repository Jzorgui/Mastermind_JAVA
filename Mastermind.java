package mastermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    public static void main(String[] args) {
  
        int[] solution = numberGenerator();	//Créer un code automatiquement
        
        //Initialise variable permettant d'afficher bon resultat final
        String validation = "NON";
                
        //initialise le compteur d'essais
        int compteur = 0;
        
        //Tabeleau permettant d'afficher le résultat de la comparaison à l'utilisateur
        String[] resultat = new String[4];
                
        do {
        	
        	int code[] = userCode(null, compteur);
        	            
            // Comparaison des deux codes        
        	resultat = compare(solution, code);
	        
	        //Affiche le résultat finale
	        validation = showResult(resultat, compteur);
	                
	        //incrémente le compteur
	        compteur++;
	        
    } while(compteur < 8 && validation != "OK");
        
    //Propose à l'utiisateur de relancer le jeu
    newGame(null);
             
  }

        
   //FONCTIONS UTILISÉES DANS LE MAIN***********************************************
    
 // code aléatoire---------------------------------------------------------
    public static int[] numberGenerator() {

        // chiffre aléatoire
        Random randy = new Random();

        // intégartion du code dans un tableau 
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
        System.out.println("Veuillez entrer un code de 4 chiffres pour votre essai numéro " + (compteur + 1) + " :");
        input = keyboard.nextLine();
    	} while(input.length() != 4);
        //génère un le code saisie dans un tabeleau
        int[] code = new int[4];
        for (int i = 0; i < 4; i++) {
        	code[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }
        return code;
    }
    
  //permet d'afficher le résulat ------------------------------------------
    public static String showResult(String[] resultat, int compteur) {
    	String validation = "NON";
        //Affiche le résultat finale
        if (resultat[0] == "OK" && resultat[1] == "OK" && resultat[2] == "OK" && resultat[3] == "OK") {
        	System.out.println("VICTOIRE !!");
        	validation = "OK";
        }
        
        if (compteur == 7) {
        	System.out.println("DÉFAITE !!");
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
    		//System.out.println("Mal placé");
    		resultat[0] = "Mal placé";
    } else {resultat[0] = "Faux";}
    }
    
    if(solution[1] == code[1]) // deuxième chiffre
    {
    	resultat[1] = "OK";
    } else {
    	if(code[1] == solution[0] || code[1] == solution[2] || code[1] == solution[3]) {
    		//System.out.println("Mal placé");
    		resultat[1] = "Mal placé";
    } else {resultat[1] = "Faux";}
    }
    
    if(solution[2] == code[2]) //troisième chiffre
    {
    	resultat[2] = "OK";
    } else {
    	if(code[2] == solution[1] || code[2] == solution[0] || code[2] == solution[3]) {
    		//System.out.println("Mal placé");
    		resultat[2] = "Mal placé";
    } else {resultat[2] = "Faux";}
    }
    
    if(solution[3] == code[3]) //quatrième chiffre
    {
    	resultat[3] = "OK";
    } else {
    	if(code[3] == solution[1] || code[3] == solution[2] || code[3] == solution[0]) {
    		//System.out.println("Mal placé");
    		resultat[3] = "Mal placé";
    } else {resultat[3] = "Faux";}
    }

    //Affiche le résultat
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