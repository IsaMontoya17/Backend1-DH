package com.digitalhouse.odontologiaAPIRest.controller;

import com.digitalhouse.odontologiaAPIRest.domain.Odontologo;
import com.digitalhouse.odontologiaAPIRest.services.impl.OdontologoServiceImpl;
import com.digitalhouse.odontologiaAPIRest.services.IOdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private IOdontologoService odontologoServiceImpl;

    public OdontologoController() {
        this.odontologoServiceImpl = new OdontologoServiceImpl();
    }

    //RequestParam url ? parametro = X & parametro = X
    //PathVariable url/pathVariable
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(odontologoServiceImpl.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoServiceImpl.guardar(odontologo));
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(odontologoServiceImpl.listar());
    }

}
