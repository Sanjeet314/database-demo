package com.in28minutes.database.databasedemo;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;
import com.in28minutes.database.databasedemo.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataDemoApplicaton implements CommandLineRunner {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDemoApplicaton.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("User by ID 1000001 -> {}",repository.findById(1000001));
        logger.info("Insert by ID 1000004 {}",repository.save(new Person("Tara", "Berlin", new Date())));
        logger.info("Update by ID 1000003-> {}",repository.save(new Person(1000003, "Zain", "Turkey", new Date())));
        repository.deleteById(1000002);
        logger.info("All users -> {}",repository.findAll());

//        logger.info("All users -> {}",dao.findAll());
//        logger.info("Delete by ID 1000002, Number of rows deleted -> {}",dao.deletebyId(1000002));
//        logger.info("Insert by ID 1000004 {}",dao.insert(new Person(1000004, "Tara", "Berlin", new Date())));
//        logger.info("Update by ID 1000003-> {}",dao.update(new Person(1000003, "Zain", "Turkey", new Date())));

    }
}
