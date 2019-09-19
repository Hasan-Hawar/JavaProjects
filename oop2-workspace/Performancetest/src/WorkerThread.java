import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkerThread implements Runnable {

	List<String> list = Collections.synchronizedList(new ArrayList<>());

	public WorkerThread(List<String> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < 10000; i++) {

			Integer rand1 = (int) Math.ceil(Math.random() * 1000000);

			Integer rand2 = (int) Math.ceil(Math.random() * 1000000);

			Integer getIndex = list.indexOf(String.valueOf(rand1));
			list.add(String.valueOf(rand2));
		}

	}
}