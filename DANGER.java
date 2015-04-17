import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Josephus problem,
 * 1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16
   1	1	3	1	3	5	7	1	3	5	7	9	11	13	15	1
   
   The series resets itself at every power of 2.
   It is a power of 2 problem. Whenever the total number of persons surviving is a power of 2, then the first
   person surviving in the lot is a winner
 * @author mbhargava
 *
 */
public class DANGER {
	
	
	/**
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String args[]) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String val = "";
		while(true)
		{
			val = reader.readLine();
			if(val.equals("00e0"))
			{
				break;
			}
			long num = convertVal(val);
			long result = 0;
			//whenever it is a power of 2
			if(num == 1 || ((num & (num - 1)) == 0))
			{
				result = 1;
			}
			else
			{
				//++This solution is elegant but gives TLE++//
				/*long left = num - 1;
				for(long i = 2; i <= num; i = i+2)
				{
					
					if(((left & (left - 1)) == 0))
					{
						result = i+1;
						break;
					}
					left--;
				}*/
				//+++++//
				
				
				//Another solution: Formula based
				//find smaller power of 2
				long i = flp2(num);
				
				result = 1+(num - i)*2;
			}
			System.out.println(result);
		}
	}
	
	/*
	 * Function gives previous power of 2
	 */
	private static long flp2(long x)
	{
	    x = x | (x >> 1);
	    x = x | (x >> 2);
	    x = x | (x >> 4);
	    x = x | (x >> 8);
	    x = x | (x >> 16);
	    return x - (x >> 1);
	}
	
	private static long convertVal(String val)
	{
		String num  = val.substring(0, val.indexOf("e"));
		String pnum = val.substring(val.indexOf("e")+1, val.length());
		long res = pnum.equals("0") ? Long.parseLong(num) :(Long.parseLong(num) * (long)Math.pow(10, Long.parseLong(pnum)));
		return res;
	}

}
