public class Exercise07_String1 {

  // Given a string, compute recursively (no loops) a new string where all the
  // lowercase 'x' chars have been changed to 'y' chars.

  public static void main(String[] args) {

    String modifiedString = stringReplacer("aXxnxnxXxutr", 0);
    System.out.println(modifiedString);
  }

  public static String stringReplacer (String inputString, int index) {
    String modifiedString = inputString;

    if (modifiedString.charAt(index) == 'x') {
      modifiedString = modifiedString.replace(modifiedString.charAt(index), 'y');
    }

    index++;

    if (!modifiedString.contains("x")) {
      return modifiedString;
    } else {
      return stringReplacer(modifiedString, index);
    }
  }
}
