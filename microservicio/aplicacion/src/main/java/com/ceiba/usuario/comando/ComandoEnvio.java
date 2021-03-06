package com.ceiba.usuario.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEnvio {

    private Long id;
    private String nombre;
    private String clave;
    private boolean premium;
}
