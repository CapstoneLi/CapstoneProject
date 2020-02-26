/**
 * @description
 * @params
 * @return
 * @date
 */


// Make a change in others fork
public class Quick {
    public static void main(String[] args){
        int[] toSort={-1,0,1,2,-1,4};
        int i=0;//先设置第一位为基准
        int j=toSort.length-1;//最后一位
        //quick_sort(toSort,i,j);
        loop(toSort,i,j);
        for(int x=0;x<toSort.length;x++){
            System.out.println(toSort[x]);
        }
    }
    public static int quicksort(int nums[], int i, int j){
        int part=nums[i];//取第一位的数值作为分配基准
        while(i<j){//这个循环会在i,j相等时退出
            while(i<j && nums[j]>=part)//先从右边开始，从后往前挑一个比基准的数放在这里，这样跳跃比较大，速度会比较快
                j--;//如果目前的数字基准的还大，不能换位置，继续向前寻找，这个循环会找到一个j,这时nunms[j]小于基准的数字
            if(i<j){
                nums[i++]=nums[j];//将j的值赋给i位置
                //i目前搞定了，向后移动
            }
            while(i<j && nums[i]<part)
                i++; //i会找到一个大于目前基准的值
            if(i<j){
                nums[j--]=nums[i];//之前空出来的j的值现在找到了一个比基准大的放进去了
                //j--;//j也搞定了，向前移动
            }
        }
        nums[i]=part;//ij这个时候相遇了，基准就应该放在这里
        return i;//返回基准的位置


    }

    public static void loop(int nums[], int l, int r){
        if(l<r){
            int i=quicksort(nums,l,r);
            loop(nums,l,i-1);//左边整理
            loop(nums,i+1,r);//右边整理
        }
    }

    public static void quick_sort(int s[],int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }

    }
}
