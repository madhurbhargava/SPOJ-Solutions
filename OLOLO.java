import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/**
 * SPOJ Problem: Onotole needs your help(OLOLO)
 * Apart from the usual bitwise logic, the trick lies in input handling.
 * It will require the most efficient input handling in java which can only 
 * be achieved via BufferedReader.
 * @author madhurbhargava
 */
public class OLOLO {
	
	private static InputStream stream;
    private static byte[] buf = new byte[102400]; //a byte buffer to store the characters in
    private static int curChar; //to hold the count of current character
    private static int numChars; //number of characters

	public static void main(String[] arguments) throws Exception
	{
		stream = System.in;
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = readInt();//Integer.parseInt(reader.readLine());
		int result = 0;
		int num2;
		for(int i = 0; i < num; i++)
		{
			num2 = readInt();//Integer.parseInt(reader.readLine());
			result = result ^ num2;
		}
		out.println(result);
		out.flush();
		
	}
	
	public static final int read() 
	{
        if (numChars == -1)
                throw new InputMismatchException();
        if (curChar >= numChars) {
                curChar = 0;
                try {
                        numChars = stream.read(buf); //this is the implicit function present in the inputStream which reads a Character into a temporary buffer
                } catch (IOException e) {
                        throw new InputMismatchException();
                }
                if (numChars <= 0)
                        return -1;
        }
        return buf[curChar++];
	}
	
	public static final int readInt() 
	{ //a function to read nextInteger skipping the newlines and empty spaces
        int c = read();
        while (isSpaceChar(c)) //
                c = read();
        int sgn = 1;
        if (c == '-') { //if the number is negative
                sgn = -1;
                c = read();
        }
        int res = 0; //integer variable to hold the number
        do {
                if (c < '0' || c > '9')
                        throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
	}
	
	public static final long readLong() { //similar as Integer
        int c = read();
        while (isSpaceChar(c))
                c = read();
        int sgn = 1;
        if (c == '-') {
                sgn = -1;
                c = read();
        }
        long res = 0;
        do {
                if (c < '0' || c > '9')
                        throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
	}

	public final  static boolean isSpaceChar(int c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
	
	
}
