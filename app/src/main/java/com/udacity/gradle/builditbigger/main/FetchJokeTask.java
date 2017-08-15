
package com.udacity.gradle.builditbigger.main;

import android.os.AsyncTask;
import android.util.Log;

import com.example.pallav.grover.myapplication.backend.libjoke.Libjoke;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class FetchJokeTask extends AsyncTask<Void, Void, String> {
    private static Libjoke myApiService = null;

    @Override
    protected final String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            Libjoke.Builder builder = new Libjoke.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null).setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });;
            myApiService = builder.build();
        }

        try {
            return myApiService.getRandomJoke().execute().getData();
        } catch (IOException e) {
            Log.e(FetchJokeTask.class.getSimpleName(), e.getMessage());
            return null;
        }
    }

}