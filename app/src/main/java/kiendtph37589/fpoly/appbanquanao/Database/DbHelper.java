package kiendtph37589.fpoly.appbanquanao.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "appMuaSam.db";
    private static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tạo bảnh Admin
        String createTableAdmin = "CREATE TABLE Admin (" +
                "maAM TEXT PRIMARY KEY, " +
                "matKhau TEXT NOT NULL, " +
                "hoTen TEXT NOT NULL)";
        db.execSQL(createTableAdmin);
        String setAdmin = "INSERT INTO thuthu VALUES('admin', 'Admin', 'admin')";
        db.execSQL(setAdmin);

        //tạo bảng người dùng
        String nnNguoiDung = "CREATE TABLE NguoiDung (" +
                "maND TEXT PRIMARY KEY, " +
                "email Email NOT NULL, " +
                "taiKhoan TEXT NOT NULL, " +
                "matKhau TEXT NOT NULL, " +
                "hoTen TEXT NOT NULL)";
        db.execSQL(nnNguoiDung);

        //tạo bảng loại sản phẩm
        String loaiSanPham = "create table LoaiSanPham(" +
                        "maLoai INTEGER primary key AUTOINCREMENT, " +
                        "tenLoai TEXT not null)";
        db.execSQL(loaiSanPham);
//tạo bảng  sản phẩm
        String ssanPham="CREATE TABLE SanPham (" +
               "maSP TEXT PRIMARY KEY, " +
               "size Text NOT NULL, " +
                "Image Integer NOT NULL, " +
                "soLuong Integer NOT NULL, " +
                "gia Integer NOT NULL, " +
               "tenSP TEXT NOT NULL," +
        "maLoai INTEGER REFERENCES LoaiSanPham(maLoai))";
        db.execSQL(ssanPham);
//tạo bảng  sản phẩm chi tiết
        String ssanPhamChiTiet="CREATE TABLE SanPhamChiTiet (" +
                "maSPCT TEXT PRIMARY KEY, " +
                "moTa TEXT NOT NULL," +
                "maSP INTEGER REFERENCES SanPham(maSP))";
        db.execSQL(ssanPhamChiTiet);
//tạo bảng  hóa đơn
        String hhoadon="CREATE TABLE HoaDon (" +
                "maHD TEXT PRIMARY KEY, " +
                "tongTien INTEGER not null, " +
                "ngay DATE not null, " +
                "maND INTEGER REFERENCES NguoiDung(maTV), " +
                "maSP INTEGER REFERENCES SanPham(maSP))";

        db.execSQL(hhoadon);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < newVersion){
            db.execSQL("DROP TABLE IF EXISTS Admin");
            onCreate(db);
            String dropTableThanhVien = "drop table if exists NguoiDung";
            db.execSQL(dropTableThanhVien);
            String dropLoaiSanPham = "drop table if exists LoaiSanPham";
            db.execSQL(dropLoaiSanPham);
            String dropSanPham = "drop table if exists SanPham";
            db.execSQL(dropSanPham);
            String dropSanPhamChiTiet = "drop table if exists SanPhamChiTiet";
            db.execSQL(dropSanPhamChiTiet);
            String dropHoaDon = "drop table if exists HoaDon";
            db.execSQL(dropHoaDon);


        }
    }
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        if (!db.isReadOnly()){
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }
}
