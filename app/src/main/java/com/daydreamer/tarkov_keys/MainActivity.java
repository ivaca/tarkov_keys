package com.daydreamer.tarkov_keys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
private EditText search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* final BottomNavigationView navigationView = findViewById(R.id.nav_menu);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.toString())
                {
                    case "Search":

                        break;

                    case "Maps":
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        overridePendingTransition(R.anim.side_from_right, R.anim.side_to_left);
                        break;
                }
                return false;
            }
        });
*/


        final ArrayList<Item> exampleList = new ArrayList<>();
        search= (EditText) findViewById(R.id.searchEdit);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (search.getText().length()>=2)
                {
                    for (int i=0; i< exampleList.size();i++)
                    {


                        if (exampleList.get(i).name.toLowerCase().contains(search.getText().toString().toLowerCase()))
                        {
                           // LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                           // recyclerView.setLayoutManager(layoutManager);
                           // layoutManager.scrollToPositionWithOffset(i,10);
                            recyclerView.smoothScrollToPosition(i);

                        }
                    }
                }
                else if (search.getText().length()==0)
                {
                    recyclerView.smoothScrollToPosition(0);
                }


                //recyclerView.smoothScrollToPosition(position);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        exampleList.add(new Item("5c1d0efb86f7744baf2e7b7b","Lab. Red keycard","Pockets and bags of Scavs, On Killa, On Glukhar, Possible in Wallets and Documents cases" ,"Multiple Ammunition spawns\n" +
                "Multiple Weapon mods spawns\n" +
                "Multiple MP5 and modded M4A1 spawns on the rack, \n" +
                "as well as a M4A1 SOPMOD II spawn on the table\n" +
                "Possible Antique teapot or Antique vase on the ground behind the desk\n" +
                "Possible Folder with intelligence on the desk\n" +
                "Lab. key. Arsenal storage room lock location",R.drawable.key_redkeycard,  new int[] {R.drawable.key_redkeycard_spawn_1,R.drawable.key_redkeycard_spawn_2,R.drawable.key_redkeycard_spawn_3,R.drawable.key_redkeycard_spawn_4,
                R.drawable.key_redkeycard_spawn_5},new int[] {R.drawable.key_redkeycard_open_1}));

        exampleList.add(new Item( "5c1d0c5f86f7744bb2683cf0", "Lab. Blue keycard", "On Shturman's body, On Glukhar's body, Pockets and bags of Scavs", "Loose Medical loot\n" +
                "Two Medcase\n" +
                "Possible LEDX Skin Transilluminator spawn on shelves", R.drawable.key_bluekeycard,new int[] {R.drawable.key_bluekeycard_spawn_1,R.drawable.key_bluekeycard_spawn_2,R.drawable.key_bluekeycard_spawn_3},
                new int[] {R.drawable.key_bluekeycard_open_1,R.drawable.key_bluekeycard_open_2}));

        exampleList.add(new Item("5c1e495a86f7743109743dfb", "Lab. Violet keycard", "Pockets and bags of Scavs, In spawned containers like MBSS, Documents case, Empty Wallet, ect. (Marked Circle for example)", "Possible Military COFDM wireless Signal Transmitter and VPX Flash Storage Module on the server rack\n" +
                "Weapon mods on the shelves in the corners\n" +
                "2x Weapon box (5x5)\n" +
                "1x Weapon box (4x4)\n" +
                "Money on the Desk\n" +
                "Possible MP5SD on the server rack\n" +
                "Possible modded M4A1 on the ground next to the server rack\n" +
                "Multiple rare item spawns on the shelf next to the door",
                R.drawable.key_violetkeycard,
                new int[] {R.drawable.key_violetkeycard_spawn_1,R.drawable.key_violetkeycard_spawn_2,R.drawable.key_violetkeycard_spawn_3},
                new int[] {R.drawable.key_violetkeycard_open_1,R.drawable.key_violetkeycard_open_2}));


        exampleList.add(new Item("5c1d0dc586f7744baf2e7b79", "Lab. Green keycard", "Pockets and bags of Scavs, On Killa", "One Medcase\n" +
                "Loose Medical Loot\n" +
                "Black keycard spawn location\n" +
                "Possible LEDX Skin Transilluminator in the metal container\n" +
                "Possible Folder with intelligence spawn near the laptop\n" +
                "Possible Folder with intelligence spawn on the shelf next to the door to the side room\n" +
                "One Weapon box (4x4)\n" +
                "Loose Weapon Mods and Ammo on the shelf\n" +
                "A possible MP5 spawn on the front desk",
                R.drawable.key_greenkeycard,new int[] {R.drawable.key_greenkeycard_spawn_1,R.drawable.key_greenkeycard_spawn_2,R.drawable.key_greenkeycard_spawn_3 },
                new int[] {R.drawable.key_greenkeycard_open_1}));

        exampleList.add(new Item("5ad5d7d286f77450166e0a89", "Key to KIBA store outlet", "In Jackets," +
                " Pockets and bags of Scavs",
                "KIBA Outlet grate door key is REQURIED\n" +" One Weapon box (4x4)\n" +
                        "One Weapon box (5x5)\n" +
                        "Two Cash registers\n" +
                        "Possible weapon spawns\n" +
                        "One possible MF-UNTAR armor vest\n" +
                        "One possible IOTV Gen4 armor (high mobility kit)\n" +
                        "One possible SSSh-95 Sfera-S (Sphere-S)\n" +
                        "One possible DVL-10 in standing weapon locker.\n" +
                        "Multiple possible F-1 and M67 grenades on top of the wooden crate, and inside the broken crate beside it.\n" +
                        "Two loose Currency stacks\n" +
                        "A very large amount of loose Weapon mods and Ammunition.",
                R.drawable.key_kibastore,new int[] {R.drawable.key_kibastore_spawn_1,R.drawable.key_kibastore_spawn_2},
                new int[] {R.drawable.key_kibastore_open_1, R.drawable.key_kibastore_open_2}));

        exampleList.add(new Item("5e42c71586f7747f245e1343", "ULTRA medical storage key", "In Jackets, Pockets and bags of Scavs",
                "Loose medical loot.\n" +
                        "Portable defibrillator\n" +
                        "LEDX Skin Transilluminator\n" +
                        "Ophthalmoscope\n" +
                        "Stimulators",
                R.drawable.key_ultramedical,new int[] {},
                new int[] {R.drawable.key_ultramedical_open_1, R.drawable.key_ultramedical_open_2}));


        exampleList.add(new Item("5c1d0f4986f7744bb01837fa", "Lab. Black keycard", "Customs: Possible in Wallets and Documents cases found in the Marked room, Reserve: On Glukhar.",
                "One Medcase\n" +
                        "A lot of Stimulators",
                R.drawable.key_blackkeycard,new int[] {R.drawable.key_blackkeycard_spawn_1, R.drawable.key_blackkeycard_spawn_2},
                new int[] {R.drawable.key_blackkeycard_open_1, R.drawable.key_blackkeycard_open_2,R.drawable.key_blackkeycard_open_3}));


        exampleList.add(new Item("5e42c81886f7742a01529f57", "Object 11SR keycard", "In Jackets\n" +
                "Pockets and bags of Scavs",
                "1st room\n" +
                        "One Weapon box (5x2)\n" +
                        "One Weapon box (4x4)\n" +
                        "One Jacket\n" +
                        "2nd room\n" +
                        "One Weapon box (4x4)\n" +
                        "One Wooden crate (5x2)\n" +
                        "Loose loot (barter items)",
                R.drawable.key_11sr,new int[] {},
                new int[] {R.drawable.key_11sr_open_1, R.drawable.key_11sr_open_2,R.drawable.key_11sr_open_3}));

        exampleList.add(new Item("5da743f586f7744014504f72", "USEC stash on Customs key", "In Jackets\n" +
                "Pockets and bags of Scavs",
                "1st room\n" +
                        "One Weapon box (5x2)\n" +
                        "One Weapon box (4x4)\n" +
                        "One Jacket\n" +
                        "2nd room\n" +
                        "One Weapon box (4x4)\n" +
                        "One Wooden crate (5x2)\n" +
                        "Loose loot (barter items)",
                R.drawable.key_usecstash,new int[] {},
                new int[] {R.drawable.key_usecstash_open_1, R.drawable.key_usecstash_open_2}));



        exampleList.add(new Item("5c94bbff86f7747ee735c08f", "TerraGroup Labs access keycard", "In the Common fund stash (Shturman's crate)\n" +
                "In Drawers on Shoreline and The Lab\n" +
                "Loot from all Bosses\n" +
                "Pockets and bags of Scavs and Scav Raiders",
                "A lot of loot if you survive xD",
                R.drawable.key_labkey,new int[] {},
                new int[] {}));

        exampleList.add(new Item("5efde6b4f5448336730dbd61", "Key card with a blue marking", "On Sanitar" ,

                "Loose medical loot\n" +
                        "Stimulators",
                R.drawable.key_labkey,new int[] {},
                new int[] {R.drawable.key_ducttape_open_1,R.drawable.key_ducttape_open_2}));

        exampleList.add(new Item("5ede7a8229445733cb4c18e2", "RB-PKPM key", "In Jackets\n" +
                "Pockets and bags of Scavs" ,

                "Rare Loose Loot\n" +
                        "Two Drawers\n" +
                        "Multiple Weapon spawns\n" +
                        "Possible spawn of certain Containers",
                R.drawable.key_rbpkpm,new int[] {},
                new int[] {R.drawable.key_rbpkpm_open_1}));


        exampleList.add(new Item("5d8e3ecc86f774414c78d05e", "RB-GN key", "In Jackets\n" +
                "Pockets and bags of Scavs" ,
                "Two Toolboxes\n" +
                        "Possible spawn of FP-100 filter absorber\n" +
                        "Possible spawn of 6-STEN-140-M military battery\n" +
                        "Possible spawn of Old firesteel",
                R.drawable.key_rbgn,new int[] {},
                new int[] {R.drawable.key_rbpkpm_open_1}));

        exampleList.add(new Item("5d80cb5686f77440545d1286", "RB-PS81 key", "In Jackets\n" +
                "Pockets and bags of Scavs" ,

                "Two Medical Supply Crates\n" +
                        "One Ration Supply Crate\n" +
                        "One Technical Supply Crate",
                R.drawable.key_rbps81,new int[] {R.drawable.key_rbps81_spawn_1,R.drawable.key_rbps81_spawn_2,R.drawable.key_rbps81_spawn_3},
                new int[] {R.drawable.key_rbps81_open_1,R.drawable.key_rbps81_open_2}));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new Adapter(exampleList);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);

        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.devider));
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
      //  AdMobInit();
    }






    @Override
    public void onBackPressed()
    {
recyclerView.clearFocus();
    }




    private AdView mAdView;

    public void AdMobInit()
    {
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
       // mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }



}
