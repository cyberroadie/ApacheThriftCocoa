import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * User: cyberroadie
 * Date: 10/03/2014
 */
public class HelloWorldServer implements Runnable {

    public static void main(String[] args) {
        new Thread(new HelloWorldServer()).run();
    }

    @Override
    public void run() {
        try {
            TServerTransport ts = new TServerSocket(6060);
            TServer server = new TThreadPoolServer(
                    new TThreadPoolServer.Args(ts).processor(
                            new HelloWorld.Processor<HelloWorldHandler>(new HelloWorldHandler())));
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
