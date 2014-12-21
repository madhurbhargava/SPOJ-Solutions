import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * Spoj Problem: BYTESM2
 * Simple DP. Improperly formatted input. 
 * Following Input was the key to understand the input format:
 *  2 
	2 2 
	1 
	2 
	3 
	4 
	Out: 6 
	2 2 
	1 2 3 4 
	Out: 6
 * @author madhurbhargava
 *
 */
public class BYTESM2 {
	
	public static void main(String[] args) //throws Exception
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
			int numTestCases = Integer.parseInt(reader.readLine());
			for(int i = 0; i < numTestCases; i++)
			{
				String[] metaData = reader.readLine().split(" ");
				final int rows = Integer.parseInt(metaData[0]);
				final int cols = Integer.parseInt(metaData[1]);
				int res = 0;
				if(rows != 0 && cols != 0)
				{
					int arr[][] = new int[rows][cols];
					StringTokenizer tokens = null;
					for(int x = 0; x < rows; x++)
					{
						if(tokens == null || (!tokens.hasMoreTokens()))
						{
							tokens = new StringTokenizer(reader.readLine());//reader.readLine().split(" ");
						}
						for(int y = 0; y < cols; y++)
						{
							if(!tokens.hasMoreTokens())
							{
								tokens = new StringTokenizer(reader.readLine());
							}
							arr[x][y] = Integer.parseInt(tokens.nextToken());//data[y]);
							
						}
					}
			
					//start from 1st row onwards
					res = max(arr, rows - 1);
				}
				out.println(res);
				out.flush();
			
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	private static int max(int[][]arr, int row)
	{
		int rows = arr.length;
		int cols = arr[0].length;
		if(row == 0)
		{
			int temp = arr[0][0];
			for(int i = 0; i < cols; i++)
			{
				int num = arr[0][i];
				if(num > temp)
				{
					temp = num;
				}
			}
			return temp;
		}
		else
		{
			
			for(int i = 0; i < cols; i++)
			{
				//if u are at 1st column
				if(i == 0)
				{
					if(cols > 1)
					{
						arr[row - 1][i] = Math.max(arr[row - 1][i]+arr[row][i], arr[row - 1][i]+arr[row][i+1]);
					}
					else
					{
						arr[row - 1][i] = arr[row - 1][i]+arr[row][i];
					}
				}
				else if(i == cols - 1)
				{
					//last column
					if(cols > 1)
					{
						arr[row - 1][i] = Math.max(arr[row - 1][i]+arr[row][i], arr[row - 1][i]+arr[row][i-1]);
					}
					else
					{
						arr[row - 1][i] = arr[row - 1][i]+arr[row][i];
					}
				}
				else
				{
					//middle columns
					int a = arr[row - 1][i]+arr[row][i];
					int b = arr[row - 1][i]+arr[row][i+1];
					int c = arr[row - 1][i]+arr[row][i-1];
					arr[row - 1][i] = Math.max(a, Math.max(b, c));
				}
				 
			}
			return max(arr, row - 1);
		}
	}
}
