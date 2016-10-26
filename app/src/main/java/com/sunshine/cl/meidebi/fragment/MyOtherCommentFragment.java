package com.sunshine.cl.meidebi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.sunshine.cl.meidebi.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyOtherCommentFragment extends Fragment {

    SwipeRefreshLayout srl;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_other_comment, container, false);
        srl = (SwipeRefreshLayout)view.findViewById(R.id.my_other_comment_srl);
        listView = (ListView)view.findViewById(R.id.my_other_comment_listView);
        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.no_data_layout,null);
        view1.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextView textView = (TextView)view1.findViewById(R.id.no_data_tv);
        textView.setText("暂无回复");
        ((ViewGroup)listView.getParent()).addView(view1);
        listView.setEmptyView(view1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),R.layout.my_message_list_item,new ArrayList<String>());
        listView.setAdapter(adapter);
        return view;
    }

}
