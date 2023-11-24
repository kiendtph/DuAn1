package kiendtph37589.fpoly.appbanquanao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class TrangChuActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView_trangchu;
    NavigationView navigationView;
    ListView lv_trangchu;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        anhXa();
        ActionBar();
        ActionViewFliper();
    }

    private void ActionViewFliper() {
        ViewFlipper viewFlipper = findViewById(R.id.viewFlipper);

        // Create an ArrayList of images
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.images1);
        images.add(R.drawable.imgae);
        images.add(R.drawable.images2);

        // Add the images to the ViewFlipper
        for (int image : images) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(image);
            viewFlipper.addView(imageView);
        }

        // Set the in and out animations for the ViewFlipper
        Animation inAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_right);
        Animation outAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_right);
        viewFlipper.setInAnimation(inAnimation);
        viewFlipper.setOutAnimation(outAnimation);

        // Set the flip interval for the ViewFlipper
        viewFlipper.setFlipInterval(3000);

        // Start the ViewFlipper
        viewFlipper.startFlipping();
    }

    private void ActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void anhXa(){
        toolbar = findViewById(R.id.toobar_trangchu);
        viewFlipper = findViewById(R.id.viewFlipper);
        recyclerView_trangchu = findViewById(R.id.recyclerview);
        lv_trangchu = findViewById(R.id.lv_trangchu);
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
    }
}