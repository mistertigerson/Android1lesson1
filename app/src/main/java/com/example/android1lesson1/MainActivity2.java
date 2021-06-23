package com.example.android1lesson1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import com.example.android1lesson1.R;
import com.example.android1lesson1.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    private ImageView camera_iv;
    private ImageView contact_iv;
    private ImageView google_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        camera_iv = findViewById(R.id.camera_btn);
        contact_iv = findViewById(R.id.contact_btn);
        google_iv = findViewById(R.id.google_btn);

        binding.buttonCome.setOnClickListener(v -> {
            Intent intent5 = new Intent(this, MainActivity3.class);
            startActivityForResult(intent5, 1);
        });
    }


    public void onClick_iv(View view) {
        switch (view.getId()) {
            case R.id.camera_btn:
            /*   Intent intent = new Intent(Intent.CATEGORY_APP_GALLERY);
                startActivity(intent); */
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
                break;


            case R.id.contact_btn:
                Intent intentContact = new Intent(
                        Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI
                );
                startActivity(intentContact);
                break;

            case R.id.google_btn:
                String urlString = "https://www.google.com/";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                startActivity(intent3);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK)
            binding.textView.setText(data.getStringExtra("key"));

    }
}
