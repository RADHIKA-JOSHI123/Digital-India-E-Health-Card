package com.example.healthcard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.util.Size;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.Barcode;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.common.InputImage;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scanner extends AppCompatActivity {
 private ListenableFuture cameraFutureProvider;
 private ExecutorService cameraExecutor;
 private PreviewView previewview;
 private MyImageAnalyser analyzer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        previewview=findViewById(R.id.previewView);
        this.getWindow().setFlags(1024,1024);

        cameraExecutor= Executors.newSingleThreadExecutor();
        cameraFutureProvider= ProcessCameraProvider.getInstance(this);

       analyzer=new MyImageAnalyser(getSupportFragmentManager());

        cameraFutureProvider.addListener(new Runnable() {
            @Override
            public void run() {

                try {
                        ProcessCameraProvider processCameraProvider = (ProcessCameraProvider) cameraFutureProvider.get();
                    bindpreview(processCameraProvider);
                }catch (ExecutionException e){
                    e.printStackTrace();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, ContextCompat.getMainExecutor(this));

    }

    private void bindpreview(ProcessCameraProvider processCameraProvider) {
        Preview preview= new Preview.Builder().build();
        CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();
        ImageCapture imagecapture = new ImageCapture.Builder().build();
        ImageAnalysis imageanalysis = new ImageAnalysis.Builder()
                .setTargetResolution(new Size(1280,720))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build();
        imageanalysis.setAnalyzer(cameraExecutor,analyzer);
        processCameraProvider.unbind();
        processCameraProvider.bindToLifecycle(this,cameraSelector,preview,imagecapture,imageanalysis);
    }

    public class MyImageAnalyser implements ImageAnalysis.Analyzer{
        private FragmentManager fragmentManager;
        private bottom_dialog bd;


        public MyImageAnalyser(FragmentManager fragmentManager) {
            this.fragmentManager = fragmentManager;
            bd= new bottom_dialog();
        }

            @Override
                    public void analyze(ImageProxy image){
            scanbarcode(image);

            }

    private void scanbarcode(ImageProxy image) {
        @SuppressLint("UnsafeOptInUsageError") Image image1=image.getImage();
        assert image1 !=null;
        InputImage inputImage = InputImage.fromMediaImage(image1,image.getImageInfo().getRotationDegrees());
        BarcodeScannerOptions options =
                new BarcodeScannerOptions.Builder()
                        .setBarcodeFormats(
                                Barcode.FORMAT_QR_CODE,
                                Barcode.FORMAT_AZTEC)
                        .build();

        BarcodeScanner scanner = BarcodeScanning.getClient();
        Task<List<Barcode>> result = scanner.process(inputImage)
                .addOnSuccessListener(new OnSuccessListener<List<Barcode>>() {
                    @Override
                    public void onSuccess(List<Barcode> barcodes) {
                        readerBarcodeData(barcodes);
                        // Task completed successfully
                        // ...
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Task failed with an exception
                        // ...
                    }
                })
                .addOnCompleteListener(new OnCompleteListener<List<Barcode>>() {
                    @Override
                    public void onComplete(@NonNull Task<List<Barcode>> task) {
                        image.close();
                    }
                });

    }

    private void readerBarcodeData(List<Barcode> barcodes) {
        for (Barcode barcode: barcodes) {
            Rect bounds = barcode.getBoundingBox();
            Point[] corners = barcode.getCornerPoints();

            String rawValue = barcode.getRawValue();

            int valueType = barcode.getValueType();
            // See API reference for complete list of supported types
            switch (valueType) {
                case Barcode.TYPE_WIFI:
                    String ssid = barcode.getWifi().getSsid();
                    String password = barcode.getWifi().getPassword();
                    int type = barcode.getWifi().getEncryptionType();
                    break;
                case Barcode.TYPE_URL:
                    if(!bd.isAdded()){
                        bd.show(fragmentManager,"");
                    }
                    bd.fetchurl(barcode.getUrl().getUrl());
                    String title = barcode.getUrl().getTitle();
                    String url = barcode.getUrl().getUrl();
                    break;
            }
        }

    }
    }


}