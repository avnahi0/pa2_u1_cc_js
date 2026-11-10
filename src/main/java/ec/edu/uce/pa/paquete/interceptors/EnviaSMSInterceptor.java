package ec.edu.uce.pa.paquete.interceptors;

import jakarta.annotation.Priority;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@EnviarSMS
@Interceptor
@Priority(IPriority.APLI2)
public class EnviaSMSInterceptor {

    @AroundInvoke
    public Object Interceptar(InvocationContext context) throws Exception {

        Long init = System.currentTimeMillis();

        Object resultado = context.proceed();

        Long end = System.currentTimeMillis() - init;

        System.out.println("\n [EnviarSMS] El tiempo de ejecución es de: " + end + "\n");

        return resultado;
    }

}
