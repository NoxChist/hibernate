package ru.neto.dao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.neto.dao.model.Person;

import java.util.List;

@Repository
public class DbRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        List<Person> personList = entityManager.createQuery("""
                        select pers
                        from Person pers
                        where pers.city_of_living = :city_of_living
                        """, Person.class)
                .setParameter("city_of_living", city)
                .getResultList();
        personList.forEach(person -> System.out.println(person.toString()));

        return personList;
    }
}
