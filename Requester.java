public class Requester implements Runnable {

    private final MessageQueue _response;
    private final MessageQueue _request;


    private final int id;
    private static int requesterCounter;

    public Requester(MessageQueue resp, MessageQueue req) {
        _response = resp;
        _request = req;
        id = getRequesterCounter();
    }

    private static int getRequesterCounter() {
        return requesterCounter++;
    }

    public int getID() {
        return this.id;
    }

    @Override
    public void run() {
        System.out.println("Request" + " " + getID() + " is processing");

        while (true) {
            _request.addRequestInTheQueue(new Request(this));
            boolean isProcessed = false;
            while (!isProcessed) {
                Response r = _response.removeResponse(this);
                if (r != null) {
                    isProcessed = true;
                    System.out.println("Request " + id + " proceed " + r);
                }
                sleep();
            }
        }
    }



    private void sleep(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

