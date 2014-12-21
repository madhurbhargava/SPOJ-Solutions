import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * SPOJ Problem: THE MAX LINES(MAXLN)
 * s = AB^2+AC
 * BC = 2r
 * Also, since CAB is right(90 degrees),
 * BC^2 = AB^2 + AC^2
 * From there AB^2 + AC^2 = (2r)^2
=> AB^2 = 4r^2 - AC^2

s = AB^2 + AC
=> s = 4r^2 - AC^2 + AC
=> s = -AC^2 + AC + 4r^2
The equation of the form: ax^2+bx+c
Now to find the maximum of above equation,
we find can be considered as a function f(AC) where AC is the unknown variable,
which can be done with differentiation . f '(AC)= 0 -2*AC +1, AC = 1/2
Substituting AC as 1/2 , function increases up to f(1/2) and then it decreases 
so the maximum value is at AC=1/2 

so, s = 0.25+4r^2
 * @author madhurbhargava
 *
 */
public class MAXLN {
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int numTestCases = Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++)
		{
			double num = Double.parseDouble(reader.readLine());
			double result = 0.25 + 4*Math.pow(num, 2);
			BigDecimal finalRes = new BigDecimal(result);
		    finalRes = finalRes.setScale(2, RoundingMode.HALF_UP);
		    out.println("Case "+(i+1)+": "+finalRes);
		    out.flush();
		}
	}

}
