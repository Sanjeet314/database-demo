package com.in28minutes.database.databasedemo.jdbc;

import com.in28minutes.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDAO {


    @Autowired
    JdbcTemplate jdbcTemplate; //jdbctemplate is autowired with database connection and we can use its functions to manipulate or play with db related things, ex: creating table

    class PersonRowMapper implements RowMapper<Person>{
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthDate(rs.getTimestamp("birth_date"));
            return person;
        }
    }



    //select * from person we want to execute from here
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new PersonRowMapper());
    }

    //using bean property row mapper, but sometime there could be mismatch in column names of data from sql query and person object
//    public List<Person> findAll() {
//        return jdbcTemplate.query("select * from person",
//                new BeanPropertyRowMapper(Person.class));
//    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    //returns number of rows actually got affected by query, look for delete or Update function used will be update only from jdbctemplate
    public int deletebyId(int id) {
        return jdbcTemplate.update("delete from person where id=?",
                new Object []{id});
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "insert into person (id, name, location, birth_date)" +
                        "values(?, ? ,?, ?)",
                new Object[] {
                        person.getId(), person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime())
                });
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "update person " + " set name = ?, location = ?, birth_date = ? " +
                        " where id = ?",
                new Object[] {
                        person.getName(),
                        person.getLocation(),
                        new Timestamp(person.getBirthDate().getTime()), person.getId()
                });
    }



}
