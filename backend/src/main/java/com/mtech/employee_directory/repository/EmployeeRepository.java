package com.mtech.employee_directory.repository;

import com.mtech.employee_directory.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Standard safe method - uses parameter binding internally
    List<Employee> findByNameContaining(String name);

    /**
     * INTENTIONALLY VULNERABLE: SQL Injection via string concatenation.
     * 
     * This mimics a common mistake where developers concatenate user input
     * directly into the query string instead of using parameter binding.
     * 
     * SonarQube rule: java:S2077 (SQL queries should not be vulnerable to injection attacks)
     * 
     * The concatenation '"%" + ":name" + "%"' breaks parameter binding - the :name
     * becomes part of the SQL string literal rather than a bound parameter.
     * 
     * Fix: Use @Query("SELECT e FROM Employee e WHERE e.name ILIKE %:name%")
     * or stick with the Spring Data method above (findByNameContaining).
     */
    @Query(value = "SELECT * FROM employee WHERE name ILIKE '%" + ":name" + "%'", nativeQuery = true)
    List<Employee> searchByNameUnsafe(@Param("name") String name);
}