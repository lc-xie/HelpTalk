package com.example.stephen.helptalk;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stephen.helptalk.TTS.TTSHelp;
import com.example.stephen.helptalk.fragment.CommonStatementFragment;
import com.example.stephen.helptalk.fragment.FruitFragment;
import com.example.stephen.helptalk.fragment.SingleWordFragment;
import com.example.stephen.helptalk.fragment.VerbFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button common,fruit,singleWord,verb;
    private Button clean,play,backspace,edit;
    private EditText editText;
    private TTSHelp ttsHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ttsHelp=new TTSHelp(this);

        editText=(EditText)findViewById(R.id.main_activity_edit_text);
        // 功能按钮
        clean=findViewById(R.id.main_func_clean);
        play=findViewById(R.id.main_func_play);
        backspace=findViewById(R.id.main_func_backspace);
        edit=findViewById(R.id.main_func_edit);
        clean.setOnClickListener(this);
        play.setOnClickListener(this);
        backspace.setOnClickListener(this);
        edit.setOnClickListener(this);
        //分类按钮
        common=findViewById(R.id.type_common_statement);
        fruit=findViewById(R.id.type_fruit_drink);
        singleWord=findViewById(R.id.type_single_word);
        verb=findViewById(R.id.type_verb);
        common.setOnClickListener(this);
        fruit.setOnClickListener(this);
        singleWord.setOnClickListener(this);
        verb.setOnClickListener(this);

        replaceFragment(new CommonStatementFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.type_common_statement:
                replaceFragment(new CommonStatementFragment());
                break;
            case R.id.type_fruit_drink:
                replaceFragment(new FruitFragment());
                break;
            case R.id.type_single_word:
                replaceFragment(new SingleWordFragment());
                break;
            case R.id.type_verb:
                replaceFragment(new VerbFragment());
                break;
            case R.id.main_func_clean:
                editText.setText("");
                break;
            case R.id.main_func_play:
                ttsHelp.playTTS(editText.getText().toString());
                break;
            case R.id.main_func_backspace:
                if (editText.getText().toString().equals(""))break;
                editText.getText().delete(editText.getText().length()-1,editText.getText().length());
                break;
            case R.id.main_func_edit:

                break;
        }
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.type_frame,fragment);
        transaction.commit();
    }

    public void setEditText(String s){
        editText.setText(editText.getText()+s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsHelp.destroyTTS();
    }
}
