//
// Simple Java code intended as a refresher for students who need to 'brush up' on their Java.
// There are no network featires in this example.
//
// Compile with: javac ParseCmdLineArgs.java
// Execute with: java ParseCmdLineArgs arg1 arg2 arg3 ...
//

import java.util.Collection;

public class ParseCmdLineArgs {

    private java.util.ArrayList<String> my_arguments;
    public enum argType
    {
        UNKOWN    (0, ""),
        IP_ADDRESS_V4(3, "may be an IPv4 address"),
        IP_ADDRESS_V6(4, "may be an IPv6 address"),
        HOSTNAME     (1, "may be a hostname");

        private final String output;
        private final int val;
        private argType(int value, String typeString)
        {
            val = value;
            output = typeString;
        }

        public String getString()  { return output; }

    };
    int countChar(String arg, char target)
    {
        int count = 0;
        for (char c: arg.toCharArray()) {
            if(c == target)
            {
                count += 1;
            }
        }
        return count;
    }
    void printArg(String arg)
    {
        System.out.println(arg);
        int dotCount;
        argType myType;
        if((dotCount = countChar(arg, '.')) > 0) {
            if (dotCount == 3)
                myType = argType.IP_ADDRESS_V4;
            else
                myType = argType.HOSTNAME;
        }   else
        {
            myType = argType.UNKOWN;
        }

        if(myType != argType.UNKOWN)
        {
            System.out.println("(" + myType.getString() + ")");
        }

    }


    void printAll()
    {
        for (String a: my_arguments) {
            printArg(a);
        }
    }

    // The sole constructor, which expects the command line arguments to be provided as a String array.
    public ParseCmdLineArgs(String[] args)
    {
        my_arguments = new java.util.ArrayList<String>();
        for (String s: args) {
            if(s.length() > 0)
                my_arguments.add(s);
        }

    }

    // main(): This is the function that is called after executing with 'java ParseCmdLineArgs'.
    // Any command line arguments are passed as the string array 'String[] args', i.e. if you execute the code with
    //   java ParseCmdLineArgs arg1 arg2 arg3
    // then String[] args will be an array of length 3, containing the strings 'arg1', arg2', and arg3.'
    public static void main(String[] args) {
        ParseCmdLineArgs parser = new ParseCmdLineArgs(args);
        if(args.length == 0 || parser.my_arguments.isEmpty()) {
            System.err.println("ERROR: No args provided");
            return;
        }
        else
            parser.printAll();
    }
}