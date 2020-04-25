import java.util.*;

/**
 * Java Methods Chapter 10
 * Exercises 2, 6 - 11, 14 - 15, 20 & 22 
 * 
 * @author Malavika Nair
 * @version October 11, 2019
 * 
 * @author Period - 1st
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - None
 */
public class JMCh10Exercises
{
    Scanner scan;

    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }

    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str  input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }

    // 10-2(a)
    public boolean endsWithStar( String s )
    {
        if (s.endsWith("*")) {
            return true;
        }else {
            return false;
        }
    }

    // 10-2(b)
    public boolean endsWith2Stars( String s )
    {
        if (s.endsWith("**")) {
            return true;
        }else {
            return false;
        }
    }

    // 10-6
    public String scroll( String s )
    {
        String v = s.substring(1,s.length());
        String u = s.substring(0,1);
        v = v+u;      
        return v; 
    }

    // 10-7
    public String convertName( String name )
    {
        int sep = name.indexOf(",");
        String last = name.substring(0,sep);
        String first = name.substring((sep +2),name.length());
        return (first+" "+last); 
    }
    
    // 10-8
    public String negate( String str )
    {
        str = str.replaceAll("0", "7");
        str = str.replaceAll("1", "0");
        str = str.replaceAll("7", "1");
        return str;
    } 

    // 10-9
    public boolean isConstant( String s )
    {
        char f = s.charAt(0);
        String e = s.substring(1);
        String str = e + f;
        
        if (str.equals(s))
        {
            return true;
        }
        else
        {
            return false;
        }

       
    }

    // 10-10
    public String removeComment( String str )
    {
        int open = str.indexOf( "/*" );
        int close = str.indexOf( "*/", open);
        if (open == -1 && close == -1) {
            return str;
        }else if (open != -1 && close != -1) {
           String beg = str.substring( 0, open);
           String end = str.substring( close +2, str.length() );
           String ans = beg+ end;
           return ans;
        }else {
            return str;
        }
        
    }

    // 10-11
    public String cutOut( String s, String s2 )
    {
        int num = s.indexOf(s2);
        
        if ( num >= 0 )
        {
            s = s.substring(0, num) + s.substring(num + s2.length());
        }

        return s;
    }

    // 10-14
    public String removeHtmlTags( String str )
    {
        int o1 = str.indexOf( "<" );
        int c = str.indexOf( ">", o1);
        int o2 = str.indexOf("<", c);
        int c2 = str.indexOf(">", o2);
        if (o1 == -1 || c == -1 || o2 == -1 || c2 == -1) {
            return str;
        }else if (o1 != -1 && c != -1 && o2 != -1 && c2 != -1) {
            String beg = str.substring(0,o1);
            String mid = str.substring(c +1, o2);
            String end = str.substring(c2 +1 , str.length());
            return beg +mid+ end;
        }else {
            return str;
        }
        
        
       
    }

    // 10-15
    public boolean onlyDigits( String s )
    {
        for (int k = 0; k < s.length(); k++)
        {
            if (Character.isDigit(s.charAt(k)) != true)
            {
                return false;
            }
        }
        return true;
    }

    // 10-20
    public static boolean isValidISBN( String isbn )
    {
        int k = isbn.length(); 
        if (k != 10) 
            return false; 
  
        int sum = 0; 
        for (int i = 0; i < 9; i++)  
        { 
            int num = isbn.charAt(i) - '0'; 
            if (0 > num || 9 < num) 
                return false; 
            sum += (num * (10 - i)); 
        } 
        char last = isbn.charAt(9); 
        if (last != 'X' && (last < '0' ||  last > '9')) {
            return false; 
        }
        sum = sum  + ((last == 'X') ? 10 : (last - '0')); 
        return (sum % 11 == 0); 
    }

    // 10-22
    public String shuffle( String s )
    {
        StringBuffer shuffledString = new StringBuffer(""); 

        while (s.length() != 0)
        {
            int index = (int) Math.floor(Math.random() * s.length());
            char c = s.charAt(index);
            s = s.substring(0,index)+s.substring(index+1);
            shuffledString.append( c );
        }

        return shuffledString.toString();
    }

    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes
     * each method.
     * 
     * @param args command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out.println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out.println( "   (7) 10-10 removeComment( String str )" );
            System.out.println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out.println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out.println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" ); 
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println("endsWithStar(" + end1Star + ") = " +
                            exercise.endsWithStar(end1Star));
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println("endsWithStar(" + ends0Star + ") = " +
                            exercise.endsWithStar(ends0Star));
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println("endsWith2Stars(" + end2Str + ") = " +
                            exercise.endsWith2Stars(end2Str));
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println("endsWith2Stars(" + endsWith1Star + ") = " +
                            exercise.endsWith2Stars(endsWith1Star));
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println("scroll(\"" + scrollStr + "\") --> " + 
                            "\"" + exercise.scroll(scrollStr) + "\"");
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println("convertName(\"" + convStr + "\") --> " +
                            "\"" + exercise.convertName(convStr) + "\"");
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println("negate(\"" + negStr + "\") --> " +
                            "\"" + exercise.negate(negStr) + "\"");
                        break;
                    case '6':
                        String constStr1 = "1010101000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println("isConstant(\"" + constStr1 + "\") = " +
                            exercise.isConstant( constStr1 ) );
                        System.out.println("isConstant(\"" + constStr2 + "\") = " +
                             exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println("removeComment(\"" + comment + "\") --> " +
                            "\"" + exercise.removeComment( comment ) + "\"");
                        System.out.println("removeComment(\"" + notComment + "\") --> " +
                            "\"" + exercise.removeComment( notComment ) + "\"");
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println("cutOut(\"" + cutstr + "\", \"" + cutOutstr + "\") --> " +
                            "\"" + exercise.cutOut( cutstr, cutOutstr ) + "\"");
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println("removeHtmlTags(\"" + htmlStr + "\") --> " +
                            "\"" + exercise.removeHtmlTags(htmlStr) + "\"");
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println("onlyDigits(\"" + digitStr + "\") = " +
                            exercise.onlyDigits(digitStr) );
                        System.out.println("onlyDigits(\"" + dStr + "\") = " +
                            exercise.onlyDigits(dStr) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println("isValidISBN(\"" + validISBN + "\") = " +
                            exercise.isValidISBN(validISBN) );
                        System.out.println("isValidISBN(\"" + invalidISBN + "\") = " +
                            exercise.isValidISBN(invalidISBN) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println("shuffle(\"" + str +  "\") --> " +
                            "\"" + exercise.shuffle( str ) + "\"");
                        System.out.println("shuffle(\"" + str +  "\") --> " +
                             "\"" + exercise.shuffle( str ) + "\"");
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
