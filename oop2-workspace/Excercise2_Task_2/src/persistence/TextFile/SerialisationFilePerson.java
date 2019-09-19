package persistence.TextFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import application.Person;
import persistence.PersonDAO;

public class SerialisationFilePerson implements PersonDAO {
	private String path;

	public SerialisationFilePerson(String path) {
		this.path = path;
	}

	@Override
	public void saveperson(List<Person> persons) {
		// TODO Auto-generated method stub
		ObjectOutputStream out = null;

		try {
			out = new ObjectOutputStream(new FileOutputStream(path));
			out.writeObject(persons);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			if (out != null)
				try {
					out.close();
				} catch (IOException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
		}
	}

	@Override
	public List<Person> loadPerson() {
		// TODO Auto-generated method stub
		ArrayList<Person> persons = new ArrayList<>();
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(path));
			persons = (ArrayList<Person>) in.readObject();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e2) {

				}
			}

		}
		return persons;
	}
}