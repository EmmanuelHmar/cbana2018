package vanmang.com.Control_Page;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;

import vanmang.com.Control_Page.Tabs.ActivityContact;
import vanmang.com.Control_Page.Tabs.ActivityLeaderships;
import vanmang.com.Control_Page.Tabs.ActivityLocations;
import vanmang.com.Control_Page.Tabs.ActivitySchedule;
import vanmang.com.Control_Page.Tabs.MainActivity;

public class BottomNavigationIntents {
    private Context context;
    private BottomNavigationView bottomNavigationView;
    private String className;
    private int itemNumber;
    private static final String TAG = "BottomNavigationIntents";


    public BottomNavigationIntents(Context context, BottomNavigationView bottomNavigationView, int itemNumber) {
        this.context = context;
        this.bottomNavigationView = bottomNavigationView;
        className = context.getClass().getSimpleName();
        this.itemNumber = itemNumber;

        runIntents();
    }

    private void runIntents() {
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(itemNumber);
        menuItem.setChecked(true);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        if (className.equalsIgnoreCase("MainActivity")) {
                            break;
                        }
                        intent = new Intent(context, MainActivity.class);
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY); //This always go back to main menu
//                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //This has 1 activity instance each
//                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //Always backto home
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    case R.id.ic_schedule:
                        if (className.equalsIgnoreCase("ActivitySchedule")) {
                            break;
                        }
                        intent = new Intent(context, ActivitySchedule.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    case R.id.ic_leaderships:
                        if (className.equalsIgnoreCase("ActivityLeaderships")) {
                            break;
                        }
                        intent = new Intent(context, ActivityLeaderships.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    case R.id.ic_locations:
                        if (className.equalsIgnoreCase("ActivityLocations")) {
                            break;
                        }
                        intent = new Intent(context, ActivityLocations.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;

                    case R.id.ic_contacts:
                        if (className.equalsIgnoreCase("ActivityContact")) {
                            break;
                        }
                        intent = new Intent(context, ActivityContact.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;
                }


                return false;
            }
        });
    }

}
