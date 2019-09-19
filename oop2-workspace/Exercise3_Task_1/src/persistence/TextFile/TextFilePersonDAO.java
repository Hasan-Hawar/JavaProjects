package persistence.TextFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Person;
import persistence.PersistenceException;
import persistence.PersonDAO;

public class TextFilePersonDAO implements PersonDAO {
	private String path;
	private File file;

	public TextFilePersonDAO(File file) {
		this.file = file;
	}

	@Override
	public void saveperson(List<Person> persons) throws PersistenceException {
		// TODO Auto-generated method stub

		try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
			for (Person p : persons) {
				out.print(p.toString());
			}

		} catch (IOException e) {
			// TODO: handle exception
			throw new PersistenceException();

		}
	}

	@Override
	public List<Person> loadPerson() throws PersistenceException {
		// TODO Auto-generated method stub
		ArrayList<Person> persons = new ArrayList<>();
		try (Scanner in = new Scanner(new FileReader(file))) {
			parseFile(persons, in);
		} catch (

		FileNotFoundException e) {
			// TODO: handle exception
			throw new PersistenceException();
		}
		return persons;
	}

	public void parseFile(ArrayList<Person> persons, Scanner in) throws PersistenceParseFileException {
		int lineNm = 0;
		while (in.hasNext()) {
			String line = in.nextLine();
			lineNm++;
			if (!line.isEmpty()) {
				try {
					Person p = new Person(line);
					persons.add(p);
				} catch (NullPointerException | IllegalArgumentException | DateTimeException e) {
					throw new PersistenceParseFileException(file.getAbsolutePath(), lineNm, line, e);
				}
			}
		}
	}

}
