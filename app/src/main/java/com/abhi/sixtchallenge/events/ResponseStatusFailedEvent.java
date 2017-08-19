package com.abhi.sixtchallenge.events;

import android.util.Log;

/**
 *  Author: Abhiraj Khare
 *  Description: Event fired when states code is other than 200.
 */
public class ResponseStatusFailedEvent {
    public ResponseStatusFailedEvent(){
        Log.i("Event", "ResponseStatusFailedEvent");
    }
}
