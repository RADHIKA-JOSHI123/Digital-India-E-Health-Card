package com.example.healthcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.MediaController;
import android.widget.VideoView;


import com.google.android.material.navigation.NavigationView;

import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class dashboard extends AppCompatActivity {
        NavigationView nav;
        ActionBarDrawerToggle toggle;
        DrawerLayout drawerLayout;
        androidx.appcompat.widget.Toolbar toolbar;

    // Urls of our images.
    String url1 = "https://pmjay.gov.in/sites/default/files/2020-01/2.jpg";
    String url2 = "https://pmjay.gov.in/sites/default/files/2020-01/4.jpg";
    String url3 = "https://pmjay.gov.in/sites/default/files/2020-01/1.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
         toolbar= (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         nav=(NavigationView)findViewById(R.id.navmenu);
         drawerLayout =(DrawerLayout)findViewById(R.id.drawer);

         toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
         drawerLayout.addDrawerListener(toggle);
         toggle.syncState();

         nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                 switch (menuItem.getItemId()){
                     case R.id.menu_home:
                         Toast.makeText(getApplicationContext(), "Home panel is open", Toast.LENGTH_SHORT).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Intent intents = new Intent(getApplicationContext(),dashboard.class);
                         startActivity(intents);
                         break;

                     case R.id.menu_call:
                         Toast.makeText(getApplicationContext(), "Call panel is open", Toast.LENGTH_SHORT).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Intent intentcall = new Intent(getApplicationContext(),call.class);
                         startActivity(intentcall);
                         break;

                     case R.id.menu_profile:
                         Toast.makeText(getApplicationContext(), "Profile panel is open", Toast.LENGTH_SHORT).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Intent intentq = new Intent(getApplicationContext(),ShowProfile.class);
                         startActivity(intentq);
                         break;

                     case R.id.menu_HealthCard:
                         Toast.makeText(getApplicationContext(), "Health card panel is open", Toast.LENGTH_SHORT).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Intent intentt = new Intent(getApplicationContext(),card.class);
                         startActivity(intentt);
                         break;

                     case R.id.menu_certificate1:
                         Toast.makeText(getApplicationContext(), "Scan the QR on 1st Vaccine certificate to upload details", Toast.LENGTH_SHORT).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Intent intentcc = new Intent(getApplicationContext(),qrscanner.class);
                         startActivity(intentcc);
                         break;

                     case R.id.menu_chat:
                         Toast.makeText(getApplicationContext(), "chat panel is open", Toast.LENGTH_SHORT).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Intent intento = new Intent(getApplicationContext(),chatbot.class);
                         startActivity(intento);
                         break;

                     case R.id.detect:
                         Toast.makeText(getApplicationContext(), "chat panel is open", Toast.LENGTH_SHORT).show();
                         drawerLayout.closeDrawer(GravityCompat.START);
                         Intent intentdet = new Intent(getApplicationContext(),Detect_Disease.class
                         );
                         startActivity(intentdet);
                         break;




                     default:
                         throw new IllegalStateException("Unexpected value: " + menuItem.getItemId());
                 }
                 return true;
             }
         });

        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList) {
            @Override
            public int getItemCount() {
                return 0;
            }

            @Override
            public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {

            }
        };

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();



    }
}