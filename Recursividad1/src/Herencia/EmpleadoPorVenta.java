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
public class EmpleadoPorVenta extends EmpleadoComun {

    private double ventas[], tasa, totalVentas;

    public EmpleadoPorVenta(int code, String name, double salary) {
        super(code, name, salary);
        ventas = new double[12];
        tasa = 0.05;

    }

    private int mesActual() {
        Calendar fecha = Calendar.getInstance();
        int mes = fecha.get(Calendar.MONTH);
        return mes;

    }

    public void agregaVenta(double monto) {
        ventas[mesActual()] += monto;

    }

    public double comision() {
        return ventas[mesActual()] * tasa;
    }

    @Override
    public double pagar() {
        return super.pagar() + comision();
    }

    @Override
    public String toString() {
        return super.toString() + "comision " + comision();
    }

}
