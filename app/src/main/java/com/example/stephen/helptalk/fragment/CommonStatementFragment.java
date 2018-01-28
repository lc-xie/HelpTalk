package com.example.stephen.helptalk.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.stephen.helptalk.MainActivity;
import com.example.stephen.helptalk.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stephen on 18-1-27.
 */

public class CommonStatementFragment extends Fragment implements View.OnClickListener{

    private Button button11,button12,button13;
    private Button button21,button22,button23;
    private Button button31,button32,button33;
    private Button button41,button42,button43;
    private Button button51,button52,button53;
    private Button button61,button62,button63;
    private EditText editText;
    private List<Button> buttonList=new ArrayList<>();
    private View view;

    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_common_statement,container,false);
        mainActivity=(MainActivity)getActivity();
        initButton();
        return view;
    }

    @Override
    public void onClick(View view) {
        Button button=(Button)view;
        mainActivity.setEditText(button.getText().toString());
    }

    public void initButton(){
        button11=(Button)view.findViewById(R.id.csf_button_11);
        button12=(Button)view.findViewById(R.id.csf_button_12);
        button13=(Button)view.findViewById(R.id.csf_button_13);
        button21=(Button)view.findViewById(R.id.csf_button_21);
        button22=(Button)view.findViewById(R.id.csf_button_22);
        button23=(Button)view.findViewById(R.id.csf_button_23);
        button31=(Button)view.findViewById(R.id.csf_button_31);
        button32=(Button)view.findViewById(R.id.csf_button_32);
        button33=(Button)view.findViewById(R.id.csf_button_33);
        button41=(Button)view.findViewById(R.id.csf_button_41);
        button42=(Button)view.findViewById(R.id.csf_button_42);
        button43=(Button)view.findViewById(R.id.csf_button_43);
        button51=(Button)view.findViewById(R.id.csf_button_51);
        button52=(Button)view.findViewById(R.id.csf_button_52);
        button53=(Button)view.findViewById(R.id.csf_button_53);
        button61=(Button)view.findViewById(R.id.csf_button_61);
        button62=(Button)view.findViewById(R.id.csf_button_62);
        button63=(Button)view.findViewById(R.id.csf_button_63);

        button11.setOnClickListener(this);
        button21.setOnClickListener(this);
        button31.setOnClickListener(this);
        button41.setOnClickListener(this);
        button51.setOnClickListener(this);
        button61.setOnClickListener(this);
        button12.setOnClickListener(this);
        button22.setOnClickListener(this);
        button32.setOnClickListener(this);
        button42.setOnClickListener(this);
        button52.setOnClickListener(this);
        button62.setOnClickListener(this);
        button13.setOnClickListener(this);
        button23.setOnClickListener(this);
        button33.setOnClickListener(this);
        button43.setOnClickListener(this);
        button53.setOnClickListener(this);
        button63.setOnClickListener(this);

    }
}
