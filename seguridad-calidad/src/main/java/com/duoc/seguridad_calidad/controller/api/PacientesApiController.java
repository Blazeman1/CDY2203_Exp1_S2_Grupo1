package com.duoc.seguridad_calidad.controller.api;

import com.duoc.seguridad_calidad.model.Paciente;
import com.duoc.seguridad_calidad.repository.PacienteRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pacientes")
public class PacientesApiController {

    private final PacienteRepository pacienteRepository;

    public PacientesApiController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PacienteRequest request) {
        if (request.nombre() == null || request.nombre().isBlank()
                || request.especie() == null || request.especie().isBlank()
                || request.raza() == null || request.raza().isBlank()
                || request.dueno() == null || request.dueno().isBlank()) {
            return ResponseEntity.badRequest().body("Todos los campos son obligatorios");
        }

        Paciente paciente = new Paciente(null, request.nombre(), request.especie(), request.raza(), request.edad(), request.dueno());
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(paciente));
    }

    public record PacienteRequest(String nombre, String especie, String raza, Integer edad, String dueno) {
    }
}
