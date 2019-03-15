package com.app.slidebottomtotopanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class XmlAnimationsActivity extends AppCompatActivity {

    ImageView iv_close,imageView;
    RelativeLayout layout_move;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_animations);

        layout_move=(RelativeLayout)findViewById(R.id.layout_move);
        iv_close=(ImageView)findViewById(R.id.iv_close);
        imageView=(ImageView)findViewById(R.id.imageView);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(XmlAnimationsActivity.this,"touch",Toast.LENGTH_SHORT).show();
                moveUp();
            }
        });

        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(XmlAnimationsActivity.this,"touch",Toast.LENGTH_SHORT).show();
              moveDown();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(XmlAnimationsActivity.this,"touch",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void moveUp(){
        layout_move.setVisibility(View.VISIBLE);
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_top);
        layout_move.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layout_move.clearAnimation();
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        layout_move.getWidth(), layout_move.getHeight());
                lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                layout_move.setLayoutParams(lp);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void moveDown(){
        Animation animation1 =
                AnimationUtils.loadAnimation(getApplicationContext(), R.anim.top_to_bottom);
        layout_move.startAnimation(animation1);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layout_move.clearAnimation();
                RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                        layout_move.getWidth(), layout_move.getHeight());
                lp.setMargins(0, 0, 0, -layout_move.getHeight());
                lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                layout_move.setLayoutParams(lp);
                layout_move.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
