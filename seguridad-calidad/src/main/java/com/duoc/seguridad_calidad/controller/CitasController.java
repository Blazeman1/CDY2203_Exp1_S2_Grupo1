// Ubicado en el paquete controller para organizar el proyecto por capas.
package com.duoc.seguridad_calidad.controller;

import com.duoc.seguridad_calidad.model.Cita;
import com.duoc.seguridad_calidad.model.Paciente;
import com.duoc.seguridad_calidad.repository.CitaRepository;
import com.duoc.seguridad_calidad.repository.PacienteRepository;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Modulo privado de citas.
 * Se ubica en controller para mantener la capa web separada de store/model.
 */
@Controller
@RequestMapping("/citas")
public class CitasController {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;

    public CitasController(CitaRepository citaRepository, PacienteRepository pacienteRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("citas", citaRepository.findAll());
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "citas";
    }

    @PostMapping
    public String crearCita(
            @RequestParam Long pacienteId,
            @RequestParam String fecha,
            @RequestParam String hora,
            @RequestParam String motivo,
            @RequestParam String veterinario,
            Model model) {

        if (fecha.isBlank() || hora.isBlank() || motivo.isBlank() || veterinario.isBlank()) {
            model.addAttribute("error", "Todos los campos son obligatorios.");
            model.addAttribute("citas", citaRepository.findAll());
            model.addAttribute("pacientes", pacienteRepository.findAll());
            return "citas";
        }

        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        if (paciente.isEmpty()) {
            model.addAttribute("error", "Debe seleccionar un paciente valido.");
            model.addAttribute("citas", citaRepository.findAll());
            model.addAttribute("pacientes", pacienteRepository.findAll());
            return "citas";
        }

        Cita cita = new Cita(
                null,
                pacienteId,
                paciente.get().getNombre(),
                fecha,
                hora,
                motivo,
                veterinario);

        citaRepository.save(cita);
        return "redirect:/citas";
    }
}
