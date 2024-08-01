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
public class EmpleadoTemporal extends EmpleadoComun {

    // Atributos 
    private Calendar finContrato;

    public EmpleadoTemporal(int code, String name) {
        super(code, name, 1500);
        this.finContrato = Calendar.getInstance();

    }

    public void setFinContrato(Calendar finContrato) {
        this.finContrato = finContrato;
    }

    public double pagar() {
        Calendar hoy = Calendar.getInstance();
        if (hoy.before(finContrato)) {
            return super.pagar();

        }
        return 0;
    }

    public String toString() {
        return super.toString() + "Fin de Contrato= " + finContrato.getTime();

    }

}
