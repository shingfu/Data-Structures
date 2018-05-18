/**
 *    用递归的方法求数组元素和
 *
 *    注意：
 *    注意递归函数的宏观语义------ 递归函数就是一个函数，完成一个功能（A方法里面调b方法 与 A方法里面调A方法 没什么不同）
 */


public class Sum {
    private static int sum(int[] arr){
        return sum(arr,0);
    }

    //计算 arr[l...n) 范围里的数字和
    private static int sum(int[] arr,int l){
        if(l == arr.length)                          // 递归分两部分
            return 0;                                // 1）求解最基本问题

        return arr[l]+sum(arr,l+1);               // 2）把原问题转化成最小的问题

    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,6,7,8};
        System.out.println(sum(nums));
    }
}
