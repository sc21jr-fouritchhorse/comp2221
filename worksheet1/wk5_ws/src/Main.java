import java.net.*;

public class Lookup {
    private InetAddress inet = null;
    public void resolve(String host)
    {
        try {
            inet = InetAddress.getByName(host);
            System.out.println("Host name :
        }
        catch(UnknownHostException e)
        }
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}