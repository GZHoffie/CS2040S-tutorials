import java.util.Arrays;

// Quick Select algorithm
public class QuickSelect {

	public static int quickSelect(int[] a, int k) {
		return quickSelect(a, k, 0, a.length-1);
	}

	public static int quickSelect(int[] a, int k, int i, int j) {
		int pivotIdx= partition(a, i, j);
		if (pivotIdx == k) {
			return a[k];
		} else if (k < pivotIdx) {			
			return quickSelect(a, k, i, pivotIdx-1);
		} else {
			return quickSelect(a, k, pivotIdx+1, j);
		}
	}

	public static void swap(int[] a, int pos1, int pos2) {
		int temp = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = temp;
	}

	public static int partition(int[] a, int i, int j) {
		// partition data items in a[i..j]
		int p = a[i]; // p is the pivot, the i-th item
		int m = i;    // Initially S1 and S2 are empty

		for (int k=i+1; k<=j; k++) { // process unknown region
			if (a[k] < p) { // case 2: put a[k] to S1
				m++;
				swap(a,k,m);
			}
		}

		swap(a,i,m); // put the pivot at the right place
		return m;    // m is the pivot's final position
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 7, 12, 3, 5, -6, 3, 8, 2, 10, -3 };

		printArray(arr);
		System.out.println(quickSelect(arr, 3)); // 0-based rank
   		Arrays.sort(arr);
   		printArray(arr);
	}
}

