package vanmang.com.Control_Page.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import vanmang.com.Control_Page.BottomNavigationIntents;
import vanmang.com.Control_Page.Contacts.ContactsACBC;
import vanmang.com.Control_Page.Contacts.ContactsCatering;
import vanmang.com.Control_Page.Contacts.ContactsCommunication;
import vanmang.com.Control_Page.Contacts.ContactsHotels;
import vanmang.com.Control_Page.Contacts.ContactsHospitality;
import vanmang.com.Control_Page.Contacts.ContactsTransportation;
import vanmang.com.Control_Page.R;
import vanmang.com.Control_Page.RecyclerOptionsAdapter;
import vanmang.com.Control_Page.RecyclerTouchListener;


public class ActivityContact extends AppCompatActivity {

    //declaration of Items for the listView
    private String items[] = new String[]{"ACBC Media", "Catering", "Communication", "Hotels", "Hospitality", "Transportation"};

    private static final String TAG = "ActivityContact";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations_contacts);

        RecyclerView recyclerView = findViewById(R.id.contacts);

        RecyclerOptionsAdapter recyclerOptionsAdapter = new RecyclerOptionsAdapter(this, items);

        recyclerView.setAdapter(recyclerOptionsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d(TAG, "onCreate: " + this.getLocalClassName());

//        Use this instead of the previous listView listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent myIntent;
                switch (position) {
                    case 0:
                        myIntent = new Intent(ActivityContact.this, ContactsACBC.class);
                        startActivityForResult(myIntent, 0);
                        break;
                    case 1:
                        myIntent = new Intent(view.getContext(), ContactsCatering.class);
                        startActivityForResult(myIntent, 1);
                        break;
                    case 2:
                        myIntent = new Intent(view.getContext(), ContactsCommunication.class);
                        startActivityForResult(myIntent, 2);
                        break;

                    case 3:
                        myIntent = new Intent(view.getContext(), ContactsHotels.class);
                        startActivityForResult(myIntent, 3);
                        break;
                    case 4:
                        myIntent = new Intent(view.getContext(), ContactsHospitality.class);
                        startActivityForResult(myIntent, 4);
                        break;
                    case 5:
                        myIntent = new Intent(view.getContext(), ContactsTransportation.class);
                        startActivityForResult(myIntent, 5);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

//        To add the divider lines in between the items
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav_Bar);

        new BottomNavigationIntents(this, bottomNavigationView, 4);

    }

}
