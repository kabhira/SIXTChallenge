package com.abhi.sixtchallenge.utilities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abhi.sixtchallenge.Network.VolleyNetwork;
import com.abhi.sixtchallenge.R;
import com.abhi.sixtchallenge.model.CodeTalkElement;
import com.abhi.sixtchallenge.view.BaseFragment;
import com.abhi.sixtchallenge.view.CarMapFragment;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

/**
 *  Author: Abhiraj Khare
 *  Description: Adapter to display cars lists.
 */

public class CodeTalkAdapter extends RecyclerView.Adapter<CodeTalkAdapter.ViewHolder> {
    private List<CodeTalkElement> mDataset;
    private BaseFragment mBaseFragment;
    private FragmentActivity mActivity;

    public CodeTalkAdapter(List<CodeTalkElement> myDataset, FragmentActivity mActivity) {
        mDataset = myDataset;
        this.mActivity = mActivity;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView cellName, cellModel, cellMake, cellLicence;
        public NetworkImageView mImageView;
        public ViewHolder(View v) {
            super(v);
            cellName = (TextView) v.findViewById(R.id.cell_name);
            cellModel = (TextView) v.findViewById(R.id.cell_model);
            cellMake = (TextView) v.findViewById(R.id.cell_make);
            cellLicence = (TextView) v.findViewById(R.id.cell_licence);
            mImageView = (NetworkImageView) v.findViewById(R.id.cell_imageView);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            CarMapFragment carMapFragment = CarMapFragment.newInstance();
            FragmentTransactionHelper.addFragmentWithModelObject(mActivity, R.id.content, carMapFragment, mDataset.get(getAdapterPosition()));
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CodeTalkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_cell, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        CodeTalkElement element = mDataset.get(position);
        holder.cellName.setText(element.getName());
        holder.cellModel.setText(element.getModelName());
        holder.cellMake.setText(element.getMake());
        holder.cellLicence.setText(element.getLicensePlate());

        // https://prod.drive-now-content.com/fileadmin/user_upload_global/assets/cars/{modelIdentifier}/{color}/2x/car.png
        String carURL = "https://prod.drive-now-content.com/fileadmin/user_upload_global/assets/cars/"+element.getModelIdentifier()+"/"+element.getColor()+"/2x/car.png";
        ImageLoader imageLoader = VolleyNetwork.getInstance(mActivity).getImageLoader();
        holder.mImageView.setDefaultImageResId(R.drawable.def_images);
        holder.mImageView.setImageUrl(carURL, imageLoader);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

