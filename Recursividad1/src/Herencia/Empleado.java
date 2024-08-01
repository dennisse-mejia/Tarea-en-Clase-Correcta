/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herencia;

import java.util.Calendar;

/**
 *
 * @author Dennisse
 */
public abstract class Empleado {

    //Atributos 
    protected int codigo;
    protected String nombre;
    protected Calendar contrato;

    public Empleado(int code, String name) {
        codigo = code;
        nombre = name;
        contrato = Calendar.getInstance();
    }

    public final int getCodigo() {
        return codigo;

    }

    public final String getNombre() {
        return nombre;

    }

    public final Calendar getContrato() {
        return contrato;

    }

    public final void setNombre(String name) {
        nombre = name;

    }

    public abstract double pagar();

    public abstract double bono();

    public String toString() {
        return "Empleado{" + "Codigo=" + codigo + "Nombre=" + nombre;
    }

}
