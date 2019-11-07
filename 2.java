package com.tri.mentalhelperen2;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

public class CallG extends AppCompatActivity  {
    public CallG(final Activity activityC, int REQUEST_CALL, String pNumC){
        if (ContextCompat.checkSelfPermission(activityC,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activityC,
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        } else {
            final String dial = "tel:" + pNumC;
            new AlertDialog.Builder(activityC)
                    .setMessage("Dial")mmmmm
                    .setPositiveButton("Dial44444", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            activityC.startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {}
                    })
                    .show();
        }
    }
}