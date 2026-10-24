package ec.edu.uce.pa.tienda;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class AppTienda implements QuarkusApplication{

    @Inject
    private VentaService ventaService;

    public static void main(String[] args) {
        Quarkus.run(AppTienda.class, args);
    }

    @Override 
    public int run(String... arg) {

        System.out.println("Iniciando aplicación Quarkus...");
        System.out.println();

        ventaService.realizarVenta(1, "REGULAR", 100.00);
        ventaService.realizarVenta(2, "VIP", 200.00);
        ventaService.realizarVenta(3, "REGULAR", 300.00);
        ventaService.realizarVenta(4, "VIP", 500.00);

        return 0;
    }
}
