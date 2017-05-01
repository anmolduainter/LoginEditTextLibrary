package com.example.library;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by joginderpal on 01-05-2017.
 */
public class textEdit extends RelativeLayout {

    public static final int anim_duration=400;
     Context context;
    String textHint;
    String text;
    ImageView profile;
    RelativeLayout rel_text,rel_edit;
     EditText editText;
    ImageButton change,okay;
     TextView textView;
     Boolean editTextOpen;


    public textEdit(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public textEdit(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    public textEdit(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public textEdit(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context=context;
        init();
    }

    public void init(){
        inflate(getContext(),R.layout.first,this);
        editTextOpen=false;
        loadViews();
       // onFocuschanged();
        clicking();
    }

    public void loadViews(){
        editText= (EditText) findViewById(R.id.edit_library);
        change= (ImageButton) findViewById(R.id.image_buttton);
        okay= (ImageButton) findViewById(R.id.image_buttton_edit);
        rel_text= (RelativeLayout) findViewById(R.id.rel_textview);
        rel_edit= (RelativeLayout) findViewById(R.id.rel_editText);
        profile= (ImageView) findViewById(R.id.library_profile);
        textView= (TextView) findViewById(R.id.text_library);
        rel_edit.setVisibility(View.INVISIBLE);
        rel_text.setVisibility(View.VISIBLE);
       // textView.setText("Enter Your Name");
    }

    public void clicking(){


        change.setOnTouchListener(new OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                rel_text.setVisibility(View.INVISIBLE);
                rel_edit.setVisibility(View.VISIBLE);

                Animator anim=ViewAnimationUtils.createCircularReveal(rel_edit,rel_edit.getLeft(),rel_edit.getTop(),0,Math.max(rel_edit.getWidth(),rel_edit.getHeight()));
                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                        if (textHint!=null) {
                            editText.setHint(textHint);
                        }
                        else{
                            editText.setHint("Your Hint");
                        }

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });


               anim.setDuration(anim_duration);
                anim.start();


                return false;
            }
        });



        okay.setOnTouchListener(new OnTouchListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                text=getText();
                rel_edit.setVisibility(View.INVISIBLE);
                rel_text.setVisibility(View.VISIBLE);

                Animator anim=ViewAnimationUtils.createCircularReveal(rel_text,0,0,0,Math.max( rel_text.getWidth(), rel_text.getHeight()));
                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                        if (text!=null){
                            textView.setText(text);
                        }
                        else{
                            textView.setText(" ");
                        }


                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });


                anim.setDuration(anim_duration);
                anim.start();




                return false;
            }
        });


    }

    public void setHint(String text){
        textHint=text;
    }

    public String getText(){
        return editText.getText().toString();
    }

    public void setText(String text){
        textView.setText(text);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setImagePro(Drawable res){
        profile.setBackground(res);
    }

    public void setBackgroundRel(int color){
        rel_text.setBackgroundColor(color);
    }

    public void setHintColor(int color){
        editText.setHintTextColor(Color.WHITE);
    }

    public void setTextColor(int color){
        editText.setTextColor(color);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void setOkay(Drawable d){

        okay.setBackground(d);

    }

}
