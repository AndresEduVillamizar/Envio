package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;

public class UsuarioEnvioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;
    private boolean premium;

    public UsuarioEnvioTestDataBuilder(){
        nombre="NombreEnvio";
        clave="password";
        premium = true;
    }

    public UsuarioEnvioTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public UsuarioEnvioTestDataBuilder conClave(String clave){
        this.clave=clave;
        return this;
    }

    public UsuarioEnvioTestDataBuilder esPremium(boolean premium){
        this.premium=premium;
        return this;
    }

    public UsuarioEnvioTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public UsuarioEnvio build(){
        return new UsuarioEnvio(id,nombre,clave,premium);
    }
}
