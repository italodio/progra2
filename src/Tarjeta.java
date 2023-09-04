
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pepsi
 */
public class Tarjeta {
    long código = 1000000000000000L;
    private int clave,monto,numTrabajador=1;
    private Date vigencia;
    private String trabajadorN,listaTarjeta="";
    
    Trabajador trabajador = new Trabajador();

    public Tarjeta() {
    }

    public Tarjeta(int clave, int monto, Date vigencia, String trabajadorN, String listaTarjeta) {
        this.clave = clave;
        this.monto = monto;
        this.vigencia = vigencia;
        this.trabajadorN = trabajadorN;
        this.listaTarjeta = listaTarjeta;
    }

    public String getListaTarjeta() {
        return listaTarjeta;
    }

    public void setListaTarjeta(String listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }


    public long getCódigo() {
        return código;
    }

    public void setCódigo(long código) {
        this.código = código;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getVigencia() {
        return vigencia;
    }

    public void setVigencia(Date vigencia) {
        this.vigencia = vigencia;
    }

    public String getTrabajadorN() {
        return trabajadorN;
    }

    public void setTrabajadorN(String trabajadorN) {
        this.trabajadorN = trabajadorN;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "c\u00f3digo=" + código + ", clave=" + clave + ", monto=" + monto + ", vigencia=" + vigencia + ", trabajadorN=" + trabajadorN + '}';
    }
    
    public long obtenerNúmeroCódigo(){
        código++;
        return this.código;
    }
    
    public int descontarMonto(int monto, int montoCompra){
        return monto-montoCompra;
    }
    
    public void agregarTarjeta(Tarjeta tarjeta){
        this.listaTarjeta = this.listaTarjeta + "Código: " + tarjeta.getCódigo() + "\n"+
                            "Clave: " + tarjeta.getClave() + "\n" + "Monto: " + tarjeta.getMonto()+
                            "\n" + "Vigencia: " + tarjeta.getVigencia() + "Trabajador: " + trabajador.getNombre();
    }
    
    public void mostrarLista(){
        SimpleDateFormat formato = new SimpleDateFormat("dd-MMMM-yyyy");
        
        System.out.println("Código: " + this.código);
        System.out.println("Clave: " + this.clave);
        System.out.println("Monto: $" + this.monto);
        System.out.println("Vigencia: " + formato.format(this.vigencia));
        System.out.println("Trabajador: trabajador" + this.generarTrabajador());
    }
    
    public int generarTrabajador(){
        this.numTrabajador++;
        return this.numTrabajador;
    }
    
    public void mostrarListaTarjeta(){
        System.out.println(this.listaTarjeta);
    }
}
