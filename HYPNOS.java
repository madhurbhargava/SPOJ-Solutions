import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * SPOJ Problem: Happy Numbers I(HYPNOS)
 * @author madhurbhargava
 */
public class HYPNOS {

	static int  mStepCount  = 0;
	public static void main(String[] arguments) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String[] num = reader.readLine().split("");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		boolean happy = false;
		while(true)
		{
			if(num.length == 2 && (num[0].equals("") && Integer.parseInt(num[1]) == 1))
			{
				happy = true;
				break;
			}
			else
			{
				if(num.length == 1)
				{
					int res = (int)Math.pow(Double.parseDouble(num[0]), 2);
					mStepCount++;
					if(map.containsKey(res))
					{
						happy = false;
						break;
					}
					else
					{
						map.put(res, res);
					}
					num = Integer.toString(res).split("");
				}
				else
				{
					int addend = 0;
					for(int i = 1; i < num.length; i++)
					{
						addend = addend +(int)Math.pow(Double.parseDouble(num[i]), 2);
					}
					mStepCount++;
					if(map.containsKey(addend))
					{
						happy = false;
						break;
					}
					else
					{
						map.put(addend, addend);
					}
					num = Integer.toString(addend).split("");
				}
			}
		}
		if(happy)
		{
			out.println(mStepCount);
		}
		else
		{
			out.println(-1);
		}
		out.flush();
	}
	
	
}
