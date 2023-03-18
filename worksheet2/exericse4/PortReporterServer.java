import java.io.*;
import java.net.*;
import java.util.*;

public class PortReporterServer
{
    public void runServer() {
        try 
        {
            ServerSocket serverSock = new ServerSocket(5555);

            System.out.println( "SERVER: Listening on " + serverSock.getLocalPort() + "." );
            

            while( true )
            {
                Socket sock = serverSock.accept();

                System.out.println( "SERVER: using local port " + sock.getLocalPort() + " and remote port " + sock.getPort() + "." );

                sock.close();
            }

        }
        catch(IOException ex) 
        {
            System.out.println( ex );
        }
    }

    public static void main(String[] args) {
        PortReporterServer prs = new PortReporterServer();
        prs.runServer();
    }
}