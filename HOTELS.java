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
import java.util.StringTokenizer;

/**
 * SPOJ Problem: Hotels along croation coast(HOTELS)
 * Fastest IO needed in Java
 * @author madhurbhargava
 *
 */
public class HOTELS {
	
	public static void main(String[] args) throws Exception
	{
		Parser in = new Parser(System.in);
	    PrintWriter out = new PrintWriter(System.out, true);
	    int n = in.nextInt();
        int max = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
		int res = spiderWalk(arr, max);
		out.println(res);
		out.flush();
	}
	
	private static int spiderWalk(int[] arr, final int max)
	{
		int counter  = 0;
		if(arr[counter] > max)
		{
			while(arr[counter]>max)
			{
				counter++;
			}
		}
		int result = 0; //arr[counter];
		int sum = 0;//arr[counter];
		int i = counter - 1;
		int j = counter;
		while(true)
		{
			if(i == arr.length - 1 && j == arr.length-1)
			{
				break;
			}
			
			if(i == arr.length - 1 || sum > max)
			{
				sum = sum - arr[j];
				j++;
			}
			else
			{
				i++;
				sum = sum + arr[i];
				
			}
			
			if(sum > result && sum <= max)
			{
				result = sum;
			}
		}
		return result;
		
	}
	
	private static int[] converToIntArr(String data, final int len)
	{
		int arr[] = new int[len];
		StringTokenizer tokens = new StringTokenizer(data);
		int i = 0;
		while(tokens.hasMoreTokens())
		{
			arr[i++] = Integer.parseInt(tokens.nextToken());
		}
		return arr;
	}
	
	/**
     * A fast parser taking in an InputStream, with self-maintained buffer
     */
    static class Parser {
        final private int BUFFER_SIZE = 65536;  // 2^16, a good compromise for some problems
        private InputStream din;    // Underlying input stream
        private byte[] buffer;      // Self-maintained buffer
        private int bufferPointer;  // Current read position in the buffer
        private int bytesRead;      // Effective bytes in the buffer read from the input stream

        public Parser(InputStream in) {
            din = in;
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        /**
         * Read the next integer from the input stream.
         * @return The next integer.
         * @throws java.io.IOException
         */
        public int nextInt() throws IOException {
            int result = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            while (c >= '0' && c <= '9') {
                result = result * 10 + c - '0';
                c = read();
            }
            if (neg) return -result;
            return result;
        }

        /**
         * Read a line of data from the input stream.
         * @return the next line of data.
         * @throws IOException if an I/O error occurs.
         */
        public String readLine() throws IOException {
            StringBuilder line = new StringBuilder();
            char c;
            while ((c = (char)(read())) != '\n') {
                line.append(c);
            }
            return line.toString();
        }

        /**
         * Read the next byte of data from the input stream.
         * @return the next byte of data, or -1 if the end of the stream is reached.
         * @throws IOException if an I/O error occurs.
         */
        public byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        /**
         * Read data from the input stream into the buffer
         * @throws IOException if an I/O error occurs.
         */
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
    }

}
