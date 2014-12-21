import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ Problem: Cards(CRDS)
 * This one was all about deriving the formula. Also it is equally important that all calculations are done on 'long' vars.
 * @author madhurbhargava
 */
public class CRDS {

	
	public static void main(String[] arguments) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTestCases = Integer.parseInt(reader.readLine());
		
		//it is imp that this is long
		long modNum = 1000007;
		
		for(int i = 0; i < numTestCases; i++)
		{
			//it is imp that all calculations are done on long
			long numLevels = Long.parseLong(reader.readLine());
			long cards = 3*((numLevels*(numLevels+1))/2) - numLevels;
			cards = cards % modNum;
			out.println(cards);
			out.flush();
			
		}
	}
	
	
}
