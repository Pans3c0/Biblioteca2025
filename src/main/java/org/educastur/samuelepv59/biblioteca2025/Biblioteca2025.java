/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.educastur.samuelepv59.biblioteca2025;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import org.educastur.samuelepv59.biblioteca2025.Excepciones;
import org.educastur.samuelepv59.biblioteca2025.Excepciones.LibroNoExiste;

/**
 *
 * @author alu19d
 */

public class Biblioteca2025 {
    
    
    private ArrayList<Libro>libros;
    private ArrayList<Usuario>usuarios;
    private ArrayList<Prestamo>prestamos;
    private ArrayList<Prestamo>prestamosHist;
    
    public SelfOut Comprobar = new SelfOut();
    public Examen Examen = new Examen();
    public Buscador Buscador = new Buscador();
    double multaDia = 1.50;
    
    
    public Biblioteca2025(){
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();
        
    }
    public static void main(String[] args) {
        Biblioteca2025 b = new Biblioteca2025();
        b.cargaDatos();
        b.Comprobar.checking();
        b.menu();
        
    }   

//<editor-fold defaultstate="collapsed" desc="MENUS">
    private void menu() {
        Scanner sc=new Scanner(System.in);
        int opcion;
        do{
            System.out.println("\n\t\t\t\t *AGENDA 2024*");
            System.out.println("\t\t\t\t1 - Gestion Usuarios");
            System.out.println("\t\t\t\t2 - Gestion Libros");
            System.out.println("\t\t\t\t3 - Gestion Prestamos/Devoluciones");
            System.out.println("\t\t\t\t4 - Prueba Examen");
            System.out.println("\n\n\t\t\t\t9 - SALIR\n\n");
            opcion=sc.nextInt();
            switch (opcion){
                case 0:
                System.out.println("Saliendo del programa...");
                break;
                case 1:{
                    menuUsuarios();
                    break;
                }
                case 2:{
                    menuLibros();
                    break;
                }
                case 3:{
                    menuPrestamos();
                    break;
                }
                case 4:{
                    menuExamen();
                    break;
                }
            }
            
        }while (opcion !=9);
    }
    public void menuLibros() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n\t\t\t*GESTION DE LIBROS*");
            System.out.println("\t\t\t1. Alta Nuevo Libro");
            System.out.println("\t\t\t2. Baja De Libro");
            System.out.println("\t\t\t3. Modificacion Ejemplares De Libro");
            System.out.println("\t\t\t4. Listar Libros Disponibles");
            System.out.println("\t\t\t5. Listar Libros ");
            System.out.println("\n\n\t\t\t9. Volver al menu principal");
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
                    librosActivos();
                    //Metodo listar libros disponibles con mas de 0 ejemplares.
                    break;
                case 5:
                    listadoLibro();
                    break;
                case 0:
                    System.out.println("\n\nVolviendo al menu principal...\n");
                    break;
                default:
                    System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
            }
        } while (opcion != 9);
}
    public void menuUsuarios() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\n\t\t\t*GESTION USUARIOS*");
        System.out.println("\t\t\t1. Alta Nuevo Usuario/a");
        System.out.println("\t\t\t2. Baja Usuario/a ");
        System.out.println("\t\t\t3. Listado Usuarios/as ");
        System.out.println("\t\t\t4. Modificar Usuario/a");
        System.out.println("\n\n\t\t\t9. Volver al menu principal");
        System.out.print("Seleccione una opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();
// ZONA DE PRUEBAS
        switch (opcion) {
            case 1:
                altaUsuario();
                break;
            case 2:
                borrarUsuario();
                break;
            case 3:
                listadoUsuarios();
                break;
            case 4:
                modificarUsuario();
                break;
            case 0:
                System.out.println("\n\nVolviendo al menu anterior...\n");
                break;
            default:
                System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
        }
    } while (opcion != 9);
}
    public void menuPrestamos() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("\n\t\t\t*GESTION PRESTAMOS*");
        System.out.println("\t\t\t1. Prestamos");
        System.out.println("\t\t\t2. Devoluciones");
        System.out.println("\t\t\t3. Prorrogas");
        System.out.println("\t\t\t4. Gestion De Listados");
        System.out.println("\n\n\t\t\t9. Volver al menu principal");
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
                prorrogarPrestamo();
                break;
            case 4:
                menuExtras();
                break;
            case 5:
                listarPrestamosActivos();
                break;
            case 6:
                // Crear metodo o usarlo que muestre todos los prestamos de las dos listas.
                break;
            case 0:
                System.out.println("\n\nVolviendo al menu principal...\n");
                break;
            default:
                System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
        }
    } while (opcion != 9);
    
    
     
}
    public void menuExtras() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n\t\t\t*GESTION DE LISTADOS*");
            System.out.println("\t\t\t1. Prestamos Activos De Un Usuario");
            System.out.println("\t\t\t2. Prestamos Activos De Un Libro");
            System.out.println("\t\t\t3. El Mas Buscado");
            System.out.println("\t\t\t4. El Mas Buscador");
            System.out.println("\t\t\t5. Listar Prestamos Activos");
            System.out.println("\t\t\t6. Listar Todos Activos");
            System.out.println("\n\n\t\t\t9. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    prestamosActivos();
                    break;
                case 2:
                    librosActivos();
                    break;
                case 3:
                    libroMasPrestado();
                    break;
                case 4:
                    usuarioMasActivo();
                    break;
                case 5:
                    prestamosActivos();
                case 0:
                    System.out.println("\n\nVolviendo al menu principal...\n");
                    break;
                default:
                    System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
            }
        } while (opcion != 9);
        
    }

    public void menuExamen(){
        Scanner sc=new Scanner (System.in);
        int opcion=0;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tBIBLIOTECA\n");
            System.out.println("\t\t\t\t1 - EXAMEN1");
            System.out.println("\t\t\t\t2 - EXAMEN2");
            System.out.println("\t\t\t\t3 - EXAMEN3");
            System.out.println("\t\t\t\t4 - EXAMEN4");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:{
                    Examen.ejercicio1();
                    break;
                }
                case 2:{
                    Examen.ejercicio2();
                    break;
                }
                case 3:{
                    Examen.ejercicio3();
                    break;
                }
                case 4:{
                    Examen.ejercicio4();
                    break;
                }
            }
        }while (opcion != 9);
    }

//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
    private void altaLibro() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Nuevo Libro:");
        System.out.println("Isbn: ");
        String isbn=sc.nextLine();
        try {
            Buscador.isbn(isbn);
            System.out.println("El libro que deseas añadir ya existe. Modifica su numero de ejemplares.\n"+Buscador.isbn(isbn).getIsbn());
            modificarLibro();
            sc.close();
            return;
        } catch (LibroNoExiste e){
            System.out.println("Titulo: ");
            String titulo=sc.nextLine();
            System.out.println("Autor: (OPCIONAL) ");
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
       
           
    }
    private void borrarLibro() {
        Scanner sc = new Scanner(System.in);
        Libro libroEncontrado = Buscador.libro();
        if (libroEncontrado == null) {
            return;
        }
        ArrayList<Prestamo> prestamosEncontrado = Buscador.prestamosActivos(libroEncontrado);
        if (prestamosEncontrado != null) {
            System.out.println("Hay prestamos activos actualmente. Desea eliminar de todas formas el libro?(SI/NO):");
            do {
                String opcion = sc.nextLine().toUpperCase();
                switch (opcion) {
                    case "SI":
                        break;
                    case "NO":
                        System.out.println("No se realizará ninguna acción.");
                        return;
                    default:
                        System.out.println("Por favor, introduzca una opción válida (SI/NO).");
                }
            } while (true);
        }
        libros.remove(libroEncontrado);
        System.out.println("Libro eliminado con exito");
    }
    private void modificarLibro() {
        Scanner sc=new Scanner(System.in);
        Libro libroEncontrado = Buscador.libro();
        if (libroEncontrado == null){
            return;
        }
        System.out.println("Introduce la cantidad de ejemplares que deseas añadir (+) o quitar (-) : ");
        String modificacion = sc.nextLine();// Extraer el número como texto
        int numero = Integer.parseInt(modificacion.substring(1));
        if (modificacion.charAt(0) == '+' ) {
            libroEncontrado.setEjemplares(libroEncontrado.getEjemplares()+numero);
        }
        if(modificacion.charAt(0) == '-'){
            if (libroEncontrado.getEjemplares()-numero<0){
                System.out.println("No puedes borrar mas libros de los que tienes");
                return;
            }
            libroEncontrado.setEjemplares(libroEncontrado.getEjemplares()-numero);
        }
        System.out.println("Ahora "+libroEncontrado.getTitulo()+" tiene "+libroEncontrado.getEjemplares()+" ejemplares");
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
        if (Buscador.dni(dni) != null){
            System.out.println("El usuario ya se encuentra registrado.");
            return;
        }
        System.out.println("Nombre: ");
        String nombre=sc.nextLine();
        System.out.println("email (OPCIONAL): ");
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
        Usuario usuarioEncontrado = Buscador.usuario();
        if(usuarioEncontrado==null){
            System.out.println("El usuario que deseas dar de baja no esta registrado en la agenda");
            return;
        }
        ArrayList<Prestamo> prestamos1 = Buscador.deudas(usuarioEncontrado);
        if (prestamos1 != null){
            System.out.println("El usuario debe devolver y pagar una multa por :\n");
            for (Prestamo prestamo : prestamos1){
                System.out.println(prestamo);
            }
            return;
        }
        usuarios.remove(usuarioEncontrado);
        System.out.println("El usuario "+usuarioEncontrado.getNombre()+ " ha sido dado de baja con exito");
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
        System.out.println("Nuevo Prestamo:");
        Usuario usuarioEncontrado = Buscador.usuario();
        if(usuarioEncontrado== null){
            return;
        }
        ArrayList<Prestamo>prestamosActivosUsuario = Buscador.prestamosActivos(usuarioEncontrado);
        if (prestamosActivosUsuario != null) {
            System.out.println("El usuario tiene prestamos activos. Operacion cancelada");
            return;
        }
        Libro libroEncontrado = Comprobar.libroDisponibilidad(Buscador.libro());
        if (libroEncontrado == null){
            System.out.println("Actualmente no se encuentra este libro disponible.");
            return;
        }
        if(Buscador.prestamosActivos(usuarioEncontrado)==Buscador.prestamosActivos(libroEncontrado)){
            System.out.println("Ya hay un prestamo activo con este usario y este libro.");
            return;
        }
        //Añadimos el prestamo en la lista prestamos y pasa a estar activo.
        LocalDate hoy = LocalDate.now();
        Prestamo p=new Prestamo(libroEncontrado,usuarioEncontrado,hoy,hoy.plusDays(15));
        prestamos.add(p);
        // Restamos un ejemplar del objeto Libro.
        libroEncontrado.setEjemplares(libroEncontrado.getEjemplares()-1);
        System.out.println("La operacion se ha realizado con exito.\nEl usuario: "+usuarioEncontrado.getNombre()+"\nEl libro: "+libroEncontrado.getTitulo()+"\nActualmente quedan "+libroEncontrado.getEjemplares()+" ejemplares.");
        }

    private void devolverPrestamo() {

        ArrayList<Prestamo> prestamosUsuarios = Buscador.prestamosActivos(Buscador.usuario());
        if (prestamosUsuarios.isEmpty()){
            System.out.println("El usuario no tienen ningun prestamo activo.");
            return;
        }
        if (Buscador.deudas(prestamosUsuarios.getFirst().getUsuarioPrest()).isEmpty()){
            System.out.println("El usuario tiene una deuda pendiente.");
        }
        Libro libroEncontrado = Buscador.libro();
        if (Buscador.deuda(prestamosUsuarios.getFirst().getUsuarioPrest(),libroEncontrado)!=null){
            System.out.println("Hay una multa pendiente con este libro.");
            return;
        }
        for (Prestamo prestamo : prestamosUsuarios){
            if (prestamo.getLibroPrest().equals(libroEncontrado)){
                // Desplazamos al objeto de una Array a otro
                prestamosHist.add(prestamo);
                prestamos.remove(prestamo);
                prestamo.setFechaDev(LocalDate.now());
                //Aumentamos el numero de ejemplares
                libroEncontrado.setEjemplares(libroEncontrado.getEjemplares()+1);
                System.out.println("Se ha devuelto el libro con exito.\nTitulo: "+prestamo.getLibroPrest().getTitulo()+".\nFecha de devolucion: "+prestamo.getFechaDev()+"\nEjemplares: "+prestamo.getLibroPrest().getEjemplares());
            }
        }
    }
    private void prorrogarPrestamo() {
        Scanner sc=new Scanner(System.in);
        ArrayList <Prestamo> prestamos1 = Buscador.prestamosActivos(Buscador.libro());
        if(prestamos1 ==null){
            System.out.println("No se encuentran prestamos activos asociados a dicho isbn");
            sc.close();
            return;
            
        }
        Usuario usuarioEncontrado = Buscador.usuario();
        System.out.println("Introduce la cantidad de dias que quieres prorrogar el prestamo:");
        int diasDevolucion = sc.nextInt();
        for(Prestamo prestamo : prestamos1){
            if(prestamo.getUsuarioPrest().equals(usuarioEncontrado)){
                prestamo.setFechaDev(LocalDate.now().plusDays(diasDevolucion));
                prestamo.setFechaPrest(LocalDate.now());
                System.out.println("\nEl libro: "+prestamo.getLibroPrest().getTitulo()+".\nNueva fecha de devolucion: "+prestamo.getFechaPrest());
            }

        }
        System.out.println("A nombre de; "+usuarioEncontrado.getNombre());
        sc.close();
    }
    private void listarPrestamosActivos(){
        System.out.println("Prestamos Activos:");
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
    private void listarPrestamosHistorial() {
        System.out.println("Historial de prestamos:");
        for(Prestamo p : prestamosHist){
            System.out.println(p);
        }
    }    
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
public void cargaDatos(){

    libros.add(new Libro("1-00","El Hobbit","JRR Tolkien","Aventuras",3));
    libros.add(new Libro("1-11","El Silmarillon","JRR Tolkien","Aventuras",3));
    libros.add(new Libro("1-22","El Medico","N. Gordon","Aventuras",4));
    libros.add(new Libro("1-33","Chaman","N. Gordon","Aventuras",3));
    libros.add(new Libro("1-44","Momo","M. Ende","Aventuras",2));
    libros.add(new Libro("1-55","Paraiso inhabitado","A.M.Matute","Aventuras",2));
    libros.add(new Libro("1-66","Olvidado Rey Gudu","A.M.Matute","Aventuras",2));
    libros.add(new Libro("1-77","El ultimo barco","D.Villar","Novela Negra",3));
    libros.add(new Libro("1-88","Ojos de agua","D.Villar","Novela Negra",9));

    usuarios.add(new Usuario("00","Ana","ana@email.com","621111111"));
    usuarios.add(new Usuario("11","David","david@email.com","622222222"));
    usuarios.add(new Usuario("22","Bea","bea@email.com","623333333"));
    usuarios.add(new Usuario("33","Lucas","lucas@email.com","624444444"));
    usuarios.add(new Usuario("44","Carlota","carlota@email.com","625555555"));
    usuarios.add(new Usuario("55","Juan","juan@email.com","626666666"));

    LocalDate hoy= LocalDate.now();
    prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
    prestamos.add(new Prestamo(libros.get(0),usuarios.get(0), hoy,hoy.plusDays(15)));
    prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
    prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy.minusDays(20),hoy.minusDays(5)));
    prestamos.add(new Prestamo(libros.get(1),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
    prestamos.add(new Prestamo(libros.get(2),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
    prestamos.add(new Prestamo(libros.get(3),usuarios.get(4), hoy.minusDays(20),hoy.minusDays(5)));
    prestamos.add(new Prestamo(libros.get(1),usuarios.get(4), hoy,hoy.plusDays(15)));
    prestamos.add(new Prestamo(libros.get(8),usuarios.get(1), hoy,hoy.plusDays(15)));

    prestamosHist.add(new Prestamo(libros.get(0),usuarios.get(0),LocalDate.parse("2023-01-01"),LocalDate.parse("2023-01-20")));//OUT
    prestamosHist.add(new Prestamo(libros.get(2),usuarios.get(0),LocalDate.parse("2023-02-02"),LocalDate.parse("2023-02-11")));
    prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(4),LocalDate.parse("2023-10-10"),LocalDate.parse("2023-10-20")));
    prestamosHist.add(new Prestamo(libros.get(5),usuarios.get(4),LocalDate.parse("2023-11-11"),LocalDate.parse("2023-11-30")));//OUT
    prestamosHist.add(new Prestamo(libros.get(1),usuarios.get(1),LocalDate.parse("2023-12-12"),LocalDate.parse("2023-12-28")));//OUT
    prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(2),LocalDate.parse("2024-08-08"),LocalDate.parse("2024-08-18")));
    prestamosHist.add(new Prestamo(libros.get(6),usuarios.get(3),LocalDate.parse("2024-09-09"),LocalDate.parse("2024-09-19")));
    prestamosHist.add(new Prestamo(libros.get(0),usuarios.get(0),LocalDate.parse("2024-10-10"),LocalDate.parse("2024-10-30")));//OUT
    prestamosHist.add(new Prestamo(libros.get(2),usuarios.get(0),LocalDate.parse("2024-11-11"),LocalDate.parse("2024-11-21")));
    prestamosHist.add(new Prestamo(libros.get(7),usuarios.get(4),LocalDate.parse("2024-12-12"),LocalDate.parse("2024-12-28")));//OUT
    prestamosHist.add(new Prestamo(libros.get(5),usuarios.get(4),LocalDate.parse("2025-01-01"),LocalDate.parse("2025-01-11")));
    prestamosHist.add(new Prestamo(libros.get(1),usuarios.get(1),LocalDate.parse("2025-01-01"),LocalDate.parse("2025-01-15")));
}


/**
 * Da la opcion de crear un usuario al no ser encontrado
 * 
 */
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
                return;
            case "NO":
                System.out.println("No se realizará ninguna acción.");
                return;
            default:
                System.out.println("Por favor, introduzca una opción válida (SI/NO).");
        }
    } while (true); // Sigue pidiendo una opción válida hasta que sea "SI" o "NO"
}
/**
 * Da la opcion de crear un usuario al no ser encontrado
 * 
 */
    private void isbnNoEncontrado() {
    Scanner sc = new Scanner(System.in);
    String opcion;

    System.out.println("El isbn introducido no está registrado en el programa.");
    do {
        System.out.println("¿Desea registrar el libro en nuestro programa? (SI/NO)");
        opcion = sc.nextLine().toUpperCase();

        switch (opcion) {
            case "SI":
                altaLibro();
                return; // Salimos del método después de registrar al usuario
            case "NO":
                System.out.println("No se realizará ninguna acción.");
                return; // Salimos del método sin hacer nada
            default:
                System.out.println("Por favor, introduzca una opción válida (SI/NO).");
        }
    } while (true); // Sigue pidiendo una opción válida hasta que sea "SI" o "NO"
}


//</editor-fold>
    public class SelfOut {
    /**
     * Comprueba si esta dispomible
     * Si no lo esta no devuelve ningun libro.
     * @param libroEncontrado
     * @return Libro
     */
    public Libro compruebaLibroDisponible (Libro libroEncontrado){
        if (libroEncontrado.getEjemplares()-1 >=0) return libroEncontrado;
        return null;
    }
    public void checking(){
        System.out.println("Prestamos de morosos son:");
        ArrayList<Prestamo>prestamosMorosos = Comprobar.muestraDeudas(prestamos);
        for (Prestamo prestamo : prestamosMorosos) {
            System.out.println(prestamo);
        }
        System.out.println("Prestamos activos son:");
        ArrayList <Prestamo> prestamosSinDeuda = Comprobar.quitaDeudas(prestamos);
        for (Prestamo prestamo : prestamosSinDeuda) System.out.println(prestamo);
        if (prestamosMorosos.isEmpty()&&prestamosSinDeuda.isEmpty()) System.out.println("No se han encontrado ningun prestamo activo.");
    }
    /**
     * Comprobamos que fechaDev es inferior a LocalDate.now y calculamos basándonos en la tarifa el precio de la multa
     * @param prestamoEncontrado Prestamo del que queremos hacer una consulta
     * @return precio total de la multa
     */
    public Double precioMulta (Prestamo prestamoEncontrado){
        if (prestamoEncontrado.getFechaDev().isBefore(LocalDate.now())){
            long diasTotal = ChronoUnit.DAYS.between(prestamoEncontrado.getFechaDev(), LocalDate.now());

            int dias = (int) diasTotal;

            return dias*multaDia; //Precio de la multa
        } else {
            return null;
        }
    }
    public Libro libroDisponibilidad (Libro libroEncontrado){
        if (libroEncontrado.getEjemplares()-1 >=0) return libroEncontrado;
        return null;
    }
    public ArrayList<Prestamo> muestraDeudas(ArrayList<Prestamo>prestamos){
        ArrayList<Prestamo>prestamos1 =  new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if(prestamo.getFechaDev().isBefore(LocalDate.now())) {
                prestamos1.add(prestamo);
            }
        }
        return prestamos1;
    }
    public ArrayList<Prestamo> quitaDeudas(ArrayList<Prestamo>prestamos){
        ArrayList<Prestamo>prestamos1 =  new ArrayList<>();
        for (Prestamo prestamo : prestamos) {
            if(prestamo.getFechaDev().isAfter(LocalDate.now().minusDays(1))) {
                prestamos1.add(prestamo);
            }
        }
        return prestamos1;
    }

}
//<editor-fold defaultstate="collapsed" desc="Extras">
/**
* Nos muestra todos los prestamos que estan a nombre de un usuario que le demos
*/
public void prestamosActivos() {

}
/**
public void prestamosActivos() {
        Usuario usuarioEncontrado = Buscador.usuario();
        if (usuarioEncontrado == null) return;
        ArrayList<Prestamo> prestamos1 = Buscador.prestamosActivos(usuarioEncontrado);
        if (prestamos1.isEmpty()){
            System.out.printf("No se ha encontrado prestamos activos para " + usuarioEncontrado.getNombre() + " actualmente.");
        return;
         }
        for (Prestamo prestamo : prestamos1) {
            System.out.println(prestamo);
        }
    }
*/
/**
 * Nos muestra los prestamos activos que coinciden con un isbn
 * Devuelve Isbm para buscar el libro
 */
    public void librosActivos(){

        ArrayList<Libro>librosDisponibles = new ArrayList<>();

        for (Libro l:libros){
            if(Comprobar.compruebaLibroDisponible(l)!=null){
                librosDisponibles.add(l);
            }
        }
        if (librosDisponibles.isEmpty()){
            System.out.println("No se han encontrado prestamos disponibles.");
            return;
        }
        System.out.println("Los libros disponibles son:");
        for (Libro l : librosDisponibles){
            System.out.println(l);
        }
    }
/**
 * Nos muestra de las dos listas el libro mas prestado
 */
    public void libroMasPrestado() {
    if (prestamos.isEmpty()) {
        System.out.println("No hay préstamos registrados.");
        return;
    }

    // Variables para almacenar el libro más prestado y el número máximo de préstamos
    Libro libroMasPrestado = null;
    int maxPrestamos = 0;

    for (Libro libro : libros) { // Recorrer la lista de libros
        int contador = 0;

        // Contar cuántos préstamos hay para este libro
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getLibroPrest().equals(libro)) {
                contador++;
            }
        }
        for (Prestamo prestamo : prestamosHist) {
            if (prestamo.getLibroPrest().equals(libro)) {
                contador++;
            }
        }

        // Verificar si este libro tiene más préstamos que el actual máximo
        if (contador > maxPrestamos) {
            maxPrestamos = contador;
            libroMasPrestado = libro;
        }
    }

    // Mostrar el resultado
        if (libroMasPrestado == null) {
        System.out.println("No se pudo determinar el libro más prestado.");
        return;
    }
        System.out.println("El libro mas prestado fue:\n"+libroMasPrestado+"\nQue se presto: "+maxPrestamos);
}
/**
 * Nos muestra de las dos listas el usuario mas activo
 */
    public void usuarioMasActivo() {
    if (prestamos.isEmpty()) {
        System.out.println("No hay usuario registrados.");
        return;
    }
    

    // Variables para almacenar el libro más prestado y el número máximo de préstamos
    Usuario usuarioMasActivo = null;
    int maxPrestamos = 0;

    for (Usuario usuario : usuarios) { // Recorrer la lista de usuarios
        int contador = 0;

        // Contar cuántos prestamos ha realizado este usuario
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuarioPrest().equals(usuario)) {
                contador++;
            }
        }
        for (Prestamo prestamo : prestamosHist) {
            if (prestamo.getUsuarioPrest().equals(usuario)) {
                contador++;
            }
        }

        // Verificar si este usuario tiene más préstamos que el actual máximo
        if (contador > maxPrestamos) {
            maxPrestamos = contador;
            usuarioMasActivo = usuario;
        }
    }

    // Mostrar el resultado
    if (usuarioMasActivo == null) {
        System.out.println("No se pudo determinar el usuario mas activo.");
        return;
    }
        System.out.println("El usuario más activo es: " + usuarioMasActivo+".\nVeces que ha cogido un libro: " + maxPrestamos);
}





//</editor-fold>

    public class Buscador {

        /**
         * Buscamos en el ArrayList el objeto libre que coincide con el isbn solicitado
          * @return Libro encontrado
         * default null no se ha encontrado libro
         */
       public Libro libro() throws LibroNoDisponible{
            Scanner sc=new Scanner(System.in);
            System.out.println("Introduce el Isbn del libro:");
            try {
                Libro libroEncontrado = isbn(sc.nextLine());
            }catch (LibroNoExiste e){
                System.out.println(e.getMessage());
            }
            
            sc.close();
            if (libroEncontrado == null){
                String cadena = "El libro no se encuentra en la biblioteca con referencia ";
                throw new Excepciones.LibroNoExiste (cadena);
            }
            else if (libroEncontrado.getEjemplares() <= 0){
                String cadena="No hay unidades del libro " + libroEncontrado.getTitulo() +
                    " disponibles actualmente" 
                    + "\nFechas de devolución previstas: ";
                ArrayList <Prestamo> prestamosEncontrados = Buscador.prestamosActivos(libroEncontrado);
                for (Prestamo p : prestamosEncontrados) {
                    System.out.println(p.getFechaDev());
                }
                throw new Excepciones.LibroNoDisponible(cadena); 
            } else return libroEncontrado;
            
            
        }
        /**
         * Busca en la lista de libros equivalente al isbn
         * @param isbn del libro
         * @return libro encontrado
         * @exception LibroNoExiste 
         */
        public Libro isbn (String isbn) throws Excepciones.LibroNoExiste {
            for (Libro l: libros){
                if (l.getIsbn().equals(isbn)){
                    return l;
                }
            }
            throw new Excepciones.LibroNoExiste("El libro "+isbn+" no existe en nuestra biblioteca ");
        }
        /**
         * Busca en los prestamos activos cual tiene la fecha de devolucion anterior a hoy
         * @param usuarioEncontrado que deseamos buscar
         * @return Lista de prestamos encontrados que tiene la deuda
         * default null no se han encontrado deudas.
         */
        public ArrayList<Prestamo> deudas(Usuario usuarioEncontrado){
            ArrayList<Prestamo> prestamos1 = new ArrayList<>();
            for (Prestamo prestamo : prestamos) {
                if(prestamo.getUsuarioPrest().equals(usuarioEncontrado) && prestamo.getFechaDev().isBefore(LocalDate.now())) {
                    prestamos1.add(prestamo);
                }
            }
            return prestamos1;
        }
        /**
         * Busca en los prestamos activos cual tiene la fecha de devolucion anterior a hoy
         * @param libroEncontrado que deseamos buscar
         * @return Lista de prestamos encontrados que tiene la deuda
         * default empty no se han encontrado deudas asociadas al libro.
         */
        public ArrayList<Prestamo> deudas(Libro libroEncontrado){
            ArrayList<Prestamo> prestamos1 = new ArrayList<>();
            for (Prestamo prestamo : prestamos) {
                if(prestamo.getLibroPrest().equals(libroEncontrado) && prestamo.getFechaDev().isBefore(LocalDate.now())) {
                    prestamos1.add(prestamo);
                }
            }
            return prestamos1;
        }
        /**
         * Busca en los prestamos activos cual tiene la fecha de devolucion anterior a hoy
         * @param libroEncontrado que deseamos buscar
         * @param usuarioEncontrado que deseamos buscar
         * @return prestamo encontrado que tiene la deuda
         * default null no se han encontrado deudas asociadas al prestamo.
         */
        public Prestamo deuda(Usuario usuarioEncontrado, Libro libroEncontrado){
            Prestamo prestamos1 = null;
            for (Prestamo prestamo : prestamos) {
                if(prestamo.getUsuarioPrest().equals(usuarioEncontrado) && prestamo.getLibroPrest().equals(libroEncontrado) && prestamo.getFechaDev().isBefore(LocalDate.now())) {
                    return prestamos1 = prestamo;
                }
            }
            return prestamos1;
        }
        /**
         * Busca coincidencias en los Prestamos Activos que coinciden. Si devuelve empty no se ha encontrado nada.
         * @param usuarioEncontrado Busqueda
         * default empty
         * @return prestamosActivos nos devuelve Arraylist de prestamos activos.
         */
        public ArrayList<Prestamo> prestamosActivos(Usuario usuarioEncontrado){
            ArrayList<Prestamo>prestamosActivos = new ArrayList<>();
            for (Prestamo prestamo : prestamos) {
                if (usuarioEncontrado == prestamo.getUsuarioPrest()){
                    prestamosActivos.add(prestamo);
                }
            }
            return prestamosActivos;
        }
        /**
         * Busca coincidencias en los Prestamos Activos que coinciden.
         * Si devuelve null no se ha encontrado nada.
         * @param libroEncontrado Busqueda
         * default null
         * @return prestamosActivos nos devuelve Arraylist de prestamos activos.
         */
        public ArrayList<Prestamo> prestamosActivos(Libro libroEncontrado){
            ArrayList<Prestamo>prestamosActivos = new ArrayList<>();
            for (Prestamo prestamo : prestamos) {
                if (libroEncontrado == prestamo.getLibroPrest()){
                    prestamosActivos.add(prestamo);
                }
            }
            return prestamosActivos;
        }
        /**
         * Busca coincidencias en los Prestamos Activos que coinciden.
         * Si devuelve null no se ha encontrado nada.
         * @param libroEncontrado Busqueda
         * default null
         * @return prestamosHistorial nos devuelve Arraylist de prestamos en total.
         */
        public ArrayList<Prestamo> prestamosHistorial(Libro libroEncontrado){
            ArrayList<Prestamo>prestamosActivos = new ArrayList<>();
            for (Prestamo prestamo : prestamos) {
                if (libroEncontrado == prestamo.getLibroPrest()){
                    prestamosActivos.add(prestamo);
                }
            }
            for (Prestamo prestamo : prestamosHist) {
                if (libroEncontrado == prestamo.getLibroPrest()){
                    prestamosActivos.add(prestamo);
                }
            }
            return prestamosActivos;
        }
        /**
         * Busca coincidencias en los Prestamos tanto activos como en historial que coinciden.
         * Si devuelve null no se ha encontrado nada.
         * @param usuarioEncontrado Busqueda
         * default null
         * @return prestamosHistorial nos devuelve Arraylist de prestamos encontrado en toda la vida del libro.
         */
        public ArrayList<Prestamo> prestamosHistorial(Usuario usuarioEncontrado){
            ArrayList<Prestamo>prestamosActivos = new ArrayList<>();
            for (Prestamo prestamo : prestamosHist) {
                if (usuarioEncontrado == prestamo.getUsuarioPrest()){
                    prestamosActivos.add(prestamo);
                }
            }
            for (Prestamo prestamo : prestamos) {
                if (usuarioEncontrado == prestamo.getUsuarioPrest()){
                    prestamosActivos.add(prestamo);
                }
            }
            return prestamosActivos;
        }
        /**
         * Pide Dni y llama al metodo dni para buscar usuario
         * @return Usuario objeto
         * null no se ha encontrado usuario y se ha hecho la llamada a usuarioNoEncontrado
         */
        public Usuario usuario(){
            Scanner sc=new Scanner(System.in);
            System.out.println("Introduce el Dni:");
            Usuario usuarioEncontrado = dni(sc.nextLine());
            if (usuarioEncontrado==null){
                usuarioNoEncontrado();
                sc.close();
                return null;
            }
            sc.close();
            return usuarioEncontrado;
        }
        /**
         * Busca usuario con dni
         * @param dni del usuario
         * @return usuario
         * null no se ha encontrado usuario
         */
        public Usuario dni (String dni){
            for(Usuario usuario : usuarios)
                if (usuario.getDni().equals(dni)) {
                    return usuario;
                }
            return null;
        }


    }

    public class Examen {
        private void ejercicio1(){
            ArrayList<Libro> listaLibros = new ArrayList<>();
            boolean repite = false;
            for (Libro l : libros){
                for (Prestamo p: prestamos){
                    if (p.getLibroPrest().equals(l)){
                        repite = true;
                    }
                }
                if (repite == false){
                    listaLibros.add(l);
                }
                repite = false;
            }

            System.out.println("Libros ACTUALMENTE no prestados:\n");

            for (Libro l : listaLibros) {
                System.out.println(l);
            }
            for (Libro l : libros){
                for (Prestamo p: prestamosHist){
                    if (p.getLibroPrest().equals(l)){
                        listaLibros.remove(l);
                    }
                }
            }

            System.out.println("Libro NUNCA prestados\n");

            for (Libro l : listaLibros) {
                System.out.println(l);
            }
        }
        
        private void ejercicio2(){
            if (prestamos.isEmpty()) {
                System.out.println("No hay libros en prestamos actualmente.");
                return;
            }


            // Variables para almacenar el libro más prestado y el número máximo de préstamos
            ArrayList<Usuario> usuariosActivos = new ArrayList<>();

            for (Usuario usuario : usuarios) { // Recorrer la lista de usuarios
                int contador = 0;

                // Contar cuántos prestamos ha realizado este usuario
                for (Prestamo prestamo : prestamos) {
                    if (prestamo.getUsuarioPrest().equals(usuario)&& contador==0) {
                        usuariosActivos.add(usuario);
                        contador = 1;
                    }
                }
                contador=0;
            }
            System.out.println("Los usuarios que se encuentran activos son:\n");
            for (Usuario u : usuariosActivos){
                System.out.println(u);

            }

        }
        
        private void ejercicio3(){
            Scanner sc = new Scanner(System.in);
            ArrayList <Prestamo> prestamosAño = new ArrayList<>();
            Usuario usuarioEncontrado = Buscador.usuario();
            if (usuarioEncontrado == null){
                sc.close();
                return;
            }
            System.out.println("Introduce el año que deseas buscar:\n");
            int año = sc.nextInt();
            for (Prestamo p : prestamosHist){
                if (p.getUsuarioPrest().equals(usuarioEncontrado)&&p.getFechaPrest().getYear()==año){
                    prestamosAño.add(p);
                }
            }
            if (prestamosAño.isEmpty()){
                System.out.println("No se han encontrado prestamos.");
                sc.close();
                return;
            }
            System.out.println("Los prestamos que se efectuo en el año "+año+" :");
            for (Prestamo p : prestamosAño){
                System.out.println(p);
            }
            sc.close();
        }
        
        private void ejercicio4(){
            // Variable año indica de donde empieza el listado.
            for (int año= 2022;año<=LocalDate.now().getYear();año++){
                int contador = 0;
                System.out.println("PRESTAMOS AÑO: "+año);
                for (Prestamo p : prestamosHist){

                    if (p.getFechaPrest().getYear()==año){
                        System.out.println(p);
                        contador++;
                    }
                }
                System.out.println("El total de préstamos en 2024 es: "+contador);

            }

        }
    }
}
