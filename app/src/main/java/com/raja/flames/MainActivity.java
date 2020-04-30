package com.raja.flames;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    TextView Boy;
    TextView Girl;
    TextView output;
    Button b;
    VideoView video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boy=findViewById(R.id.Boy);
        Girl=findViewById(R.id.Girl);
        output=findViewById(R.id.Result);
        video=findViewById(R.id.videoView);
        b=findViewById(R.id.button);

        Boy.addTextChangedListener(textWatcher);
        Girl.addTextChangedListener(textWatcher);


    }
    private TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                output.setText("");
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String BoyName=Boy.getText().toString().trim();
                String GirlName=Girl.getText().toString().trim();

                b.setEnabled(!BoyName.isEmpty() && !GirlName.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public void whenClicked(View v) {
        StringBuffer result = new StringBuffer();

        char a1 = Flames.get(Boy.getText().toString(), Girl.getText().toString());
        switch (a1) {
            case 'f':
                result.append("Friends");
                break;
            case 'l':
                result.append("Love");
                break;
            case 'a':
                result.append("Affection");
                break;
            case 'm':
                result.append("Marriage");
                break;
            case 'e':
                result.append("Enimies");
                break;
            case 's':
                result.append("Sisters");
                break;
        }
        output.setText(result);
        closeKeyBoard();
    }
    private void closeKeyBoard(){
        View view=this.getCurrentFocus();

        InputMethodManager im=(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
