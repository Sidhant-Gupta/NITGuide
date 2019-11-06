package com.example.nit_guide;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class profile extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST =234 ;
    private FirebaseAuth firebaseauth;
    TextView tv_hello;
    Button btn_logout,btn_chose,btn_upload,btn_home;
    ImageView iv_file;
    private Uri filepath;//uri are actually url which are meant for local storage
    //so it is actually a path to our files in local storage

    FirebaseStorage storage;//Used to upload files ed pdf
    FirebaseDatabase firebasedatabase;//used to store urls of uploaded files

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mStorageRef = FirebaseStorage.getInstance().getReference();
        storage=FirebaseStorage.getInstance();
        firebasedatabase=FirebaseDatabase.getInstance();


        firebaseauth=FirebaseAuth.getInstance();
        if(firebaseauth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(getApplicationContext(),login_activity.class));
        }

        FirebaseUser user=firebaseauth.getCurrentUser();
        String name=user.getDisplayName ();
//        Log.d("Iwanttoknow",user.getDisplayName());
//        System.out.print ("DisplayName"+user.getDisplayName());
        tv_hello=(TextView) findViewById(R.id.tv_hello);
        btn_logout=(Button) findViewById(R.id.btn_logout);
        btn_chose=(Button)findViewById(R.id.btn_chose);
        btn_upload=(Button)findViewById(R.id.btn_upload);
        iv_file=(ImageView) findViewById(R.id.iv_file);
        btn_home=(Button) findViewById(R.id.btn_home);


        tv_hello.setText("Welcome " +user.getEmail());

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hintent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(hintent);
            }
        });

        btn_chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                show_file_choser();
                if(ContextCompat.checkSelfPermission(profile.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    show_file_choser();
                }
                else{
                    ActivityCompat.requestPermissions(profile.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });

        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(filepath!=null)//successfully chosen a file
                    upload_file(filepath);
                else
                    Toast.makeText(profile.this,"First please select a file",Toast.LENGTH_SHORT).show();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseauth.signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),login_activity.class));
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==9 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            show_file_choser();
        }
        else{
            Toast.makeText(profile.this,"Please Provide permissions",Toast.LENGTH_SHORT);
        }
    }


    private void show_file_choser(){
        //offer user to select a file using file manager
        //to do this we need to use intent
        Intent file_choser=new Intent();
        file_choser.setType("application/pdf");
        file_choser.setAction(Intent.ACTION_GET_CONTENT);//to fetch files
//        startActivityForResult(Intent.createChooser(file_choser,"Select an Image"),PICK_IMAGE_REQUEST);//launch the intent
        startActivityForResult(file_choser,86);//after this line is executed onActivityResult method will be automatically invoked

    }

    //this method is invoked by android
    //to check weather user has successfully chosen a file
    //basically acknowledgement will be done in this method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //resultcode->operation fully performed or not ,be it not selecting file
        //data.getdata()->file chosen or not

        if(requestCode==86 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
                filepath=data.getData();//return uri of selected file
        }
        else{
            Toast.makeText(profile.this,"Please select a file",Toast.LENGTH_SHORT).show();
        }
    }

    private void upload_file(Uri filepath){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        final String filename=System.currentTimeMillis()+"";
        final StorageReference storageRef = storage.getReference();//returns root path where our files will be stored in firebase storage
        //we will not store our files in root element but in sub element
        //within this folder we will save our files

        storageRef.child("Uploads").child(filename).putFile(filepath)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        Task<Uri> uri=taskSnapshot.getStorage().getDownloadUrl();
                        while(!uri.isComplete());
                        Uri url=uri.getResult();
                        DatabaseReference reference=firebasedatabase.getReference();//return the path to root
                        reference.child(filename).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(profile.this,"File Uploaded",Toast.LENGTH_SHORT).show();
                                }
                                else
                                    Toast.makeText(profile.this,"File not successfully Uploaded",Toast.LENGTH_SHORT).show();
                            }
                        });
                        progressDialog.dismiss();

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(profile.this,"r",Toast.LENGTH_SHORT).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress=(100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded"+(int)progress+"%");
            }
        });

    }
}
