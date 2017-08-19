package com.abhi.sixtchallenge.view;

import android.support.v4.app.Fragment;

/**
 *  Author: Abhiraj Khare
 *  Description: Base class for all fragment to store data object.
 */

public class BaseFragment extends Fragment {

    private Object modelObject;

    public Object getModelObject() {
        return modelObject;
    }

    public void setModelObject(Object modelObject) {
        this.modelObject = modelObject;
    }
}
