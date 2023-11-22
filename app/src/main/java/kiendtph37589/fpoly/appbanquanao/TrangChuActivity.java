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
        ArrayList<String> mangQuangCao = new ArrayList<>();
        mangQuangCao.add("https://www.google.com.vn/imgres?imgurl=https%3A%2F%2Ftoquoc.mediacdn.vn%2F280518851207290880%2F2022%2F11%2F22%2Fphoto-1669124886644-16691248878931843591997-0-200-1041-1866-crop-16691249768821245192000.jpg&tbnid=cJHMaq-ciLma3M&vet=12ahUKEwi719CqkNeCAxXzZfUHHRJ4ALYQMygXegQIARB4..i&imgrefurl=http%3A%2F%2Fttvn.toquoc.vn%2Fblack-friday-old-sailor-2022-dai-tiec-san-sale-giam-gia-den-50-20221122205025542.htm&docid=PhJMW2L-crVjAM&w=1666&h=1041&q=h%C3%ACnh%20%E1%BA%A3nh%20sale%20qu%E1%BA%A7n%20%C3%A1o&ved=2ahUKEwi719CqkNeCAxXzZfUHHRJ4ALYQMygXegQIARB4");
        mangQuangCao.add("https://www.google.com.vn/imgres?imgurl=https%3A%2F%2Fsuno.vn%2Fblog%2Fwp-content%2Fuploads%2F2015%2F12%2Fsale-off.jpg&tbnid=ld5iZtNndIVRWM&vet=12ahUKEwi719CqkNeCAxXzZfUHHRJ4ALYQMygEegQIARBS..i&imgrefurl=https%3A%2F%2Fsuno.vn%2Fblog%2Fnhung-quang-cao-duoi-het-khach-hang-cua-ban%2F&docid=gPr7ciIs6aSxAM&w=600&h=317&q=h%C3%ACnh%20%E1%BA%A3nh%20sale%20qu%E1%BA%A7n%20%C3%A1o&ved=2ahUKEwi719CqkNeCAxXzZfUHHRJ4ALYQMygEegQIARBS");
        mangQuangCao.add("https://www.google.com.vn/imgres?imgurl=https%3A%2F%2Fthuthuatnhanh.com%2Fwp-content%2Fuploads%2F2022%2F06%2FAnh-sale-dep.jpg&tbnid=O8H8uDpRf_qD0M&vet=12ahUKEwik1_uZkdeCAxX8tlYBHYeABPQQMygGegQIARBb..i&imgrefurl=https%3A%2F%2Fthuthuatnhanh.com%2Fanh-sale%2F&docid=jzoCvgjm36xbzM&w=1680&h=1228&q=h%C3%ACnh%20%E1%BA%A3nh%20sale%20qu%E1%BA%A7n%20%C3%A1o&hl=vi&ved=2ahUKEwik1_uZkdeCAxX8tlYBHYeABPQQMygGegQIARBb");

        for (int i = 0; i < mangQuangCao.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            Glide.with(getApplicationContext()).load(R.drawable.imgae).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(slide_in);
        viewFlipper.setOutAnimation(slide_out);
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