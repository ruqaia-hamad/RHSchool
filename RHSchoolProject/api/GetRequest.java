package api;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.*;

import src.Student;

public class GetRequest {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		boolean exit = true;
		while (exit) {
			try {
		
				System.out.println("please Enter number of users you want");
				Integer result = sc.nextInt();

				if (result == 0) {
					
					String url = "https://randomuser.me/api/?results=30";

					HttpClient client = HttpClient.newHttpClient();
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					String res=response.body();
					Data data = new Gson().fromJson(res, Data.class);
				
		         
			
					for (Integer j = 0; j < response.body().length(); j++) {
					
						System.out.println("This the version " + data.getInfo().getVersion());
						System.out.println("The gender is  " + data.getResults().get(0).getGender());
						System.out.println("This the user name " + data.getResults().get(0).getName().getFirst()
								+ data.getResults().get(0).getName().getLast());
						System.out.println("**************");
						
			
					}

				} else {

					System.out.println("please Enter gender of users you want");
					String gender = sc.next();
					System.out.println("please Enter password format");
					String password = sc.next();
					System.out.println("please Enter page number");
					Integer page = sc.nextInt();
					System.out.println("please Enter seed");
					String seed = sc.next();
					System.out.println("please Enter  nationality ");
					String nat = sc.next();
					System.out.println("please Enter  1 if you want to exclude press 1 and 2 if you want to include ");
					Integer choice = sc.nextInt();
					
					
					if(choice==1) {
						
				
					System.out.println("please Enter  Types that you  want to exclude | Add comma After Each Type ");
					String exc = sc.next();
		
						
						String url = "https://randomuser.me/api/?results="+result+"&gender=" + gender + "&seed=" + seed + "&password="
								+ password + "&page=" + page  +"&nat="+ nat+"&exc="+exc;
						HttpClient client = HttpClient.newHttpClient();
						HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
						HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
						String responseB = response.body();
						Path pathToFileForReadingWriting = Paths.get("C:\\Users\\user015\\eclipse-workspace\\RHNewCode\\School\\RHSchoolProject\\jsonfile2.txt");

						String jsonFromFile = Files.readString(pathToFileForReadingWriting);
						Files.writeString(pathToFileForReadingWriting,responseB, StandardCharsets.UTF_8);
						System.out.println(jsonFromFile);
						if (responseB.contains("error")) {
							System.out.println("we have error");
							Gson gson = new Gson();
							ErrorHandler errorhandler = gson.fromJson(jsonFromFile, ErrorHandler.class);
							System.out.println(errorhandler.getError());
						} else {
							Gson gson = new Gson();
				
							Data data = new Gson().fromJson(responseB, Data.class);
							List<Results> listofResult=data.getResults();
							for (Results x:listofResult) {
							
								if(data.getInfo().getVersion()!=null) {
							System.out.println("This the version " + data.getInfo().getVersion());}
								if(x.getGender()!=null) {
							System.out.println("The gender is  " + x.getGender());}
								if(x.getLogin()!=null && x.getLogin().getPassword()!=null) {
							System.out.println("The password is  " + x.getLogin().getPassword());}
								if(x.getName() !=null && x.getName().getFirst()+ " " + x.getName().getLast()!=null) {
							System.out.println("This the user name " + x.getName().getFirst()+ " " + x.getName().getLast());}
								if( data.getInfo().getPage()!=null) {
							System.out.println("This the page number " + data.getInfo().getPage());}
								if(data.getInfo().getSeed()!=null) {
							System.out.println("This the seed " + data.getInfo().getSeed());}
								if(x.getNat()!=null) {
							System.out.println("This the nationality" +" " + x.getNat());}
							System.out.println("\n");
							System.out.println("**************");
						}
							}
					}
					else {
						System.out.println("please Enter  Types that you want to include | Add comma After Each Type ");
						String inc = sc.next();
					
						String url ="https://randomuser.me/api/?results="+result+"&gender=" + gender + "&seed=" + seed + "&password="
								+ password + "&page=" + page  +"&nat="+ nat+"&inc="+inc;
						HttpClient client = HttpClient.newHttpClient();
						HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
						HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
						String responseB = response.body();
						if (responseB.contains("error")) {
							System.out.println("we have error");
							Gson gson = new Gson();
							ErrorHandler errorhandler = gson.fromJson(responseB, ErrorHandler.class);
							System.out.println(errorhandler.getError());
						} else {
							Gson gson = new Gson();
							Data data = new Gson().fromJson(responseB, Data.class);

							List<Results> listofResult=data.getResults();
								for (Results x:listofResult) {
								if(data.getInfo().getVersion()!=null) {
							System.out.println("This the version " + data.getInfo().getVersion());}
								if(x.getGender()!=null) {
							System.out.println("The gender is  " + x.getGender());}
								if( x.getLogin()!=null && x.getLogin().getPassword()!=null) {
							System.out.println("The password is  " + x.getLogin().getPassword());}
								if(x.getName()!=null &&x.getName().getFirst()!=null &&  x.getName().getLast()!=null) {
							System.out.println("This the user name " + x.getName().getFirst()+ " " + x.getName().getLast());}
								if(data.getInfo().getPage()!=null) {
							System.out.println("This the page number " + data.getInfo().getPage());}
								if(data.getInfo().getSeed()!=null) {
							System.out.println("This the seed " + data.getInfo().getSeed());}
								if(x.getNat()!=null) {
							System.out.println("This the nationality"+" " + x.getNat());}
							System.out.println("\n");
							System.out.println("**************");
						}
							}
						
						
					}
					
				}}
			catch (Exception e) {
				System.out.println(e);
			}
			System.out.println("If you want to exit press 0 and 1 to continue");
			Integer choice = sc.nextInt();
			if (choice == 0) {
				exit = false;
				System.out.println("Good Bye");

			} else {
				exit = true;
			}
		}
	}
}