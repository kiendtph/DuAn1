package kiendtph37589.fpoly.appbanquanao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kiendtph37589.fpoly.appbanquanao.R;

public class DangNhap extends AppCompatActivity {
    private TextView tv_DangKy;
    private Button btn_DangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        tv_DangKy = findViewById(R.id.tv_DangKy);
        btn_DangNhap = findViewById(R.id.btn_DangNhap);
        btn_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangNhap.this, TrangChuActivity.class));
            }
        });
        tv_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangNhap.this, DangKy.class));
            }
        });
    }
    //;duowbg
}