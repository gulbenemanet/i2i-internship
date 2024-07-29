package com.example;

import org.voltdb.*;
import java.io.IOException;
import java.util.ArrayList;
import org.voltdb.client.*;

public class Main {

    private final Client client;

    public Main(String servers) throws Exception {
        client = ClientFactory.createClient();
        client.createConnection(servers);
    }

    public ArrayList<Subscriber> getSubscribers() throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("GetSubscriber");

        if (response.getStatus() != ClientResponse.SUCCESS) {
            System.err.println(response.getStatusString());
            return new ArrayList<>(); 
        } else {
            ArrayList<Subscriber> subscribers = new ArrayList<>();
            VoltTable voltTable = response.getResults()[0];

            while (voltTable.advanceRow()) {
                subscribers.add(new Subscriber(
                        (int) voltTable.get("SUBSC_ID", VoltType.INTEGER),
                        voltTable.getString("SUBSC_NAME"),
                        voltTable.getString("SUBSC_SURNAME"),
                        voltTable.getString("MSISDN"),
                        (int) voltTable.get("TARIFF_ID", VoltType.INTEGER),
                        voltTable.getTimestampAsLong("START_DATE")
                ));
            }

            return subscribers;
        }
    }

    public static void main(String[] args) {
        try {
            Main voltdb = new Main("localhost:32776");
            ArrayList<Subscriber> subscribers = voltdb.getSubscribers();

            for (Subscriber subscriber : subscribers) {
                System.out.println(subscriber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Subscriber {

    private int id;
    private String name;
    private String surname;
    private String msisdn;
    private int tariffId;
    private long dateTimeStamp;

    public Subscriber(int id, String name, String surname, String msisdn, int tariffId, long dateTimeStamp) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.msisdn = msisdn;
        this.tariffId = tariffId;
        this.dateTimeStamp = dateTimeStamp;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", msisdn='" + msisdn + '\'' +
                ", tariffId=" + tariffId +
                ", dateTimeStamp=" + dateTimeStamp +
                '}';
    }
}
