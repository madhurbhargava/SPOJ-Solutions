import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ Problem: GJLIVE(GJLIVE)
 * @author madhurbhargava
 *
 */
public class GJLIVE {
	
	private static final String AP = "AP";
	private static final String GP = "GP";
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int prev = -1;
		int total = 0;
		for(int i = 0; i < 10; i++)
		{
			int num = Integer.parseInt(reader.readLine());
			total = total + num;
			if(total == 100)
			{
				break;
			}
			else if(total > 100)
			{
				int diffCurr = total - 100;
				int diffPrev = (100 - (total - num));
				if(diffCurr == diffPrev)
				{
					break;
				}
				
				if(diffCurr > diffPrev)
				{
					total = total - num;
				}
				
				break;
			}
			prev  = num;
		}
		out.println(total);
		out.flush();
	}

}
