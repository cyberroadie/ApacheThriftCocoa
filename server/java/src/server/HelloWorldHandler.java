package server;

import org.apache.thrift.TException;
import thrift.HelloWorld;
import thrift.Person;

/**
 * User: cyberroadie
 * Date: 10/03/2014
 */
public class HelloWorldHandler implements HelloWorld.Iface {

    @Override
    public String getGreeting(Person person) throws TException {
        if(person.firstName == null || person.firstName == "") {
            throw new TException("First name required");
        }
        String first = "Hello " + person.firstName;
        if(person.lastName != "" || person.lastName != null) {
            first += " " + person.lastName;
        }
        return first + "!!!!";
    }

}
