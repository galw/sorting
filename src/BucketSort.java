import java.util.ArrayList;

public class BucketSort implements Sort{

	public int[] sort(int[] input) {
		int size = input.length;
		int[] output = new int[size];
		
		ArrayList<Integer> buckets[] = new ArrayList[size];
		
		int max = input[0];
		int min = input[0];
		
		// Initialize all the buckets and find the maximum value and the minimum value
		for (int i = 0; i < size; ++i) {
			buckets[i] = new ArrayList<Integer>();
			
			if (input[i] > max) {
				max = input[i];
			}
			if (input[i] < min) {
				min = input[i];
			}
		}
		
		int range = max - min + 1;
		
		// Add each element to his correct bucket
		for (int i = 0; i < size; i++) {
			
			int a = (input[i] - min);
			int b = size / range;
			int c = a * b;
			
			buckets[c].add(input[i]);
		}
		
		// Sort each bucket and arrange it into the final array
		int lastPos = 0;
		for (int i = 0; i < size; ++i) {
			int[] tmpArray = new int[buckets[i].size()];
			fillArray(buckets[i], tmpArray);

			countingSort(tmpArray);
			
			for (int j = 0; j < tmpArray.length; ++j) {
				output[lastPos + j] = tmpArray[j];
			}
			
			lastPos += tmpArray.length;
		}

		return output;
	}

	// Only for use our CountingSort
	private void countingSort(int[] tmpArray) {
		CountingSort a = new CountingSort();
		a.sort(tmpArray);
	}

	/**
	 * This method convert ArrayList Of Integers (non-primitive) to array of int (primitive)
	 * @param arrayList
	 * @param tmpArray
	 */
	private void fillArray(ArrayList<Integer> arrayList, int[] tmpArray) {
		for (int i = 0; i < arrayList.size(); ++i) {
			tmpArray[i] = arrayList.get(i).intValue();
		}
	}
}
