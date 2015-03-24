import java.io.BufferedReader;
import java.io.IOException;

/**
 * SPOJ problem Tricount, Simple Formula based approach
 * @author mbhargava
 *
 */
public class TRICOUNT {
	public static void main(String[] a) throws IOException {
		BufferedReader r = new BufferedReader(new java.io.InputStreamReader(
				System.in));
		int n1 = Integer.parseInt(r.readLine());
		for (int i = 0; i < n1; i++) {
			long result = 0;
			long n = Long.parseLong(r.readLine());
			result = n * (n + 2) * (2 * n + 1) / 8;
			System.out.println(result);
		}
	}
}
