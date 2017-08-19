package com.abhi.sixtchallenge.Network;

import com.abhi.sixtchallenge.model.CodeTalkElement;

/**
 *  Author: Abhiraj Khare
 *  Description: Network request to be executed by Volley to fetch json.
 */

public class CodeTalkRequest  extends VolleyRequest<CodeTalkElement[]> {

    private static String url = "http://www.codetalk.de/cars.json";
    public CodeTalkRequest(){
        super(Method.GET, url, CodeTalkElement[].class, null, null, null);
    }
}