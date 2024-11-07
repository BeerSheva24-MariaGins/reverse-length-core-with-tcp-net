package telran.appl.net;

import telran.net.Protocol;
import telran.net.Request;
import telran.net.Response;
import telran.net.ResponseCode;

public class ReverseLengthProtocol implements Protocol {
    @Override
    public Response getResponse(Request request) {
        String requestType = request.requestType();
        String requestData = request.requestData();
        String result = "";

        switch (requestType) {
            case "reverse":
                result = new StringBuilder(requestData).reverse().toString();
                return new Response(ResponseCode.OK, result);
            case "length":
                result = String.valueOf(requestData.length());
                return new Response(ResponseCode.OK, result);
            default:
                return new Response(ResponseCode.WRONG_TYPE, "Unsupported request type: " + requestType);
        }
    }   
}
