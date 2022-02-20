import java.util.PriorityQueue;
import java.util.Queue;

public class MessageQueue {
    private final Queue<Message> _messageQueue;


    public MessageQueue(){
        _messageQueue = new PriorityQueue<>();
    }


    public synchronized void addResponseInTheQueue(Message message){
        if ( !_messageQueue.offer(message) ){
            throw new RuntimeException();
        }
    }

    public synchronized Response removeResponse(Requester requester){
        Response r = null;
        Message message = _messageQueue.peek();
        if (message != null){
            if (message.getRequester() == requester){
                r = removeResponse();
            }
        }
        return r;
    }

    public synchronized Response removeResponse(){
        return (Response) _messageQueue.poll();
    }


    public synchronized void addRequestInTheQueue(Message message){
        if ( !_messageQueue.offer(message) ){
            throw new RuntimeException();
        }
    }

    public synchronized Request removeRequest(){
        return (Request)_messageQueue.poll();
    }





}
