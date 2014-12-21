import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ ProblemL Number Steps(NSteps)
 * @author madhurbhargava
 *
 */
public class NSTEPS {
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++)
		{
			String[] data = reader.readLine().split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			
			if(x == y || (x-y==2))
			{
				if(x % 2 == 0)
				{
					out.println(x+y);
					
				}
				else
				{
					out.println(x+y-1);
				}
			}
			else
			{
				out.println("No Number");
			}
			out.flush();
		}
	}

}
