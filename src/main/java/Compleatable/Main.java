package Compleatable;


import io.reactivex.Completable;
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


        Completable completable = Completable.create(emitter -> {

            getResponse();
            emitter.onComplete();

        });

        completable.subscribe(() -> System.out.println("onComplete"), error -> System.out.println(error));

    }

    private static void getResponse() throws Exception {
        String plain = "none";
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("httsp://rest-service.guides.spring.io/greeting");
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            throw new Exception();
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            plain = plain + line;
        }
    }
}
