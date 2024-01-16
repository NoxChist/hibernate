package ru.neto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neto.dao.model.Person;
import ru.neto.dao.repository.DbRepository;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HibernateController {
    private final DbRepository repository;

    public HibernateController(DbRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) throws SQLException {
        return repository.getPersonsByCity(city);
    }
}
