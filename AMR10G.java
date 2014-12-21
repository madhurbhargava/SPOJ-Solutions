import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * SPOJ Problem: Christmas Play(AMR10G), Simple array walk over a sorted array.
 * @author madhurbhargava
 * O(NlogN+N) 
 */
public class AMR10G {
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++)
		{
			String[] metaData = reader.readLine().split(" ");
			String data = reader.readLine();
			int[] arr = convert(data, Integer.parseInt(metaData[0]));
			int res = 0;
			if(!(Integer.parseInt(metaData[1]) == 1 || Integer.parseInt(metaData[1]) == 0))
			{
				Arrays.sort(arr);
				res = check(arr, Integer.parseInt(metaData[1]));
			}
			out.println(res);
			out.flush();
		}
		
		
	}
	
	private static int check(int[] arr, int wl)
	{
		int finalDiff = -1;
		wl = wl - 1;
		int diff;
		for(int si = 0, ei = wl;;si++, ei++)
		{
			diff = arr[ei] - arr[si];
			if(si == 0)
			{
				finalDiff = diff;
			}
			if(diff < finalDiff)
			{
				finalDiff = diff;
			}
			if(ei == arr.length - 1 || finalDiff == 0)
			{
				break;
			}
		}
		
		return finalDiff;
		
	}
	
	private static int[] convert(String data, final int length)
	{
		StringTokenizer tokens = new StringTokenizer(data); 
		int i = 0;
		int[]arr = new int[length];
		while(tokens.hasMoreTokens())
		{
			arr[i++] = Integer.parseInt(tokens.nextToken());
		}
		return arr;
	}

}
