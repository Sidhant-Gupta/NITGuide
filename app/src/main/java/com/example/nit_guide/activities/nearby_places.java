package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nit_guide.R;
import com.example.nit_guide.fun_spots;

import org.w3c.dom.Text;

public class nearby_places extends AppCompatActivity {

    ListView lview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_nearby_places);


        String[] places = new String[]{"Restaurants and Cafes", "Dhaba", "Travelling List", "Fun Spots"};
        setupUIView();
        SimpleAdapter simpleAdapter = new SimpleAdapter (this, places);
        lview.setAdapter (simpleAdapter);
        lview.setOnItemClickListener (new AdapterView.OnItemClickListener ( ) {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selected_item = (String)adapterView.getItemAtPosition (i);
//                System.out.println(selected_item);
                if(selected_item.equalsIgnoreCase ("Restaurants and Cafes")){
                    Intent startIntent=new Intent(getApplicationContext (), Restaurants.class);
                    startActivity(startIntent);
                }
                else if(selected_item.equalsIgnoreCase ("Dhaba")){
                    Intent startIntent=new Intent(getApplicationContext (), khokha.class);
                    startActivity(startIntent);
                }
                else if(selected_item.equalsIgnoreCase ("Travelling List")){
                    Intent startIntent=new Intent(getApplicationContext (), travelling_places.class);
                    startActivity(startIntent);
                }
                else if(selected_item.equalsIgnoreCase ("Fun Spots")){
                    Intent startIntent=new Intent(getApplicationContext (), fun_spots.class);
                    startActivity(startIntent);
                }
            }
        });
    }

    private void setupUIView() {
        lview = (ListView)findViewById (R.id.lview);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater li = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);;
        private TextView spots,spods;
        private ImageView img;
        private String[] placesnearby;


        public SimpleAdapter(Context context,String[] places){
            mContext = context;
            placesnearby = places;
        }


        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object getItem(int i) {
            return placesnearby[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){
                view = li.inflate (R.layout.single_row_contact,null,true);
            }
            spots = (TextView)view.findViewById (R.id.tv_heading);
            spods = (TextView)view.findViewById (R.id.tv_subheading);

            img = (ImageView)view.findViewById (R.id.img_contact);

            spots.setText (placesnearby[i]);

//            img.setImageResource (R.drawable.places_bg);

//            "Restaurants", "Khokha", "Travelling List", "Fun Spots"};
            if(placesnearby[i].equalsIgnoreCase ("Restaurants and Cafes")){
                spods.setText ("Because we need a break from mess!");
                img.setImageResource (R.drawable.restaurant);
            }
            else if(placesnearby[i].equalsIgnoreCase ("Dhaba")){
                spods.setText ("Let's agree we can't afford richness 24*7!");
                img.setImageResource (R.drawable.khokha);
            }
            else if(placesnearby[i].equalsIgnoreCase ("Fun Spots")){
                spods.setText ("Because we need some city air");
                img.setImageResource (R.drawable.places_bg);
            }
            else if(placesnearby[i].equalsIgnoreCase ("Travelling List")){
                spods.setText ("Because we have a bucket list ;)");
                img.setImageResource (R.drawable.places);
            }

            return view;
        }
    }

}
