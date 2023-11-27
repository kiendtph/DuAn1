package kiendtph37589.fpoly.appbanquanao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import kiendtph37589.fpoly.appbanquanao.R;

public class MainActivity extends AppCompatActivity {
    private ImageView img_Logo;
    private static final int FADE_DURATION = 2000; // Thời gian hiệu ứng hiển thị (milliseconds)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            img_Logo = findViewById(R.id.img_logo);
// Tạo hiệu ứng hiển thị dần dần
            Animation fadeInAnimation = new AlphaAnimation(0, 1);
            fadeInAnimation.setDuration(FADE_DURATION);
            fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    img_Logo.setVisibility(View.VISIBLE);
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    // Sau khi hiệu ứng kết thúc, chuyển đến màn hình chính
                    // Ví dụ: startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                    finish();
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                    // Không cần xử lý
                }
            });
            img_Logo.startAnimation(fadeInAnimation);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(MainActivity.this, DangNhap.class));
                    finish();
                }
            },FADE_DURATION);
        }
    }