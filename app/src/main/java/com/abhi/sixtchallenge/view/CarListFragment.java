package com.abhi.sixtchallenge.view;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.abhi.sixtchallenge.R;
import com.abhi.sixtchallenge.events.DataChangedEvent;
import com.abhi.sixtchallenge.events.EventBusSingleton;
import com.abhi.sixtchallenge.model.CodeTalkElement;
import com.abhi.sixtchallenge.model.DataManager;
import com.abhi.sixtchallenge.utilities.CodeTalkAdapter;
import com.abhi.sixtchallenge.utilities.CustomAlertDialog;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 *  Author: Abhiraj Khare
 *  Description: Fragment to show cars list
 */
public class CarListFragment extends BaseFragment {

    private CodeTalkAdapter mAdapter;
    private List<CodeTalkElement> mDataset;
    private CustomAlertDialog customAlertDialog;

    public CarListFragment() {
        // Required empty public constructor
    }

    public static CarListFragment newInstance() {
        CarListFragment fragment = new CarListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_car_list, container, false);
        RecyclerView mRecyclerView = (RecyclerView) rootView.findViewById(R.id.list_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mDataset = DataManager.instance().getMainList();
        mAdapter = new CodeTalkAdapter(mDataset, this.getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBusSingleton.instance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBusSingleton.instance().unregister(this);
    }

    @Subscribe
    public void dataChangedEvent(DataChangedEvent event){
        mAdapter.notifyDataSetChanged();
    }

}
