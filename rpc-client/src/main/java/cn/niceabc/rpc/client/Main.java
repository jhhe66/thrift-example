package cn.niceabc.rpc.client;

import cn.niceabc.rpc.auth.RPCNetAuthService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws TException {
        // TSocket transport = new TSocket("localhost", 8200);
        TSocket transport = new TSocket("rpc-server", 8200);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);

        TMultiplexedProtocol tmp = new TMultiplexedProtocol(protocol, RPCNetAuthService.class.getSimpleName());

        RPCNetAuthService.Client client = new RPCNetAuthService.Client(tmp);


        transport.open();

        boolean bool = client.login("shiguang.ma", "123456");
        log.debug("client.login {}", bool);

        transport.close();

    }
}
