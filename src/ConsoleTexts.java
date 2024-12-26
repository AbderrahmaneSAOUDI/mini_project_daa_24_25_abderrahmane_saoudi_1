import java.util.Scanner;

public class ConsoleTexts {
	private Helper help = new Helper();

	protected void error(String _message) {
		System.out.println(new Style().colorize(_message, Style.RED));
	}

	protected void welcome() {
		System.out.println("__________________________________________________");
		System.out.println("|    WELCOME TO SORTING ALGORITHMS COMPARISON    |");
		System.out.println("|          made by: Abderrahmane SAOUDI          |");
		System.out.println("|________________________________________________|");
	}

	protected void thanks() {
		System.out.println("\n");
		System.out.println("__________________________________________________");
		System.out.println("|    THANK YOU FOR USING THIS APPLICATION        |");
		System.out.println("|        made by: Abderrahmane SAOUDI            |");
		System.out.println("|________________________________________________|");
	}

	protected String gettext() {
		Scanner input = new Scanner(System.in);
		System.out.print(">\t" + Style.GREEN);
		return input.nextLine() + Style.RESET;
	}

	protected void sortORsearch() {
		System.out.println("\n");
		System.out.println("[1] Sort Algorithms");
		System.out.println("[2] Search Algorithms");
		System.out.println("[0] Exit");
	}

	protected void fillType() {
		System.out.println("\n");
		System.out.println("Array fill type:");
		System.out.println("[1] Manual");
		System.out.println("[2] Random");
		System.out.println("[3] I Already have entered an array");
		System.out.println("[0] Exit");
		System.out.println("[-1] Back");
	}

	protected void fillManual() {
		System.out.println("\n");
		System.out.println("Array Size Type:");
		System.out.println("[1] Fixed");
		System.out.println("[2] Dynamic");
		System.out.println("[0] Exit");
		System.out.println("[-1] Back");
	}

	protected void fillManualFixed() {
		System.out.println("\n");
		System.out.println("Array Size:");
	}

	protected void fillManualDynamic() {
		System.out.println("\n");
		System.out.println("Start entering values, enter -1 to stop");
	}

	protected void sortAlgorithms() {
		System.out.println("\n\n");
		System.out.println("choose a sorting algorithms to calculate the time complexity");
		System.out.println("[1] Selection Sort");
		System.out.println("[2] Insertion Sort");
		System.out.println("[3] Bubble Sort");
		System.out.println("[4] Merge Sort");
		System.out.println("[5] Quick Sort");
		System.out.println("[6] Heap Sort");
		System.out.println("[7] Shell Sort");
		System.out.println("[0] Exit");
	}
}
