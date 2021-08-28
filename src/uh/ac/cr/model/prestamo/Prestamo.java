package uh.ac.cr.model.prestamo;

public class Prestamo {

    private int idPrestamista;
    private int idInteresado;
    private double totalPrestamo;
    private double pendientePago;
    private Boolean estado;



    public Prestamo(int prestamista, int interesado, double totalPrestamo, double pendientePago, Boolean estado) {
        this.idPrestamista = prestamista;
        this.idInteresado = interesado;
        this.totalPrestamo = totalPrestamo;
        this.pendientePago = pendientePago;
        this.estado = estado;
    }
    public int getIdPrestamista() {
        return idPrestamista;
    }
    public void setIdPrestamista(int idPrestamista) {
        this.idPrestamista = idPrestamista;
    }
    public int getIdInteresado() {
        return idInteresado;
    }
    public void setIdInteresado(int idInteresado) {
        this.idInteresado = idInteresado;
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
    public String toFile(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(idPrestamista  + "\n");
        stringBuilder.append(idInteresado  + "\n");
        stringBuilder.append(totalPrestamo  + "\n");
        stringBuilder.append(pendientePago  + "\n");
        stringBuilder.append(estado  + "\n");
        stringBuilder.append("/Prestamo\n");
        return stringBuilder.toString();
    }
}
