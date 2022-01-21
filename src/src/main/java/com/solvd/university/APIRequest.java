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
				.header("x-rapidapi-key", "API KEY")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();

		HttpRequest requestLocal = HttpRequest.newBuilder().uri(URI.create( 
				"https://***.***.*.**/FileDirectory/File.Json"))
				.build();

		client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println)
				.join();
		client.sendAsync(rapidAPIrequest, BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();
		client.sendAsync(requestLocal, BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println);

	}
}
