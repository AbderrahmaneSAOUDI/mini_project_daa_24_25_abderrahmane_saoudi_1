import java.util.Scanner;

public class ApplyChoices {
	private final ConsoleTexts console = new ConsoleTexts();
	private final Style style = new Style();
	private final Helper help = new Helper();

	protected static int[] array;
	private int[] times = new int[7];;

	protected void sortORsearch(int _choice) {
		if (_choice == 1) {
			console.fillType();
			int choice = help.getInt(">\t\t", -1, 2);
			fillType(choice);
		} else if (_choice == 2) {
			// TODO : "[2] Search Algorithms"
		} else if (_choice == 0) console.thanks();
		else console.error("Invalid choice");
	}

	protected void fillType(int _choice) {
		if (_choice == 1) {
			console.fillManual();
			int choice = help.getInt(">\t\t", -1, 2);
			fillManual(choice);
		} else if (_choice == 2) {
			System.out.println("\n");
			System.out.println("Enter the size of the array");
			int size = help.getInt(">\t\t", 1, 1000000000);
			fillRandom(size);
		} else if (_choice == 3) {
			console.sortAlgorithms();
			int choice = help.getInt(">\t\t", 7);
			sortAlgorithms(choice);
		} else if (_choice == 0) console.thanks();
		else if (_choice == -1) {
			console.sortORsearch();
			int choice = help.getInt(">\t\t", 2);
			sortORsearch(choice);
		} else console.error("Invalid choice");
	}

	protected void fillManual(int _choice) {
		if (_choice == 1) {
			console.fillManualFixed();
			int size = help.getInt(">\t\t");
			fillManualFixed(size);
		} else if (_choice == 2) fillManualDynamic();
		else if (_choice == 0) console.thanks();
		else if (_choice == -1) {
			console.fillType();
			int choice = help.getInt(">\t\t", -1, 2);
			fillType(choice);
		} else console.error("Invalid choice");
	}

	protected void fillManualFixed(int _size) {
		array = new int[_size];
		help.fillArrayManual();

		console.fillType();
		int choice = help.getInt(">\t\t", -1, 2);
		fillType(choice);
	}

	protected void fillManualDynamic() {
		console.fillManualDynamic();
		help.fillDynamicArray();

		console.fillType();
		int choice = help.getInt(">\t\t", -1, 2);
		fillType(choice);
	}
	
	protected void fillRandom (int _size) {
		System.out.println("Filling the array with random values...");
		help.fillArrayRandom(_size);
		System.out.println("Array filled with random values");

		console.sortAlgorithms();
		int choice = help.getInt(">\t\t", 7);
		sortAlgorithms(choice);
	}

	protected void sortAlgorithms(int _algorithm) {
		if (_algorithm == 0) {
			console.thanks();
			return;
		}
		times[_algorithm - 1] = help.calculateTime(array, _algorithm);

		console.sortAlgorithms();
		int choice = help.getInt(">\t\t", 7);
		sortAlgorithms(choice);
	}
}
