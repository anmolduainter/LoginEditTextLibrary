package com.example.joginderpal.edittextanimation;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.library.textEdit;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {

    textEdit username,email,password;
    RelativeLayout main;
    Button btn;

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         username= (com.example.library.textEdit) findViewById(R.id.username);
        email= (textEdit) findViewById(R.id.email);
        password= (textEdit) findViewById(R.id.password);
        main= (RelativeLayout) findViewById(R.id.relative_main);
        btn= (Button) findViewById(R.id.Login_btn);
        username.setHint("Username");
        password.setHint("Password");
        email.setHint("Email");
        username.setText("Username");
        email.setText("Email");
        password.setText("Password");

        Glide.with(MainActivity.this).load("http://www.wallpapereast.com/static/images/1321922_STpOMHj.jpg").bitmapTransform(new BlurTransformation(MainActivity.this,100))
                .into(new SimpleTarget<GlideDrawable>() {
                    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {

                         main.setBackground(resource);
                    }
                });


        username.setBackgroundRel(0);
        email.setBackgroundRel(0);
        password.setBackgroundRel(0);
        Drawable email_icon=getResources().getDrawable(R.drawable.email,null);
        Drawable pass_icon=getResources().getDrawable(R.drawable.password,null);
        Drawable okay=getResources().getDrawable(R.drawable.okay,null);
        email.setImagePro(email_icon);
        password.setImagePro(pass_icon);
        username.setHintColor(Color.WHITE);
        email.setHintColor(Color.WHITE);
        password.setHintColor(Color.WHITE);
        username.setTextColor(Color.WHITE);
        email.setTextColor(Color.WHITE);
        password.setTextColor(Color.WHITE);
        username.setOkay(okay);
        email.setOkay(okay);
        password.setOkay(okay);
     //   btn.setBackgroundColor(R.color.username);


       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent i=new Intent(MainActivity.this,secondActivity.class);
               i.putExtra("username",username.getText().toString());
               startActivity(i);


           }
       });

    }

}
