package akka;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import com.typesafe.config.ConfigFactory;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("ActorSystem1", ConfigFactory.load("app.conf"));
        ActorSelection actor2Selection = system.actorSelection("akka://ActorSystem2@127.0.0.1:2552/user/actor2");
        ActorRef actor1 = system.actorOf(Actor1.props(), "actor1");
        actor1.tell(new StartMessage(actor2Selection), ActorRef.noSender());
    }
}

class StartMessage {
    public final ActorSelection actorSelection;

    public StartMessage(ActorSelection actorSelection) {
        this.actorSelection = actorSelection;
    }
}
