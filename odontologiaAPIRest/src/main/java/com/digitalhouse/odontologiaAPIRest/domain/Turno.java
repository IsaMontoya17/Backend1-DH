package com.digitalhouse.odontologiaAPIRest.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private static Integer idCounter = 0; // Contador para generar IDs únicos
    private Integer id; // ID único para cada instancia
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;

    public Turno(Odontologo odontologo, Paciente paciente, LocalDate fecha, LocalTime hora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
        this.id = ++idCounter; // Asigna un ID único a cada turno
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(Integer idCounter) {
        Turno.idCounter = idCounter;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
