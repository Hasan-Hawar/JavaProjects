import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class MainStrem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> list = Arrays.asList("a1", "b2", "d2", "d5", "d1", "d7");

		list.stream().map(String::toUpperCase).sorted().forEach(System.out::println);

		IntStream intStream = new Random().ints(1, 15);
		System.out.println();

	}

}
