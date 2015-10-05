package com.example.jokerlol.acharyaone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by Joker LOL on 9/15/2015.
 */
public class parseappagain extends Application {
    @Override
    public void onCreate() {
        Parse.initialize(this, "IND6d2D5CTpybnTpNjkhbBJV6NZcV1kidz85hufC", "dosCyai1NaRyQwwa3xbcqZoI67jJ6NPOGEwo8TZh");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
