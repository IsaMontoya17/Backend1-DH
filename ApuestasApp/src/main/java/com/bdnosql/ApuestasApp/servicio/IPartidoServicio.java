package com.bdnosql.ApuestasApp.servicio;

import com.bdnosql.ApuestasApp.modelo.Partido;

import java.util.List;

public interface IPartidoServicio {
    Partido guardar(Partido partido);
    List<Partido> listarTodos();
}
