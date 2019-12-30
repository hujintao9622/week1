package com.bawei.week1.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.week1.R;
import com.bawei.week1.model.bean.JavaBean;
import com.bawei.week1.util.NetUtil;

import java.util.List;

/**
 * 功能:  页面
 * 作者:  胡锦涛
 * 时间:  2019/12/29 0029 上午 11:26
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private List<JavaBean.DataBean> list;

    public MyAdapter(List<JavaBean.DataBean> data) {

        list = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=View.inflate(parent.getContext(), R.layout.item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        JavaBean.DataBean dataBean = list.get(position);
        holder.name.setText(dataBean.getGoods_name());
        holder.price.setText(dataBean.getRank_price());
        NetUtil.getInstance().getPhoto(dataBean.getGoods_thumb(),holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.OnItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.it_img);
            name=itemView.findViewById(R.id.it_name);
            price=itemView.findViewById(R.id.it_price);
        }
    }
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void OnItemClick(int position);
    }
}
