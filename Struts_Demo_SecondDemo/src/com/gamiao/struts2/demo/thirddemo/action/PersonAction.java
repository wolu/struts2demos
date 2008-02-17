package com.gamiao.struts2.demo.thirddemo.action;

import org.apache.log4j.Logger;

import java.util.List;

import com.gamiao.struts2.demo.thirddemo.bo.Person;
import com.gamiao.struts2.demo.thirddemo.service.PersonService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class PersonAction implements Preparable {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PersonAction.class);

    private PersonService service;
    private List<Person> persons;
    private Person person;
    private Integer id;

    public PersonAction(PersonService service) {
        this.service = service;
    }

    public String execute() {
		if (logger.isDebugEnabled()) {
			logger.debug("execute() - start"); //$NON-NLS-1$
		}

        this.persons = service.findAll();

		if (logger.isDebugEnabled()) {
			logger.debug("execute() - end"); //$NON-NLS-1$
		}
        return Action.SUCCESS;
    }

    public String save() {
		if (logger.isDebugEnabled()) {
			logger.debug("save() - start"); //$NON-NLS-1$
		}

        this.service.save(person);
        this.person = new Person();
		String returnString = execute();
		if (logger.isDebugEnabled()) {
			logger.debug("save() - end"); //$NON-NLS-1$
		}
        return returnString;
    }

    public String remove() {
		if (logger.isDebugEnabled()) {
			logger.debug("remove() - start"); //$NON-NLS-1$
		}

        service.remove(id);
		String returnString = execute();
		if (logger.isDebugEnabled()) {
			logger.debug("remove() - end"); //$NON-NLS-1$
		}
        return returnString;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void prepare() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("prepare() - start"); //$NON-NLS-1$
		}

        if (id != null)
            person = service.find(id);

		if (logger.isDebugEnabled()) {
			logger.debug("prepare() - end"); //$NON-NLS-1$
		}
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
