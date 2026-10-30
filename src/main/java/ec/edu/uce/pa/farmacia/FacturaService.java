package ec.edu.uce.pa.farmacia;

import ec.edu.uce.pa.farmacia.interceptors.ValidarVenta;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped 
public class FacturaService {

    @ValidarVenta 
    public String factura(Venta venta) {
        System.out.println("\nFactura Electronica\n");

        System.out.println("Factura emitida al Sr/a: " + venta.getNomCliente());
        System.out.println("Medicamento: " + venta.getMedicamento());
        System.out.println("Precio: $" + venta.getPrecio());
        System.out.println("Correo: " + venta.getCorreo());
        System.out.println();

        return  "\n Gracias por su compra...";
    }

}
