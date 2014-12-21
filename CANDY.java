import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestClass{
	
	public static void main(String[]args)
	{
		Scanner a = new Scanner(System.in);
		int count = a.nextInt();
		a.nextLine();
		while(count!=-1)
		{
			if(count != -1)
			{
				ArrayList<Integer> input = new ArrayList<Integer>();
				for(int i = count; i > 0; i--)
				{
					input.add(new Integer(a.nextInt()));
				}
				Collections.sort(input);
				calcCandyMoves(convertIntegers(input));
				
			}
			count = a.nextInt();
		}
	}
	
	private static void calcCandyMoves(int[] list)
	{
		int sum= 0; 
	     for (int i:list)
	         sum = sum + i;
	     //is the equal division possible
	     if(sum%list.length == 0)
	     {
	    	int bucketSize = sum/list.length;
	    	int moves = 0;
	    	
	    	for(int i = 0, j = i+1; i < list.length && j < list.length;)
	    	{
	    		
	    				if(list[j] > bucketSize)
	    				{
	    					while(list[i] != bucketSize)
	    					{
	    						int updated = list[j] - 1;
	    						list[j] = updated;
	    						updated = list[i] + 1;
	    						list[i] = updated;
	    						moves++;
	    						if(list[i] == bucketSize)
	    						{
	    							i++;
	    							break;
	    						}
	    						if(list[j] == bucketSize)
	    						{
	    							j++;
	    							break;
	    						}
	    					}
	    					
	    				}
	    				else
	    				{
	    					j++;
	    				}
	    		
	    	}
	    	System.out.println(moves);
	     }	
	     else
	     {
	    	 System.out.println("-1");
	     }
	}
	
	private static int[] convertIntegers(ArrayList<Integer> integers)
	{
	    int[] ret = new int[integers.size()];
	    for (int i=0; i < ret.length; i++)
	    {
	        ret[i] = integers.get(i).intValue();
	    }
	    return ret;
	}
}