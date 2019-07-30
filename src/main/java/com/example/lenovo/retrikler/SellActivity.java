package com.example.lenovo.retrikler;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SellActivity extends AppCompatActivity {

    private Spinner sp2;
    private EditText name;
    private EditText pno;
    private EditText add;
    private EditText des;
    private EditText pr;
    private Button br,brt,brc;
    private ImageView img;
    private FirebaseStorage firebaseStorage;
    private static int PICK_IMAGE=123;
    private static int REQUEST_CAMERA=12;
    Uri image;



        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (((requestCode == REQUEST_CAMERA)) && ((resultCode == RESULT_OK)) && data.getExtras() != null) {
                Bitmap tbitmap =(Bitmap)data.getExtras().get("data");
                img.setImageBitmap(tbitmap);
            }
            else if (((requestCode == PICK_IMAGE)) && ((resultCode == RESULT_OK)) && data.getData() != null){
            image = data.getData();
            img.setImageURI(image);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        sp2= findViewById(R.id.spinner2);
        name=findViewById(R.id.editText70);
        pno=findViewById(R.id.editText90);
        add=findViewById(R.id.editText100);
        des=findViewById(R.id.editText110);
        pr=findViewById(R.id.editText120);
        br=findViewById(R.id.button7);
        brt=findViewById(R.id.takepicture);
        brc=findViewById(R.id.choose);
        img=findViewById(R.id.imageView4);

        brc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent=new Intent();
             intent.setType("image/*");
             intent.setAction(Intent.ACTION_GET_CONTENT);
             startActivityForResult(Intent.createChooser(intent,"Select image"),PICK_IMAGE);
            }
        });

        brt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CAMERA);
            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data();
                startActivity(new Intent(SellActivity.this, DatabaseActivity.class));
            }
        });

        sp2= findViewById(R.id.spinner2);

        List<String> listt=new ArrayList<>();
        listt.add("Mobile");
        listt.add("Mobile Accessories");
        listt.add("Hard Disk");
        listt.add("Mouse");
        listt.add("Keybord");
        listt.add("Others");
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,listt);
        adapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);

        sp2.setAdapter(adapter1);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemvall=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SellActivity.this,"Selected:"+ itemvall,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void data(){
        String sname=name.getText().toString();
        String spno=pno.getText().toString();
        String sadd=add.getText().toString();
        String ssp=sp2.getSelectedItem().toString();
        String sdes=des.getText().toString();
        String spr=pr.getText().toString();

        FirebaseDatabase fbd= FirebaseDatabase.getInstance();
        DatabaseReference myRef= fbd.getReference("Seller");
        String id= myRef.push().getKey();
        firebaseStorage = FirebaseStorage.getInstance();
        StorageReference myref1=firebaseStorage.getReference("Seller").child(String.valueOf(UUID.randomUUID()));
        UploadTask uploadTask=myref1.putFile(image);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SellActivity.this,"Failed",Toast.LENGTH_SHORT).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(SellActivity.this,"Success",Toast.LENGTH_SHORT).show();

            }
        });

        datab databb=new datab(id,ssp,sname,spno,sadd,sdes,spr);
        myRef.child(id).setValue(databb);
        Toast.makeText(SellActivity.this,"Successful",Toast.LENGTH_SHORT).show();
    }
}

