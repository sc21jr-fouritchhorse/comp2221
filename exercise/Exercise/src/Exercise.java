import java.net.*;


public class Exercise {

    static String findMatching(byte[] a1, byte[] a2)
    {
        String a1_s = printAddress(a1);
        String a2_s = printAddress(a2);
        String bytes1[] = a1_s.split(".");
        String bytes2[] = a2_s.split(".");
        StringBuilder out = new StringBuilder()
        for (int i = 0; i < 4; i++)
        {
            if (bytes1[i] == bytes2[i])
                out.append(bytes1[i]);
            else
                out.append('*');
            if (i < 4)
                out.append('.');
        }
        return out.toString();
    }
    static String printAddress(byte[] address)
    {
        StringBuilder sb = new StringBuilder();
        for (byte b : address) {
            int b_1 =  (int) b & 0xff;
            sb.append(b_1);
            if(isv4(address))
                sb.append('.');
            else if (isv6(address))
                sb.append(':');
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
    static boolean isv6(byte[] address)
    {
        return address.length == 16;
    }
    static boolean isv4(byte[] address)
    {
        return address.length == 4;
    }
    public static void main(String[] args) {
        //Will always have at least one address
        InetAddress myAddress = null;
        switch (args.length)
        {
            case 1:
                try
                {
                    myAddress = InetAddress.getByName(args[0]);
                }
                catch (UnknownHostException e)
                {
                    System.err.println("ERROR: Invalid hostname");
                    return;
                }
                byte[] ip_bytes = myAddress.getAddress();
                //print the hostname and IP address to the terminal
                System.out.println(args[0] + ' ' + printAddress(myAddress.getAddress()));
                //Determine if arg[1] is an IPv4 or IPv6
                System.out.print("The above address is an ");
                if(isv4(myAddress.getAddress()))
                    System.out.print("IPv4");
                else if(isv6(ip_bytes))
                    System.out.print("IPv6");
                else
                    System.err.print("invalid");
                System.out.println(" address");
                return;
            case 2:
                InetAddress myAddress_2 = null;
                try
                {
                    myAddress = InetAddress.getByName(args[0]);
                    myAddress_2 = InetAddress.getByName(args[1])
                }
                catch (UnknownHostException e)
                {
                    System.out.println("ERROR: Invalid hostname(s)");
                    return;
                }
                byte[] ip_bytes_1 = myAddress.getAddress();
                byte[] ip_bytes_2 = myAddress_2.getAddress();
                //Test if both arg[1] and arg[2] are valid IPv4 addresses
                if(isv4(ip_bytes_1) && isv4(ip_bytes_2))
                {
                    System.out.println(findMatching(ip_bytes_1, ip_bytes_2));
                }
                return;
            default:
                System.err.println("ERROR: Unexpected or no arguments provided");
        }
    }
}