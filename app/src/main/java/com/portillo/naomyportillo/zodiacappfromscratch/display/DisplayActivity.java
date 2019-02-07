package com.portillo.naomyportillo.zodiacappfromscratch.display;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.portillo.naomyportillo.zodiacappfromscratch.R;
import com.squareup.picasso.Picasso;

import static com.portillo.naomyportillo.zodiacappfromscratch.recyclerview.ZodiacHolder.ZODIACDATE;
import static com.portillo.naomyportillo.zodiacappfromscratch.recyclerview.ZodiacHolder.ZODIACIMAGE;
import static com.portillo.naomyportillo.zodiacappfromscratch.recyclerview.ZodiacHolder.ZODIACNAME;

public class DisplayActivity extends AppCompatActivity {

    private String displayName;
    private String displayDate;
    private String displayImageUrl;

    private ImageView displayImage;
    private TextView displayNameTextView;
    private TextView displayDateTextView;
    private Button horoscopeButton;

    private String URL = "";
    private final String URLSTARTPOINT = "https://www.astrology.com/horoscope/daily/today/";
    private final String URLENDPOINT = ".html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        findViews();
        Intent intent = getIntent();
        extractIntentData(intent);
        setViews();
        buttonOnClick(URL);

    }

    private void buttonOnClick(final String url) {
        horoscopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent webpageIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(webpageIntent);

            }
        });
    }

    private void setViews() {
        Picasso.get().load(displayImageUrl).into(displayImage);
        displayNameTextView.setText(displayName);
        displayDateTextView.setText(displayDate);
    }

    @NonNull
    private void extractIntentData(Intent intent) {
        displayName = intent.getStringExtra(ZODIACNAME);
        displayDate = intent.getStringExtra(ZODIACDATE);
        displayImageUrl = intent.getStringExtra(ZODIACIMAGE);
        URL = URLSTARTPOINT + displayName + URLENDPOINT;
    }

    private void findViews() {
        displayImage = findViewById(R.id.display_zodiac_imageview);
        displayNameTextView = findViewById(R.id.display_zodiac_name_textview);
        displayDateTextView = findViewById(R.id.display_zodiac_date_textview);
        horoscopeButton = findViewById(R.id.horoscope_button);
    }
}
