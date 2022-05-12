package ru.example.mygallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;

public class ImgviewActivity extends AppCompatActivity {
    int position;
    String[] pathList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imgview);
        Intent intent = getIntent();
        pathList = intent.getStringArrayExtra("pathList");
        position = intent.getIntExtra("Position", 0);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageBitmap(BitmapFactory.decodeFile(pathList[position]));
    }
}