public class Response  extends Message {

    public final String _responseResult;
    public final String _req_numb;

    public int _result;

    public Response (Request request){
        super(request.getPriority(), request.getRequester());
        _req_numb = request.getRequest();
        _responseResult = request.getRequest() + " " + request.getRequestNum();
    }

    public void set_result(int i) {
        _result = i;
    }

    public String getResponseResult(){
        return this._responseResult;
    }
    @Override
    public String toString(){
        return super.toString() + " Request: " + getResponseResult() + " Result: " + _result;
    }
}
