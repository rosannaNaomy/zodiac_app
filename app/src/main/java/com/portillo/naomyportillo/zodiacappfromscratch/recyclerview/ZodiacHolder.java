package com.portillo.naomyportillo.zodiacappfromscratch.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.portillo.naomyportillo.zodiacappfromscratch.R;
import com.portillo.naomyportillo.zodiacappfromscratch.display.DisplayActivity;
import com.portillo.naomyportillo.zodiacappfromscratch.model.ZodiacModel;

public class ZodiacHolder extends RecyclerView.ViewHolder {

    private static final String TAG = ".ZodiacHolder";
    public static final String ZODIACNAME = "name";
    public static final String ZODIACIMAGE = "image";
    public static final String ZODIACDATE = "date";
    private static CardView zodiacCardview;
    private static TextView zodiacTextview;

    public ZodiacHolder(@NonNull View itemView) {
        super(itemView);
        this.zodiacCardview = itemView.findViewById(R.id.layout_mzodiac_cardview);
        this.zodiacTextview = itemView.findViewById(R.id.zodiacName_textView);
    }

    public static void onBind(final ZodiacModel zodiacModel) {

        zodiacTextview.setText(zodiacModel.getName());

        zodiacCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(zodiacCardview.getContext(), DisplayActivity.class);

                intent.putExtra(ZODIACNAME, zodiacModel.getName());
                intent.putExtra(ZODIACIMAGE, zodiacModel.getImage());
                intent.putExtra(ZODIACDATE, zodiacModel.getNumber());

                zodiacCardview.getContext().startActivity(intent);
            }
        });

    }
}
