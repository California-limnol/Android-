package com.example.my.fragment_weixin;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by ws1688 on 2016/7/8.
 */
public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private TextView txt_topbar;
    private TextView txt_chat;
    private TextView txt_contract;
    private TextView txt_discover;
    private TextView txt_me;
    private FrameLayout ly_content;

    private MyFragment fg1,fg2,fg3,fg4;
    private FragmentManager fManeger;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        fManeger=getSupportFragmentManager();
        bindViews();
        txt_chat.performClick();
    }

    private void bindViews(){
        txt_topbar=(TextView)findViewById(R.id.txt_topbar);
        txt_chat=(TextView)findViewById(R.id.txt_chat);
        txt_contract=(TextView)findViewById(R.id.txt_contract);
        txt_discover=(TextView)findViewById(R.id.txt_diacover);
        txt_me=(TextView)findViewById(R.id.txt_me);
        ly_content=(FrameLayout)findViewById(R.id.ly_content);

        txt_chat.setOnClickListener(this);
        txt_contract.setOnClickListener(this);
        txt_discover.setOnClickListener(this);
        txt_me.setOnClickListener(this);
    }

    private void setSelected(){
        txt_chat.setSelected(false);
        txt_contract.setSelected(false);
        txt_discover.setSelected(false);
        txt_me.setSelected(false);
    }
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1!=null) fragmentTransaction.hide(fg1);
        if(fg2!=null) fragmentTransaction.hide(fg2);
        if(fg3!=null) fragmentTransaction.hide(fg3);
        if(fg4!=null) fragmentTransaction.hide(fg4);
    }
    @Override
    public void onClick(View view) {
FragmentTransaction fTransaction=fManeger.beginTransaction();
        hideAllFragment(fTransaction);
        switch (view.getId()){
            case R.id.txt_chat:
                setSelected();
                txt_chat.setSelected(true);
                if(fg1==null){
                    fg1= MyFragment.newInstance("第一个Fragment");
                    fTransaction.add(R.id.ly_content,fg1);
                }else {
                    fTransaction.show(fg1);
                }
                break;
            case R.id.txt_contract:
                setSelected();
                txt_contract.setSelected(true);
                if(fg2==null){
                    fg2= MyFragment.newInstance("第二个Fragment");
                    fTransaction.add(R.id.ly_content,fg2);
                }else {
                    fTransaction.show(fg2);
                }
                break;
            case R.id.txt_diacover:
                setSelected();
                txt_discover.setSelected(true);
                if(fg3==null){
                    fg3=MyFragment.newInstance("第三个Fragment");
                    fTransaction.add(R.id.ly_content,fg3);
                }else {
                    fTransaction.show(fg3);
                }
                break;
            case R.id.txt_me:
                setSelected();
                txt_me.setSelected(true);
                if(fg4==null){
                    fg4=MyFragment.newInstance("第四个Fragment");
                    fTransaction.add(R.id.ly_content,fg4);
                }else {
                    fTransaction.show(fg4);
                }
                break;
        }
        fTransaction.commit();
    }
}
