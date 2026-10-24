package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject 
    private PedidoService pedidoService;

    @Inject 
    private CompraService compraService;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... arg) {

        System.out.println("Iniciando aplicación Quarkus...");

        Pedido pedido = new Pedido("avnahi", "Laptop", 1500.00, "j.oos@gmail.com");
        pedido.setTelefono("09999999999");
        this.pedidoService.realizar(pedido);

        Compra compra = new Compra("Joss", "Smart TV", 1201.5, "avn.ahi@gmail.com");
        compra.setTelefono("0999999999");
        this.compraService.realizar(compra);

        return 0;
    }
}
