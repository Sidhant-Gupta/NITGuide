package com.example.nit_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class alertdialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        Intent intent = getIntent ( );
        String value = intent.getStringExtra ("name");
        setContentView (R.layout.activity_alertdialog);
        TextView tv = (TextView) findViewById (R.id.alertdialog);


        if (value.equals ("Library")) {
            tv.setText ("Library"+'\n'+"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place."+"\n"+"ADDRESS: Infront of the Juice Corner.");
        }
        else if(value.equals ("CCN")){
            tv.setText ("CCN"+'\n'+"The Centre of Computer networking.It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\"+\"\\n\"+\"ADDRESS: Infront of the Juice Corner." );
        }
        else if(value.equals ("Juice Corner")){
            tv.setText ("Library"+'\n'+"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\"+\"\\n\"+\"ADDRESS: Infront of the Juice Corner." );
        }
        else if(value.equals ("NIT Market")){
            tv.setText ("Library\"+'\\n'+\"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\\\"+\\\"\\\\n\\\"+\\\"ADDRESS: Infront of the Juice Corner." );
        }
        else if(value.equals ("Senate Hall")){
            tv.setText ("Library\"+'\\n'+\"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\\\"+\\\"\\\\n\\\"+\\\"ADDRESS: Infront of the Juice Corner." );
        }
        else if(value.equals ("Administrative Block")){
            tv.setText ("Library\"+'\\n'+\"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\\\"+\\\"\\\\n\\\"+\\\"ADDRESS: Infront of the Juice Corner." );
        }
        else if(value.equals ("Moxie's Grill Canteen")){
            tv.setText ("Library\"+'\\n'+\"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\\\"+\\\"\\\\n\\\"+\\\"ADDRESS: Infront of the Juice Corner." );
        }
        else if(value.equals ("Amul Canteen")){
            tv.setText ("Library\"+'\\n'+\"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\\\"+\\\"\\\\n\\\"+\\\"ADDRESS: Infront of the Juice Corner." );
        }
        else if(value.equals ("Jubilee Hall")){
            tv.setText ("Library\"+'\\n'+\"It is a good place to study. If you need a serene and quiet place to get your grey cells working, this is the right place.\\\"+\\\"\\\\n\\\"+\\\"ADDRESS: Infront of the Juice Corner." );
        }
    }
}
