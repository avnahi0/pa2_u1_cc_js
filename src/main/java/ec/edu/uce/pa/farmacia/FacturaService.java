package ec.edu.uce.pa.farmacia;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped 
public class FacturaService {

    @Inject
    private NotificacionService notificacionService;

    public void factura(Venta venta) {
        System.out.println("Factura Electronica");

        System.out.println("Factura emitida al Sr/a: " + venta.getNomCliente());
        System.out.println("Medicamento: " + venta.getMedicamento());
        System.out.println("Valor de $ " + venta.getPrecio());
        System.out.println("Correo: " + venta.getCorreo());

        String asunto = "Compra de medicamentos";
        String cuerpo = "Estimado/a " + venta.getNomCliente() + ", por la compra de su medicamento '"
                + venta.getMedicamento() + "'" +
                " el valor a pagar es de $ " + venta.getPrecio();

        this.notificacionService.notificacion(venta.getCorreo(), asunto, cuerpo);
    }

}
