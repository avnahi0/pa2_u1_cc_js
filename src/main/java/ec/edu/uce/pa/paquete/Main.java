package ec.edu.uce.pa.paquete;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

//@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private PedidoService pedidoService;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... arg) {

        System.out.println("Iniciando aplicación Quarkus... \n");

        Pedido pedido = new Pedido("avnahi", "Laptop", 1500.00, "avn_ahi@gmail.com");
        pedido.setTelefono("09999999999");
        this.pedidoService.realizar(pedido, "^^");

        return 0;
    }
}
