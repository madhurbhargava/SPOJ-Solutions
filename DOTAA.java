import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ Problem: DOTA Heroes(DOTAA)
 * Efficient I/O required. DO NOT use scanner. Make sure to take care of tricky test cases like:
 * 4 3 400
 * 200
 * 200
 * 200
 * 1201
 * @author madhurbhargava
 *
 */
public class DOTAA {

	
	public static void main(String[] arguments) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++)
		{
			String[] data = reader.readLine().split(" ");
			int numHeroes = Integer.parseInt(data[0]);
			int numTowers = Integer.parseInt(data[1]);
			int tDamage = Integer.parseInt(data[2]);
			boolean reach = false;
			//As per prob specs, number of towers is always less than or equal to number of heroes
			for(int j = 0; j < numHeroes; j++)
			{
				int heroPower = Integer.parseInt(reader.readLine());
				if(heroPower > tDamage)
				{
					double sustain = (double)heroPower/(double)tDamage;
					if(isWhole(sustain))
					{
						sustain = sustain - 1;
					}
					else
					{
						sustain = Math.floor(sustain);
					}
					numTowers = (int) (numTowers - sustain);
				}
				
				if(numTowers <= 0)
				{
					reach = true;
				}
			}
			if(reach)
			{
				out.println("YES");
			}
			else
			{
				out.println("NO");
			}
			out.flush();
		}
	}
	
	private static boolean isWhole(double value) {
	    return Math.floor(value) == value;
	}
}
