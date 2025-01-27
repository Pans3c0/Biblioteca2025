package org.educastur.samuelepv59.biblioteca2025;

public class Excepciones {
    public boolean esInt (String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    public boolean esDouble (String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    public char calcularLetraDNI (int n){
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        return letras[n % 23];
    }

    public class LibroNoDisponible extends Exception{

    public LibroNoDisponible(String cadena) {
        super(cadena);
    }
    
    }

    public class LibroNoExiste extends Exception {
        public LibroNoExiste(String cadena){                                                                        
                    super(cadena); //Llama al constructor de Exception y le pasa el contenido de cadena              
        }
    }
}
