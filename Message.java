public abstract class Message implements Comparable <Message> {

    private final int _messageId;
    private final Priority _messagePriority;
    private final Requester _requester;
    private static int thisID;

    protected Message( Priority messagePriority, Requester requester) {
        _messageId =  getThisMessageId();
        _messagePriority = messagePriority;
        _requester = requester;

    }

    private synchronized static int getThisMessageId(){
        return thisID++;
    }

    public final Priority getPriority(){
        return this._messagePriority;
    }

    public final Requester getRequester(){
        return this._requester;
    }


    public final int getMessageId(){
        return this._messageId;
    }




    @Override
    public int compareTo(Message m){
        return this.getPriority().compare(m.getPriority());
    }

    @Override
    public String toString(){
        return getClass().getName() +" id: "+ getMessageId() + " priority level: " + getPriority();
    }
}
