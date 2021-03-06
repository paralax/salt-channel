package saltchannel.dev;

import java.io.IOException;
import org.junit.Test;

public class TcpTestServerTest {

    @Test
    public void testStartStop() throws IOException {
        int port = TcpTestServer.DEFAULT_PORT + 11;
        TcpTestServer s1 = TcpTestServer.createEchoServer(port);
        s1.start();
        s1.stop();
    }
    
    @Test
    public void testMultipleStartStop() throws IOException {
        int port = TcpTestServer.DEFAULT_PORT + 11;
        
        TcpTestServer s1 = TcpTestServer.createEchoServer(port);
        s1.start();
        s1.stop();
        
        TcpTestServer s2 = TcpTestServer.createEchoServer(port);
        s2.start();
        s2.stop();
        
        TcpTestServer s3 = TcpTestServer.createEchoServer(port);
        s3.start();
        s3.stop();
    }
}
