import java.util.Scanner;


public class Main {
	
	public static void main(String []args)
	{
		Scanner a = new Scanner(System.in);
		long num = a.nextLong();
		if(num%10 == 0)
		{
			System.out.println(2);
		}
		else
		{
			System.out.println(1);
			System.out.println(num%10);
		}
	}

}
