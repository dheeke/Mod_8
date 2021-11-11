package Thread_Lesson;

import java.util.Random;

class Run_Thread2 extends Thread  
{
	private int[] array;
	private int begin;
	private int end;
	private int tempSum;

	public Run_Thread2(int[] array, int begin, int end)
	{
		this.array = array;
		this.begin = begin;
		this.end = end;

	}
	
	public int getTempSum() {return this.tempSum;}
	
	public void run()
	{
		tempSum = 0;
		
		for(int i = begin; i < end; i++)
		{
			tempSum += array[i];
		}
	}
}

public class Array_Sum2 
{
	public static void main(String[] args)
	{
		int[] array;
		array = new int[200000000];
		int begin1 = 0;
		int end1 = array.length/2;
		int begin2 = (array.length/2)+1;
		int end2 = array.length;
		int result1 = 0;
		int result2 =0;
		int total =0;
		Random rn = new Random();
		
		for(int i=0; i<array.length; i++)
		{
			array[i] = rn.nextInt(10)+1;
		}
		
		Run_Thread2 run1 = new Run_Thread2(array, begin1, end1);
		Run_Thread2 run2 = new Run_Thread2(array, begin2, end2);
		long start = System.currentTimeMillis();
		run1.start();
		run2.start();
		
		try 
		{
			run1.join();
			run2.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		result1 = run1.getTempSum();
		result2 = run2.getTempSum();
		
		long finish = System.currentTimeMillis();
		long time = finish-start;
		total = result1 + result2;
		System.out.println("The sum of the array is:" + total);
		System.out.println("The elapsed time of the array summation was:" + time + " miliseconds");
		
	}

}
