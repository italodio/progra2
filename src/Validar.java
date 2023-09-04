
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pepsi
 */
public class Validar {

    public Validar() {
    }
    
    public boolean validarRut(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;

        }
        return Character.toUpperCase(dv) == (char) (s != 0 ? s + 47 : 75);
    }
    
    public boolean validarClave(int password,String run){
        boolean flag = true;
        String string_password = Integer.toString(password);
        for (int i = 0; i <= 3; i++) {
            if (run.charAt(i) != string_password.charAt(i)) {
                flag = false;
            } 
        }
        return flag;    
    }
    
    public boolean validarMonto(int monto){
        return monto > 0;
    }
    
    public boolean validarFecha(Date vigencia){
        Date fecha = new Date();
        return vigencia.compareTo(fecha) >= 0;
    }
    public boolean validarNombre(String name){
        return name.isBlank();
    }
    
    public boolean validarCompra(int monto, int montoCompra){
        return monto>=montoCompra;
    }
    
    public boolean validarRun(String rut){
        if (rut.length() >= 7 && rut.length() <= 8) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validarDv(char dv){
        if (Character.toString(dv).matches("[0-9kK]")) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validarClavesiwi(int password, String run){
        // boolean flag = true;
        String password_string = Integer.toString(password);
        run = run.substring(0,4);
        return password_string.equalsIgnoreCase(run);
    }
}

