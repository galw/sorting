public class MergeSort implements Sort {

	public int[] sort(int[] input) {
		mergeSort(input, 0, input.length - 1);
		
		return input;
	}

	private void mergeSort(int[] originalArray, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;
			mergeSort(originalArray, leftIndex, middleIndex);
			mergeSort(originalArray, middleIndex + 1, rightIndex);
			merge(originalArray, leftIndex, middleIndex, rightIndex);
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
	
	// private method which gets to arrays and copy from source to dest, from startIndex to endIndex
	private void arrayCopy(int[] srcArray, int[] destArray,
			int startIndex) {
		for (int i = 0; i < destArray.length - 1; i++) {
			destArray[i] = srcArray[i + startIndex];
		}
	}
}