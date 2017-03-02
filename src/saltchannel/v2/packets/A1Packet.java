package saltchannel.v2.packets;

import saltchannel.BadPeer;
import saltchannel.util.Deserializer;
import saltchannel.util.Serializer;

/**
 * Data of A1 message, low-level serialization / deserialization.
 * 
 * @author Frans Lundberg
 */
public class A1Packet implements Packet {
    public static final int PACKET_TYPE = 8;
    private static final int CLOSE_BIT_INDEX = 0;
    
    public int getType() {
        return PACKET_TYPE;
    }
    
    public int getSize() {
        return PacketHeader.SIZE;
    }
    
    public void toBytes(byte[] destination, int offset) {
        Serializer s = new Serializer(destination, offset);
        PacketHeader header = new PacketHeader(PACKET_TYPE);
        boolean closeBit = true;
        header.setBit(CLOSE_BIT_INDEX, closeBit);
        s.writeHeader(header);
    }
    
    public static A1Packet fromBytes(byte[] source, int offset) {
        A1Packet p = new A1Packet();
        Deserializer d = new Deserializer(source, offset);
        PacketHeader header = d.readHeader();
        
        int packetType = header.getType();
        if (packetType != PACKET_TYPE) {
            throw new BadPeer("unexpected packet type, " + packetType);
        }
        
        boolean close = header.getBit(CLOSE_BIT_INDEX);
        
        if (!close) {
            throw new BadPeer("close flag must be set");
        }
        
        return p;
    }
}
