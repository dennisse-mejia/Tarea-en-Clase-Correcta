/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Herencia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author Dennisse
 */
public class Empresa {

    static Scanner lea = new Scanner(System.in);

    static Empleado[] empleados = new Empleado[100];
    static int numEmpleados = 0;

    public static void main(String[] args) {
        int op;

        do {
            System.out.println("1- Agregar Empleado");
            System.out.println("2- Pagar Empleado");
            System.out.println("3- Lista de Empleados");
            System.out.println("4- Sub Menu especifico");
            System.out.println("5- Salir");
            System.out.print("Escoja Opcion: ");
            op = lea.nextInt();

            switch (op) {
                case 1:
                    hire();
                    break;
                case 2:
                    pay();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    submenu();
                    break;
            }
        } while (op != 5);
    }

    private static Empleado search(int cod) {
        for (int i = 0; i < numEmpleados; i++) {
            Empleado empleado = empleados[i];
            if (empleado.getCodigo() == cod) {
                return empleado;
            }
        }
        return null;
    }

    private static void hire() {
        System.out.println("Ingrese el tipo de empleado (COMUN, HORA, VENTA, TEMPORAL): ");
        String tipoEmpleado = lea.next().toUpperCase();

        if (!tipoEmpleado.equals("COMUN") && !tipoEmpleado.equals("HORA") && !tipoEmpleado.equals("VENTA") && !tipoEmpleado.equals("TEMPORAL")) {
            System.out.println("Tipo de empleado no válido.");
            return;
        }

        System.out.print("Ingrese el código del empleado: ");
        int codigo = lea.nextInt();

        if (search(codigo) != null) {
            System.out.println("El código ya está en uso.");
            return;
        }

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = lea.next();

        switch (tipoEmpleado) {
            case "COMUN":
                System.out.print("Ingrese el salario: L.");
                double salario = lea.nextDouble();
                empleados[numEmpleados++] = new EmpleadoComun(codigo, nombre, salario);
                break;
            case "HORA":
                empleados[numEmpleados++] = new EmpleadoPorHora(codigo, nombre);
                break;
            case "VENTA":
                System.out.print("Ingrese el salario: L.");
                salario = lea.nextDouble();
                empleados[numEmpleados++] = new EmpleadoPorVenta(codigo, nombre, salario);
                break;
            case "TEMPORAL":
                empleados[numEmpleados++] = new EmpleadoTemporal(codigo, nombre);
                break;
        }
    }

    private static void pay() {
        System.out.print("Ingrese el código del empleado: ");
        int codigo = lea.nextInt();
        Empleado emp = search(codigo);
        if (emp != null) {
            System.out.println("Pago: L." + emp.pagar());
        } else {
            System.out.println("Empleado no existe en planilla.");
        }
    }

    private static void list() {
        for (int i = 0; i < numEmpleados; i++) {
            System.out.println(empleados[i]);
        }
    }

    private static void submenu() {
        int op;
        do {
            System.out.println("1-Fecha Fin Contrato a Temporales");
            System.out.println("2-Ingresar Venta");
            System.out.println("3-Ingresar Horas de Trabajo");
            System.out.println("4-Regresar al Menu Principal");
            System.out.print("Escoja una opcion: ");
            op = lea.nextInt();

            switch (op) {
                case 1:
                    setFin();
                    break;
                case 2:
                    ventas();
                    break;
                case 3:
                    horas();
            }

        } while (op != 4);
    }

    private static void setFin() {
        System.out.print("Ingrese el código del empleado: ");
        int codigo = lea.nextInt();
        Empleado empleado = search(codigo);

        if (empleado != null && empleado instanceof EmpleadoTemporal) {
            System.out.print("Ingrese el año de fin de contrato: ");
            int year = lea.nextInt();
            System.out.print("Ingrese el mes de fin de contrato: ");
            int month = lea.nextInt();
            System.out.print("Ingrese el día de fin de contrato: ");
            int day = lea.nextInt();
            Calendar finContrato = Calendar.getInstance();
            finContrato.set(year, month - 1, day);
            ((EmpleadoTemporal) empleado).setFinContrato(finContrato);
            System.out.println("Fecha de fin de contrato actualizada.");
        } else {
            System.out.println("Empleado no existe o no trabaja temporal.");
        }
    }

    private static void ventas() {

        System.out.print("Ingrese el código del empleado: ");
        int codigo = lea.nextInt();
        Empleado empleado = search(codigo);
        if (empleado != null && empleado instanceof EmpleadoPorVenta) {
            System.out.print("Ingrese el monto de la venta: ");
            double monto = lea.nextDouble();
            ((EmpleadoPorVenta) empleado).agregaVenta(monto);
            System.out.println("Venta registrada.");
        } else {
            System.out.println("Empleado no existe o no trabaja por ventas.");
        }
    }

    private static void horas() {
        System.out.print("Ingrese el código del empleado: ");
        int codigo = lea.nextInt();
        Empleado emp = search(codigo);
        if (emp != null && emp instanceof EmpleadoPorHora) {
            System.out.print("Ingrese las horas trabajadas: ");
            int horas = lea.nextInt();
            ((EmpleadoPorHora) emp).setHorasT(horas);
            System.out.println("Horas registradas.");
        } else {
            System.out.println("Empleado no existe o no trabaja por horas.");
        }
    }
}
