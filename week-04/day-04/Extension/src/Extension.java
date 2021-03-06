import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by aze on 2017.04.04..
 */
public class Extension {
  int add(int a, int b) {
    return a + b;
  }

  int maxOfThree(int a, int b, int c) {
    int maxNumber = a;
    if (b > maxNumber) {
      maxNumber = b;
    }
    if (c > maxNumber) {
      maxNumber = c;
    }
    return maxNumber;
  }

  double median(List<Double> pool) {
    Collections.sort(pool);
    if (pool.size() % 2 == 0) {
      return ((pool.get(pool.size() / 2)) + (pool.get(pool.size() / 2 - 1))) / 2;
    }
    return pool.get(pool.size() / 2);
  }

  boolean isVowel(char c) {
    return Arrays.asList('a', 'á' ,'u', 'ú', 'o', 'ó', 'e', 'é', 'i', 'í', 'ö', 'ő', 'ü', 'ű').contains(c);
  }

  String translate(String hungarian) {
    String teve = hungarian;
    int length = teve.length();
    for (int i = 0; i < length; i++) {
      char c = teve.charAt(i);
      if (isVowel(c)) {
        teve = String.join(c + "v" + c, teve.split(""+c));
        i+=2;
        length+=2;
      }
    }
    return teve;
  }
}