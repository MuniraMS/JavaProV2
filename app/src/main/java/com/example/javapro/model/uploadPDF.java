package com.example.javapro.model;

import com.google.firebase.database.FirebaseDatabase;
import com.example.javapro.R;


public class uploadPDF {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    public void  storejavaone() {

        PDFs j1L1 = new PDFs("1. Introduction", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FIntroduction.pdf?alt=media&token=8e5158b1-2c4b-4378-ba21-daeb4aa59a42",R.drawable.bookmark);
        PDFs j1L2 = new PDFs("2. Java basics (I)", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FJavaBasics%20(I).pdf?alt=media&token=22d55251-a609-4f8b-919a-2f776490fdbd",R.drawable.bookmark);
        PDFs j1L3 = new PDFs("3. Java basics (II)", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FLec_3%20-JavaBasics%20(II)%20_Dr.%20Faten-%D9%85%D8%AD%D9%88%D9%84.pdf?alt=media&token=d2d1c87b-efee-478b-abae-81956f22a5f9",R.drawable.bookmark);
        PDFs j1L4 = new PDFs("4. Conditions", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FLec_4%20-%20Conditions(1).pdf?alt=media&token=9208d578-a828-454c-8e28-6847a563febf",R.drawable.bookmark);
        PDFs j1L5 = new PDFs("5. Loops", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FLec_5%266%20-%20Loops-converted.pdf?alt=media&token=b920a2b2-ed82-487e-a250-ad9695d59323",R.drawable.bookmark);
        PDFs j1L6 = new PDFs("6. Methods", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FLec%237%268%20-%20Methods-converted.pdf?alt=media&token=a4998088-cf72-4830-becf-58beabb69246",R.drawable.bookmark);
        PDFs j1L7 = new PDFs("7. Arrays", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FLec%239%2610%20-%20Arrays-converted.pdf?alt=media&token=e71c40ed-03ba-4c1c-a5a0-a1586245661c",R.drawable.bookmark);
        PDFs j1L8 = new PDFs("8. Objects & Classes", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone%2FLec%2311%20-%20Objects%20%26%20classes-converted.pdf?alt=media&token=f595897c-5be4-4587-bf1b-7b3f768e584f",R.drawable.bookmark);

        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L1);
        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L2);
        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L3);
        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L4);
        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L5);
        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L6);
        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L7);
        firebaseDatabase.getReference("javaoneslide").push().setValue(j1L8);
    }
    public void  storejavatwo() {

        PDFs j1L1 = new PDFs("1. Object & classes ", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec%232%20-%20Objects%20_%20classes.pdf?alt=media&token=bda3e055-a576-496f-a671-60334d1896b6",R.drawable.bookmark);
        PDFs j1L2 = new PDFs("2. More in object & classes", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec%233%20-%20More%20on%20classes.pdf?alt=media&token=ea40b319-8421-4064-b0d7-2b378502b40e",R.drawable.bookmark);
        PDFs j1L3 = new PDFs("3. Composition", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec%234%20-%20Composition.pdf?alt=media&token=90330677-3058-4a61-8f38-767604a60abe",R.drawable.bookmark);
        PDFs j1L4 = new PDFs("4. Inheritence", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2Flec05-inheritance.pdf?alt=media&token=93cf7f5e-ae71-4ef0-9691-86d35c0617e9",R.drawable.bookmark);
        PDFs j1L5 = new PDFs("5. Array & Arraylists", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec6%20-%20Arrays%20and%20ArrayList(1).pdf?alt=media&token=40521098-c8b8-49c4-a323-1b11ec095141",R.drawable.bookmark);
        PDFs j1L6 = new PDFs("6. Polymorphism", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec7%20-%20Polymorphism.pdf?alt=media&token=2bd5f91d-4c62-4524-891e-25dce93f2204",R.drawable.bookmark);
        PDFs j1L7 = new PDFs("7. Interfaces", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec8-%20Interfaces(1).pdf?alt=media&token=0fd1ebb0-6791-4eb3-99b4-35ae61ec4ebe",R.drawable.bookmark);
        PDFs j1L8 = new PDFs("8. Exception Handling", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec9-%20Exception%20Handling.pdf?alt=media&token=c3e627fc-c2dd-4296-8d0b-e02a6288e600",R.drawable.bookmark);
        PDFs j1L9 = new PDFs("9. Files and Streams", "https://firebasestorage.googleapis.com/v0/b/javapro-b2cd6.appspot.com/o/javaone2%2FLec10%20-%20Introduction%20to%20Streams.pdf?alt=media&token=bb52421e-e789-4801-a17e-ccf045c4953b",R.drawable.bookmark);

        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L1);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L2);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L3);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L4);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L5);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L6);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L7);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L8);
        firebaseDatabase.getReference("javatwoslide").push().setValue(j1L9);

    }
}
