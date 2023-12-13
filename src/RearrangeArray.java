public class RearrangeArray {
    public static void rearrange(int[] arr) {
        int n = arr.length;

        // Separate positive and negative numbers using the
        // two-pointer approach
        int i = -1;
        for (int j = 0; j < n; j++) {
            if (arr[j] < 0) {
                i++;
                swap(arr, i, j);
            }
        }

        // Now, 'i' points to the last negative number
        int posIndex = i + 1;
        int negIndex = 0;

        // Rearrange the array by alternating positive and negative numbers
        while (posIndex < n && negIndex < posIndex && arr[negIndex] < 0) {
            swap(arr, negIndex, posIndex);
            posIndex++;
            negIndex += 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        rearrange(arr);

        // Print the rearranged array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
