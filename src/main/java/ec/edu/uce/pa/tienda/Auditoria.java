package ec.edu.uce.pa.tienda;

import java.util.UUID;

import jakarta.enterprise.context.Dependent;

@Dependent
public class Auditoria {

    private String id = UUID.randomUUID().toString(); //Universally Unique Identifier

    public Auditoria() {
    }

    public Auditoria(String id) {
        this.id = id;
    }

    public void enviar(String msj){
        System.out.println("Auditoria " + this.id + ": " + msj);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
