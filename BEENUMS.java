import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * SPOJ Problem: BeeHive Numbers(BEENUMS)
 * 2 rules for a valid hive, Both must be true together for a valid hive
 * Rule 1: Hive Cell count should be of the order of 6n + 1
 * Rule 2: Hive Cell count - 1 = 6*1 + 6*2 + 6*3..........and so on 
 * @author madhurbhargava
 */
public class BEENUMS {

	public static void main(String[] arguments) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long num = 0;
		while(true)
		{
			num = Long.parseLong(reader.readLine());
			if(num == -1)
			{
				break;
			}
			if(num == 1)
			{
				out.println("Y");
				out.flush();
				continue;
			}
			//apply first rule
			if((num - 1) % 6 == 0)
			{
				//apply second rule
				boolean status = false;
				int add = 0;
				for(int i = 1; add < num;i++)
				{
					add = add + 6*i;
					if(add == num - 1)
					{
						status = true;
						break;
					}
				}
				if(status)
				{
					out.println("Y");
				}
				else
				{
					out.println("N");
				}
				
			}
			else
			{
				out.println("N");
			}
			out.flush();
		}
	}
	
	
}
