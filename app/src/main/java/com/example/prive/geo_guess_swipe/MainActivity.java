package com.example.prive.geo_guess_swipe;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Snackbar sb = Snackbar.make(findViewById(android.R.id.content), "", Snackbar.LENGTH_SHORT);

        List<Photos> photoList = new ArrayList<>();

        for (int i = 0; i < Photos.cityImageArray.length; i++) {

            photoList.add(new Photos(Photos.cityImageArray[i]));
        }

        RecyclerView cityRV = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                LinearLayoutManager.VERTICAL);

        cityRV.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter(this, photoList);
        cityRV.setAdapter(adapter);

/*
Add a touch helper to the RecyclerView to recognize when a user swipes to delete a list entry.
An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
and uses callbacks to signal when a user is performing these actions.
*/
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }

                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());

                        if (Photos.trueOrFalse[position] && swipeDir == 4) {
                            sb.setText("Correct");
                            sb.show();
                        } else if (!Photos.trueOrFalse[position] && swipeDir == 8) {
                            sb.setText("Correct");
                            sb.show();
                        } else {
                            sb.setText("Wrong");
                            sb.show();
                        }
                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(cityRV);

    }
}
