package com.kobe.ubersplash.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.utils.TeanBeen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/2/8.
 */

public class FragmentRecyclerAdapter extends RecyclerView.Adapter<FragmentRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<TeanBeen.PeopleBeen> girlList;
    private List<Integer> heights;

    public FragmentRecyclerAdapter(Context context, List<TeanBeen.PeopleBeen> girlList) {
        this.context = context;
        this.girlList = girlList;
        heights = new ArrayList<>();
        setHeights(heights);
    }

    public void setHeights(List<Integer> heights) {
        for (int i = 0; i < girlList.size(); i++) {
            heights.add((int) (300 + Math.random() * 400));
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageview);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = heights.get(position);
        holder.itemView.setLayoutParams(params);
        Picasso.with(context)
                .load(girlList.get(position).getImgsrc())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "dangqian" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return girlList.size();
    }

}
