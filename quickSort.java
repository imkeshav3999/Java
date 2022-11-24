public class quickSort {
    //pivot and partition
    //int return type:- to return the index of pivot
    //worst case: O(n^2) - IT OCCURS WHEN PIVOT IS ALWAYS THE SMALLEST OR THE LARGEST ELEMENT
    //avg case: O(n logn)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];//making last element = pivot
        //making space for elements smaller than pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //take pivot to the right index
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    public static void quick(int[] arr, int low, int high) {
        if (low < high) {
            int pivotidx = partition(arr, low, high);

            quick(arr, low, pivotidx - 1);
            quick(arr, pivotidx + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        quick(arr, 0, n - 1);
        //print
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
