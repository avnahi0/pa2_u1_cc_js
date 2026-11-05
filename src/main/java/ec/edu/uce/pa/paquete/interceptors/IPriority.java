package ec.edu.uce.pa.paquete.interceptors;

import jakarta.interceptor.Interceptor;

public interface IPriority {

    public int APLI1 = Interceptor.Priority.APPLICATION + 1;
    public int APLI2 = Interceptor.Priority.APPLICATION + 2;
    public int APLI3 = Interceptor.Priority.APPLICATION + 3;
    public int APLI4 = Interceptor.Priority.APPLICATION + 4;

}
