/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.educastur.samuelepv59.biblioteca2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *primer commit
 * @author alu19d
 */
public class Biblioteca2025 {
    
    
    private ArrayList<Libro>libros;
    private ArrayList<Usuario>usuarios;
    private ArrayList<Prestamo>prestamos;
    
    
    private boolean estatus = true;
    
    
    public Biblioteca2025(){
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        
    }
    public static void main(String[] args) {
        Biblioteca2025 b = new Biblioteca2025();
        b.cargaDatos();
        b.menu();
        
    }   

//<editor-fold defaultstate="collapsed" desc="MENUS">
    private void menu() {
        Scanner sc=new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("\n AGENDA 2024"); 
            System.out.println("\t\t\t\t1 - Libros");
            System.out.println("\t\t\t\t2 - Usuarios");
            System.out.println("\t\t\t\t3 - Prestamos");
            System.out.println("\t\t\t\t4 - Filtros");
            System.out.println("\n\n\t\t\t\t0 - SALIR\n\n");
            opcion=sc.nextInt();
            switch (opcion){
                case 0:
                System.out.println("Saliendo del programa...");
                break;
                case 1:{
                    menuLibros();
                    break;
                }
                case 2:{
                    menuUsuarios();
                    break;
                }
                case 3:{
                    menuPrestamos();
                    break;
                }
                case 4:{
                    menuFiltros();
                    break;
                }
            }
            
        }while (opcion !=0);
    }
    public void menuLibros() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\nSubmenu: Libros");
        System.out.println("\t\t\t1. Dar De Alta Libro");
        System.out.println("\t\t\t2. Eliminar Un Libro");
        System.out.println("\t\t\t3. Modificar Un Libro");
        System.out.println("\t\t\t4. Listar Libros");
        System.out.println("\n\n\t\t\t0. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                altaLibro();
                break;
            case 2:
                borrarLibro();
                break;
            case 3:
                modificarLibro();
                break;
            case 4:
                listadoLibro();
                break;
            case 0:
                System.out.println("\n\nVolviendo al menu principal...\n");
                break;
            default:
                System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
        }
    } while (opcion != 0);
}
    public void menuUsuarios() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\nSubmenu: Usuarios");
        System.out.println("\t\t\t1. Alta Usuarios");
        System.out.println("\t\t\t2. Borrar Usuario ");
        System.out.println("\t\t\t3. Modificar Usuario ");
        System.out.println("\t\t\t4. Listado Usuarios");
        System.out.println("\n\n\t\t\t0. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        opcion = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        switch (opcion) {
            case 1:
                altaUsuario();
                break;
            case 2:
                borrarUsuario();
                break;
            case 3:
                modificarUsuario();
                break;
            case 4:
                listadoUsuarios();
                break;
            case 0:
                System.out.println("\n\nVolviendo al menu anterior...\n");
                break;
            default:
                System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
        }
    } while (opcion != 0);
}
    public void menuPrestamos() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\nSubmenu: Prestamos");
        System.out.println("\t\t\t1. Nuevo Prestamo");
        System.out.println("\t\t\t2. Borrar Un Prestamo");
        System.out.println("\t\t\t3. Modficar Un Prestamo");
        System.out.println("\t\t\t4. Listar Un Prestamo");
        System.out.println("\n\n\t\t\t0. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        opcion = sc.nextInt();
        sc.nextLine(); 

        switch (opcion) {
            case 1:
                nuevoPrestamo();
                break;
            case 2:
                devolverPrestamo();
                break;
            case 3:
                modificarPrestamo();
                break;
            case 4:
                listarPrestamos();
                break;
            case 0:
                System.out.println("\n\nVolviendo al menu principal...\n");
                break;
            default:
                System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
        }
    } while (opcion != 0);
    
    
     
}
    public void menuFiltros() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSubmenu: Filtros");
            System.out.println("\t\t\t1. Prestamos por libro");
            System.out.println("\t\t\t2. Libros Tendencia");
            System.out.println("\t\t\t3. Modficar Un Prestamo");
            System.out.println("\t\t\t4. Listar Un Prestamo");
            System.out.println("\n\n\t\t\t0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    numeroPrestamos();
                    break;
                case 2:
                    mayorFiltroPrestamos();
                    break;
                case 3:
                    modificarPrestamo();
                    break;
                case 4:
                    listarPrestamos();
                    break;
                case 0:
                    System.out.println("\n\nVolviendo al menu principal...\n");
                    break;
                default:
                    System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
            }
        } while (opcion != 0);
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
    private void altaLibro() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nuevo Libro:");
        System.out.println("Isbn: ");
        String isbn=sc.nextLine();
        System.out.println("Titulo: ");
        String titulo=sc.nextLine();
        System.out.println("Autor: ");
        String autor=sc.nextLine();
        if (autor.isEmpty()){
            autor=null;
        }
        System.out.println("Genero: ");
        String genero=sc.nextLine();
        System.out.println("Numero Ejemplares: ");
        int ejemplares=sc.nextInt();
        Libro l=new Libro(isbn,titulo,autor,genero,ejemplares);
        libros.add(l);    
    }

    private void borrarLibro() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el isbn del libro que deseas eliminar");
        String isbn = sc.nextLine();
        int pos = buscaLibro(isbn);
        if(pos==-1){
            System.out.println("El libro que deseas eliminar no se encuentra en la biblioteca");
        } else {
            int n = libros.get(pos).getEjemplares();
            // creo un if para este metodo en caso de que llegue a 0 se quiera borrar toda la informacion sobre el libro
            if (n > 0 ) {
                n--;
                libros.get(pos).setEjemplares(n);
                System.out.println("Te quedan "+n+" ejemplares de "+isbn);
            } 
        }
    }
    

    private void modificarLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listadoLibro() {
        int n = 0;
        for (Libro l : libros) {
            System.out.println(n+" . "+l);
            n++;
        }
    }  
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="GESTION USUARIOS">
    private void altaUsuario() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nuevo Usuario:");
        System.out.println("DNI: ");
        String dni=sc.nextLine();
        System.out.println("Nombre: ");
        String nombre=sc.nextLine();
        System.out.println("email: ");
        String email=sc.nextLine();
        if (email.isEmpty()){
            email=null;
        }
        System.out.println("telefono: ");
        String telefono=sc.nextLine();
        Usuario u=new Usuario(dni,nombre,email,telefono);
        usuarios.add(u); 
    }
    private void borrarUsuario() {
        int posNombre = buscaDni(solicitaDni());
        if(posNombre==-1){
            System.out.println("El usuario que deseas dar de baja no esta registrado en la agenda");
        } else {
            usuarios.remove(posNombre);
            System.out.println("El usuario "+usuarios.get(posNombre).getNombre()+ " ha sido dado de baja con exito");
        }
    }
    
    private void modificarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void listadoUsuarios() {
        System.out.println();
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="GESTION PRESTAMOS">
    private void nuevoPrestamo() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nuevo Prestamo:");
        int posNombre = buscaDni(solicitaDni());
        int posLibro = buscaLibro(solicitaIsbn());
        if (posLibro == -1){
            System.out.println("No se encuentra el libro indicado");
        } else if (libros.get(posLibro).getEjemplares()> 0) {
            LocalDate hoy = LocalDate.now();
            Prestamo p=new Prestamo(libros.get(posLibro),usuarios.get(posNombre),hoy,hoy.plusDays(15));
            prestamos.add(p);
            libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);              
        } else {
            System.out.println("Ya no quedan ejemplares de este libro actualmente");
        }
    }
    
    private void devolverPrestamo() {
        Scanner sc=new Scanner(System.in);
        String dni = solicitaDni();
        if (dni == null) {
            return;
        }
        String isbn = solicitaIsbn();
        
        Prestamo prestamoADevolver = null;
        
        for (Prestamo prestamo : prestamos) {
        if (prestamo.getUsuarioPrest().getDni().equals(dni) && 
            prestamo.getLibroPrest().getIsbn().equals(isbn)) {  // Asumimos que un préstamo sin fecha de devolución está activo
            prestamoADevolver = prestamo;
            break;
            } 
        } 
        
        
        // Actualizamos la fecha del prestamo.
        prestamoADevolver.setFechaDev(LocalDate.now());
        
        Libro libro = prestamoADevolver.getLibroPrest();
        libro.setEjemplares(libro.getEjemplares()+1);
        
        System.out.println("Se ha devuelto el libro con exito.\nTitulo: "+libro.getTitulo()+".\nFecha de devolucion: "+prestamoADevolver.getFechaDev());
          
    }
    
        
    
      
    private void modificarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    private void listarPrestamos() {
        System.out.println();
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }    
    }    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
private void cargaDatos() {
        //random
        Random rand = new Random();
        
        
        // Libros
        libros.add(new Libro("1-01", "El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía", 5));
        libros.add(new Libro("1-02", "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 3));
        libros.add(new Libro("1-03", "1984", "George Orwell", "Ciencia ficción", 2));
        libros.add(new Libro("1-04", "La piedra filosofal", "J.K.Rowling", "Fantasía", 2));
        libros.add(new Libro("1-05", "Como salir del armario", "LGBTQI+", "Fantasías sexuales", 5));
        libros.add(new Libro("1-06", "Las claves del amor", "Arturito", "Psicologia Amorosa", 5));
        libros.add(new Libro("1-07", "Don Quijote de la Mancha", "Miguel de Cervantes", "Clásico", 4));
        libros.add(new Libro("1-08", "Crimen y castigo", "Fiódor Dostoievski", "Novela psicológica", 3));
        libros.add(new Libro("1-09", "Orgullo y prejuicio", "Jane Austen", "Romance", 4));
        libros.add(new Libro("1-10", "El principito", "Antoine de Saint-Exupéry", "Fábula", 6));
        libros.add(new Libro("1-11", "Rayuela", "Julio Cortázar", "Novela experimental", 2));
        libros.add(new Libro("1-12", "El código Da Vinci", "Dan Brown", "Thriller", 5));
        libros.add(new Libro("1-13", "Crónica de una muerte anunciada", "Gabriel García Márquez", "Novela", 3));
        libros.add(new Libro("1-14", "El nombre del viento", "Patrick Rothfuss", "Fantasía épica", 4));
        libros.add(new Libro("1-15", "La sombra del viento", "Carlos Ruiz Zafón", "Misterio", 3));
        libros.add(new Libro("1-16", "Memorias de una geisha", "Arthur Golden", "Novela histórica", 2));
        libros.add(new Libro("1-17", "El alquimista", "Paulo Coelho", "Ficción filosófica", 5));
        libros.add(new Libro("1-18", "Los juegos del hambre", "Suzanne Collins", "Distopía", 4));
        libros.add(new Libro("1-19", "El perfume", "Patrick Süskind", "Novela histórica", 2));
        libros.add(new Libro("1-20", "Crónicas marcianas", "Ray Bradbury", "Ciencia ficción", 3));
        

        // Usuarios
        usuarios.add(new Usuario("11111111A", "Joseiro", "joseiro@email.com", "123456789"));
        usuarios.add(new Usuario("22222222B", "Orcrema", "orcrema@email.com", "987654321"));
        usuarios.add(new Usuario("33333333C", "Lisboa", "lisboa@email.com", "456789123"));
        usuarios.add(new Usuario("44444444D", "Roces", "roces@email.com", "321987654"));
        usuarios.add(new Usuario("55555555E", "Pacheco", "pacheco@email.com", "6891111111"));
        usuarios.add(new Usuario("66666666F", "Carmen", "carmen@email.com", "611222222"));
        usuarios.add(new Usuario("77777777G", "Roberto", "roberto@email.com", "622333333"));
        usuarios.add(new Usuario("88888888H", "Elena", "elena@email.com", "633444444"));
        usuarios.add(new Usuario("99999999I", "Miguel", "miguel@email.com", "644555555"));
        usuarios.add(new Usuario("10101010J", "Laura", "laura@email.com", "655666666"));
        usuarios.add(new Usuario("12121212K", "Pablo", "pablo@email.com", "666777777"));
        usuarios.add(new Usuario("13131313L", "Sofía", "sofia@email.com", "677888888"));
        usuarios.add(new Usuario("14141414M", "Javier", "javier@email.com", "688999999"));
        usuarios.add(new Usuario("15151515N", "Ana", "ana@email.com", "699000000"));
        usuarios.add(new Usuario("16161616O", "Diego", "diego@email.com", "600111111"));

        
        //prestamos
        LocalDate hoy = LocalDate.now();
        prestamos.add(new Prestamo(libros.get(3),usuarios.get(4),hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(4),usuarios.get(0),hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(1),hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(2),hoy,hoy.plusDays(15)));   
        
        for (int i = 0; i < 21; i++) { // 21 para llegar a un total de 25 préstamos
        Libro libroAleatorio = libros.get(rand.nextInt(libros.size()));
        Usuario usuarioAleatorio = usuarios.get(rand.nextInt(usuarios.size()));
        LocalDate fechaPrestamo = hoy.minusDays(rand.nextInt(30));
        LocalDate fechaDevolucion = fechaPrestamo.plusDays(15);
        
        prestamos.add(new Prestamo(libroAleatorio, usuarioAleatorio, fechaPrestamo, fechaDevolucion));
    }
    }    
    public int buscaDni (String dni){
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getDni().equalsIgnoreCase(dni)){
                pos = i;
                break;                
            }            
        }
        return pos;
    }
    public int buscaDniPrest (String dni){
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++) {
            if(prestamos.get(i).getUsuarioPrest(). getDni().equalsIgnoreCase(dni)){    
                pos = i;
                break;                
            }            
        }
        return pos;
    }
    public int buscaLibro (String isbn){
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getIsbn().equalsIgnoreCase(isbn)){
                pos = i;
                break;                
            }            
        }
        return pos;
    }
    public int buscaLibroPrest (String isbn){
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if(prestamos.get(i).getLibroPrest().getIsbn().equalsIgnoreCase(isbn)){
                pos = i;
                break;                
            }            
        }
        return pos;
    }
    private void usuarioNoEncontrado() {
    Scanner sc = new Scanner(System.in);
    String opcion;

    System.out.println("El usuario introducido no está registrado en el programa.");
    do {
        System.out.println("¿Desea crearse una cuenta en nuestro programa? (SI/NO)");
        opcion = sc.nextLine().toUpperCase();

        switch (opcion) {
            case "SI":
                altaUsuario();
                return; // Salimos del método después de registrar al usuario
            case "NO":
                System.out.println("No se realizará ninguna acción.");
                estatus = false;
                return; // Salimos del método sin hacer nada
            default:
                System.out.println("Por favor, introduzca una opción válida (SI/NO).");
        }
    } while (true); // Sigue pidiendo una opción válida hasta que sea "SI" o "NO"
}
    public String solicitaDni(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el Dni del usuario:");
        String dni=sc.nextLine();
        int posU = buscaDni(dni);
        if (posU == -1){
            usuarioNoEncontrado();
            return null;
        } 
        return dni;
    }
    public String solicitaIsbn(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el Isbn del libro:");
        String isbn=sc.nextLine();
        int posL = buscaLibro(isbn);
        if (posL == -1){
            System.out.println("El isbn no corresponde a ningun libro...");
            isbn = "not found";
        } 
        return isbn;
    }
    public Map<Libro, Integer> contarLibros(){
        Map<Libro, Integer> prestamosPorLibro = new HashMap<>();

        for (Prestamo prestamo : prestamos) {
            Libro libro = prestamo.getLibroPrest();
            prestamosPorLibro.put(libro, prestamosPorLibro.getOrDefault(libro, 0) + 1);
        }
        return prestamosPorLibro;
    }
//</editor-fold>

    
//<editor-fold defaultstate="collapsed" desc="Filtros">
    public void numeroPrestamos(){
        Map<Libro, Integer> prestamosPorLibro = contarLibros();
        System.out.println("Número de préstamos por libro:");
        for (Map.Entry<Libro, Integer> entry : prestamosPorLibro.entrySet()) {
            Libro libro = entry.getKey();
            int numeroPrestamos = entry.getValue();
            if (numeroPrestamos > 0){
                System.out.println(libro.getTitulo() + " - ISBN: " + libro.getIsbn() + ": " + numeroPrestamos + " préstamo(s)");
            }
        }
    }
    public void mayorFiltroPrestamos() {
        Map<Libro, Integer> prestamosPorLibro = contarLibros();

        // Convertir el Map a una lista de entradas
        List<Map.Entry<Libro, Integer>> listaOrdenada = new ArrayList<>(prestamosPorLibro.entrySet());

        // Ordenar la lista
        Collections.sort(listaOrdenada, new Comparator<Map.Entry<Libro, Integer>>() {
            @Override
            public int compare(Map.Entry<Libro, Integer> e1, Map.Entry<Libro, Integer> e2) {
                return e2.getValue().compareTo(e1.getValue()); // Orden descendente
            }
        });

        // Mostrar los resultados ordenados
        System.out.println("Número de préstamos por libro (ordenado de mayor a menor):");
        for (Map.Entry<Libro, Integer> entry : listaOrdenada) {
            Libro libro = entry.getKey();
            int numeroPrestamos = entry.getValue();
            System.out.println(numeroPrestamos + "prestamo(s): " + libro.getTitulo()+" "+ libro.getIsbn());
        }
    }            
//</editor-fold>   
}
