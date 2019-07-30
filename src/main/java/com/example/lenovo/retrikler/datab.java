package com.example.lenovo.retrikler;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

public class datab {
    public String id;
    public String sp;
    public String name;
    public String pno;
    public String add;
    public String des;
    public String pr;

    public datab(String id,String sp, String name, String pno, String add, String des, String pr) {
        this.id = id;
        this.sp = sp;
        this.name = name;
        this.pno = pno;
        this.add = add;
        this.des = des;
        this.pr = pr;
    }
}
