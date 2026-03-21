// Ubicado en el paquete controller para organizar el proyecto por capas.
package com.duoc.seguridad_calidad.controller;

import com.duoc.seguridad_calidad.model.Paciente;
import com.duoc.seguridad_calidad.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Modulo privado de pacientes.
 * Se movio a controller para separar capa web de modelos y almacenamiento.
 */
@Controller
@RequestMapping("/pacientes")
public class PacientesController {

    private final PacienteRepository pacienteRepository;

    public PacientesController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pacientes", pacienteRepository.findAll());
        return "pacientes";
    }

    @PostMapping
    public String crearPaciente(
            @RequestParam String nombre,
            @RequestParam String especie,
            @RequestParam String raza,
            @RequestParam Integer edad,
            @RequestParam String dueno,
            Model model) {

        // Validacion minima para mantener integridad de datos en almacenamiento en memoria.
        if (nombre.isBlank() || especie.isBlank() || raza.isBlank() || dueno.isBlank()) {
            model.addAttribute("error", "Todos los campos son obligatorios.");
            model.addAttribute("pacientes", pacienteRepository.findAll());
            return "pacientes";
        }

        Paciente paciente = new Paciente(null, nombre, especie, raza, edad, dueno);
        pacienteRepository.save(paciente);
        return "redirect:/pacientes";
    }
}
