package ec.edu.uce.pa.farmacia.interceptors;

import java.lang.reflect.Parameter;

import ec.edu.uce.pa.farmacia.ValidarVentaService;
import ec.edu.uce.pa.farmacia.Venta;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@ValidarVenta
@Interceptor
public class ValidarVentaInterceptor {

    @Inject
    public ValidarVentaService validarVentaService;

    @AroundInvoke     
     public Object Interceptor(InvocationContext contexto) throws Exception{

        Object resultado = contexto.proceed();
        System.out.println("Mensaje luego que se ejecuta el método interceptado. \n");

        System.out.println("Retorna " + resultado +"\n");

        String nomMetodo = contexto.getMethod().getName();
        System.out.println("Validando la venta del método: " + nomMetodo);

        Parameter[] parametros = contexto.getMethod().getParameters();

        for (Parameter parametro : parametros){
            System.out.println("Parametro: " + parametro.getName());
        }

        Object[] valores = contexto.getParameters();

        Venta venta = (Venta) valores[0];

        String nomCliente = venta.getNomCliente();
        String medicamento = venta.getMedicamento();
        double precio = venta.getPrecio();
        String correo = venta.getCorreo();

        this.validarVentaService.guardarEnlaBase(nomCliente, medicamento, precio, correo);

        return resultado;
        
    }

}
