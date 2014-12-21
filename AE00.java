import java.util.Scanner;

public class TestClass{
	
	public static void main(String[]args)
	{
		Scanner a = new Scanner(System.in);
		int squares = a.nextInt();
		calcRectangles(squares);
	}
	
	private static int calcRectangles(int squares)
	{
		int basic = squares;
		int mulfactor = (int)Math.floor(Math.sqrt((double)squares));
		//count stack-ups
		for(int i = 2; i <= mulfactor; i++)
		{
			int count = 0;
			for(int k = i;count <= squares; k++)
			{
				count = i*k;
				if(count <= squares)
				{
					basic++;
				}
				
			}
		}
		System.out.println(basic);
		return basic;
	}
}