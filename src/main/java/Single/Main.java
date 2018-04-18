package Single;


import io.reactivex.Single;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mkirsch on 16.04.18.
 */
public class Main {

    public static void main(String[] args) throws IOException {


        Single<String> single = Single.create(emitter -> {

            emitter.onSuccess(getResponse());

        });

        single.subscribe(s -> System.out.println(s), throwable -> System.out.println("Error is: " + throwable));

    }

    private static String getResponse() throws IOException {
        String plain = "none";
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://rest-service.guides.spring.io/greeting");
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            plain = plain + line;
        }
        return plain;
    }
}
