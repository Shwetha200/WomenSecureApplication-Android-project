package com.example.women2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView iconContact;
    private Button btnCallPolice;
    private Button btnCallAmbulance;
    private ImageView womenLawsImageView;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconContact = findViewById(R.id.iconContact);
        btnCallPolice = findViewById(R.id.btnCallPolice);
        btnCallAmbulance = findViewById(R.id.btnCallAmbulance);
        womenLawsImageView = findViewById(R.id.womenLawsImageView);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // Set a click listener for the contact icon to show police and ambulance buttons
        iconContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePoliceAndAmbulanceButtons();
            }

            private void togglePoliceAndAmbulanceButtons() {
                int policeVisibility = (btnCallPolice.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;int ambulanceVisibility = (btnCallAmbulance.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;

                btnCallPolice.setVisibility(policeVisibility);
                btnCallAmbulance.setVisibility(ambulanceVisibility);
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
            }
        });

        // Set a click listener for the police button to call the police emergency number
        btnCallPolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callEmergencyNumber("tel:100"); // Replace with the appropriate number
            }
        });

        // Set a click listener for the ambulance button to call the ambulance emergency number
        btnCallAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callEmergencyNumber("tel:108"); // Replace with the appropriate number
            }
        });

        // Set a click listener for the womenLawsImageView
        womenLawsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // You can add logic here for the behavior you want when clicking on womenLawsImageView
                // For example, toggle visibility of button1 and button2.
                toggleButtonsVisibility();
            }
        });
        // Set a click listener for Button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the CustomPageActivity
                Intent intent = new Intent(MainActivity.this, CustomPageActivity.class);
                startActivity(intent);
            }
        });
        // Set a click listener for Button2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the CustomPageActivity2
                Intent intent = new Intent(MainActivity.this, CustomePageActivity2.class);
                startActivity(intent);
            }
        });


    }

    private void showPoliceAndAmbulanceButtons() {
        btnCallPolice.setVisibility(View.VISIBLE);
        btnCallAmbulance.setVisibility(View.VISIBLE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
    }

    private void toggleButtonsVisibility() {
        int visibility1 = (button1.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;
        int visibility2 = (button2.getVisibility() == View.VISIBLE) ? View.GONE : View.VISIBLE;

        button1.setVisibility(visibility1);
        button2.setVisibility(visibility2);

        btnCallPolice.setVisibility(View.GONE);
        btnCallAmbulance.setVisibility(View.GONE);
    }

    private void callEmergencyNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
        startActivity(intent);
    }
}
