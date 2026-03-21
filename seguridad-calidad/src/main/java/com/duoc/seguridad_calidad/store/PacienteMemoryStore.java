package com.duoc.seguridad_calidad.store;

import com.duoc.seguridad_calidad.model.Paciente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

/**
 * Repositorio en memoria para pacientes.
 * Se usa en semana 1 para cumplir el requerimiento sin base de datos.
 */
@Component
public class PacienteMemoryStore {
    // Lista interna para almacenar pacientes en memoria.
    private final List<Paciente> pacientes = new ArrayList<>();
    // Secuencia atomica para generar IDs unicos de forma segura en concurrencia.
    private final AtomicLong sequence = new AtomicLong(1);

    // Metodo sincronizado para agregar un nuevo paciente, asignando un ID unico.
    public synchronized Paciente save(Paciente paciente) {
        // Se asigna ID incremental para simular una clave primaria.
        paciente.setId(sequence.getAndIncrement());
        pacientes.add(paciente);
        return paciente;
    }

    // Metodo sincronizado para obtener todos los pacientes, devolviendo una copia inmodificable.
    public synchronized List<Paciente> findAll() {
        // Se devuelve copia inmodificable para proteger el estado interno.
        return Collections.unmodifiableList(new ArrayList<>(pacientes));
    }

    // Metodo sincronizado para buscar un paciente por ID, devolviendo un Optional.
    // Devuelve un Optional para manejar casos donde el paciente no exista sin lanzar excepciones.
    public synchronized Optional<Paciente> findById(Long id) {
        return pacientes.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
