package com.portillo.naomyportillo.zodiacappfromscratch.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.portillo.naomyportillo.zodiacappfromscratch.R;
import com.portillo.naomyportillo.zodiacappfromscratch.model.ZodiacModel;

import java.util.List;

public class ZodiacAdapter extends RecyclerView.Adapter<ZodiacHolder> {

   List<ZodiacModel> zodiacModelList;

    public ZodiacAdapter(List<ZodiacModel> zodiacModelList) {
        this.zodiacModelList = zodiacModelList;
    }

    @NonNull
    @Override
    public ZodiacHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.zodiac_recycler_view, viewGroup, false);
        return new ZodiacHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull ZodiacHolder zodiacHolder, int pos) {
        ZodiacModel zodiacModel = zodiacModelList.get(pos);
        ZodiacHolder.onBind(zodiacModel);
    }

    @Override
    public int getItemCount() {
        return zodiacModelList.size();
    }
}
