package cn.niceabc.rpc.server;

import cn.niceabc.rpc.auth.AuthServiceImpl;
import cn.niceabc.rpc.auth.RPCNetAuthService;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

public class Main {

    public static void main(String[] args) {
        try {
            // 设置协议工厂为 TBinaryProtocol.Factory
            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();
            // 关联处理器与 Hello 服务的实现
            TMultiplexedProcessor processor = new TMultiplexedProcessor();
            TServerTransport t = new TServerSocket(8200);
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(t).processor(processor));
            processor.registerProcessor(
                    RPCNetAuthService.class.getSimpleName(),
                    new RPCNetAuthService.Processor<RPCNetAuthService.Iface>(new AuthServiceImpl())
            );
//         TSimpleServer server = new TSimpleServer(new Args(t).processor(processor));
            System.out.println("the serveris started and is listening at 8200...");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
