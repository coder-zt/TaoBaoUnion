package com.zhangtao.taobaounion.ui.adapter;

import android.content.ClipData;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zhangtao.taobaounion.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ItemView> {
    List<TestData> mData = new ArrayList<>();


    @NonNull
    @Override
    public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, parent, false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemView holder, int position) {
        holder.setData(mData.get(position));
    }


    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setData(List<TestData> data){
        if(mData != null){
            mData.clear();
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

     class ItemView extends RecyclerView.ViewHolder {
        TextView mTestName, mTestIndex;
        ItemView(@NonNull View itemView) {
            super(itemView);
            mTestName = itemView.findViewById(R.id.name);
            mTestIndex = itemView.findViewById(R.id.index);
        }

        void setData(TestData testData) {
            mTestIndex.setText(testData.getIndex() + "");
            mTestName.setText(testData.getName());
            if(testData.isSelect()){
                mTestName.setTextColor(Color.RED);
            }else{
                mTestName.setTextColor(Color.GRAY);
            }
        }
    }
}
