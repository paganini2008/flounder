package indi.atlantis.framework.vortex.common;

import java.net.SocketAddress;

/**
 * 
 * NioConnection
 *
 * @author Fred Feng
 * @version 1.0
 */
public interface NioConnection {

	void connect(SocketAddress remoteAddress, HandshakeCallback handshakeCallback);

	boolean isConnected(SocketAddress remoteAddress);

}
