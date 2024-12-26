public class Test {
	private final static Helper helper = new Helper();

	public static void main(String[] args) {
		int[] left = helper.createArray(0, "Left Array:"), right = helper.createArray(0, "Right Array:");

		int[] array = helper.concatenate(left, right);

		int[] merged = new SortAlgorithms().mergeSort(array);

		helper.displayArray(merged, "Merged Array:");
	}


}
