package com.example.lenovo.retrikler;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class BuyActivity extends AppCompatActivity {
    private ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7;
    private FirebaseStorage firebaseStorage;
    Uri image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imageView1= findViewById(R.id.imageView);
        imageView2= findViewById(R.id.imageView2);
        imageView3= findViewById(R.id.imageView6);
        imageView4= findViewById(R.id.imageView8);
        imageView5= findViewById(R.id.imageView9);
        imageView6= findViewById(R.id.imageView10);
        imageView7= findViewById(R.id.imageView11);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage = FirebaseStorage.getInstance();
                StorageReference myref1=firebaseStorage.getReference("Buyer").child(String.valueOf(UUID.randomUUID()));
                startActivity(new Intent(BuyActivity.this, DatabaseActivity.class));
                imageView1.setImageURI(image);
                UploadTask uploadTask=myref1.putFile(image);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(BuyActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage = FirebaseStorage.getInstance();
                StorageReference myref1=firebaseStorage.getReference("Buyer").child(String.valueOf(UUID.randomUUID()));
                startActivity(new Intent(BuyActivity.this, DatabaseActivity.class));
                imageView2.setImageURI(image);
                UploadTask uploadTask=myref1.putFile(image);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(BuyActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage = FirebaseStorage.getInstance();
                StorageReference myref1=firebaseStorage.getReference("Buyer").child(String.valueOf(UUID.randomUUID()));
                startActivity(new Intent(BuyActivity.this, DatabaseActivity.class));
                imageView3.setImageURI(image);
                UploadTask uploadTask=myref1.putFile(image);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(BuyActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage = FirebaseStorage.getInstance();
                StorageReference myref1=firebaseStorage.getReference("Buyer").child(String.valueOf(UUID.randomUUID()));
                startActivity(new Intent(BuyActivity.this, DatabaseActivity.class));
                imageView4.setImageURI(image);
                UploadTask uploadTask=myref1.putFile(image);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(BuyActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage = FirebaseStorage.getInstance();
                StorageReference myref1=firebaseStorage.getReference("Buyer").child(String.valueOf(UUID.randomUUID()));
                startActivity(new Intent(BuyActivity.this, DatabaseActivity.class));
                imageView5.setImageURI(image);
                UploadTask uploadTask=myref1.putFile(image);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(BuyActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage = FirebaseStorage.getInstance();
                StorageReference myref1=firebaseStorage.getReference("Buyer").child(String.valueOf(UUID.randomUUID()));
                startActivity(new Intent(BuyActivity.this, DatabaseActivity.class));
                imageView6.setImageURI(image);
                UploadTask uploadTask=myref1.putFile(image);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(BuyActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseStorage = FirebaseStorage.getInstance();
                StorageReference myref1=firebaseStorage.getReference("Buyer").child(String.valueOf(UUID.randomUUID()));
                startActivity(new Intent(BuyActivity.this, DatabaseActivity.class));
                imageView7.setImageURI(image);
                UploadTask uploadTask=myref1.putFile(image);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this,"Failed",Toast.LENGTH_SHORT).show();

                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(BuyActivity.this,"Success",Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}
