package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// String getCustomer (String usernumber) {
		// public static String getCustomer() {
		// BufferedReader reader = new BufferedReader(new FileReader(path +
		// "Customer.csv"));

		String[] fileLines = new String[5];
		fileLines[0] = "1;Mike;Mustermann;56487;48456;78865;45468";
		fileLines[1] = "2;Melisa;Musterfrau;56487;48456;78865;45468";
		fileLines[2] = "3;Moriz;Mustermensch;56487;48456;78865;45468";
		fileLines[3] = "4;Michael;Musterperson;56487;48456;78865;45468";
		fileLines[4] = "5;Mirco;Müller;56487;48456;78865;45468";

		String[] customerInfo = new String[7];

		for (int i = 0; i < fileLines.length; i++) {
			String[] line1 = new String[customerInfo.length];
			line1 = fileLines[i].split(";");
			System.out.printf("%s \n", line1);
			// System.out.println(fileLines[i]);
			class Customer {
				private String userId;
				private String firstName;
				private String lastName;
				private String password;
				private String id1;
				private String id2;
				private String id3;
				private String id4;

				public Customer(String userId, String firstName, String lastName, String id1, String id2, String id3,
						String id4) {
					this.userId = userId;
					this.firstName = firstName;
					this.lastName = lastName;
					this.id1 = id1;
					this.id2 = id2;
					this.id3 = id3;
					this.id4 = id4;

				}

				Customer customer;
				String path = (System.getProperty("user.dir") + "\\src\\Banksystem\\persistance\\");
				String line = "";

				public void getCustomer(String[] userInfo) throws IOException {
					BufferedReader reader = new BufferedReader(new FileReader(path + "Customer.csv"));
					// int nr = 0;
					while (reader.readLine() != null) {
						String[] tokens = line.split(";");
						customer = new Customer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5],
								tokens[6]);
					}
					System.out.println(customer);
				}

			}
			// }

		}

	}

}
