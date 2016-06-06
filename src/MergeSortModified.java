public class MergeSortModified implements Sort {

	public int[] sort(int[] input) {
		mergeSortModified(input, 0, input.length - 1);

		return input;
	}

	private void mergeSortModified(int[] inputArray, int leftIndex,
			int rightIndex) {
		if (leftIndex < rightIndex) {
			int third = ((rightIndex - leftIndex) / 3) + leftIndex;
			int twoThirds = (rightIndex - leftIndex) / 3 + third;

			mergeSortModified(inputArray, leftIndex, third);
			mergeSortModified(inputArray, third + 1, twoThirds);
			mergeSortModified(inputArray, twoThirds + 1, rightIndex);

			merge(inputArray, leftIndex, ((leftIndex + twoThirds) / 2), twoThirds);
			merge(inputArray, third, ((third + rightIndex) / 2), rightIndex);
		}
	}

	private void merge(int[] originalArray, int leftIndex, int middleIndex,
			int rightIndex) {

		int sizeLeft = middleIndex - leftIndex + 1;
		int sizeRight = rightIndex - middleIndex;

		int[] leftArray = new int[sizeLeft + 1];
		int[] rightArray = new int[sizeRight + 1];

		arrayCopy(originalArray, leftArray, leftIndex);
		arrayCopy(originalArray, rightArray, middleIndex + 1);

		leftArray[leftArray.length - 1] = Integer.MAX_VALUE;
		rightArray[rightArray.length - 1] = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		for (int k = leftIndex; k <= rightIndex; k++) {
			if (leftArray[i] <= rightArray[j]) {
				originalArray[k] = leftArray[i++];
			} else {
				originalArray[k] = rightArray[j++];
			}
		}
	}

	// private method which gets two arrays and copy from source to dest, from
	// startIndex to endIndex
	private void arrayCopy(int[] srcArray, int[] destArray, int startIndex) {
		for (int i = 0; i < destArray.length - 1; i++) {
			destArray[i] = srcArray[i + startIndex];
		}
	}
}
