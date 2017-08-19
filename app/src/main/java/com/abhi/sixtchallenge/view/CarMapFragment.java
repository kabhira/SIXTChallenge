package com.abhi.sixtchallenge.view;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.sixtchallenge.R;
import com.abhi.sixtchallenge.model.CodeTalkElement;
import com.google.android.gms.maps.model.LatLng;

/**
 *  Author: Abhiraj Khare
 *  Description: Fragment to show cars on Map.
 */

public class CarMapFragment extends MapBaseFragment {


    public CarMapFragment() {
        // Required empty public constructor
    }

    public static CarMapFragment newInstance() {
        CarMapFragment fragment = new CarMapFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_car_map2, container, false);
        setMapView(rootView, R.id.request_map_view,savedInstanceState);
        if(getModelObject() != null) {
            CodeTalkElement element = (CodeTalkElement) getModelObject();
            LatLng latLng = new LatLng(element.getLatitude(), element.getLongitude());
            updateMapUI(latLng);
        }
        return rootView;
    }

}
