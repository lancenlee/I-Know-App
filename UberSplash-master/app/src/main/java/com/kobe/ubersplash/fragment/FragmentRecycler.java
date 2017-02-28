package com.kobe.ubersplash.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.adapter.FragmentRecyclerAdapter;
import com.kobe.ubersplash.utils.OkHttpUtils;
import com.kobe.ubersplash.utils.TeanBeen;


public class FragmentRecycler extends Fragment {

    private RecyclerView recyclerView;
    private FragmentRecyclerAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    String url = "http://c.3g.163.com/recommend/getChanListNews?" +
            "channel=T1456112189138&size=20&passport=&devId=1uuFYbybIU2oqSRGyFrjCw%3D%3D" +
            "&lat=%2F%2FOm%2B%2F8ScD%2B9fX1D8bxYWg%3D%3D&lon=LY2l8sFCNzaGzqWEPPgmUw%3D%3D" +
            "&version=9.0&net=wifi&ts=1464769308" +
            "&sign=bOVsnQQ6gJamli6%2BfINh6fC%2Fi9ydsM5XXPKOGRto5G948ErR02zJ6%2FKXOnxX046I" +
            "&encryption=1&canal=meizu_store2014_news" +
            "&mac=sSduRYcChdp%2BBL1a9Xa%2F9TC0ruPUyXM4Jwce4E9oM30%3D";

    public void initData() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        OkHttpUtils.getInstance().getBeanOfOk(getActivity(), url, TeanBeen.class, new OkHttpUtils.CallBack<TeanBeen>() {
            @Override
            public void getData(TeanBeen teanBeen) {
                if (teanBeen != null) {
                    adapter = new FragmentRecyclerAdapter(getContext(), teanBeen.getGirls());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


}
