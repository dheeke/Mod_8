package Thread_Lesson;

import java.util.Random;
import java.util.Scanner;

class Run_Thread extends Thread  
{
	private int[] array;
	private int begin;
	private int end;
	private int tempSum;

	public Run_Thread(int[] array, int begin, int end)
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


public class Array_Sum
{
	public static void main(String[] args)
	{
		int[] array;
		array = new int[200000000];
		int begin1 = 0;
		int end1 = array.length;
		int result = 0;
		Random rn = new Random();
		
		for(int i=0; i<array.length; i++)
		{
			array[i] = rn.nextInt(10)+1;
		}
		
		Run_Thread run1 = new Run_Thread(array, begin1, end1);
		long start = System.currentTimeMillis();
		run1.start();
		
		try 
		{
			run1.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		result = run1.getTempSum();
		long finish = System.currentTimeMillis();
		long time = finish-start;
		System.out.println("The sum of the array is:" + result);
		System.out.println("The elapsed time of the array summation was:" + time + " miliseconds");
		
	}
 }
