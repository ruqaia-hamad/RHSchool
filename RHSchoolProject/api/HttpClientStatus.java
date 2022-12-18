package api;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientStatus {

	public static void main(String[] args) throws IOException, InterruptedException {
		   HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder()
	                .uri(URI.create("https://randomuser.me/api/"))
	                .GET() 
	                .build();

	        HttpResponse<Void> response = client.send(request,
	                HttpResponse.BodyHandlers.discarding());

	        System.out.println(response.statusCode()+"\n");
	    }

	}


