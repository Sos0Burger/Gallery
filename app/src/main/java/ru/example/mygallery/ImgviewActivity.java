package ru.example.mygallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
    public void nextImg(View v){
        if (position<pathList.length-1){
            PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
            position++;
            photoView.setImageBitmap(BitmapFactory.decodeFile(pathList[position]));
        }
        else{
            Toast.makeText(getApplicationContext(), "Фото больше нет", Toast.LENGTH_SHORT).show();
        }
    }
    public void previousImg(View v){
        if (position!=0){
            PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
            position--;
            photoView.setImageBitmap(BitmapFactory.decodeFile(pathList[position]));
        }
        else{
            Toast.makeText(getApplicationContext(), "Фото больше нет", Toast.LENGTH_SHORT).show();
        }
    }
}