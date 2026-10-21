package ec.edu.uce.pa.farmacia;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

//@QuarkusMain
public class AppFarmacia implements QuarkusApplication {

    @Inject
    private FacturaService facturaService;

    public static void main(String[] args) {

        Quarkus.run(AppFarmacia.class, args);

    }

    @Override
    public int run(String... arg) {

        System.out.println("Iniciando aplicación Quarkus...");

        Venta venta = new Venta("avnahi", "Singripal", 0.80, "avn.ahi@gmail.com");
        this.facturaService.factura(venta);

        return 0;
    }
}
