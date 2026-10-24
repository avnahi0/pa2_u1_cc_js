package ec.edu.uce.pa.tienda;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("vip")
public class DescuentoVIP implements CalculadoraDescuento {

    private String id = UUID.randomUUID().toString(); // Universally Unique Identifier

    public DescuentoVIP() {
    }

    public DescuentoVIP(String id) {
        this.id = id;
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.15;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
