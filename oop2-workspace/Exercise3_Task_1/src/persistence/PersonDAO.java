package persistence;

import java.util.List;

import application.Person;

public interface PersonDAO {

	public void saveperson(List<Person> persons) throws PersistenceException;

	List<Person> loadPerson() throws PersistenceException;
}
