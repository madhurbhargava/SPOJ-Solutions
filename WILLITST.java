import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ Problem: Will It Ever Stop(WILLITST)
 * Simple check for powers of 2. Use long due to input specs.
 * @author madhurbhargava
 *
 */
public class WILLITST {
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long num = Long.parseLong(reader.readLine());
		if((num & (num - 1)) == 0)
		{
			out.println("TAK");
		}
		else
		{
			out.println("NIE");
		}
		out.flush();
			
	}

}
