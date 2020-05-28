package com.example.myapp;


import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
       Button button = (Button) findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view){
               setWallpaper();
           }
       });
    }
    private void setWallpaper(){
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.homefr);
        Bitmap bitmapl= BitmapFactory.decodeResource(getResources(), R.drawable.lockfr);
        WallpaperManager manager= WallpaperManager.getInstance(getApplicationContext());
        try{
            manager.setBitmap(bitmap); //set homepage
            WallpaperManager.setBitmap(bitmapl,null,true,WallpaperManager.FLAG_LOCK); //set screen page
            Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show();
        }catch(IOException e){
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }

    }
}







