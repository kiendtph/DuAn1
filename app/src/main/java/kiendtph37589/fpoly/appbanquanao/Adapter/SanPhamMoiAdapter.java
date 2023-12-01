package kiendtph37589.fpoly.appbanquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import kiendtph37589.fpoly.appbanquanao.R;
import kiendtph37589.fpoly.appbanquanao.model.SanPhamMoi;

public class SanPhamMoiAdapter extends RecyclerView.Adapter<SanPhamMoiAdapter.MyViewHoder> {
    Context context;
    List<SanPhamMoi> array;

    public SanPhamMoiAdapter(Context context, List<SanPhamMoi> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sp_moi, parent,false);

        return new MyViewHoder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        SanPhamMoi sanPhamMoi = array.get(position);
        holder.tv_ten.setText(sanPhamMoi.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");

        holder.tv_gia.setText("Giá: "+decimalFormat.format(Double.parseDouble(sanPhamMoi.getGiasp()))+ "Đ");
        Glide.with(context).load(sanPhamMoi.getHinhanh()).into(holder.img_hinhanh);
    }

    @Override
    public int getItemCount() {
        return array.size();
    }


    public class MyViewHoder extends RecyclerView.ViewHolder{
        TextView tv_gia,tv_ten;
        ImageView img_hinhanh;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
            tv_gia = itemView.findViewById(R.id.tv_giasp_moi);
            tv_ten = itemView.findViewById(R.id.tv_tensp_moi);
            img_hinhanh = itemView.findViewById(R.id.img_sp_image);
        }
    }
}
