package com.android4dev.navigationview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Admin on 04-06-2015.
 */
public class ContentFragment extends ListFragment implements OnItemClickListener {

    String[] menu_titles;
    TypedArray menu_Icons;

    CustomListAdapter adapter;
    private List<RowItem> rowItems;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_fragment,container,false);
        SearchView searchView = (SearchView) v.findViewById(R.id.searchView);
//        ListView listView = (ListView)v.findViewById(R.id.listView);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(getActivity(), "onQueryTextSubmit", Toast.LENGTH_SHORT)
                        .show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                Toast.makeText(getActivity(), "onQueryTextChange", Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });


        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        menu_titles = getResources().getStringArray(R.array.titles);
        menu_Icons = getResources().obtainTypedArray(R.array.icons);

        rowItems = new ArrayList<RowItem>();

        for (int i = 0; i < menu_titles.length; i++) {
            RowItem items = new RowItem(menu_titles[i], menu_Icons.getResourceId(
                    i, -1));

            rowItems.add(items);
        }

        adapter = new CustomListAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Toast.makeText(getActivity(), menu_titles[position], Toast.LENGTH_SHORT)
                .show();

    }
}

