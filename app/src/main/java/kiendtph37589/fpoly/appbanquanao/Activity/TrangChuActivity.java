package kiendtph37589.fpoly.appbanquanao.Activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.request.Request;
import com.google.android.material.navigation.NavigationView;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
//
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import kiendtph37589.fpoly.appbanquanao.Adapter.LoaiSpAdapter;
import kiendtph37589.fpoly.appbanquanao.R;
import kiendtph37589.fpoly.appbanquanao.Retrofit.ApiBanHang;
import kiendtph37589.fpoly.appbanquanao.Retrofit.RetrofitClient;
import kiendtph37589.fpoly.appbanquanao.model.LoaiSp;
import kiendtph37589.fpoly.appbanquanao.utils.Utils;

public class TrangChuActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView_trangchu;
    NavigationView navigationView;
    ListView lv_trangchu;
    DrawerLayout drawerLayout;
    LoaiSpAdapter loaiSpAdapter;
    ArrayList<LoaiSp> mangloaisp;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);

        anhXa();
        ActionBar();
        ActionViewFliper();
        if (isConnected(this)){
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
            ActionViewFliper();
            getLoaiSanPham();
        }else {
            Toast.makeText(this, "Không có internet", Toast.LENGTH_SHORT).show();
        }
    }

    private void getLoaiSanPham() {

        compositeDisposable.add(apiBanHang.getLoaiSp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                   loaiSpModel -> {
                       if (loaiSpModel.isSuccess()){
                           mangloaisp = (ArrayList<LoaiSp>) loaiSpModel.getResult();
                           loaiSpAdapter = new LoaiSpAdapter(getApplicationContext(),mangloaisp);
                           lv_trangchu.setAdapter(loaiSpAdapter);
                       }
                   }
                ));
    }

    private void ActionViewFliper() {
        ViewFlipper viewFlipper = findViewById(R.id.viewFlipper);

        // Create an ArrayList of images
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.imgae);
        images.add(R.drawable.images3);
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
        //khai báo list
        mangloaisp = new ArrayList<>();
        //Khởi tạo Adapter


    }
    private boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);//Nho them quyen vao khong bi loi
        NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if ((wifi != null && wifi.isConnectedOrConnecting()) || (mobile != null && mobile.isConnectedOrConnecting())){
            return true;
        }else {
            return false;
        }
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();

    }
}