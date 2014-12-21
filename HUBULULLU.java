import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Main {
	
	public static String ABWINS = "Airborne wins.";
	public static String PWINS = "Pagfloyd wins.";
	
	public static void main(String []args) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < num; i++)
		{
			String[] arr = reader.readLine().split(" ");
			if(arr[1].equals("0"))
			{
				out.println(ABWINS);
			}
			else if(arr[1].equals("1"))
			{
				out.println(PWINS);
			}
			out.flush();
		}
	}

}

