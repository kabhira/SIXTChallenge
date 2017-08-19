package com.abhi.sixtchallenge.model;

import android.util.Log;

import com.abhi.sixtchallenge.Network.CodeTalkRequest;
import com.abhi.sixtchallenge.Network.VolleyNetwork;
import com.abhi.sixtchallenge.events.DataChangedEvent;
import com.abhi.sixtchallenge.events.EventBusSingleton;
import com.abhi.sixtchallenge.utilities.CustomApplication;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  Author: Abhiraj Khare
 *  Description: Singleton File used for caching the data.
 */
public class DataManager {

    private static DataManager instance = new DataManager();
    private ArrayList<CodeTalkElement> mainList;

    private DataManager(){
        mainList = new ArrayList<CodeTalkElement>();
        Log.e("Singleton Check", "I am called.");
        EventBusSingleton.instance().register(this);
        CodeTalkRequest codeTalkRequest = new CodeTalkRequest();
        VolleyNetwork.getInstance(CustomApplication.getmContext()).addToRequestQueue(codeTalkRequest);
    }

    public static DataManager instance()
    {
        return instance;
    }

    public synchronized ArrayList<CodeTalkElement> getMainList(){
        return mainList;
    }



    @Subscribe
    public void serverResponse(CodeTalkElement[] data){

        mainList.clear();
        mainList.addAll(Arrays.asList(data));
        EventBusSingleton.instance().postEvent(new DataChangedEvent());
    }

}
