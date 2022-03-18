package com.in28minutes.database.databasedemo.jpa;


import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//Repository
@Repository
@Transactional
//Transaction: if we are inserting a bunch of things all at once either all of them should pass or all of them should fail if one fail, ideally this should be made in service but for this example lets keeps here
public class PersonJpaRepository {

    //connection to database
    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id){
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person){
        return entityManager.merge(person);
    }

    public Person insert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(int id){
        Person person = findById(id);
        entityManager.remove(person);
    }
}
