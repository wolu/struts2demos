package com.gamiao.struts2.demo.thirddemo.service;

import java.util.List;

import com.gamiao.struts2.demo.thirddemo.bo.Person;

public interface PersonService {
    public List<Person> findAll();

    public void save(Person person);

    public void remove(int id);

    public Person find(int id);
}
