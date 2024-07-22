/*
 *  6510450411
 *  Thanachote Ngamkana
 */
package Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class IO {
  private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

  public void print(String str) {
    try {
      writer.write(str);
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int input() {
    String str;
    try {
      str = reader.readLine().trim();
      return Integer.parseInt(str);
    } catch (IOException | NumberFormatException e) {
      e.printStackTrace();
    }

    return -1;
  }
}
