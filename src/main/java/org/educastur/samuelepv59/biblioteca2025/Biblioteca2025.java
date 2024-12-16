/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.educastur.samuelepv59.biblioteca2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *primer commit
 * @author alu19d
 */
public class Biblioteca2025 {
    
    private ArrayList<Libro>libros;
    private ArrayList<Usuario>usuarios;
    private ArrayList<Prestamo>prestamos;
    
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

    private void cargaDatos() {
        // Libros
        libros.add(new Libro("1-01", "El Señor de los Anillos", "J.R.R. Tolkien", "Fantasía", 5));
        libros.add(new Libro("1-02", "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico", 3));
        libros.add(new Libro("1-03", "1984", "George Orwell", "Ciencia ficción", 2));
        libros.add(new Libro("1-04", "La piedra filosofal", "J.K.Rowling", "Fantasía", 2));
        libros.add(new Libro("1-05", "Como salir del armario", "LGBTQI+", "Fantasías sexuales", 5));
        libros.add(new Libro("1-06", "Las claves del amor", "Arturito", "Psicologia Amorosa", 5));
        

        // Usuarios
        usuarios.add(new Usuario("11111111A", "Joseiro", "joseiro@email.com", "123456789"));
        usuarios.add(new Usuario("22222222B", "Orcrema", "orcrema@email.com", "987654321"));
        usuarios.add(new Usuario("33333333C", "Lisboa", "lisboa@email.com", "456789123"));
        usuarios.add(new Usuario("44444444D", "Roces", "roces@email.com", "321987654"));
        usuarios.add(new Usuario("47549911W", "Pacheco", "pacheco@email.com", "6891111111"));

        LocalDate hoy = LocalDate.now();
        prestamos.add(new Prestamo(libros.get(3),usuarios.get(4),hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(4),usuarios.get(0),hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(0),usuarios.get(1),hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(2),hoy,hoy.plusDays(15)));
        
        
       
    }

    private void menu() {
        Scanner sc=new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("\n AGENDA 2024"); 
            System.out.println("\t\t\t\t1 - Libros");
            System.out.println("\t\t\t\t2 - Usuarios");
            System.out.println("\t\t\t\t3 - Prestamos");
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
                borrarPrestamo();
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

    private void altaLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void borrarLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void modificarLibro() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listadoLibro() {
        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    private void altaUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void borrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    private void nuevoPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void borrarPrestamo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
 
}
