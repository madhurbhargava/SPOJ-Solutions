import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ Problem: What's Next(ACPC10A)
 * @author madhurbhargava
 *
 */
public class ACPC10A {
	
	private static final String AP = "AP";
	private static final String GP = "GP";
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String[] data = reader.readLine().split(" ");
			int x = Integer.parseInt(data[0]);
			int y = Integer.parseInt(data[1]);
			int z = Integer.parseInt(data[2]);
			if(x == 0 && y == 0 && z == 0)
			{
				break;
			}
			int next = -1;
			if(z - y == y - x)
			{
				next = z + (y - x);
				out.println(AP + " " +next);
			}
			else
			{
				next = z * (y/x);
				out.println(GP + " " +next);
			}
			out.flush();
		}
	}

}
