/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.pallav.grover.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import e.pallavgrover.jokeslibrary.JokesLibrary;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "libjoke",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.grover.pallav.example.com",
                ownerName = "backend.myapplication.grover.pallav.example.com",
                packagePath = ""
        )
)
public class JokeEndPoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "getRandomJoke")
    public Joke getRandomJoke() {
        return new Joke(JokesLibrary.getRandomJoke());
    }
}
