package ec.edu.uce.pa.farmacia.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@NotificarVenta
@Interceptor
@Priority(IPriority.APLI1)
public class NotificarVentaInterceptor {

    @AroundInvoke
    public Object Interceptar(InvocationContext context) throws Exception {

        Long init = System.currentTimeMillis();

        Object resultado = context.proceed();

        Long end = System.currentTimeMillis() - init;

        System.out.println("\n [NotificarVenta] El tiempo de ejecución es de: " + end + "\n");

        return resultado;
    }

}
