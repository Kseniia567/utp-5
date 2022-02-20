import java.util.ArrayList;
import java.util.List;

public class Main {


        private static final int serviceCounter = 10;
        private static final int requesterCounter = 10;

        public static void main(String[] args) {

            MessageQueue requestQueue = new MessageQueue();
            MessageQueue responseQueue  = new MessageQueue();

            List<Service> serviceList = serviceList(requestQueue, responseQueue);
            List<Requester> requestList = requestList(requestQueue, responseQueue);




            serviceList.forEach(e -> new Thread(e).start());
            requestList.forEach(e -> new Thread(e).start());

        }

        private  static List <Service> serviceList(MessageQueue requestQueue, MessageQueue responseQueue){
            List<Service> list = new ArrayList<>();
            for (int i = 0; i < Main.serviceCounter; i++ ) {
                list.add(new Service(responseQueue, requestQueue));
            }
            return list;
        }

        private  static List <Requester> requestList(MessageQueue requestQueue, MessageQueue responseQueue){
            List<Requester> list = new ArrayList<>();
            for (int i = 0; i < Main.requesterCounter; i++ ){
                list.add(new Requester(responseQueue, requestQueue));
            }
            return list;
        }
    }

