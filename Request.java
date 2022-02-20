import java.util.Arrays;
import java.util.Random;

public class Request extends Message {

    private static final  Random _randomInt;
    private final String _request;
    private final int _request_num;
    private final int[] _input = new int[5];


    static{
        _randomInt = new Random();
    }


    public Request(Requester requester){
        super( Priority.getRandomPriority(), requester );
        _request_num = _randomInt.nextInt(10);

        for(int i = 0; i < _input.length; i++) {
            _input[i] = _randomInt.nextInt(100);
        }
        _request = Arrays.toString(_input);
    }

    public String getRequest(){
        return this._request;
    }

    public int getRequestNum(){
        return this._request_num;
    }


    public int[] get_input() {
        return _input;
    }






    @Override
    public String toString(){
        return _request+" Number: "+_request_num;
    }

}
