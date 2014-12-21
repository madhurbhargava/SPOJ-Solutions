import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * SPOJ Problem: Feynman(SAMER08F)
 * @author madhurbhargava
 */
public class SAMER08F {

	public static void main(String[] arguments) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = 1;
		int result;
		while(true)
		{
			num = Integer.parseInt(reader.readLine());
			if(num == 0)
			{
				break;
			}
			if(num == 1)
			{
				out.println(1);
				out.flush();
				continue;
			}
			result = (int)Math.pow(num, 2) + 1;
			for(int i = num - 1; i > 1; i--)
			{
				result = result+(int)Math.pow(i, 2);
			}
			out.println(result);
			out.flush();
		}
		
		
	}
	
}
