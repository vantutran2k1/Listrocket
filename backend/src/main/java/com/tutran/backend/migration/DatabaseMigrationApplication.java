package com.tutran.backend.migration;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DatabaseMigrationApplication implements CommandLineRunner {

    private final Flyway flyway;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseMigrationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        runMigrations();
    }

    private void runMigrations() {
        flyway.migrate();
    }

}
