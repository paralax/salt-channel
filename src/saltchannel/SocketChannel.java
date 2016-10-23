package saltchannel;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * A thin wrapper around a Socket to adapt it to a Channel.
 * 
 * @author Frans Lundberg
 */
public class SocketChannel implements ByteChannel {
    private final StreamChannel channel;
    
    /**
     * Creates a StreamChannel from a socket. The input stream of the socket
     * is wrapped with a BufferedInputStream. The output stream is not wrapped.
     * The socket is never closed by this class.
     * 
     * @param socket
     * @throws IOException
     */
    public SocketChannel(Socket socket) throws IOException {
        BufferedInputStream b = new BufferedInputStream(socket.getInputStream());
        channel = new StreamChannel(b, socket.getOutputStream());
    }
    
    public byte[] read() throws ComException {
        return channel.read();
    }

    public void write(byte[]... messages) throws ComException {
        channel.write(messages);
    }
}
