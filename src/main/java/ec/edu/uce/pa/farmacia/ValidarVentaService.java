package ec.edu.uce.pa.farmacia;

import java.time.LocalDateTime;

import jakarta.inject.Singleton;

@Singleton 
public class ValidarVentaService {

    public void guardarEnlaBase (String nomCliente, String medicamento, double precio, String correo){

        System.out.println("Guardando en la base datos la auditoria del cliente: " + nomCliente + ", por la compra de '" + medicamento + "', por la cantidad de $" + precio + " y correo: " + correo);
        System.out.println("\nCon fecha y hora: " + LocalDateTime.now());
        System.out.println();

    }

}
