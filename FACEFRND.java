import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * SPOJ Problem: Friend of Friends(FACEFRND)
 * Simple use of hashmap
 * @author madhurbhargava
 */
public class FACEFRND {

	
	public static void main(String[] arguments) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numFriends = Integer.parseInt(reader.readLine());
		Integer[] immfs = new Integer[numFriends];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < numFriends; i++)
		{
			String[] frndData = reader.readLine().split(" ");
			immfs[i] = Integer.parseInt(frndData[0]);
			for(int k = 2; k < frndData.length; k++)
			{
				map.put(Integer.parseInt(frndData[k]), Integer.parseInt(frndData[k]));
			}
		}
		for(int i = 0; i < immfs.length; i++)
		{
			map.remove(immfs[i]);
		}
		out.println(map.size());
		out.flush();
	}
	
	
}
