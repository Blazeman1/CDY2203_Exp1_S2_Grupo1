package com.duoc.seguridad_calidad.config;

import com.duoc.seguridad_calidad.model.AppUser;
import com.duoc.seguridad_calidad.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataSeederConfig {

    @Bean
    CommandLineRunner seedUsers(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() > 0) {
                return;
            }

            userRepository.save(new AppUser(null, "admin", passwordEncoder.encode("admin123"), "ADMIN"));
            userRepository.save(new AppUser(null, "vet", passwordEncoder.encode("vet123"), "VETERINARIO"));
            userRepository.save(new AppUser(null, "recep", passwordEncoder.encode("recep123"), "RECEPCION"));
        };
    }
}
