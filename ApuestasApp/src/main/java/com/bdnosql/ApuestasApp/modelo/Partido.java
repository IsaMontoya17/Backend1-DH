package com.bdnosql.ApuestasApp.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "partidos")
public class Partido {

    private Integer id;

    private Estado estado;

    private String resultado;

    @Field(name = "equipo_local")
    private Equipo equipoLocal;

    @Field(name = "equipo_visitante")
    private Equipo equipoVisitante;


}
