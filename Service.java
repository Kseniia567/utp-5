public class Service implements Runnable {

    private final MessageQueue _response;
    private final MessageQueue _request;
    private final int id;
    private static int serviceCounter;


    public Service( MessageQueue resp, MessageQueue req ){
        _response = resp;
        _request = req;
        id = getRequesterCounter();
    }

    private static int getRequesterCounter(){
        return serviceCounter++;
    }

    public int getID(){
        return this.id;
    }

    public void run(){
        System.out.println("Response" +" "+ getID() + " " +"is processing by");
        while(true){
            Request r = _request.removeRequest();
            if(r != null){
                System.out.println("Response "+ getID() + " " + r + " "+" is proceed");
                Response q = new Response(r);
                q.set_result(maxValue(r.get_input()));
                _response.addResponseInTheQueue(q);
            }
            sleep();
        }
    }

    private void sleep(){
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



    private int maxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
