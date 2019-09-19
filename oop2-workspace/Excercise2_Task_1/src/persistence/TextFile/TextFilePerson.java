package persistence.TextFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Person;
import persistence.PersonDAO;

public class TextFilePerson implements PersonDAO {
	private String path;

	public TextFilePerson(String path) {
		this.path = path;
	}

	@Override
	public void saveperson(List<Person> persons) {
		// TODO Auto-generated method stub
		PrintWriter out = null;

		try {
			File file = new File(path);
			file.createNewFile();
			out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), Charset.forName("UTF-8")));
			for (Person p : persons)
				out.println(p.toString());
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (out != null)
				out.close();
		}
	}

	@Override
	public List<Person> loadPerson() {
		// TODO Auto-generated method stub
		ArrayList<Person> persons = new ArrayList<>();
		Scanner scan = null;
		String line;
		try {
			scan = new Scanner(new File(path), "UTF-8");
			while (scan.hasNext()) {
				line = scan.nextLine();
				Person person = new Person(line);
				persons.add(person);
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (scan != null) {
				scan.close();
			}
		}
		return persons;
	}

}
