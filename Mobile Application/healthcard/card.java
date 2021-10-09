package com.example.healthcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

import static android.graphics.Bitmap.Config.ARGB_8888;
import static android.graphics.Color.BLACK;
import static android.graphics.Color.WHITE;

public class card extends AppCompatActivity {
    private FirebaseUser user;
    private String UserID,path;
    public DatabaseReference reference;
    private String fullName;
    private StorageReference mstorageref;
    TextView healthkiId;
    Button gbtn;
    ImageView qrDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        user= FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference(path = "Users");
        UserID=user.getUid();

        final TextView fullNameTextView = findViewById(R.id.fullName);
       // final TextView ageTextView = findViewById(R.id.age);
        final TextView healthTextView = findViewById(R.id.healthid);

        reference.child(UserID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                User userprofile = datasnapshot.getValue(User.class);

                if (userprofile != null) {

                    fullName = userprofile.fullName;
                    //String age = userprofile.age;
                    String health = user.getUid();


                    fullNameTextView.setText(fullName);
                  //  ageTextView.setText(age);
                    healthTextView.setText(health);


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                String text;
                Toast.makeText(card.this,
                        text = "Something wrong happened..!",
                        Toast.LENGTH_LONG).show();
            }
        });


        //pic
        mstorageref= FirebaseStorage.getInstance().getReference().child("Images/1621710030842.jpg");

        try {
            final File localfile = File.createTempFile("girl","jpg");
            mstorageref.getFile(localfile)
            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                    Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                    ((ImageView)findViewById(R.id.profile_img)).setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(card.this, "Error", Toast.LENGTH_SHORT).show();
                }
            });



        } catch (IOException e) {
            e.printStackTrace();
        }



        //QR
        qrDisplay=findViewById(R.id.qr_imgholder);
        gbtn=findViewById(R.id.generatebtn);
        healthkiId=findViewById(R.id.healthid);
      gbtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              if(!TextUtils.isEmpty(healthkiId.getText())){
                  String text= healthkiId.getText().toString();
                  Bitmap qrcode=createBitmap(text);
                  qrDisplay.setImageBitmap(qrcode);
              }
          }
      });

    }

    private Bitmap createBitmap(String text) {
        BitMatrix result=null;
        try{
            result=new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE,300,300,null);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
        int width=result.getWidth();
        int height=result.getHeight();
        int[] pixels= new int[width*height];
        for(int x=0;x<height;x++){
            int offset= x*width;
            for(int k=0;k<width;k++){
                pixels[offset + k]=result.get(k,x) ? BLACK : WHITE;
            }
        }
        Bitmap mybitmap=Bitmap.createBitmap(width,height,ARGB_8888);
        mybitmap.setPixels(pixels,0,width,0,0,width,height);
        return mybitmap;
    }

}