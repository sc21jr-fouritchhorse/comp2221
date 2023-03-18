import java.io.*;
import java.net.*;

public class PortReporterClient
{
    private String hostname = "localhost";
    private Socket s = null;
    public void reportPort()
    {
        try {
            s = new Socket(hostname, 5555);
            System.out.println("My port is " + s.getLocalPort() + 
            "\n and my server's port is " +  s.getPort());
            s.close();
        } catch (UnknownHostException e) {
            System.err.println("Couldn't find host!");
        }  catch (IOException e) {
            System.err.println(e);
        }
        
    }
    public static void main( String[] args )
    {
        PortReporterClient prc = new PortReporterClient();
        prc.reportPort();
    } 
}