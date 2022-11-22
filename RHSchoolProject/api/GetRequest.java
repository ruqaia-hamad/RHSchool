package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.*;

public class GetRequest {

    public static void main(String[] args) throws IOException, InterruptedException {
    
        String url="https://randomuser.me/api/?results=5&gender=female&password=upper,lower,1-16";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

   
        Data data = new Gson().fromJson(response.body(), Data.class);
        int result=data.getResults().size();
    	for(int i=0; i<result;i++) {
        System.out.println("This the version " + data.getInfo().getVersion());
        System.out.println("This the version " + data.getResults().get(i).getGender());
        System.out.println("This the user name " + data.getResults().get(i).getName().getFirst()+data.getResults().get(0).getName().getLast());
        System.out.println("**************");
    	}
}}