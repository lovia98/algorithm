package com.example.algorithm.book;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * 선택 정렬
 *  1. 배열의 첫번째 숫자와 나머지의 숫자를 비교하면서 가장 최소 숫자를 찾아 위치를 바꾼다.
 *  2. 그 이후 자리수의 숫자도 같은 방법으로 위치를 변경 한다.
 *  3. 자리수를 옮겨서 탐색 할때 마다 loop의 횟수가 1씩 감소 하지만 반 이상이 되기 때문에
 *     알고리즘 수행 시간은 O(n제곱)만큼 걸린다.
 */
public class SelectionSort {

    public static void main(String ...args) {
        int[] array = {2, 3, 5, 6, 1, 7};
        selectionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void selectionSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            int indexOfLowest = indexLowest(array, i);
            swapElements(array, i, indexOfLowest);
        }
    }

    private static void swapElements(int[] array, int i, int indexOfLowest) {
        int temp = array[i];
        array[i] = array[indexOfLowest];
        array[indexOfLowest] = temp;
    }

    private static int indexLowest(int[] array, int start) {
        int lowIndex = start;
        for (int i = start; i < array.length; i++) {
            if(array[i] < array[lowIndex]) {
              lowIndex = i;
            }
        }
        return lowIndex;
    }
}
