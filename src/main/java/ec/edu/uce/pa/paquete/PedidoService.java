package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.interceptors.Auditoria;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PedidoService {

    @Auditoria
    public String realizar(Pedido pedido, String valor1) {

        Long init = System.currentTimeMillis();

        try {
            Thread.sleep(1500);
        } catch (Exception e) {

        }

        System.out.println("Realizando pedido...");
        System.out.println("Pedido realizado al cliente: " + pedido.getCliente());
        System.out.println("Producto: " + pedido.getProducto());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("Correo: " + pedido.getCorreo());
        System.out.println("Pedido realizado con exito. \n");

        Long end = System.currentTimeMillis() - init;

        return "\n Pedido realizado con éxito. \n El tiempo que le toma a la ejecución es : " + end;

    }
}