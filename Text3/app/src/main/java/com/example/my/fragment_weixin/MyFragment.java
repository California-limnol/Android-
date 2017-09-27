package com.example.my.fragment_weixin;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by ws1688 on 2016/7/8.
 */
public class MyFragment extends Fragment {

    private  String content;
    public static MyFragment newInstance(String pContent){
        MyFragment newFragment=new MyFragment();
        Bundle bundle=new Bundle();
        bundle.putString("content",pContent);

        newFragment.setArguments(bundle);
        return newFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            content = args.getString("content");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);
        TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        txt_content.setText(content);

        return view;
    }
}
