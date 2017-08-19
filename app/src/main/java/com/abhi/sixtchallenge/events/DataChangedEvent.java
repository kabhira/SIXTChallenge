package com.abhi.sixtchallenge.events;

import android.util.Log;

/**
 *  Author: Abhiraj Khare
 *  Description: Event fired by event bus, when data is fetched and UI need to be updated.
 */

public class DataChangedEvent {

    public DataChangedEvent(){
        Log.i("Event", "ConnectionStartedEvent");
    }
}
