package Proyecto;


import java.time.LocalDate;
import java.util.Scanner;

import static Proyecto.Main.*;

public class Funciones {
static Scanner teclado = new Scanner(System.in);

//Menu principal
    public static void menuPrincipal(){
        System.out.println("### MENÚ PRINCIPAL ###");
        System.out.println("1. Gestión de clientes.");
        System.out.println("2. Gestión de pájaros.");
        System.out.println("3. Realizar venta.");
        System.out.println("4. Mostrar ventas.");
        System.out.println("5. Salir.");
        System.out.println("Elige un índice.");
    }


//Apartado clientes
    public static int gestionClientes(){
        System.out.println("### Gestión de Clientes ###");
        System.out.println("1. Alta.");
        System.out.println("2. Baja. ");
        System.out.println("3. Busqueda por DNI. ");
        System.out.println("4. Modificación. ");
        System.out.println("5. Listado. ");
        System.out.println("Elige un índice. ");
        int option = teclado.nextInt();
        teclado.nextLine();
        return option;
    }

    public static void altaCliente(){
        System.out.println("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Dni: ");
        String dni = teclado.nextLine();
        System.out.println("Teléfono: ");
        String telefono = teclado.nextLine();
        System.out.println("Email: ");
        String email = teclado.nextLine();
        clientes.add(new Cliente(nombre, dni, telefono, email));
    }

    public static void buscarPorDni(){
        System.out.println("Dime el DNI que quieres buscar en la base de datos");
        boolean encontrado = false;
        String dniBuscado = teclado.nextLine();
        for (Cliente cliente : clientes){
            if (cliente.getDni().equalsIgnoreCase(dniBuscado)){
                encontrado = true;
                System.out.println("¡Cliente encontrado!");
                System.out.println(cliente.getNombre() + ", " + cliente.getDni() + ", " + cliente.getEmail() +", " + cliente.getTelefono());
            }
        }
        if (!encontrado){
            System.out.println("El Dni buscado no se encuentra en nuestra base de datos. ");
        }
    }

    public static void bajaCliente(){
        listaClientes();
        System.out.println("¿Que índice de cliente quieres borrar?");
        int indiceCliente = teclado.nextInt() -1;
        clientes.remove(indiceCliente);
    }

    public static void modificarTelefono(){
        listaClientes();
        System.out.println("¿Que índice de cliente quieres cambiar el teléfono?");
        int indiceCliente = teclado.nextInt() -1;
        teclado.nextLine();
        System.out.println("¿Cúal es el nuevo teléfono?");
        String nuevoTelefono = teclado.nextLine();
        Cliente cliente = clientes.get(indiceCliente);
        cliente.setTelefono(nuevoTelefono);

    }

    public static void listaClientes(){
    for ( int i = 0; i < clientes.size(); i++){
        Cliente cliente = clientes.get(i);
        System.out.println((i+1)+ ". " + cliente.getNombre() + ", " + cliente.getTelefono() + ", " + cliente.getDni() + ", " + cliente.getEmail() );
    }
    }


//Apartado Pajaros
    public static int gestionPajaros(){
        System.out.println("### Gestión de Pájaros ###");
        System.out.println("1. Alta.");
        System.out.println("2. Baja. ");
        System.out.println("3. Busqueda por especie. ");
        System.out.println("4. Modificación precio. ");
        System.out.println("5. Listado. ");
        System.out.println("Elige un índice. ");
        int option = teclado.nextInt();
        teclado.nextLine();
        return option;
    }

    public static void altaPajaro(){
        System.out.println("Especie: ");
        String especie = teclado.nextLine();
        System.out.println("Color: ");
        String color = teclado.nextLine();
        System.out.println("Precio: ");
        double precio = teclado.nextDouble();
        pajaros.add(new Pajaro(especie, color, precio));
    }

    public static void bajaPajaro(){
        listaPajaros();
        System.out.println("¿Que índice de pájaro quieres borrar?");
        int indicePajaro = teclado.nextInt() -1;
        pajaros.remove(indicePajaro);
    }

    public static void buscarPorEspecie(){
        System.out.println("Dime la especie que quieres buscar en la base de datos");
        boolean encontrado = false;
        String especieBuscada = teclado.nextLine();
        for (Pajaro pajaro : pajaros){
            if (pajaro.getEspecie().equalsIgnoreCase(especieBuscada)){
                System.out.println("¡Pájaro encontrado!");
                System.out.println(pajaro.getEspecie() + ", " + pajaro.getPrecio() + ", " + pajaro.getColor());
                encontrado = true;
            }

        }
        if (!encontrado){
            System.out.println("La especie buscada no se encuentra en nuestro catálogo. ");
        }
    }

    public static void modificarPrecioPajaro(){
        listaPajaros();
        System.out.println("¿Que índice de pajaro quieres cambiar el precio?");
        int indicePajaro = teclado.nextInt() -1;
        teclado.nextLine();
        System.out.println("¿Cúal es el nuevo precio?");
        double nuevoPrecio = teclado.nextDouble();
        teclado.nextLine();
        Pajaro pajaro = pajaros.get(indicePajaro);
        pajaro.setPrecio(nuevoPrecio);
    }

    public static void listaPajaros(){
        for ( int i = 0; i < pajaros.size(); i++){
            Pajaro pajaro = pajaros.get(i);
            System.out.println((i+1)+ ". " + pajaro.getEspecie() + ", " + pajaro.getColor() + ", " + pajaro.getPrecio() + " € "  );
        }
    }

    //Apartado Ventas

    public static int gestionVentas(){
        System.out.println("### Gestión de Ventas###");
        System.out.println("1. Nueva venta.");
        System.out.println("2. Mostras ventas realizadas. ");
        System.out.println("3. Mostrar ventas por cliente. ");
        System.out.println("4. Mostrar importe de cada venta. ");
        System.out.println("Elige un índice. ");
        int option = teclado.nextInt();
        teclado.nextLine();
        return option;
    }

    /*public static void nuevaVenta(){
        System.out.println("Por favor, elige un cliente por su índice");
        System.out.println("Recuerda darle de alta en el apartado clientes");
        listaClientes();
        int indiceCliente = teclado.nextInt() -1;
        System.out.println("Ahora dime el índice del pájaro. ");
        listaPajaros();
        int indicePajaros = teclado.nextInt() -1;
        Pajaro pajaro = pajaros.get(indicePajaros);
        LocalDate hoy = LocalDate.now();
        Cliente cliente  = clientes.get(indiceCliente);

    }*/

    public static void ventasRealizadas(){

    }

    public static void ventasPorCliente(){

    }

    public static void importeTotalVenta(){

    }
}
