import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Spoj Problem: QUADAREA
 * Simple application of brahmagupta's formula
 * @author madhurbhargava
 *
 */
public class QUADAREA {
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++)
		{
			String[] metaData = reader.readLine().split(" ");
			double a = Double.parseDouble(metaData[0]);
			double b = Double.parseDouble(metaData[1]);
			double c = Double.parseDouble(metaData[2]);
			double d = Double.parseDouble(metaData[3]);
			double s = (a+b+c+d)/2;
			s = (s - a)*(s - b)*(s - c)*(s - d);
			s = Math.sqrt(s);
			out.println(s);
			out.flush();
		}	
	}

}
