package Modelo;

public class Registro {
    String nomClase;
    String mensajeInvocacion;
    String hora;

    public Registro(String nomClase, String mensajeInvocacion, String hora) {
        this.nomClase = nomClase;
        this.mensajeInvocacion = mensajeInvocacion;
        this.hora = hora;
    }

    public void setNomClase(String nomClase) {
        this.nomClase = nomClase;
    }

    public void setMensajeInvocacion(String mensajeInvocacion) {
        this.mensajeInvocacion = mensajeInvocacion;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return this.nomClase+","+this.mensajeInvocacion+","+this.hora;
    }

}
