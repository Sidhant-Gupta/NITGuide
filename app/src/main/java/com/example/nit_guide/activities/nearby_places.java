package com.example.nit_guide.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nit_guide.R;

import org.w3c.dom.Text;

public class nearby_places extends AppCompatActivity {

    ListView lview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_nearby_places);


        String[] places = new String[]{"Restaurants", "Khokha", "Travelling List", "Fun Spots"};
        setupUIView();
        SimpleAdapter simpleAdapter = new SimpleAdapter (this, places);
        lview.setAdapter (simpleAdapter);
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
            spots = (TextView)findViewById (R.id.tv_heading);
            spods = (TextView)findViewById (R.id.tv_subheading);

            img = (ImageView)findViewById (R.id.img_contact);

            spots.setText (placesnearby[i]);
            spods.setText (placesnearby[i]);
            img.setImageResource (R.drawable.places_bg);

//            "Restaurants", "Khokha", "Travelling List", "Fun Spots"};
//            if(placesnearby[i].equalsIgnoreCase ("Restaurants")){
//                img.setImageResource (R.drawable.places_bg);
//            }
//            else if(placesnearby[i].equalsIgnoreCase ("Khokha")){
//                img.setImageResource (R.drawable.places_bg);
//            }
//            else if(placesnearby[i].equalsIgnoreCase ("Fun Spots")){
//                img.setImageResource (R.drawable.places_bg);
//            }
//            else if(placesnearby[i].equalsIgnoreCase ("Travelling List")){
//                img.setImageResource (R.drawable.places_bg);
//            }

            return view;
        }
    }

}
