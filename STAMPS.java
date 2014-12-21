import java.util.Scanner;
import java.util.StringTokenizer;

public class TestClass{
	
	public static void main(String[]args)
	{
		Scanner a = new Scanner(System.in);
		int numCases = a.nextInt();
		a.nextLine();
		for(int i = 0; i < numCases; i++)
		{
			String info1 = a.nextLine();
			String info2 = a.nextLine();
			StringTokenizer strToken = new StringTokenizer(info1);
		    int count = strToken.countTokens();
		    int[] arrStamps = new int[count];

		    for(int x = 0;x < count;x++){
		        arrStamps[x] = Integer.parseInt((String)strToken.nextElement());
		    }
		    
		    strToken = new StringTokenizer(info2);
		    count = strToken.countTokens();
		    int[] arrFrnds = new int[count];

		    for(int x = 0;x < count;x++){
		        arrFrnds[x] = Integer.parseInt((String)strToken.nextElement());
		    }
		    
		    countFrnds(arrStamps, arrFrnds, i);
		}
	}
	
	private static void countFrnds(int arrStamps[], int arrFrnds[], int num)
	{
		int friendCount = 0;
		int total = 0;
		boolean possible = false;
		sort(arrFrnds);
		for(int i = 0; i < arrFrnds.length; i++)
		{
			total = total + arrFrnds[i];
			friendCount++;
			if(total >= arrStamps[0])
			{
				possible = true;
				break;
			}
		}
		
		if(total < arrStamps[0])
		{
			possible = false;
		}
		
		num = num+1;
		System.out.println("Scenario "+ "#" + num +":");
		if(possible)
		{
			System.out.println(friendCount);
		}
		else
		{
			System.out.println("impossible");
		}
	}
	
	private static void sort(int []unsorted)
	{
		//if(unsorted.length < 7)
		{
			insertionSort(unsorted);
		}
		/*else
		{
			mergeSort(unsorted);
		}*/
	}
	
	private static void insertionSort(int [] unsorted)
	{
		//pick-->shift-->insert
		int buffer;
		for(int i = 1 ; i < unsorted.length; i++)
		{
			//pick
			buffer = unsorted[i];
			int j = i;
			//shift
			for(; j > 0; j--)
			{
				if(buffer > unsorted[j - 1])
				{
					unsorted[j] = unsorted[j - 1];
				}
				else
				{
					break;
				}
			}
			//insert
			unsorted[j] = buffer;
		}
	}
}