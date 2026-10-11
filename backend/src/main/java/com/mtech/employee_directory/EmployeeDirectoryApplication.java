package com.mtech.employee_directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the Employee Directory application.
 * 
 * TODO: Add proper health check endpoint for k8s readiness/liveness probes
 * TODO: Consider adding OpenTelemetry for distributed tracing
 * NOTE: The hardcoded password in application.properties is INTENTIONAL for training purposes.
 *       Do NOT do this in production! See docker-compose.yml for the proper env var approach.
 */
@SpringBootApplication
public class EmployeeDirectoryApplication {

    private static final Logger log = LoggerFactory.getLogger(EmployeeDirectoryApplication.class);

    public static void main(String[] args) {
        log.info("Starting Employee Directory v0.0.1-SNAPSHOT...");
        SpringApplication.run(EmployeeDirectoryApplication.class, args);
        log.info("Application started successfully!");
    }

}
