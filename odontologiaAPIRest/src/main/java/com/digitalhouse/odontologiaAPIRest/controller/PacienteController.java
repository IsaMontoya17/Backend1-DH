package com.digitalhouse.odontologiaAPIRest.controller;

import com.digitalhouse.odontologiaAPIRest.domain.Paciente;
import com.digitalhouse.odontologiaAPIRest.services.IPacienteService;
import com.digitalhouse.odontologiaAPIRest.services.impl.PacienteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteService pacienteServiceImpl;

    public PacienteController() {
        this.pacienteServiceImpl = new PacienteServiceImpl();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteServiceImpl.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteServiceImpl.guardar(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        return ResponseEntity.ok(pacienteServiceImpl.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        boolean eliminado = pacienteServiceImpl.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}//CIERRE DE LA CLASE
