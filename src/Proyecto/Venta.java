package Proyecto;

import java.util.ArrayList;

public class Venta {
    //Atributos
    private Cliente cliente;
    private ArrayList<Pajaro> lineasDeVenta;
    private String fecha;

    //Constructor
    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.lineasDeVenta = new ArrayList<>();
        this.fecha = fecha;
    }


}
