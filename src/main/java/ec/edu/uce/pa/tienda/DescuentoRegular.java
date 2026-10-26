package ec.edu.uce.pa.tienda;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento {

    private String id = UUID.randomUUID().toString(); // Universally Unique Identifier

    public DescuentoRegular() {
    }

    public DescuentoRegular(String id) {
        this.id = id;
    }

    @Override
    public double calcular(double monto) {
        return monto * 0.05;
    }

    public String getId() {
        return id;
    }

}
