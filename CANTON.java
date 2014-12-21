import java.util.Scanner;

public class TestClass{
	
	public static void main(String[]args)
	{
		Scanner a = new Scanner(System.in);
		int numTestCase = a.nextInt();
		a.nextLine();
		for(int x = 0;x < numTestCase;x++)
		{
			calcCantorTerm(a.nextInt());
		}
		
	}
	
	private static void calcCantorTerm(int term)
	{
		int x = 1;
		int y = 1;
		boolean dwalk = false;
		boolean up = false;
		for(int i = 1; i < term; i++)
		{
			if(!dwalk)
			{
				if(x == 1 && y == 1)
				{
					x++;
					up = false;
				}
				else if(x == 1)
				{
					y++;
					up = true;
				}
				else if(y == 1)
				{
					x++;
					up = false;
				}
				dwalk = true;
				
			}
			else
			{
				if(up)
				{
					y--;x++;
				}
				else
				{
					y++;x--;
				}
				
				if(x == 1 || y == 1)
				{
					dwalk = false;
				}
				
			}
			
			
		}
		System.out.println("TERM "+term+" IS "+y+"/"+x);
	}
}