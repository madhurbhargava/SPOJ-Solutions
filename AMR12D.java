import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * SPOJ Problem AMR12D: Simple check for palindrome
 * @author mbhargava
 *
 */
public class AMR12D {
	
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
		int testCases = Integer.parseInt(inp.readLine());
		int count = 0;
		while(count++ < testCases)
		{
			String str  = inp.readLine();
			StringBuffer rev = new StringBuffer(str);
			rev = rev.reverse();
			if(str.equals(rev.toString()))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
	}

}
