import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
/**
 * Mostly an optimization problem. StringTokenizer is the key in this case. Make sure to avoid creating strings
 * @author madhurbhargava
 *
 */
public class Main {
	
	public final static String GODZILLA = "Godzilla";
    public final static String MECHAGODZILLA = "MechaGodzilla";
	
	public static void main(String []args) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTestCases = Integer.parseInt(reader.readLine());
		
		while(numTestCases-- > 0)
		{
			reader.readLine();
			reader.readLine();
			String ngStr = reader.readLine();
			String nmStr = reader.readLine();
			int ng = findLargest(ngStr);
			int nm = findLargest(nmStr);
			battle(ng, nm, out);
		}
	}
	
	private static void battle(int ngLarge, int nmLarge, PrintWriter out) throws IOException
	{
		if(ngLarge > nmLarge || ngLarge == nmLarge)
		{
			out.println(GODZILLA);
		}
		else
		{
			out.println(MECHAGODZILLA);
		}
		out.flush();
	}
	
	private static int findLargest(String str)
	{
		//StringTokenizer is twice as fast as String.split
		StringTokenizer stok = new StringTokenizer(str);
		int largest = Integer.parseInt(stok.nextToken());
		int num;
		while(stok.hasMoreTokens())
		{
			num = Integer.parseInt(stok.nextToken());
			if(num > largest)
			{
				largest = num;
			}
		}
		return largest;
	}

}
