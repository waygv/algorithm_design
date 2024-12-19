public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) { // remember this condition is important
            return; 
        }
        
        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        
        mergeSort(left);
        mergeSort(right);

        
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        mergeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
