import lab5.stacks.*;
import lab5.queues.*;
import java.util.Date;

public class PalindromeRaces
{
  static final int N = 100;
  static final int M = 1500000; 
  public static void main(String[] asd)
  {
    String nonPalindrome = genRandomNonPalindrome(N);
    String palindrome = genRandomPalindrome(N);
    System.out.println(isPalindromeFancy(nonPalindrome));
    System.out.println(isPalindromePlain(nonPalindrome));
    long startTime, elapsedTime;
    //tests isPalindromeFancy()
    startTime = (new Date()).getTime();
    for(int i = 0; i < M; i++)
    {
      if(isPalindromeFancy(palindrome)!= true)
        break;
    }
    elapsedTime = (new Date()).getTime() - startTime;
    System.out.println("Fancy");
    System.out.println (elapsedTime + " milliseconds");
    System.out.println();
    //tests isPalindromePlain()
    startTime = (new Date()).getTime();
    for(int i = 0; i < M; i++)
    {
      if(!isPalindromePlain(palindrome))
        break;
    }
    elapsedTime = (new Date()).getTime() - startTime;
    System.out.println("Plain");
    System.out.println (elapsedTime + " milliseconds");
    
  }
  
  public static String genRandomPalindrome(int N)
  {
    String half = genRandomString(N);
    String reversedHalf = "";
    for(int i = N - 1; i >= 0; i--)
    {
      reversedHalf = reversedHalf + half.charAt(i);
    }
    return half + reversedHalf;
      
  }
    
  public static String genRandomNonPalindrome(int N)
  {
    String half = genRandomString(N);
    return half + half;
  }
    
    public static String genRandomString(int N)
    {
      final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
      String randomString = "";
      int i;
      for(int n = 0; n < N; n++)
      {
        i = (int)(26 * Math.random());
        randomString = randomString + LOWERCASE.charAt(i);
      }
      return randomString;
      
    }
    
    public static boolean isPalindromeFancy(String s) {
        char c;
        BoundedQueueInterface<Character> queue =
            new ArrayBndQueue<Character>(new Character[s.length()]);
        BoundedStackInterface<Character> stack =
            new ArrayStack<Character>(new Character[s.length()]);
        for (int i=0; i<s.length(); i++) {
            c = s.charAt(i);
            queue.enqueue(c);
            stack.push(c);
        }
        for (int i=0; i<s.length(); i++) {
            c = queue.dequeue();
            if (c != stack.top())
                return false;
            stack.pop();
        }
        return true;
    }
    
    public static boolean isPalindromePlain(String s) {
    int lo = 0;
    int hi = s.length()-1;
    while (lo < hi) {
        if (s.charAt(lo) != s.charAt(hi))
            return false;
        lo++;
        hi--;
    }
    return true;
    }
  }
    


 
 