import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Helper {
	//	-----------------[ void fillArrayFromParent ]-----------------
	protected void fillArrayFromParent(int[] _parent, int[] _array, int start, int end) {
		int j = 0;
		for (int i = start; i <= end; i++) {
			_array[j++] = _parent[i];
		}
	}


	//	-----------------[ void fillArrayManual ]-----------------
	protected void fillArrayManual() {
		int value;
		for (int i = 0; i < ApplyChoices.array.length; i++) {
			value = getInt("[" + (i + 1) + "] >\t");
			ApplyChoices.array[i] = value;
		}
	}

	protected void fillDynamicArray() {
		ArrayList<Integer> list = new ArrayList<>();
		int value;
		int i = 0;
		do {
			value = getInt("[" + ++i + "] >\t");
			if (value >= 0) list.add(value);
		} while (value >= 0);

		ApplyChoices.array = convertListToArray(list);
	}


	//	-----------------[ void fillArrayRandom ]-----------------
	protected void fillArrayRandom() {
		Random r = new Random();
		for (int i = 0; i < ApplyChoices.array.length; i++) {
			ApplyChoices.array[i] = r.nextInt(100);
		}
	}

	protected void fillArrayRandom(boolean _zeroIncluded) {
		Random r = new Random();
		if (_zeroIncluded) for (int i = 0; i < ApplyChoices.array.length; i++)
			ApplyChoices.array[i] = r.nextInt(101);
		else for (int i = 0; i < ApplyChoices.array.length; i++)
			ApplyChoices.array[i] = r.nextInt(100) + 1;
	}

	protected void fillArrayRandom(int _size) {
		Random r = new Random();
		ApplyChoices.array = new int[_size];
		for (int i = 0; i < _size; i++) {
			ApplyChoices.array[i] = r.nextInt(_size * 3);
		}
	}

	protected void fillArrayRandom(int _size, boolean _zeroIncluded) {
		Random r = new Random();
		if (_zeroIncluded) for (int i = 0; i < _size; i++)
			ApplyChoices.array[i] = r.nextInt(_size * 3);
		else for (int i = 0; i < ApplyChoices.array.length; i++)
			ApplyChoices.array[i] = r.nextInt(_size * 3) + 1;
	}


	//	-----------------[ void displayArray ]-----------------
	protected void displayArray(int[] _array) {
		System.out.println("\n");
		for (int i = 0; i < _array.length; i++)
			System.out.print(_array[i] + "\t\t");
	}

	protected void displayArray(int[] _array, String text) {
		System.out.println("\n" + text);
		for (int i = 0; i < _array.length; i++)
			System.out.print(_array[i] + "\t\t");
	}

	//	-----------------[ int[] concatenate ]-----------------
	protected int[] concatenate(int[] _left, int[] _right) {
		int[] copy = new int[_left.length + _right.length];
		int j = 0;
		for (int i = 0; i < _left.length; i++) copy[j++] = _left[i];
		for (int i = 0; i < _right.length; i++) copy[j++] = _right[i];
		return copy;
	}

	protected int[] concatenate(int[] _left, int[] _right, String text) {
		int[] copy = new int[_left.length + _right.length];
		int j = 0;
		for (int i = 0; i < _left.length; i++) copy[j++] = _left[i];
		for (int i = 0; i < _right.length; i++) copy[j++] = _right[i];
		displayArray(copy, text);
		return copy;
	}


	//	-----------------[ int[] createArray ]-----------------
	protected int[] createArray() {
		int[] array = new int[new Random().nextInt(10) + 1];
		fillArrayRandom();
		return array;
	}

	protected int[] createArray(String text) {
		int[] array = new int[new Random().nextInt(10) + 1];
		fillArrayRandom();
		displayArray(array, text);
		return array;
	}

	protected int[] createArray(int _size) {
		int[] array = new int[(_size < 1) ? new Random().nextInt(10) + 1 : _size];
		fillArrayRandom();
		return array;
	}

	protected int[] createArray(int _size, String text) {
		int[] array = new int[(_size < 1) ? new Random().nextInt(10) + 1 : _size];
		fillArrayRandom();
		displayArray(array, text);
		return array;
	}


	//	-----------------[ int[] createArrayManual ]-----------------
	protected int calculateTime(int[] _array, int _algorithm) {
		int[] sortedArray = new int[_array.length];
		SortAlgorithms algorithms = new SortAlgorithms();
		int startTime = (int) System.currentTimeMillis();
		if (_algorithm == 1)      sortedArray = algorithms.selectionSort(_array);
		else if (_algorithm == 2) sortedArray = algorithms.insertionSort(_array);
		else if (_algorithm == 3) sortedArray = algorithms.bubbleSort(_array);
		else if (_algorithm == 4) sortedArray = algorithms.mergeSort(_array);
		else if (_algorithm == 5) sortedArray = algorithms.quickSort(_array);
		else if (_algorithm == 6) sortedArray = algorithms.heapSort(_array);
		else if (_algorithm == 7) sortedArray = algorithms.shellSort(_array);
		else return -1;
		int endTime = (int) System.currentTimeMillis();
		int time = endTime - startTime;
		System.out.println("Time complexity for : " + time + "ms");
		return time;
	}


	//	-----------------[ Other Methods ]-----------------
	protected void swapValues(int[] _array, int _i, int _j) {
		if (_i < _array.length && _j < _array.length) {
			int x = _array[_j];
			_array[_j] = _array[_i];
			_array[_i] = x;
		}
	}

	private int[] convertListToArray(ArrayList<Integer> _list) {
		int[] array = new int[_list.size()];
		for (int i = 0; i < array.length; i++)
			array[i] = _list.get(i);
		return array;
	}


	//	-----------------[ int getInt ]-----------------
	protected int getInt(String _text) {
		Scanner input = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.print(_text + Style.GREEN);
			try {
				choice = input.nextInt();
			} catch (InputMismatchException e) {
			}
			System.out.print(Style.RESET);
		} while (choice < 0);
		return choice;
	}

	protected int getInt(String _text, int _max) {
		return getInt(_text, 0, _max);
	}

	public int getInt(String _text, int _min, int _max) {
		Scanner input = new Scanner(System.in);
		int choice = -5;
		do {
			System.out.print(_text + Style.GREEN);
			try {
				choice = input.nextInt();
			} catch (InputMismatchException e) {
			}
			System.out.print(Style.RESET);
		} while (choice < _min || choice > _max);
		return choice;
	}
}
