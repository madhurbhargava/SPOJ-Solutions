import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * SPOJ Problem: He is Offside(OFFSIDE)
 * Very Confusing Problem statement. 
 * Problem Statement can be simplified to: If two defenders 
 * are closer to goal line than attacker, then attacker is not offside.
 * @author madhurbhargava
 */
public class OFFSIDE 
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true)
		{
			String[] playerCount = (reader.readLine()).split(" ");
			int a = Integer.parseInt(playerCount[0]);
			int d = Integer.parseInt(playerCount[1]);
			if(a == 0 && d == 0)
			{
				break;
			}
			int attackers[] = convertToIntArray((reader.readLine()).split(" "), a);
			int defenders[] = convertToIntArray((reader.readLine()).split(" "), d);
			int min = attackers[0];
			for(int i = 1; i < attackers.length; i++)
			{
				if(attackers[i]<=min)
				{
					min = attackers[i];
				}
			}
			int count = 0;
			for(int i = 0; i < defenders.length; i++)
			{
				if(defenders[i]<=min)
				{
					count++;
				}
				if(count >= 2)
				{
					break;
				}
			}
			
			if(count>=2)
			{
				out.println("N");
			}
			else
			{
				out.println("Y");
			}
			out.flush();
		}
	}
	
	private static int[] convertToIntArray(String[]arr, final int len)
	{
		int[] finalArr = new int[len]; 
		for(int i = 0; i < len; i++)
		{
			finalArr[i] = Integer.parseInt(arr[i]);
		} 
		return finalArr;
	}
}
