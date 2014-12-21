import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * SPOJ Problem: Is It a tree(PT07Y)
 * Uses Union find Algorithm
 * @author madhurbhargava
 *
 */
public class PT07Y {
	private static final String YES = "YES";
	private static final String NO = "NO";
	public static void main(String[] args) throws Exception
	{
		boolean isTree = true;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[] data = reader.readLine().split(" ");
		final int nodes = Integer.parseInt(data[0]);
		final int edges = Integer.parseInt(data[1]);
		//if(nodes > edges)
		{
			int[] nodeArr = new int[nodes];
			Arrays.fill(nodeArr, -1);
			for(int i = 0; i < edges; i++)
			{
				String nodelist[] = reader.readLine().split(" ");
				int x = Integer.parseInt(nodelist[0]) - 1;
				int y = Integer.parseInt(nodelist[1]) - 1;
				//make sure x is lesser
				if(x > y)
				{
					x = x ^ y;  
					y = x ^ y;  
					x = x ^ y;  
				}
				//we have to union x and y, x would be the lesser edge and would always be the parent of y
				int fOne = find(x, nodeArr);
				int fTwo = find(y, nodeArr);
				if(fOne == fTwo && (fOne != -1))
				{
					isTree = false;
					break;
				}
				else
				{
					//both are -1
					if(fOne == x && fTwo == y)
					{
						nodeArr[y] = fOne;
						nodeArr[x] = (nodeArr[x] - 1);
					}
					else
					{
						nodeArr[y] = fOne;
						nodeArr[fOne] = (nodeArr[fOne] - 1);
					}
				}
				
			}
		}
		if(isTree)
		{
			out.println(YES);
		}
		else
		{
			out.println(NO);
		}
		out.flush();
	}
	
	/**
	 * return s father of a node
	 * @param node
	 * @param nodeArr
	 * @return
	 */
	private static int find(int node, int[] nodeArr)
	{
		int res = nodeArr[node];
		if(res < 0)
		{
			return node;
		}
		else
		{
			return find(res, nodeArr);
		}
	}

}
