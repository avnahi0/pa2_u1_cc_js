package ec.edu.uce.pa.tienda;

import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class VentaService {

    @Inject
    private Auditoria auditoria;

    private CalculadoraDescuento descuentoRegular;

    private CalculadoraDescuento descuentoVIP;

    private String id = UUID.randomUUID().toString();

    public VentaService() {
    }

    @Inject
    public VentaService(@Named("regular") CalculadoraDescuento descuentoRegular,
            @Named("vip") CalculadoraDescuento descuentoVIP) {
        this.descuentoRegular = descuentoRegular;
        this.descuentoVIP = descuentoVIP;
    }

    public void realizarVenta(int numVenta, String tipoCliente, double monto) {

        double descuento = 0.0;

        if (tipoCliente.equalsIgnoreCase("REGULAR")) {
            descuento = this.descuentoRegular.calcular(monto);
        }
        if (tipoCliente.equalsIgnoreCase("VIP")) {
            descuento = this.descuentoVIP.calcular(monto);
        }

        double total = monto - descuento;

        this.auditoria.enviar("La venta N° " + numVenta + " por una cantidad de $" + monto
                + ", se realizo con éxito a un cliente '" + tipoCliente + "' \n" +
                "por lo cual se aplica un descuento de $" + descuento + " por lo que su total a cancelar es de $"
                + total + "\n");

    }

    public String getId() {
        return id;
    }

}
