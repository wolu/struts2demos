package com.gamiao.struts2.demo.thirddemo.service;

import org.apache.log4j.Logger;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.gamiao.struts2.demo.thirddemo.bo.Person;

@Transactional
public class PersonServiceImpl implements PersonService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);

    private EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    public List<Person> findAll() {
		if (logger.isDebugEnabled()) {
			logger.debug("findAll() - start"); //$NON-NLS-1$
		}

        Query query = getEntityManager().createQuery("select p FROM Person p");
		List<Person> returnList = query.getResultList();
		if (logger.isDebugEnabled()) {
			logger.debug("findAll() - end"); //$NON-NLS-1$
		}
        return returnList;
    }

    public void save(Person person) {
		if (logger.isDebugEnabled()) {
			logger.debug("save(Person) - start"); //$NON-NLS-1$
		}

        if (person.getId() == null) {
            // new
            em.persist(person);
        } else {
            // update
            em.merge(person);
        }

		if (logger.isDebugEnabled()) {
			logger.debug("save(Person) - end"); //$NON-NLS-1$
		}
    }

    public void remove(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("remove(int) - start"); //$NON-NLS-1$
		}

        Person person = find(id);
        if (person != null) {
            em.remove(person);
        }

		if (logger.isDebugEnabled()) {
			logger.debug("remove(int) - end"); //$NON-NLS-1$
		}
    }

    private EntityManager getEntityManager() {
        return em;
    }

    public Person find(int id) {
		if (logger.isDebugEnabled()) {
			logger.debug("find(int) - start"); //$NON-NLS-1$
		}

		Person returnPerson = em.find(Person.class, id);
		if (logger.isDebugEnabled()) {
			logger.debug("find(int) - end"); //$NON-NLS-1$
		}
        return returnPerson;
    }

}
