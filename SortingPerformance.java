package thirteen;

public class SortingPerformance {
	public static String formatHeader = "%-12s%-7s%-10s%-7s%-7s%n"; //s - first string; %n - new line; numbers - minimum rastoqnie
	public static String formatTimeData = "%,-12d%-7d%-10d%-7d%-7d%n";//d - cheli chisla
	
	public static void main(String[] args) {
		System.out.printf(formatHeader, "Array size", "Bubble", "Selection", "Merge", "Quick");
		
		compareSortingForElements(50_000);
		compareSortingForElements(100_000);
		compareSortingForElements(150_000);
		compareSortingForElements(200_000);
		compareSortingForElements(250_000);
		compareSortingForElements(300_000);
		compareSortingForElements(350_000);
		
//		int n = 50_000;
//		int[] arrB = new int[n];
//		int[] arrS = new int[n];
//		int[] arrM = new int[n];
//		int[] arrQ = new int[n];
//		for(int i = 0; i < n; i++) {
//			int element = (int) (Math.random() * 1000);
//			arrB[i] = element;
//			arrS[i] = element;
//			arrM[i] = element;
//			arrQ[i] = element;
//		}
//		
//		long timeB = 0, timeS = 0, timeM = 0, timeQ = 0;
//		
//		long currentTime = System.currentTimeMillis();
//		BubbleSort.bubbleSort(arrB);
//		timeB = System.currentTimeMillis() - currentTime;
//		
//		currentTime = System.currentTimeMillis();
//		MergeSort.mergeSort(arrM);
//		timeM = System.currentTimeMillis() - currentTime;
//		
//		currentTime = System.currentTimeMillis();
//		SelectionSort.selectionSort(arrS);
//		timeS = System.currentTimeMillis() - currentTime;
//		
//		currentTime = System.currentTimeMillis();
//		QuickSort.quickSort(arrQ);
//		timeQ = System.currentTimeMillis() - currentTime;
//		
//		String formatHeader = "%-12s%-7s%-10s%-7s%-7s%n"; //s - first string; %n - new line; numbers - minimum rastoqnie
//		String formatTimeData = "%,-12d%-7d%-10d%-7d%-7d%n";//d - cheli chisla
//		System.out.printf(formatHeader, "Array size", "Bubble", "Selection", "Merge", "Quick");
//		System.out.printf(formatTimeData, n, timeB, timeS, timeM, timeQ);
	}
	
	public static void compareSortingForElements(int n) {
		int[] arrB = new int[n];
		int[] arrS = new int[n];
		int[] arrM = new int[n];
		int[] arrQ = new int[n];
		for(int i = 0; i < n; i++) {
			int element = (int) (Math.random() * 1000);
			arrB[i] = element;
			arrS[i] = element;
			arrM[i] = element;
			arrQ[i] = element;
		}
		
long timeB = 0, timeS = 0, timeM = 0, timeQ = 0;
		
		long currentTime = System.currentTimeMillis();
		BubbleSort.bubbleSort(arrB);
		timeB = System.currentTimeMillis() - currentTime;
		
		currentTime = System.currentTimeMillis();
		MergeSort.mergeSort(arrM);
		timeM = System.currentTimeMillis() - currentTime;
		
		currentTime = System.currentTimeMillis();
		SelectionSort.selectionSort(arrS);
		timeS = System.currentTimeMillis() - currentTime;
		
		currentTime = System.currentTimeMillis();
		QuickSort.quickSort(arrQ);
		timeQ = System.currentTimeMillis() - currentTime;
		
		System.out.printf(formatTimeData, n, timeB, timeS, timeM, timeQ);
		
	}
}
