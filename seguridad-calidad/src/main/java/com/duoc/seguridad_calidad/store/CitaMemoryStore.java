package com.duoc.seguridad_calidad.store;

import com.duoc.seguridad_calidad.model.Cita;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

/**
 * Repositorio en memoria para citas.
 * Mantiene almacenamiento temporal coherente con el alcance academico.
 */
@Component
public class CitaMemoryStore {
    // Lista interna para almacenar citas en memoria.
    private final List<Cita> citas = new ArrayList<>();
    // Secuencia atomica para generar IDs unicos de forma segura en concurrencia.
    private final AtomicLong sequence = new AtomicLong(1);

    // Metodo sincronizado para agregar una nueva cita, asignando un ID unico.
    public synchronized Cita save(Cita cita) {
        // ID incremental para identificar cada cita en la interfaz.
        cita.setId(sequence.getAndIncrement());
        citas.add(cita);
        return cita;
    }

    // Metodo sincronizado para obtener todas las citas, devolviendo una copia inmodificable.
    public synchronized List<Cita> findAll() {
        // Copia defensiva para evitar modificaciones externas.
        return Collections.unmodifiableList(new ArrayList<>(citas));
    }
}
