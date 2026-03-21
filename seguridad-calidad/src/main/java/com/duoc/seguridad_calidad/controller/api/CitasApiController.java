package com.duoc.seguridad_calidad.controller.api;

import com.duoc.seguridad_calidad.model.Cita;
import com.duoc.seguridad_calidad.model.Paciente;
import com.duoc.seguridad_calidad.repository.CitaRepository;
import com.duoc.seguridad_calidad.repository.PacienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/citas")
public class CitasApiController {

    private final CitaRepository citaRepository;
    private final PacienteRepository pacienteRepository;

    public CitasApiController(CitaRepository citaRepository, PacienteRepository pacienteRepository) {
        this.citaRepository = citaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody CitaRequest request) {
        if (request.fecha() == null || request.fecha().isBlank()
                || request.hora() == null || request.hora().isBlank()
                || request.motivo() == null || request.motivo().isBlank()
                || request.veterinario() == null || request.veterinario().isBlank()) {
            return ResponseEntity.badRequest().body("Todos los campos son obligatorios");
        }

        Optional<Paciente> paciente = pacienteRepository.findById(request.pacienteId());
        if (paciente.isEmpty()) {
            return ResponseEntity.badRequest().body("Paciente no encontrado");
        }

        Cita cita = new Cita(
                null,
                request.pacienteId(),
                paciente.get().getNombre(),
                request.fecha(),
                request.hora(),
                request.motivo(),
                request.veterinario());

        return ResponseEntity.status(HttpStatus.CREATED).body(citaRepository.save(cita));
    }

    public record CitaRequest(Long pacienteId, String fecha, String hora, String motivo, String veterinario) {
    }
}
