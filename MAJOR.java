import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

/**
 * SPOJ Problem: Majority(MAJOR)
 * Code makes use of Moore's Voting Algo.
 * Just the algo is not enough, fastest I/O in java will be required.
 * @author madhurbhargava
 *
 */
public class MAJOR {
	
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
	
	private static String YES = "YES";
	private static String NO = "NO"; 
	public static void main(String[] arguments) throws Exception
	{
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
		InputReader in 		= new MAJOR().new InputReader(System.in);
        OutputWriter out	=	new MAJOR().new OutputWriter(System.out);
		int numTestCases = in.readInt();//Integer.parseInt(reader.readLine());
		for(int i = 0; i < numTestCases; i++)
		{
			int arrLen = in.readInt();//reader.readLine();
			//String data = reader.readLine();
			int[] nums = IOUtils.readIntArray(in,arrLen);//convertToInt(data);
		    int majorityCandidate = findMajority(nums);
		    boolean flag = isMajority(nums, majorityCandidate);
		    if(flag)
		    {
		    	out.printLine(YES+" "+majorityCandidate);
		    }
		    else
		    {
		    	out.printLine(NO);
		    }
		    out.flush();
		}
		out.close();
	}
	
	private static boolean isMajority(int a[],  int cand)
	{
		int count = 0;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == cand)
			{
				count++;
			}
		}
		
		if(count > a.length/2)
		{
			return true;
		}
		return false;
	}
	
	private static int findMajority(int[] nums)
	{
		int majority = -1;
		int count = 0;
		for(int i = 0; i < nums.length; i++)
		{
			if(majority == nums[i] || majority == -1)
			{
				majority = nums[i];
				count++;
			}
			else
			{
				count--;
			}
			if(count == 0)
			{
				majority = -1;
			}
		}
		return majority;
	}
	
	private static int[] convertToInt(String data)
	{
		StringTokenizer tokens = new StringTokenizer(data);
		final int[] arr = new int[tokens.countTokens()];
		int i = 0;
		while(tokens.hasMoreTokens())
		{
			arr[i++] = Integer.parseInt(tokens.nextToken());
		}
		return arr;
	}
	
	class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

	}

class OutputWriter {
		private final PrintWriter writer;

		public OutputWriter(OutputStream outputStream) {
			
			writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
		}

		public OutputWriter(Writer writer) {
			this.writer = new PrintWriter(writer);
		}

		public void print(Object...objects) {
			for (int i = 0; i < objects.length; i++) {
				if (i != 0)
					writer.print(' ');
				writer.print(objects[i]);
			}
		}

		public void printLine(Object...objects) {
			print(objects);
			writer.println();
		}

		public void close() {
			writer.close();
		}

		public void flush() {
			writer.flush();
		}

		}

static class IOUtils {

		public static int[] readIntArray(InputReader in, int size) {
			int[] array = new int[size];
			for (int i = 0; i < size; i++)
				array[i] = in.readInt();
			return array;
		}

		}
	
}
