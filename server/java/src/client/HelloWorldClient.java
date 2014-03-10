package client;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import thrift.HelloWorld;
import thrift.Person;

import java.util.Scanner;

/**
 * User: cyberroadie
 * Date: 10/03/2014
 */
public class HelloWorldClient {

    public static void main(String[] args) throws TException {
        TTransport transport = new TSocket("localhost", 6060);
        transport.open();
        TProtocol protocol = new TBinaryProtocol(transport);
        HelloWorld.Client client = new HelloWorld.Client(protocol);

        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("First name:");
            String input = s.next();
            Person person = new Person(input);
            input = s.next();
            System.out.println("Last name:");
            person.setLastName(input);
            String response = client.getGreeting(person);
            System.out.println(response);
        }

    }

}
