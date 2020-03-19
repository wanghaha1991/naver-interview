package offer;

public class 旋转数组的最小数字 {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left<right){
            int mid = (left+right)/2;
            //mid > right 左侧数组有序
            if (numbers[mid] > numbers[right]){
                left = mid + 1;

            }
            //mid < right 右侧有序
            else if (numbers[mid] < numbers[right]){
                right = mid;
            }
            //mid == right 保守减小区间
           else {
               right --;
           }
        }
        return numbers[left];
    }

}
