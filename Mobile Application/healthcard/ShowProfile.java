package com.example.healthcard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
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
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.Objects;

public class ShowProfile extends AppCompatActivity {

    private FirebaseUser user;
    private String UserID,path;
    public DatabaseReference reference;
    private String fullName;

    //profile pic

    Button up,ch;
    ImageView img;
    StorageReference mstoragereference;
    private StorageTask uploadTask;

    public Uri imageuri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_profile);


            user= FirebaseAuth.getInstance().getCurrentUser();
            reference = FirebaseDatabase.getInstance().getReference(path = "Users");
            UserID=user.getUid();

        final TextView greetingTextView = findViewById(R.id.gretting);
        final TextView fullNameTextView = findViewById(R.id.fullName);
        final TextView emailTextView = findViewById(R.id.emailAddress);
        final TextView ageTextView = findViewById(R.id.age);
        final TextView healthTextView = findViewById(R.id.healthid);

            reference.child(UserID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                    User userprofile = datasnapshot.getValue(User.class);

                    if (userprofile != null) {

                        fullName = userprofile.fullName;
                        String email = userprofile.email;
                        String age = userprofile.age;
                        String health = user.getUid();


                        greetingTextView.setText("Welcome, " + fullName + "!");
                        fullNameTextView.setText(fullName);
                        emailTextView.setText(email);
                        ageTextView.setText(age);
                        healthTextView.setText(health);


                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    String text;
                    Toast.makeText(ShowProfile.this,
                            text = "Something wrong happened..!",
                            Toast.LENGTH_LONG).show();
                }
            });


            //profile pic
        mstoragereference= FirebaseStorage.getInstance().getReference("Images");

        ch=(Button)findViewById(R.id.choose_btn);
        up=(Button)findViewById(R.id.upload_btn);
        img=(ImageView)findViewById(R.id.profile_image);
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uploadTask !=null && uploadTask.isInProgress()){
                    Toast.makeText(ShowProfile.this, "Upload in progress", Toast.LENGTH_SHORT).show();
                }else {
                    FileUploader();
                }
            }
        });


        }
        //profile pic

    private String getExtension(Uri uri){
        ContentResolver cr= getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    private void FileUploader() {
        StorageReference Ref=mstoragereference.child(System.currentTimeMillis()+"."+getExtension(imageuri));

        uploadTask= Ref.putFile(imageuri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(ShowProfile.this, "Image uploaded Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
    }

    private void Filechooser() {
        Intent intentg =new Intent();
        intentg.setType("image/*");
        intentg.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentg, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imageuri=data.getData();
            img.setImageURI(imageuri);
        }
    }
}