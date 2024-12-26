public class SortAlgorithms {
	protected final Helper helper = new Helper();

	protected int[] selectionSort(int[] _array) {
		for (int i = 0; i < _array.length; i++) {
			int min_index = i;
			for (int j = i + 1; j < _array.length; j++)
				if (_array[min_index] > _array[j]) min_index = j;
			helper.swapValues(_array, i, min_index);
		}
		return _array;
	}

	protected int[] insertionSort(int[] _array) {
		for (int i = 1; i < _array.length; i++) {
			int temp = _array[i], j = i - 1;
			while (j >= 0 && _array[j] > temp) _array[j + 1] = _array[j--];
			_array[j + 1] = temp;
		}
		return _array;
	}

	protected int[] bubbleSort(int[] _array) {
		for (int i = _array.length - 1; i >= 0; i--)
			for (int j = 0; j < i; j++)
				if (_array[j] > _array[i]) helper.swapValues(_array, j, i);
		return _array;
	}

	protected int[] mergeSort(int[] _array) {
		if (_array.length == 1) return _array;
		else {
			int mid = _array.length / 2;
			int[] left = new int[mid], right = new int[_array.length - mid];
			helper.fillArrayFromParent(_array, left, 0, mid - 1);
			helper.fillArrayFromParent(_array, right, mid, _array.length - 1);
			return merge(mergeSort(left), mergeSort(right));
		}
	}

	protected int[] quickSort(int[] _array) {
		return l_quickSort(_array, 0, _array.length - 1);
	}

	protected int[] shellSort(int[] _array) {
		int n = _array.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int temp = _array[i], j;
				for (j = i; j >= gap && _array[j - gap] > temp; j -= gap) _array[j] = _array[j - gap];
				_array[j] = temp;
			}
		}
		return _array;
	}

	protected int[] shellSort(int[] _array, int _gap) {
		int n = _array.length;
		for (int gap = _gap; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int temp = _array[i], j;
				for (j = i; j >= gap && _array[j - gap] > temp; j -= gap) _array[j] = _array[j - gap];
				_array[j] = temp;
			}
		}
		return _array;
	}

	protected int[] heapSort(int[] _array) {
		int n = _array.length;
		for (int i = n / 2 - 1; i >= 0; i--)
			swapHeap(_array, i, n);
		for (int i = n; i >= 0; i--) {
			helper.swapValues(_array, i, 0);
			swapHeap(_array, 0, i);
		}
		return _array;
	}


	//	-----------------[ Private Methods ]-----------------
	private void swapHeap(int[] _array, int _root, int _length) {
		int max = _root;
		int left = 2 * _root + 1;
		int right = 2 * _root + 2;

		if (left < _length && _array[left] > _array[max]) max = left;
		if (right < _length && _array[right] > _array[max]) max = right;
		if (max != _root) {
			helper.swapValues(_array, max, _root);
			swapHeap(_array, _length, max);
		}
	}

	private int[] merge(int[] _left, int[] _right) {
		int[] sorted = new int[_left.length + _right.length];
		int i = 0, j = 0, k = 0;
		while (i < _left.length && j < _right.length) if (_left[i] <= _right[j]) sorted[k++] = _left[i++];
		else sorted[k++] = _right[j++];
		while (i < _left.length) sorted[k++] = _left[i++];
		while (j < _right.length) sorted[k++] = _right[j++];
		return sorted;
	}

	private int[] l_quickSort(int[] _array, int _low, int _high) {
		if (_low < _high) {
			int pivot = partition(_array, _low, _high);
			l_quickSort(_array, _low, pivot - 1);
			l_quickSort(_array, pivot + 1, _high);
		}
		return _array;
	}

	private int partition(int[] _array, int _low, int _high) {
		int pivot = _array[_high];
		int i = _low - 1;
		for (int j = _low; j < _high; j++) {
			if (_array[j] < pivot) {
				i++;
				helper.swapValues(_array, i, j);
			}
		}
		helper.swapValues(_array, i + 1, _high);
		return i + 1;
	}
}
