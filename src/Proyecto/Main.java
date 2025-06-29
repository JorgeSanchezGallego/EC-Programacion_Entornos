package Proyecto;

import java.util.ArrayList;
import java.util.Scanner;

import static Proyecto.Funciones.*;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Pajaro> pajaros = new ArrayList<>();
    static ArrayList<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            Funciones.menuPrincipal();
            opcion = teclado.nextInt();
            switch (opcion){
                case 1 -> {
                    int option = gestionClientes();
                    switch (option){
                        case 1 -> altaCliente();
                        case 2 -> bajaCliente();
                        case 3 -> buscarPorDni();
                        case 4 -> modificarTelefono();
                        case 5 -> listaClientes();
                    }
                }
                case 2 -> {
                    int option = gestionPajaros();
                    switch (option){
                        case 1 -> altaPajaro();
                        case 2 -> bajaPajaro();
                        case 3 -> buscarPorEspecie();
                        case 4 -> modificarPrecioPajaro();
                        case 5 -> listaPajaros();
                    }
                }
                case 3 -> {
                    int option = gestionVentas();
                    switch (option){
                        case 1 -> nuevaVenta();
                        case 2 -> ventasRealizadas();
                        case 3 -> ventasPorCliente();
                        case 4 -> importeTotalVenta();
                    }

                }
            }

        } while (opcion !=5);


    }

}
