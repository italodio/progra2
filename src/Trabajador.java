/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pepsi
 */
public class Trabajador {
    private String run;
    private char dv;
    private String nombre;

    public Trabajador() {
    }

    public Trabajador(String run, char dv, String nombre) {
        this.run = run;
        this.dv = dv;
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "run=" + run + ", dv=" + dv + ", nombre=" + nombre + '}';
    }
    
    public void imprimirDatos(){
        System.out.println("RUN: " + this.run);
        System.out.println("DV: " + this.dv);
        System.out.println("Nombre: " + this.nombre);
    }
}
