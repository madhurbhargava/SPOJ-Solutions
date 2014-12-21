import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ Problem: Cut the Silver Bar(SILVER)
 * @author madhurbhargava
 *
 */
public class SILVER {
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int result = -1;
		int []arr = new int[20000];
		int count  = 0;
		int iteration = 1;
		for(int i = 0; i < 20000;)
		{
			for(int j = 0; j < iteration; j++)
			{
				arr[i++] = count;
				if(i == 20000)
				{
					break;
				}
			}
			iteration = iteration * 2;
			count++;
		}
		while(true)
		{
			int num = Integer.parseInt(reader.readLine());
			if(num == 0)
			{
				break;
			}
			
			
			out.println(arr[num - 1]);
			out.flush();
		}
	}

}
