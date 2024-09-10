package com.bdnosql.ApuestasApp.controlador;

import com.bdnosql.ApuestasApp.modelo.Partido;
import com.bdnosql.ApuestasApp.servicio.IPartidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoControlador {
    private IPartidoServicio partidoServicio;

    @Autowired
    public PartidoControlador(IPartidoServicio partidoServicio) {
        this.partidoServicio = partidoServicio;
    }

    //crear
    @PostMapping
    public ResponseEntity<Partido> crear(@RequestBody Partido partido) {
        return ResponseEntity
                .status(HttpStatus.CREATED) //201
                .body(partidoServicio
                        .guardar(partido));

        //esto hacíamos
        //return ResponseEntity
        // .ok(partidoServicio
        // .guardar(partido)); //200

    }

    //consultar todos
    @GetMapping
    public ResponseEntity<List<Partido>> listarTodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(partidoServicio.listarTodos());
    }

}
