package ec.edu.uce.pa.paquete.interceptors;

import java.lang.reflect.Parameter;

import ec.edu.uce.pa.paquete.Pedido;
import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
@Priority(IPriority.APLI4)
public class MedirTiempoInterceptor {

    @AroundInvoke
    public Object Interceptar(InvocationContext context) throws Exception {

        Long init = System.currentTimeMillis();

        Object resultado = context.proceed();

        Long end = System.currentTimeMillis() - init;

        System.out.println("\n [MedirTiempo] El tiempo de ejecución es de: " + end + "\n");

        return resultado;
    }

}
