package src.main.java.com.solvd.university;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class APIRequest {

	public void ApiCall() {
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
				.build();
		HttpRequest rapidAPIrequest = HttpRequest.newBuilder()
				.uri(URI.create(
						"https://movie-database-imdb-alternative.p.rapidapi.com/?s=Avengers%20Endgame&r=json&page=1"))
				.header("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
				.header("x-rapidapi-key", "aca3e53d40mshcbae7237c06efbbp16b1f6jsn872e4e5c0944")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		HttpRequest requestLocal = HttpRequest.newBuilder().uri(URI.create( 
				"https://192.168.1.77/C:/Users/Bokha/Documents/GitHub/University/src/src/main/resources/User.json"))
				.build();

		client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println)
				.join();
		client.sendAsync(rapidAPIrequest, BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();
		client.sendAsync(requestLocal, BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println);

	}
}
