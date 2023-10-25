package practicasExamenUno;

import java.util.Scanner;

public class Mutante {
	static Scanner sc = new Scanner(System.in);
    static String[] adn = new String[6];
    static char[][] matrizAdn = new char[6][6];

    public static void main(String[] args) {
        
    	pedirLetras();
    	
    	if(isMutant(adn)) {
        	System.out.println("Este ADN es mutante");
        }else {
        	System.out.println("Este ADN no es mutante");
        }
    	
    	//---------------------------------------------------------------------------------------------------
    }
    
    public static void pedirLetras() {
    	
        System.out.println("Ingresa las 6 secuencias de ADN (cada una de 6 letras):");

        for (int i = 0; i < 6; i++) {
            boolean secuenciaValida = false;
            while (!secuenciaValida) {
                String input = sc.nextLine().toUpperCase();
                System.out.println("Ingresa las 6 siguiente secuencias de ADN (cada una de 6 letras):");
                if (input.matches("^[ATGC]+$") && input.length() == 6) {
                    adn[i] = input;
                    secuenciaValida = true;
                } else {
                    System.out.println("Caracter no válido o ingresaste una cantidad distinta de 6. Solo 6 letras entre A, T, G o C.");
                }
            }
        }
        
        stringAMatriz(adn); 

    }
    
    //pasar el string a matriz
    public static void stringAMatriz(String adn[]) {
	    for (int i = 0; i < adn.length; i++) {
	        for (int j = 0; j < adn.length; j++) {
	            matrizAdn[i][j] = adn[i].charAt(j);
	        }
	    }
	    for(int i = 0; i < matrizAdn.length; i++) {
	    	System.out.println("");
	    	for(int j = 0; j < matrizAdn[i].length; j++) {
	    		System.out.print(matrizAdn[i][j]);
	    	}
	    }
	    System.out.println(" ");
	    isMutant(adn);
    }
  
    //---------------------------------------------------------------------------------------------------
    // ver si según las secuencias de letras son mutantes o no

    public static boolean isMutant(String adn[]) {
    	
    	boolean esMutante = false;
    	//verificar horizontal
    	for (int i = 0; i < matrizAdn.length; i++) {
            for (int j = 0; j < matrizAdn[i].length-3; j++) {
                if (matrizAdn[i][j] == matrizAdn[i][j+1] && 
                	matrizAdn[i][j] == matrizAdn[i][j+2] && 
                	matrizAdn[i][j] == matrizAdn[i][j+3]) {
        	    	//System.out.println("Hay un mutante (horizontal)");
                    esMutante = true; //o sea que hay mutantes
                }

            }
        }
    	
    	//verificar vertical
    	for (int i = 0; i < matrizAdn.length-3; i++) {
        	for (int j = 0; j < matrizAdn[i].length; j++) {
        		if (matrizAdn[i][j] == matrizAdn[i+1][j] && 
        			matrizAdn[i][j] == matrizAdn[i+2][j] && 
        			matrizAdn[i][j] == matrizAdn[i+3][j]) {
        	    	//System.out.println("Hay un mutante (vertical)");
        	    	esMutante = true; //hay mutantes
        		}
            }
        }
    	
    	
    	//verificar diagonales
    	for (int i = 0; i < matrizAdn.length -3; i++) {  
    	    for (int j = 0; j < matrizAdn[i].length -3; j++) {  
    	        if (matrizAdn[i][j] == matrizAdn[i+1][j+1] &&
    	            matrizAdn[i][j] == matrizAdn[i+2][j+2] &&
    	            matrizAdn[i][j] == matrizAdn[i+3][j+3]) {
        	    	//System.out.println("Hay un mutante (diagonal)");
        	    	esMutante = true;
    	        }
    	    }
    	    
    	}
    	
    	for(int i = 0; i < matrizAdn.length - 3; i++) {
        	for(int j = 3; j < matrizAdn[i].length; j++) {
        		if (matrizAdn[i][j] == matrizAdn[i+1][j-1] && 
        			matrizAdn[i][j] == matrizAdn[i+2][j-2] && 
        			matrizAdn[i][j] == matrizAdn[i+3][j-3]) {
        	    	//System.out.println("Hay un mutante (diagonal)");
        	    	esMutante = true; // hay mutantes
        		}
        	}
        }
    	
    	if (esMutante) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
}
