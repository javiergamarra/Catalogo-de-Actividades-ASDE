package com.nhpatt.asde;

import com.nhpatt.asde.async.services.ApiaryService;
import com.nhpatt.asde.models.Event;

import org.junit.Test;

import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.http.Path;
import rx.Observable;

import static org.junit.Assert.assertEquals;


public class CheckMockwebserverTest implements ApiaryService {
    @Override
    public Observable<List<Event>> getEventList() {
        return null;
    }

    @Override
    public Observable<Event> getEventWithId(@Path("id") String id) {
        return null;
    }

    @Override
    public String doTest() {
        return "Yay!";
    }

    @Test
    public void test() throws Exception {
        // Create a MockWebServer. These are lean enough that you can create a new
        // instance for every unit test.
        MockWebServer server = new MockWebServer();

        // Schedule some responses.
        server.enqueue(new MockResponse().setBody("Yay!"));

        // Start the server.
        server.start();

        // Ask the server for its URL. You'll need this to make HTTP requests.
        HttpUrl baseUrl = server.url("/activities");

        assertEquals(doTest(), "Yay!");


        // Shut down the server. Instances cannot be reused.
        server.shutdown();
    }


}
