package kiendtph37589.fpoly.appbanquanao.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kiendtph37589.fpoly.appbanquanao.R;
import kiendtph37589.fpoly.appbanquanao.model.LoaiSp;

public class LoaiSpAdapter extends BaseAdapter {
    ArrayList<LoaiSp> array;
    Context context;

    public LoaiSpAdapter(Context context,ArrayList<LoaiSp> array) {
        this.array = array;
        this.context = context;
    }

    @Override
    public int getCount() {
        return array.size();
    }

    @Override
    public Object getItem(int position) {
        return array.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{
        TextView tv_tenSp;
        ImageView img_imgage;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_sanpham, null);
            viewHolder.tv_tenSp = convertView.findViewById(R.id.tv_tenSp);
            viewHolder.img_imgage = convertView.findViewById(R.id.img_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_tenSp.setText(array.get(position).getTensanpham());
        Glide.with(context).load(array.get(position).getHinhanh()).into(viewHolder.img_imgage);

        return convertView;
    }
}
