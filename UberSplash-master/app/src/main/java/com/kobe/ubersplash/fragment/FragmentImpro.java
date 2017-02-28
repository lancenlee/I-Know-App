package com.kobe.ubersplash.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.adapter.DragAdapter;
import com.kobe.ubersplash.common.DividerGridItemDecoration;
import com.kobe.ubersplash.entity.Item;
import com.kobe.ubersplash.helper.MyItemTouchCallback;
import com.kobe.ubersplash.helper.OnRecyclerItemClickListener;
import com.kobe.ubersplash.utils.ACache;
import com.kobe.ubersplash.utils.VibratorUtil;

import java.util.ArrayList;
import java.util.List;

public class FragmentImpro extends Fragment implements MyItemTouchCallback.OnDragListener{
    private List<Item> results = new ArrayList<Item>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////////////////////////////////////////////////////////
        /////////初始化数据，如果缓存中有就使用缓存中的
        ArrayList<Item> items = (ArrayList<Item>) ACache.get(getActivity()).getAsObject("items");
        if (items!=null)
            results.addAll(items);
        else {
            for (int i = 0; i < 3; i++) {
                results.add(new Item(i * 8 + 0, "收款", R.mipmap.takeout_ic_category_brand));
                results.add(new Item(i * 8 + 1, "转账", R.mipmap.takeout_ic_category_flower));
                results.add(new Item(i * 8 + 2, "余额宝", R.mipmap.takeout_ic_category_fruit));
                results.add(new Item(i * 8 + 3, "手机充值", R.mipmap.takeout_ic_category_medicine));
                results.add(new Item(i * 8 + 4, "医疗", R.mipmap.takeout_ic_category_motorcycle));
                results.add(new Item(i * 8 + 5, "彩票", R.mipmap.takeout_ic_category_public));
                results.add(new Item(i * 8 + 6, "电影", R.mipmap.takeout_ic_category_store));
                results.add(new Item(i * 8 + 7, "游戏", R.mipmap.takeout_ic_category_sweet));
            }
        }
        results.remove(results.size()-1);
        results.add(new Item(results.size(), "更多", R.mipmap.takeout_ic_more));
        ////////////////////////////////////////////////////////
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DragAdapter adapter = new DragAdapter(R.layout.item_drag,results);
        recyclerView = (RecyclerView)view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));

        itemTouchHelper = new ItemTouchHelper(new MyItemTouchCallback(adapter).setOnDragListener(this));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
                if (vh.getLayoutPosition()!=results.size()-1) {
                    itemTouchHelper.startDrag(vh);
                    VibratorUtil.Vibrate(getActivity(), 70);   //震动70ms
                }
            }
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                Item item = results.get(vh.getLayoutPosition());
                Toast.makeText(getActivity(),item.getId()+" "+item.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFinishDrag() {
        //存入缓存
        ACache.get(getActivity()).put("items",(ArrayList<Item>)results);
    }

}





