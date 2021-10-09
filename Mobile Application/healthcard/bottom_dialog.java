package com.example.healthcard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class bottom_dialog extends BottomSheetDialogFragment {

    private TextView title,link,btn_visit;
    private ImageView close;
    private String fetchurl;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.bottom_dialog,container,false);

        title=view.findViewById(R.id.txt_title);
        link=view.findViewById(R.id.txt_link);
        btn_visit=view.findViewById(R.id.visit);
        close=view.findViewById(R.id.close);


        btn_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlink = new Intent("android.intent.action.VIEW");
                intentlink.setData(Uri.parse(fetchurl));
                startActivity(intentlink);
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return view;
    }
public void fetchurl(String url){
    ExecutorService executorService= Executors.newSingleThreadExecutor();
    Handler handler=new Handler(Looper.getMainLooper());
    executorService.execute(new Runnable() {
        @Override
        public void run() {
            fetchurl=url;
        }
    });

}
}
