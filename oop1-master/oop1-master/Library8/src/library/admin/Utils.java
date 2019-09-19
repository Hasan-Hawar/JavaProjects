package library.admin;

import java.util.ArrayList;

import library.data.Item;

public class Utils {

	public static long[] addNumber(long[] numbers, long newNumber) {
		if (numbers == null) {
			numbers = new long[1];
			numbers[0] = newNumber;
			return numbers;
		}
		long[] newNumbers = new long[numbers.length + 1];
		System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
		newNumbers[numbers.length] = newNumber;
		return newNumbers;
	}

	public static long[] addNumbers(long[] array1, long[] array2) {
		if (array1 == null)
			return array2;
		if (array2 == null)
			return array1;
		long[] newNumbers = new long[array1.length + array2.length];
		System.arraycopy(array1, 0, newNumbers, 0, array1.length);
		System.arraycopy(array2, array1.length, newNumbers, 0, array2.length);
		return newNumbers;
	}
	public static Item[] findMethod(Item[]... arrays) {
		int n = 0;
		for (Item[] array : arrays) {
			n += array.length;
		}
		Item[] lastArray = new Item[n];
		int i = 0;
		for (Item[] array : arrays) {
			for (Item element : array) {
				lastArray[i] = element;
				i++;
			}
		}
		return lastArray;
	}

	public static long[] toArrayList(ArrayList<Long> list) {
		long[] ItemId = new long[list.size()];
		int n = 0;
		for (Long item : list) {
			ItemId[n] = item;
			n++;
		}
		return ItemId;
	}

}
