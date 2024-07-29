package akka_2;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import com.typesafe.config.ConfigFactory;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ActorSystem2", ConfigFactory.load("application.conf"));
        
        ActorRef actor2 = system.actorOf(Actor2.props(), "actor2");
        
        System.out.println("\"Actor2 is up and running: \" + actor2");
        
    }
}
