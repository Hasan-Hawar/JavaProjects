package persistence;

import java.util.List;

import model.Person;

public interface PersonDAO {
	void save(List<Person> persons) throws PersistenceException ;
	List<Person> load() throws PersistenceException;
}
