package com.example.pnm;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PictureUploadActivity extends AppCompatActivity {
    EditText et_pic_name, et_pic_detail;
    ImageView iv;
    TextView tv_gps;
    Button btn_gps, btn_upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_upload);
        et_pic_name = findViewById(R.id.et_pic_name);
        et_pic_detail = findViewById(R.id.et_pic_detail);
        iv = findViewById(R.id.iv);
    }

    public void clickImg(View view){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case 10:
                if(resultCode==RESULT_OK){
                    Uri uri = data.getData();
                    if(uri!=null){
                        iv.setImageURI(uri);
                    }
                }else{
                    Toast.makeText(this, "선택된 이미지가 없습니다.",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    public void clickUpload(View view){

    }
}