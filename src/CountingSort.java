public class CountingSort implements Sort {

	public int[] sort(int[] input) {
		int N = input.length;
		
		//two checks if the sorting process is unnecessary
		if (N == 0) {
			return null;
		}
		if (N == 1) {
			return input;
		}
		
		int[] output = new int[N];
		int min = findMin(input);
		int max = findMax(input);
		int range = max - min + 1;
		int[] countingArray = new int[range];

		// for each i, min <= i <= max, mark the number of element in "input"
		// with the value i
		for (int i = 0; i < N; i++) {
			countingArray[input[i] - min]++;
		}
		// for each i, min <= i <= max, mark the number of element in "input"
		// with the value <= i
		for (int i = 1; i < range; i++) {
			countingArray[i] += countingArray[i - 1];
		}
		// put the elements in their right position on "output"
		for (int i = N - 1; i >= 0; i--) {
			output[countingArray[input[i] - min] - 1] = input[i];
			countingArray[input[i] - min]--;
		}
		return output;
	}

	private int findMax(int[] input) {
		int max = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] > max) {
				max = input[i];
			}
		}
		return max;
	}

	private int findMin(int[] input) {
		int min = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] < min) {
				min = input[i];
			}
		}
		return min;
	}
}