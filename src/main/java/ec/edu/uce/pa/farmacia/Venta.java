package ec.edu.uce.pa.farmacia;

public class Venta {

    private String nomCliente;
    private String medicamento;
    private double precio;
    private String correo;

    public Venta() {
    }

    public Venta(String nomCliente, String medicamento, double precio, String correo) {
        this.nomCliente = nomCliente;
        this.medicamento = medicamento;
        this.precio = precio;
        this.correo = correo;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


}
