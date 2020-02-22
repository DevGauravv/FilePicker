package com.example.filepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Intent fileIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    textView = findViewById(R.id.btn_select);
    textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
            fileIntent.setType("*/*");

            startActivityForResult(fileIntent,1);



        }
    });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case 1:


                if(resultCode == RESULT_OK)
                {
                    String dataPath = data.getData().getPath();

                    textView.setText(dataPath);

                }

                break;
        }

    }
}
