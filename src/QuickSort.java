public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10 ,8, 9, 1, 5, 4, 3, 11, 2, 7, 6};

        quicksort2(arr, 0, arr.length - 1);

        for(int i: arr)
            System.out.println(i);
    }

    static int[] quicksort(int[] arr) {
        int pivot = arr[arr.length - 1];

        System.out.println("pivot " + pivot);

        int indexAtual = 0;
        int posicaoDeTroca = -1;

        while (indexAtual != arr.length) {
            int valorAtual = arr[indexAtual];

            if (valorAtual < pivot) {
                posicaoDeTroca++;
                arr[indexAtual] = arr[posicaoDeTroca];
                arr[posicaoDeTroca] = valorAtual;
            }

            indexAtual++;
        }

        posicaoDeTroca++;

        arr[arr.length - 1] = arr[posicaoDeTroca];
        arr[posicaoDeTroca] = pivot;

        return arr;
    }

    static void quicksort2(int[] arr, int start, int end) {
        System.out.println("start/end = " + start + " | " + end);
        if (start < end) {
            int pivot = findPivotPosition(arr, start, end);

            quicksort2(arr, start, pivot - 1);
            quicksort2(arr, pivot + 1, end);
        }
    }

    static int findPivotPosition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int pivotFinalPosition = start - 1;

        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                pivotFinalPosition++;
                swap(arr, i, pivotFinalPosition);
            }
        }

        pivotFinalPosition++;

        swap(arr, pivotFinalPosition, end);

        return pivotFinalPosition;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}