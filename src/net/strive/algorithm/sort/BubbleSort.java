package net.strive.algorithm.sort;

/**
 * @author Administrator
 * 冒泡法排序
 * 将相邻的两个数比较，将小的调到前头。
 */
public class BubbleSort {

	/**
	 * @param str
	 */
	public static void main(String...str) {
		int[] values={3,1,6,2,9,0,7,4,5};
		sort(values);
		/*遍历数组1*/
		for(int i:values)
		{
			System.out.println(i);
		}
		/*遍历数组2*/
		for(int i=0;i<values.length;i++)
		{
			System.out.println("index:"+i+" value :"+ values[i]);
		}
		
		sort();
		
		
	}
	public static void sort(int[] values)
	{
		int temp;
		for(int i=0;i<values.length;++i)
		{
			for(int j=0;j<values.length-i-1;++j)
			{
				if(values[j]>values[j+1])
				{
					temp=values[j];
					values[j]=values[j+1];
					values[j+1]=temp;
				}
			}
		}
	}
	
	/**
	 * @deprecated 
	 * 标注为废弃的
	 */
	public static void sort()
	{
		System.out.println("废弃的sort方法!");
	}

}
