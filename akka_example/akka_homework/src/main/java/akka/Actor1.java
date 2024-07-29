package akka;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.Props;

public class Actor1 extends AbstractActor {
    private ActorSelection actor2Selection;

    public static Props props() {
        return Props.create(Actor1.class, () -> new Actor1());
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
        		.match(StartMessage.class, msg -> {
                    this.actor2Selection = msg.actorSelection;
                    actor2Selection.tell("Hi from Actor1", getSelf());
                })
                .matchEquals("Hi back from Actor2", msg -> {
                    System.out.println("Received reply in Actor1: " + msg);
                    // Reply back to Actor2
                    actor2Selection.tell("How are you, Actor2?", getSelf());
                })
                .matchEquals("I'm good, Actor1!", msg -> {
                    System.out.println("Received another reply in Actor1: " + msg);
                })
                .build();
    }
}
