package com.example.myapp;


import android.app.WallpaperManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Locale;

import dalvik.system.DexFile;


public class MainActivity extends AppCompatActivity {
    private ContentResolver cResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
       Button buttonf = (Button) findViewById(R.id.buttonOne);
       buttonf.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view){
               setWallpaperf();
               setAppLocale("fr");
               Intent i = new Intent( android.provider.Settings.ACTION_LOCALE_SETTINGS );
               startActivity( i );
           }
       });
        Button buttone = (Button) findViewById(R.id.buttonTwo);
        buttone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                setWallpapere();
                setAppLocale("en");
                Intent i = new Intent( android.provider.Settings.ACTION_LOCALE_SETTINGS );
                startActivity( i );
            }
        });
        Button buttth = (Button) findViewById(R.id.buttonThree);
        buttth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goToUrl("http://stackoverflow.com/");
            }
        });
        Button buttfo = (Button) findViewById(R.id.buttonFour);
        buttfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                goToUrl("http://stackoverflow.com/");
            }
        });
    }
    private void setWallpaperf(){
        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.homefr);
        Bitmap bitmapl= BitmapFactory.decodeResource(getResources(), R.drawable.lockfr);
        WallpaperManager manager= WallpaperManager.getInstance(getApplicationContext());
        try{
            manager.setBitmap(bitmap); //set homepage
            manager. setBitmap(bitmapl,null,true,WallpaperManager.FLAG_LOCK); //set screen page
            Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show();
        }catch(IOException e){
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setWallpapere(){
        Bitmap bitmape= BitmapFactory.decodeResource(getResources(), R.drawable.lockfr);
        Bitmap bitmapl= BitmapFactory.decodeResource(getResources(), R.drawable.homefr);
        WallpaperManager manager= WallpaperManager.getInstance(getApplicationContext());
        try{
            manager.setBitmap(bitmape); //set homepage
            manager.setBitmap(bitmapl,null,true,WallpaperManager.FLAG_LOCK); //set screen page
            Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show();
        }catch(IOException e){
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }

    }


    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        } else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        resources.updateConfiguration(config, dm);
    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}







