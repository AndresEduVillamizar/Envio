package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioEnvioTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioEnvioTest {

    @Test
    void deberiaCrearElEnvioCorrectamente() {

        UsuarioEnvio usuarioEnvio = new UsuarioEnvioTestDataBuilder()
                .conId(1L)
                .build();

        assertEquals(1, usuarioEnvio.getId());
        assertEquals("NombreEnvio", usuarioEnvio.getNombre());
        assertEquals("password", usuarioEnvio.getClave());
        assertEquals(true, usuarioEnvio.isPremium());
    }

    @Test
    void deberiaFallarSinNombre() {

        UsuarioEnvioTestDataBuilder usuarioEnvioTestDataBuilder = new UsuarioEnvioTestDataBuilder()
                .conNombre(null)
                .conId(1L);

        BasePrueba.assertThrows(() -> {
                    usuarioEnvioTestDataBuilder.build();
                }, ExcepcionValorObligatorio.class, "Se requiere ingresar el nombre del usuario"
        );
    }

    @Test
    void deberiaFallarSinClave(){

        UsuarioEnvioTestDataBuilder usuarioEnvioTestDataBuilder = new UsuarioEnvioTestDataBuilder()
                .conId(1L)
                .conClave(null);

        BasePrueba.assertThrows(() -> {
                    usuarioEnvioTestDataBuilder.build();
                }, ExcepcionValorObligatorio.class, "Se requiere ingresar un contraseña"
        );

    }
}
