package mx.cenitt.www.cenittapp.inicio;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import mx.cenitt.www.cenittapp.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
/*      ImageView img = (ImageView)findViewById(R.id.loadingView);
        img.setBackgroundResource(R.drawable.loading);

        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
        frameAnimation.start();
        frameAnimation.stop(); */

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, InicioSesion.class);
                startActivity(intent);
                finish();

            }
        }, 4000);
    }


}


