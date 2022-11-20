package com.example.ecs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ecs.databinding.ActivityListItemBinding;
import com.example.ecs.net.EcsDoc;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    List<EcsDoc.Proofs> proofs;

    public ListAdapter(Context context, List<EcsDoc.Proofs> proofs) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.proofs = proofs;
    }

    @Override
    public int getCount() {
        return proofs.size();
    }

    @Override
    public Object getItem(int i) {
        return proofs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        /*뷰 바인딩*/
        ActivityListItemBinding binding = ActivityListItemBinding.inflate(layoutInflater);
        /* 발급기관 */
        binding.txtInsttNm.setText(proofs.get(i).getIssuInsttNm());
        /* 전자증명서 */
        binding.txtDocNm.setText(proofs.get(i).getDocKndNm());
        /* 발급일자 */
        binding.txtIssuDt.setText(proofs.get(i).getIssuDt());
        /* 유효기간 */
        binding.txtValidDt.setText(proofs.get(i).getVaildDt());

        return  binding.getRoot();
    }
}
