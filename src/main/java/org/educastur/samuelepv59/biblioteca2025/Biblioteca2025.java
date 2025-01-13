/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.educastur.samuelepv59.biblioteca2025;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author alu19d
 */
public class Biblioteca2025 {
    
    
    private ArrayList<Libro>libros;
    private ArrayList<Usuario>usuarios;
    private ArrayList<Prestamo>prestamos;
    private ArrayList<Prestamo>prestamosHist;
    
    
    private boolean estatus = true;
    
    
    public Biblioteca2025(){
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
        this.prestamosHist = new ArrayList();
        
    }
    public static void main(String[] args) {
        Biblioteca2025 b = new Biblioteca2025();
        b.cargaDatos();
        b.SelfControl();
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
                    menuExtras();
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
        System.out.println("\t\t\t2. Devolver Un Prestamo");
        System.out.println("\t\t\t3. Prorrogar Un Prestamo");
        System.out.println("\t\t\t4. Listar Hisotiral De Prestamos");
        System.out.println("\t\t\t5. Listar Prestamos Activos");
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
                prorrogarPrestamo();
                break;
            case 4:
                listarPrestamos();
                break;
            case 5:
                listarPrestamosActivos();
                break;
            case 0:
                System.out.println("\n\nVolviendo al menu principal...\n");
                break;
            default:
                System.out.println("\n\nOpcion no valida. Intente de nuevo.\n");
        }
    } while (opcion != 0);
    
    
     
}
    public void menuExtras() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSubmenu: Extras");
            System.out.println("\t\t\t1. Libros Prestados");
            System.out.println("\t\t\t2. Prestamos Activos");
            System.out.println("\t\t\t3. El Mas Buscado");
            System.out.println("\t\t\t4. El Mas Buscador");
            System.out.println("\n\n\t\t\t0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    librosActivos();
                    break;
                case 2:
                    prestamosActivos();
                    break;
                case 3:
                    libroMasPrestado();
                    break;
                case 4:
                    usuarioMasActivo();
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
        Libro libroEncontrado = buscaLibro();
        if(libroEncontrado == null){;
            System.out.println("El libro que deseas eliminar no se encuentra en la biblioteca");
        } else {
            libros.remove(libroEncontrado);
            System.out.println("El libro fue eliminado con exito");
        }
    }
    private void modificarLibro() {
        Scanner sc=new Scanner(System.in);
        Libro libroEncontrado = buscaLibro();
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
            libroEncontrado.setEjemplares(libroEncontrado.getEjemplares()-numero);
            if (libroEncontrado.getEjemplares()<0){
                System.out.println("No puedes borrar mas libros de los que tienes");
                libroEncontrado.setEjemplares(libroEncontrado.getEjemplares()+numero);
            }
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
        Usuario usuarioEncontrado = buscaUsuario();
        if(usuarioEncontrado==null){
            System.out.println("El usuario que deseas dar de baja no esta registrado en la agenda");
        } else {
            usuarios.remove(usuarioEncontrado);
            System.out.println("El usuario "+usuarioEncontrado.getNombre()+ " ha sido dado de baja con exito");
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
        Usuario usuarioEncontrado = buscaUsuario();
        boolean status = prestamoActual(usuarioEncontrado);
        if (status == true){
            System.out.println("El usuario\n"+usuarioEncontrado.toString()+"\nya tiene al menos un prestamo activo. ");
            return;
        }
        Libro libroEncontrado = buscaLibro();
        if (libroEncontrado == null){
            System.out.println("No se encuentra el libro indicado");
        } else if (libroEncontrado.getEjemplares() > 0){
            LocalDate hoy = LocalDate.now();
            Prestamo p=new Prestamo(libroEncontrado,usuarioEncontrado,hoy,hoy.plusDays(15));
            prestamos.add(p);
            libroEncontrado.setEjemplares(libroEncontrado.getEjemplares()-1);
            System.out.println("La operacion se ha realizado con exito.\nEl usuario: "+usuarioEncontrado.getNombre()+"\nEl libro: "+libroEncontrado.getTitulo());
            } else if (libroEncontrado.getEjemplares() <= 0){
                System.out.println("No quedan ejemplares activos en el sistema.");
                return;
            }
        }    
    private void devolverPrestamo() {
        Prestamo prestamoADevolver = buscarPrestamo();
        
        // Si no hay prestamos a devolver cerramos metodo.
        if (prestamoADevolver == null){
            return;
        }
        prestamosHist.add(prestamoADevolver);
        // Actualizamos la fecha del prestamo.
        prestamoADevolver.setFechaDev(LocalDate.now());
        
        // Añadimos un ejemplar a la lista de libros.
        Libro libro = prestamoADevolver.getLibroPrest();
        libro.setEjemplares(libro.getEjemplares()+1);
        prestamos.remove(prestamoADevolver);
        
        System.out.println("Se ha devuelto el libro con exito.\nTitulo: "+libro.getTitulo()+".\nFecha de devolucion: "+prestamoADevolver.getFechaDev());
          
    }
    private void prorrogarPrestamo() {
        Prestamo prestamoEncontrado = buscarPrestamo();
        if (prestamoEncontrado == null){
            return;
        }
        prestamoEncontrado.setFechaDev(LocalDate.now().plusDays(15));
        prestamoEncontrado.setFechaPrest(LocalDate.now());
        System.out.println("El prestamo se ha prorrogado con exito.\nEl libro: "+prestamoEncontrado.getLibroPrest().getTitulo()+".\nNueva fecha de devolucion: "+prestamoEncontrado.getFechaPrest());
    }
    private void listarPrestamosActivos(){
        System.out.println("Prestamos Activos:");
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }
    private void listarPrestamos() {
        System.out.println("Historial de prestamos:");
        for(Prestamo p : prestamosHist){
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
            LocalDate apertura = LocalDate.of(2024, Month.NOVEMBER, 02);
            prestamos.add(new Prestamo(libros.get(3),usuarios.get(4),hoy ,hoy.plusDays(12)));
            prestamos.add(new Prestamo(libros.get(4),usuarios.get(0),hoy,hoy.plusDays(15)));
            prestamos.add(new Prestamo(libros.get(0),usuarios.get(1),apertura,apertura.plusDays(15)));
            prestamos.add(new Prestamo(libros.get(5),usuarios.get(2),apertura,apertura.plusDays(15)));   

            for (int i = 0; i < 21; i++) { // 21 para llegar a un total de 25 préstamos
            Libro libroAleatorio = libros.get(rand.nextInt(libros.size()));
            Usuario usuarioAleatorio = usuarios.get(rand.nextInt(usuarios.size()));
            LocalDate fechaPrestamo = hoy.minusDays(rand.nextInt(30));
            LocalDate fechaDevolucion = fechaPrestamo.plusDays(rand.nextInt(13));

            prestamosHist.add(new Prestamo(libroAleatorio, usuarioAleatorio, fechaPrestamo, fechaDevolucion));
        }
        }    
/**
 * Pide Dni y realiza todas las acciones necesarias
 * @return Usuario objeto
 * @default null
 */
    public Usuario buscaUsuario(){
        Usuario usuarioEncontrado;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el Dni del usuario:");
        String dni=sc.nextLine();
        int posU = buscaDni(dni);
        if (posU == -1){
            usuarioNoEncontrado();
            return null;
        } else{
            usuarioEncontrado = usuarios.get(posU);
            return usuarioEncontrado;
        }
    }
/**
* Busca usuario con dni
* @param dni del usuario
* @return usuarios.get(i)
* @default -1
*/    
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
/**
 * Busca libro con isbn
 * @param isbn del libro
 * @return libro.get(i)
 * @default -1
 */
    public int buscaIsbn (String isbn){
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getIsbn().equalsIgnoreCase(isbn)){
                pos = i;
                break;                
            }            
        }
        return pos;
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
                estatus = false;
                return; // Salimos del método sin hacer nada
            default:
                System.out.println("Por favor, introduzca una opción válida (SI/NO).");
        }
    } while (true); // Sigue pidiendo una opción válida hasta que sea "SI" o "NO"
}
/**
 * Pide Isbn y realiza todas las acciones necesarias
 * @return Libro Objeto
 * @default null
 */
    public Libro buscaLibro(){
        Libro libroEncontrado;
        Scanner sc=new Scanner(System.in);
        System.out.println("Introduce el Isbn del libro:");
        String isbn=sc.nextLine();
        int posL = buscaIsbn(isbn);
        if (posL == -1){
            isbnNoEncontrado();
            return null;
        } else {
            libroEncontrado = libros.get(posL);
            return libroEncontrado;
        }
        
    } 
/**
 * En este metodo pedimos Dni e Isbn para buscar en prestamos
 * @return Objeto Prestamo
 * @default null
 */
    public Prestamo buscarPrestamo(){
        Scanner sc=new Scanner(System.in);
        Prestamo prestamoEncontrado = null;
        Usuario usuarioEncontrado = buscaUsuario();
        if (usuarioEncontrado == null) {
            return prestamoEncontrado;
        }
        Libro isbn = buscaLibro();
        
        
        
        for (Prestamo prestamo : prestamos) {
        if (prestamo.getUsuarioPrest().equals(usuarioEncontrado) && 
            prestamo.getLibroPrest().equals(isbn)) {
            prestamoEncontrado = prestamo;
            break;
            } 
        } 
        
        return prestamoEncontrado;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Extras">
    /**
     * Nos muestra todos los prestamos que estan a nombre de un usuario que le demos
     */
    public void prestamosActivos(){
        Scanner sc=new Scanner(System.in);
        int contador = 0;
        LocalDate hoy = LocalDate.now();
        Usuario usuarioEncontrado = buscaUsuario();
        if (usuarioEncontrado==null){
            return;
        }
        for (Prestamo prestamo : prestamos) {
            if (usuarioEncontrado == prestamo.getUsuarioPrest()){    
            System.out.println(prestamo);
            contador++;
        }    
    }
        if (contador == 0){
        System.out.println("El usuario "+usuarioEncontrado.getNombre()+" no tiene ningun prestamo activo.");
    } 
        
    }
    /**
     * Busa en los prestamos activos cual tiene la fecha de devolucion superior a hoy
     * @param usuarioEncontrado que deseamos buscar
     * @return usuario encontrado
     */
    public boolean prestamoActual(Usuario usuarioEncontrado){
        Scanner sc=new Scanner(System.in);
        boolean status = false;
        LocalDate hoy = LocalDate.now();
        if (usuarioEncontrado==null){
            return status;
        }
        for (Prestamo prestamo : prestamos) {
            if (usuarioEncontrado == prestamo.getUsuarioPrest() && prestamo.getFechaDev().isAfter(hoy)){    
            return true;   
        }    
    }
        return status;
    }
    /**
     * Nos muestra los prestamos activos que coinciden con un isbn
     * @param Isbn para buscar el libro
     */
    public void librosActivos(){
        int contador = 0;
        Scanner sc=new Scanner(System.in);
        LocalDate hoy = LocalDate.now();
        Libro libroEncontrado = buscaLibro();
        if (libroEncontrado==null){
            
            return;
            
        }
        for (Prestamo prestamo : prestamos) {
            if (libroEncontrado == prestamo.getLibroPrest() && prestamo.getFechaDev().isAfter(hoy)){    
            System.out.println(prestamo);
            contador++;
        }
        
    }    
      if (contador == 0 ){
            System.out.println("El libro "+libroEncontrado.getTitulo()+" no se encuentra activo.");
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
    if (libroMasPrestado != null) {
        System.out.println("El libro más prestado es: " + libroMasPrestado+".\nVeces prestado: " + maxPrestamos);
    } else {
        System.out.println("No se pudo determinar el libro más prestado.");
    }
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
    if (usuarioMasActivo != null) {
        System.out.println("El usuario más activo es: " + usuarioMasActivo+".\nVeces que ha cogido un libro: " + maxPrestamos);
    } else {
        System.out.println("No se pudo determinar el usuario mas activo.");
    }
}
    /**
     * Comprueba todos los prestamos activos y separa los morosos de los que estan en plazo aun
     */
    public void SelfControl(){
        int contador = 0;
        Scanner sc=new Scanner(System.in);
        LocalDate hoy = LocalDate.now();
        System.out.println("Prestamos de morosos son:");
        for (Prestamo prestamo : prestamos){
            if (prestamo.getFechaPrest().isBefore(hoy.minusDays(14))){
                System.out.println(prestamo);
                contador++;
            }
        }
        System.out.println("Se han encontrado en total:"+contador+"\nLos libros activos que aun estan a tiempo y se deben devolver son:");
        contador=0;
        for(Prestamo prestamo : prestamos){
           if (prestamo.getFechaPrest().isAfter(hoy.minusDays(15))){
                System.out.println(prestamo);
                contador++;
            }
        }
        System.out.println("Se han encontrado en total: "+contador);

    }
    
//</editor-fold>   
}
