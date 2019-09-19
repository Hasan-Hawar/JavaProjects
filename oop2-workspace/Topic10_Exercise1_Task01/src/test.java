import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String content = "Hello";
		BoxClass<Object> b = new BoxClass<Object>(content);
		System.out.println(b.getContent());

		BoxClass<BankAccount> b1 = new BoxClass<>(new BankAccount(11551, 11581, "CH011"));
		BankAccount account = b1.getContent();
		b1.getContent();
		System.out.println(account.getContent());

		List<BoxClass<String>> myList = new ArrayList<BoxClass<String>>();
		myList.add(new BoxClass<String>("My Name"));
		myList.add(new BoxClass<String>("Your Namr"));
		for (BoxClass<String> BXC : myList) {
			System.out.println(BXC.getContent());
		}

	}

}
