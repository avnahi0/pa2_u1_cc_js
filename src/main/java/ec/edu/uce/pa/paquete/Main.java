package ec.edu.uce.pa.paquete;

import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionMail;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionSMS;
import ec.edu.uce.pa.paquete.extensiones.NotificacionExtensionWhatsApp;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private CompraService compraService;

    @Inject
    private NotificacionExtensionMail notificacionExtensionMail;

    @Inject
    private NotificacionExtensionSMS notificacionExtensionSMS;

    @Inject
    private NotificacionExtensionWhatsApp notificacionExtensionWhatsApp;

    public static void main(String[] args) {

        Quarkus.run(Main.class, args);

    }

    @Override
    public int run(String... arg) {

        System.out.println("\nIniciando aplicación Quarkus... \n");

        Pedido pedido = new Pedido("avnahi", "Laptop", 1500.00, "avn_ahi@gmail.com");
        pedido.setTelefono("09999999999");

        Compra compra = new Compra("Joss", "Samsung A15", 845.25, "joss_2005@gmail.com");
        compraService.realizar(compra, this.notificacionExtensionMail);
        compra.setTelefono("0994456327");


        Compra compra2 = new Compra("avnahi", "Redmi 10C 2025", 845.25, "avn.ahi2005@gmail.com");
        compraService.realizar(compra2, this.notificacionExtensionSMS);
        compra2.setTelefono("0998743269");

        Compra compra3 = new Compra("Felix", "Samsung A10", 783.98, "yonk.boo@gmail.com");
        compraService.realizar(compra3, this.notificacionExtensionWhatsApp);
        compra3.setTelefono("0959875632");
        return 0;
    }
}
