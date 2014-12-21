import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
/**
 * SPOJ: PERMUT2
 * Single Pass through the array. Time constraints.
 * @author madhurbhargava
 *
 */
public class PERMUT2 {
 
	private static String AMBI = "ambiguous";
	private static String NAMBI = "not ambiguous";
	
	
	public static void main(String []args) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = Integer.parseInt(reader.readLine());
		
		while(num != 0)
		{
			boolean status = checkAmbiguity(reader.readLine());
			if(status)
			{
				out.println(NAMBI);
			}
			else
			{
				out.println(AMBI);
			}
			out.flush();
			num = Integer.parseInt(reader.readLine());
		}
	}
	
	private static boolean checkAmbiguity(String str)
	{
		boolean status = false;
		String[] stok = str.split(" ");
		if(stok.length == 1)
		{
			return false;
		}
		String[] permStr = new String[stok.length];
		for(int i = 0; i < stok.length; i++)
		{
			int position = i;
			String num = stok[i];
			int loc = Integer.parseInt(num) - 1;
			String res = Integer.toString(position+1);
			permStr[loc] = res;
			if(!permStr[loc].equals(stok[loc]))
			{
				status = true;
				break;
			}
		}
		return status;
	}
 
}
 