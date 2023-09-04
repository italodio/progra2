
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author pepsi
 */
public class Principal {

    public static void main(String[] args) {
        // MAIN
        Scanner leer = new Scanner(System.in);
        boolean flag;
        int montoCompra, opción;

        // Trabajador
        String run;
        char dv;
        String nombre;
        // Tarjeta
        int clave, monto;
        long código;
        String vigencia;

        Validar validación = new Validar();
        Tarjeta tarjeta = new Tarjeta();
        Trabajador trabajador = new Trabajador();

        do {
            System.out.println("Menú.");
            System.out.println("1.- Ingresar datos trabajador y clave. ");
            System.out.println("2.- Ingreso de datos tarjeta. ");
            System.out.println("3.- Comprar. ");
            System.out.println("4.- Salir. (Ver datos finales). ");
            opción = leer.nextInt();

            switch (opción) {
                case 1: // INGRESAR TRABAJADOR
                    do {
                        System.out.println("Ingrese nombre. ");
                        nombre = leer.nextLine();
                        flag = validación.validarNombre(nombre);
                        if (flag == true) {
                            System.out.println("El nombre no puede estar vacío. ");
                        }
                    } while (flag == true);
                    
                    do {                        
                        System.out.println("Ingrese run SÍN DÍGITO VERIFICADOR. ");
                        run = leer.next();
                        flag = validación.validarRun(run);
                        if (flag == false) {
                            System.out.println("RUN fuera de rango. ");
                        }
                    } while (flag == false);
                    
                    do {                        
                        System.out.println("Ingrese dígito verificador. "
                                            + " Si ingresa más de un caracter se tomará en cuenta el primero. ");
                        dv = leer.next().charAt(0);
                        flag = validación.validarDv(dv);
                        if (flag == false) {
                            System.out.println("Dígito no válido. ");
                        }
                    } while (flag == false);

                    /*do {
                        System.out.println("Ingrese RUN: ");
                        run = leer.nextInt();
                        System.out.println("Ingrese dígito verificador: ");
                        dv = leer.next().charAt(0);
                        flag = validación.validarRut(run, dv);
                        if (flag == false) {
                            System.out.println("RUT incorrecto.");
                        }
                    } while (flag == false);*/

                    do {  // VALIDAR CLAVE TRABAJADOR                      
                        System.out.println("Ingrese su clave, debe ser los 4 primeros dígitos de su rut.");
                        clave = leer.nextInt();
                        flag = validación.validarClavesiwi(clave, run);
                        if (flag == false) {
                            System.out.println("Clave incorrecta.");
                        }
                    } while (flag == false);
                    
                    
                    trabajador.setRun(run);
                    trabajador.setDv(Character.toUpperCase(dv));
                    trabajador.setNombre(nombre);
                    tarjeta.setClave(clave);

                    System.out.println("DATOS TRABAJADOR INGRESADOS");
                    trabajador.imprimirDatos();
                    break;

                case 2: // DEFINIR DATOS TARJETA.
                    código = tarjeta.obtenerNúmeroCódigo();
                    tarjeta.setCódigo(código);

                    Date fechaDate = null;

                    do { // VIGENCIA
                        System.out.println("Ingrese vigencia tarjeta. ");
                        vigencia = leer.next();
                        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

                        try {
                            fechaDate = formato.parse(vigencia);
                            flag = validación.validarFecha(fechaDate);
                        } catch (ParseException e) {
                            flag = false;
                            System.out.println("Fecha inválida. ");
                        }
                        if (flag == false) {
                            System.out.println("Tarjeta no vigente. ");
                        }
                    } while (flag == false);
                    tarjeta.setVigencia(fechaDate);

                    do { // MONTO
                        System.out.println("Ingrese la cantidad de MONTO que la Gift Card posee. ");
                        monto = leer.nextInt();
                        flag = validación.validarMonto(monto);
                        if (flag == false) {
                            System.out.println("Monto debe ser mayor a 0. ");
                        }
                    } while (flag == false);
                    tarjeta.setMonto(monto);
                    break;

                case 3:
                    // INGRESAR MONTO TARJETA  
                    do {
                        System.out.println("Ingrese el monto de compra. ");
                        montoCompra = leer.nextInt();
                        flag = validación.validarCompra(tarjeta.getMonto(),montoCompra);
                        
                        if (flag == false) {
                            System.out.println("El monto de compra es mayor al cupo de la tarjeta. ");
                        } 
                    } while (flag == false);
                    
                    tarjeta.descontarMonto(tarjeta.getMonto(), montoCompra);
                    tarjeta.setMonto(tarjeta.descontarMonto(tarjeta.getMonto(), montoCompra));
                    break;
                case 4:
                    System.out.println("Ha salido de el programa. ");
                    break;
                default:
                    System.out.println("Opción inválida. ");
                
            } 
            tarjeta.agregarTarjeta(tarjeta);
        } while (opción != 4);
        System.out.println("-----------------");
        trabajador.imprimirDatos();
        System.out.println("-----------------");
        tarjeta.mostrarLista();
        System.out.println("-----------------");
        tarjeta.mostrarListaTarjeta();
        
    }
}
