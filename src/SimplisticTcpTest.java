import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

// TODO: Replace examples and use TDD development by writing your own tests

public class SimplisticTcpTest {

    @Test
    public void SampleTests() {
        assertEquals("CLOSE_WAIT",   TCP.traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN"}));
        assertEquals("ESTABLISHED",  TCP.traverseStates(new String[] {"APP_PASSIVE_OPEN", "RCV_SYN","RCV_ACK"}));
        assertEquals("LAST_ACK",     TCP.traverseStates(new String[] {"APP_ACTIVE_OPEN","RCV_SYN_ACK","RCV_FIN","APP_CLOSE"}));
        assertEquals("SYN_SENT",     TCP.traverseStates(new String[] {"APP_ACTIVE_OPEN"}));
        assertEquals("ERROR",        TCP.traverseStates(new String[] {"APP_PASSIVE_OPEN","RCV_SYN","RCV_ACK","APP_CLOSE","APP_SEND"}));
    }
}

class TCP {
    public static String traverseStates(String[] events) {
        String [] states = {"CLOSED","LISTEN","SYN_RCVD","SYN_SENT",
                            "ESTABLISHED","FIN_WAIT_1","CLOSING",
                            "FIN_WAIT_2","TIME_WAIT","CLOSE_WAIT","LAST_ACK"};
//
        HashMap<HashMap<String, String>, String> eventsMap = new HashMap<>();
        eventsMap.put("CLOSED","APP_PASSIVE_OPEN", "LISTEN");
        eventsMap.put("APP_ACTIVE_OPEN", "SYN_SENT");
        eventsMap.put("RCV_SYN", "SYN_RCVD");
        eventsMap.put("APP_SEND", "SYN_SENT");
        eventsMap.put("APP_CLOSE", "CLOSED");
        eventsMap.put("APP_CLOSE", "FIN_WAIT_1");
        eventsMap.put("RCV_ACK", "ESTABLISHED");
        eventsMap.put("RCV_SYN", "SYN_RCVD");
        eventsMap.put("RCV_SYN_ACK", "ESTABLISHED");
        eventsMap.put("APP_CLOSE", "CLOSED");
        eventsMap.put("APP_CLOSE", "FIN_WAIT_1");
        eventsMap.put("RCV_FIN", "CLOSE_WAIT");
        eventsMap.put("RCV_FIN", "CLOSING");
        eventsMap.put("RCV_FIN_ACK", "TIME_WAIT");
        eventsMap.put("RCV_ACK", "FIN_WAIT_2");
        eventsMap.put("RCV_ACK", "TIME_WAIT");
        eventsMap.put("RCV_FIN", "TIME_WAIT");
        eventsMap.put("APP_TIMEOUT", "CLOSED");
        eventsMap.put("APP_CLOSE", "LAST_ACK");
        eventsMap.put("RCV_ACK", "CLOSED");
        for(String ev : events){
            String event = ev;
            eventsMap.get(ev);

        }

        String state = "CLOSED";                        // initial state, always
        // Your code here!
        return null;
    }
}
