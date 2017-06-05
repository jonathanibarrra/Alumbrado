package com.example.usuario.alumbrado.models;

/**
 * Created by Usuario on 4/06/2017.
 */
public class Alumbrado {

        private String estrato;

    private String tarifaMensual;

    private String usuario;

    /**
     * No args constructor for use in serialization
     *
     */
    public Alumbrado() {
    }


    public Alumbrado(String estrato, String tarifaMensual, String usuario) {
        super();
        this.estrato = estrato;
        this.tarifaMensual = tarifaMensual;
        this.usuario = usuario;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    public String getTarifaMensual() {
        return tarifaMensual;
    }

    public void setTarifaMensual(String tarifaMensual) {
        this.tarifaMensual = tarifaMensual;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


}
