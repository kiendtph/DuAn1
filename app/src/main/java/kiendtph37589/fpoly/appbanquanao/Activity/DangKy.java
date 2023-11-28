package kiendtph37589.fpoly.appbanquanao.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import kiendtph37589.fpoly.appbanquanao.R;

public class DangKy extends AppCompatActivity {
    private EditText edt_tenTK,edtEmail,edtSoDT,edtpassWord,edtNhaplaiMk;
    private FirebaseAuth mAuth;
    private TextView tv_DangNhap;
    private Button btn_DangKy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        edt_tenTK = findViewById(R.id.edt_tenTK);
        edtEmail = findViewById(R.id.edtEmail);
        edtpassWord = findViewById(R.id.edtMatKhau);
        edtSoDT = findViewById(R.id.edtSoDT);
        mAuth = FirebaseAuth.getInstance();
        edtNhaplaiMk = findViewById(R.id.edtNhapLaiMK);
        btn_DangKy = findViewById(R.id.btn_DangKy);
        btn_DangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regester();
            }
        });
        tv_DangNhap = findViewById(R.id.tv_DangNhap);
        tv_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DangKy.this, DangNhap.class));
            }
        });

    }

    private void regester() {
        String tenTK,email,soDT,passWord,rePassWord;
        tenTK = edt_tenTK.getText().toString();
        email = edtEmail.getText().toString();
        soDT = edtSoDT.getText().toString();
        rePassWord = edtNhaplaiMk.getText().toString();
        passWord = edtpassWord.getText().toString();
        if (TextUtils.isEmpty(tenTK)){
            Toast.makeText(this, "Vui lòng nhập tên tài khoản!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(soDT)){
            Toast.makeText(this, "Vui lòng nhập số điện thoại!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Vui lòng nhập email!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passWord)){
            Toast.makeText(this, "Vui lòng nhập password!!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passWord.equalsIgnoreCase(passWord) != rePassWord.equalsIgnoreCase(rePassWord)){
            Toast.makeText(this, "Nhập lại mật khẩu sai!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (soDT.length() > 10){
            Toast.makeText(this, "Vui lòng nhập đúng số điện thoại", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email,passWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(DangKy.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DangKy.this, DangNhap.class));
                }else {
                    Toast.makeText(DangKy.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}