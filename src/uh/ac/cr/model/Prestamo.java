package uh.ac.cr.model;

public class Prestamo {
    private int prestamista;
    private int interesado;
    private double totalPrestamo;
    private double pendientePago;
    private Boolean estado;

    public Prestamo(int prestamista, int interesado, double totalPrestamo, double pendientePago, Boolean estado) {
        this.prestamista = prestamista;
        this.interesado = interesado;
        this.totalPrestamo = totalPrestamo;
        this.pendientePago = pendientePago;
        this.estado = estado;
    }
    public Object getPrestamista() {
        return prestamista;
    }
    public void setPrestamista(int prestamista) {
        this.prestamista = prestamista;
    }
    public Object getInteresado() {
        return interesado;
    }
    public void setInteresado(int interesado) {
        this.interesado = interesado;
    }
    public double getTotalPrestamo() {
        return totalPrestamo;
    }
    public void setTotalPrestamo(double totalPrestamo) {
        this.totalPrestamo = totalPrestamo;
    }
    public double getPendientePago() {
        return pendientePago;
    }
    public void setPendientePago(double pendientePago) {
        this.pendientePago = pendientePago;
    }
    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void abonar(double nuevoAbono){
        this.pendientePago -= nuevoAbono;
        if (this.pendientePago <= 0)
            estado = false;
    }
}
