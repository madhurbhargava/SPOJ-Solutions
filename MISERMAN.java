import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Spoj Problem: Wiser and Miser(MISERMAN)
 * Simple DP. Improperly formatted input. String.split(" ") fails. 
 * Usage of StringTokenizer is mandatory.
 * @author madhurbhargava
 *
 */
public class MISERMAN {
	
	public static void main(String[] args) //throws Exception
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter out = new PrintWriter(System.out);
			//int numTestCases = Integer.parseInt(reader.readLine());
			//for(int i = 0; i < numTestCases; i++)
			{
				StringTokenizer tokens = new StringTokenizer(reader.readLine());
				final int rows = Integer.parseInt(tokens.nextToken());
				final int cols = Integer.parseInt(tokens.nextToken());
				int res = 0;
				if(rows != 0 && cols != 0)
				{
					int arr[][] = new int[rows][cols];
					for(int x = 0; x < rows; x++)
					{
						tokens = new StringTokenizer(reader.readLine());//reader.readLine().split(" ");
						for(int y = 0; y < cols; y++)
						{
							arr[x][y] = Integer.parseInt(tokens.nextToken());//data[y]);
						}
					}
			
					//start from 1st row onwards
					res = min(arr, rows - 1);
				}
				out.println(res);
				out.flush();
			
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	private static int min(int[][]arr, int row)
	{
		int rows = arr.length;
		int cols = arr[0].length;
		if(row == 0)
		{
			int temp = arr[0][0];
			for(int i = 0; i < cols; i++)
			{
				int num = arr[0][i];
				if(num < temp)
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
						arr[row - 1][i] = Math.min(arr[row - 1][i]+arr[row][i], arr[row - 1][i]+arr[row][i+1]);
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
						arr[row - 1][i] = Math.min(arr[row - 1][i]+arr[row][i], arr[row - 1][i]+arr[row][i-1]);
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
					arr[row - 1][i] = Math.min(a, Math.min(b, c));
				}
				 
			}
			return min(arr, row - 1);
		}
	}
}
