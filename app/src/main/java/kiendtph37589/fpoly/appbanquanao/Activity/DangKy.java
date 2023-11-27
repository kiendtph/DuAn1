package kiendtph37589.fpoly.appbanquanao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import kiendtph37589.fpoly.appbanquanao.R;

public class DangKy extends AppCompatActivity {
    private TextView tv_DangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        tv_DangNhap = findViewById(R.id.tv_DangNhap);
        tv_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangKy.this, DangNhap.class));
            }
        });

    }
}