package Heap_and_PQ;

import java.lang.Math;
import java.util.Arrays;

public class Heap 
{
	String[] arr_rep;
	int size;
	int addHere; 
	
	public Heap()
	{
		arr_rep = new String[5];
		size = 0;
		addHere = 1;
	}
	
	public int getSize()
	{ return size; }
	
	private void resize()
	{
		if(size < 3) return;
		if(size + 1 == arr_rep.length - 1)
		{
			String[] newRep = new String[arr_rep.length * 2];
			for(int i = 0; i < arr_rep.length; i++) newRep[i] = arr_rep[i];
			arr_rep = newRep;
		}
		else if(size <= arr_rep.length/4)
		{
			String[] newRep = new String[arr_rep.length / 2];
			for(int i = 0; i < arr_rep.length; i++) newRep[i] = arr_rep[i];
			arr_rep = newRep;
		}
	}
	
	private String sink(int makeFirst) //returns max elements
	{
		String max = arr_rep[1];
		arr_rep[1] = arr_rep[makeFirst];
		arr_rep[makeFirst] = max;
		
		int numLeft = makeFirst - 1; 
		
		int currInd = 1;
		
		while(currInd * 2 <= numLeft && numLeft > 2)
		{
			if( (currInd * 2 + 1 > numLeft || arr_rep[currInd * 2].compareTo(arr_rep[currInd * 2 + 1]) > 0)) 
			{ exch(currInd, currInd * 2); currInd *= 2; }
			
			else if ( arr_rep[currInd].compareTo(arr_rep[currInd * 2 + 1]) < 0)
			{ exch(currInd, currInd * 2 + 1); currInd = currInd * 2 + 1; }
			
			else currInd = 2 * numLeft + 1;
		}
		System.out.println("Sorted in place: " + Arrays.toString(arr_rep));
		return max;
	}
	
	void sort()
	{
		System.out.println("Sorted in place: " + Arrays.toString(arr_rep));
		String[] sorted = new String[size];
		int tmp = 0; 
		while(tmp < size)
		{
			sorted[size - tmp  -1] = sink(size - tmp);
			tmp++;
//			System.out.println(Arrays.toString(sorted));
		}
	}
	
	private void swim(int startInd)
	{
		//we know that startInd has parent floor(k/2) - recursively check 
		int currInd = startInd; 
		while((currInd / 2 > 0) && (arr_rep[currInd].compareTo(arr_rep[currInd / 2]) > 0))
		{
			exch(currInd, currInd/2);
			currInd = currInd/2;
		}
		System.out.println(Arrays.toString(arr_rep));
	}
	
	private void exch(int ind_1, int ind_2)
	{
		String str_1 = arr_rep[ind_1];
		arr_rep[ind_1] = arr_rep[ind_2];
		arr_rep[ind_2] = str_1;
	}
	
	String getMax()
	{ 
		return arr_rep[1]; 
	}
	
	
	void insert(String toAdd)
	{
		resize();
		size++;
		arr_rep[size] = toAdd;
		swim(size);
	}
	
	public String toString()
	{
		return Arrays.toString(arr_rep);
	}
}
