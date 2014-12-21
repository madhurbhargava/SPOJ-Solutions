import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;
 
/**
 * SPOJ: BISHOPS
 * Big input handling. Simple paper simulation helped in solving.
 * @author madhurbhargava
 */
public class BISHOPS {
 
	
	private static BigInteger TWO = new BigInteger("2");
	
	public static void main(String []args) throws NumberFormatException, IOException
	{
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int num = 0;
		
		while(num < 1024)
		{
			BigInteger in = scan.nextBigInteger();
			if(!(in.intValue() == 1 || in.intValue() == 0))
			{
				in = (in.subtract(BigInteger.ONE)).multiply(TWO);
			}
			out.println(in);
			out.flush();
			num++;
		}
	}
	
	
 
}
 