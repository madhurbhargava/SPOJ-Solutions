import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

/**
 * SPOJ Problem: Flowers Flourish from France(MFLAR 10)
 * @author madhurbhargava
 *
 */
public class MFLAR10 {
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
	public static void main(String[] args) throws Exception
	{
		BufferedReader reader=new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		//int numTestCases=Integer.parseInt(reader.readLine());
		//InputReader in 		= new MFLAR10().new InputReader(System.in);
        //OutputWriter out	=	new MFLAR10().new OutputWriter(System.out);
		//int numTestCases = in.readInt();//Integer.parseInt(reader.readLine());
		while(true)
		{
			
			String str = reader.readLine();
			if(str.equals("*"))
			{
				break;
			}
			else
			{
				String[] strData = str.split(" ");
				String fchar = strData[0].substring(0, 1);
				boolean status = true;
				for(int i = 1; i < strData.length; i++)
				{
					if(!fchar.equalsIgnoreCase(strData[i].substring(0, 1)))
					{
						status = false;
						break;
					}
				}
				if(status)
				{
					out.println("Y");
				}
				else
				{
					out.println("N");
				}
				out.flush();
			}
			
			
		}
		
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
