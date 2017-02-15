package com.numetriclabz.androidsearch;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.ContentValues.TAG;
import static com.numetriclabz.androidsearch.MainActivity.ITEMS;
import static com.numetriclabz.androidsearch.R.styleable.View;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public SearchView search;
    private List<String> list = new ArrayList<String>();
    private static List<String> listFixes = new ArrayList<String>();
    Adapter mAdapter;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        createlist();  // in this method, Create a list of items.
        createlistFixes();
        mRecyclerView.setLayoutManager(new LinearLayoutManager (this));

        // call the adapter with argument list of items and context.
        mAdapter = new Adapter(list,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        MenuInflater inflater2 = getMenuInflater();
        inflater.inflate(R.menu.action, menu);

        final MenuItem searchItem = menu.findItem(R.id.search);
        final SearchView searchView = new SearchView(this);
        MenuItemCompat.setShowAsAction(searchItem, MenuItemCompat.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItemCompat.SHOW_AS_ACTION_IF_ROOM);
        MenuItemCompat.setActionView(searchItem, searchView);

        final MenuItem actionMenu = menu.findItem(R.id.actionMenu);

        searchView.setOnQueryTextListener(listener); // call the QuerytextListner.
        searchView.setOnClickListener(new View.OnClickListener() { // whole field clickable
            @Override
            public void onClick(View v) {
                searchView.setIconified(false);
                searchView.setQueryHint("type to search");
            }
        });
        return true;
    }

    // this method is used to create list of items.
    public void createlist(){
        for (int i = 0; i < ITEMS.size(); i++) {
            list.add(ITEMS.get(i).content);
        }

    }

    public void createlistFixes(){
        for (int i = 0; i < ITEMS.size(); i++) {
            listFixes.add(ITEMS.get(i).details);
        }

    }

    public static String getListFixes(int i){
        return listFixes.get(i);
    }

    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static int j = 0;static int k =0;
    static String failures[] = {

            "Steam coming from under the hood",
            "Headlights not working",
            "Abs light on dashboard is on",
            "Keys sign on dashboard blinks",
            "Flat or faulty battery",
            "HT (high-tension) leads",
            "Spark plugs",
            "Clutch cables",
            "Fuel problems",
            "Starter motor",
            "Alternator faults",
            "Taillights not working",
            "Steering",
            "Overheating",
            "Flat tire/blowout",
            "No start",
            "Engine turning over but not starting",
            "Dead on key",
            "Loss of power",
            "Engine management light on",
            "Overheating",
            "Flat tyre, spare - no jack",
            "Electric car windows issue"

    };

    static String fixes[] = {

            "Steam coming from under the hood: \n \n" +
                    "Causes: Coolant leakage. \n \nHow to fix?\nStop the car, wait 10 minutes until coolant in radiator gets cooler. " +
                    "Buy the coolant in shop if you dont have it. Refill the radiator. If you cannot stop the car - turn the blower up to cool the engine and drive to the nearest mechanic",

            "Headlights not working: \n \n"+
                    "Bla, bla broken headlights pal!",

            "Abs light on dashboard is on: \n \n"+
                    "Check the emergency break:\n" +
                    "Sometimes the emergency brake will not go down far enough and keep the light on, even though the brakes are actually not applied.\n" +
                    "The emergency brake does not run on the same system as the main brake line, but if the E-brake is in working condition, it can still be applied in a situation where the main lines fail. It can also be applied as a preventative measure in areas with steep driving terrain. However, this light can get stuck on if the handle is notshut off properly.\n" +
                    "Check your E-brake to be sure that it is in the proper down position. Adjust a few times and see if the light goes off.\n" +
                    "Sometimes the emergency brake will not go down far enough and keep the light on, even though the brakes are actually not applied.\n" +
                    "The emergency brake does not run on the same system as the main brake line, but if the E-brake is in working condition, it can still be applied in a situation where the main lines fail. It can also be applied as a preventative measure in areas with steep driving terrain. However, this light can get stuck on if the handle is notshut off properly.\n" +
                    "Check your E-brake to be sure that it is in the proper down position. Adjust a few times and see if the light goes off.\n" +
                    "\n"+
            "Losing Hydraulic Pressure \n\n" +
            "Check Your Hydraulic Circuits",

            "Keys sign on dashboard blinks: \n \n"+
                    "Bla, bla broken headlights pal!",

            "Flat or faulty battery: \n \n"+
                    "If you’ve got a problem with your battery, there’s a good chance it’ll be down to lots of short journeys or a poor electrical connection. Battery faults are the most common cause of breakdown – especially in the winter.\n" +
                    "When your car is serviced, the garage should check that connections are secure and that the battery terminals are clean and protected from corrosion. Read more about how our patrols test batteries and get you going again. \n" +
                    "If you don’t make long journeys very often, your battery won’t have had much chance to charge. You can sort this out by charging it overnight, every 2 weeks or so. That way, you’ll be able to keep it running longer. ",

            "HT (high-tension) leads: \n \n"+
                    "HT leads, which carry high voltage to the spark plugs, deteriorate with age which can make it difficult to start your car. Damp-repellant sprays like WD-40 can help, but it's best to ask a garage to check over the ignition system if you're having starting problems. Regular servicing should help avoid problems in the first place.",

            "Spark plugs: \n \n"+
                    "Spark plugs can break or wear out but shouldn't be a problem as long as your car is serviced regularly.",

            "Clutch cables: \n \n"+
                    "The clutch cable is under a lot of stress. And if it breaks, it can be a serious problem. It’s best to get it checked if you notice any change to the way the clutch feels when you press the pedal. If your clutch cable does break, pull over in the nearest safe spot and call us on 0800 88 77 66. Our patrols can usually make temporary repairs at the roadside, to get you home or get you to the nearest garage.",

            "Fuel problems: \n \n"+
                    "Put the wrong fuel in your engine? It does happen to more than 150,000 drivers every year, but don’t start your engine. Give us a call on 0800 072 7420 and our dedicated Fuel Assist technicians can drain and flush the fuel out of your system. They’ll have you back up and running in no time at all.",

            "Starter motor: \n \n"+
                    "Although starter motors are usually tough and robust, they do fail eventually. But as long as you get your car serviced regularly, any potential faults should get picked up before they cause you any problems.",

            "Keys sign on dashboard blinks: \n \n"+
                    "Bla, bla broken headlights pal!",

            "Keys sign on dashboard blinks: \n \n"+
                    "Bla, bla broken headlights pal!",

            "Keys sign on dashboard blinks: \n \n"+
                    "Bla, bla broken headlights pal!",

            "Keys sign on dashboard blinks: \n \n"+
                    "Some of the most common reasons cars and trucks overheat are a faulty cooling system or low fluid level. During hotter months, your vehicle's cooling system has to work harder to prevent engine overheating. Check your car's fluids, such as engine coolant, brake fluid, automatic transmission fluid, washer fluid and engine oil regularly. " +
                    "Don't wait until your dashboard warning light comes on or you find yourself pulled to the side of the road with a steaming hood. If you do wind up in this situation, turn off your air conditioning and turn on your heater. Although it's hot, it can help remove heat from the engine and use the additional fans to cool things down until you can get to safety.",

            "Keys sign on dashboard blinks: \n \n"+
                    "One of the most common culprits of road-trip delays are flat tires, which can be caused by wear and tear\n" +
                    "or overinflation in summer months caused by increased air pressure from the heat. While some newer vehicles have tire-pressure monitoring systems, most cars' computers will not detect this problem. A simple tire gauge will tell you if you need to add or let out air in your tires. Most service stations have a gauge on the air pump. " +
                    "Refer to your owner's manual or the label inside the driver's door for proper tire inflation levels.",

            "Keys sign on dashboard blinks: \n \n"+
                    "Car batteries rarely signal failure ahead of time and often occur at the most inopportune time, such as during a getaway. Hot summer months are the worst conditions for your battery. Make sure your vehicle has all of the plastic pieces that surround the battery. These pieces are engineered to keep your battery cool and divert fresh air across the battery to extend its life." +
                    "The battery is used mainly for starting the vehicle. If it is taking a long time to start, check the battery. You can do this with a simple battery tester that plugs into your vehicle's 12-volt receptacle. A failed battery will cause the alternator/generator to work harder to charge it, and can lead to alternator failure if not cared for quickly. " +
                    "Take care of battery problems while it's just the battery. Another good preventive measure is to replace your battery every three years or as recommended by your manual.",

            "Keys sign on dashboard blinks: \n \n"+
                    "Bla, bla broken headlights pal!",

            "Keys sign on dashboard blinks: \n \n"+
                    "Bla, bla broken headlights pal!",
            "",
            "",
            "",
            "",
            ""

    };

    static {
        int fSize = failures.length;
        for (int i = 1; i <= fSize; i++) {
            addItem(new DummyItem(Integer.toString(i), failures[j], fixes[k]));
            j++;
            k++;
        }
    }


    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    static
    {
        Collections.sort(ITEMS, new Comparator<DummyItem>() {
            @Override
            public int compare(DummyItem item2, DummyItem item1)
            {
                return  item2.content.compareToIgnoreCase(item1.content);
            }
        });
    }


    SearchView.OnQueryTextListener listener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextChange(String query) {

            query = query.toLowerCase();

            final List<String> filteredList = new ArrayList<>();

            for (int i = 0; i < ITEMS.size(); i++) {

                final String text = ITEMS.get(i).content.toLowerCase();
                if (text.contains(query)) {

                    filteredList.add(ITEMS.get(i).content.toLowerCase());
                }
            }

            mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            mAdapter = new Adapter(filteredList, MainActivity.this);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();  // data set changed
            return true;

        }
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    };


    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }


}



