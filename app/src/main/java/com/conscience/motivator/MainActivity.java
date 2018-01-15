package com.conscience.motivator;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.conscience.motivator.data.DBTables.AppDatabase;
import com.conscience.motivator.data.DBTables.Goal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.getAppDB(this.getApplicationContext());

        new AsyncDbAccess().execute();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NewGoalActivity.class);
            startActivity(intent);
        });
    }

    private class AsyncDbAccess extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Goal goal = new Goal("new goal", "make some things",
                    "in progress", 0);
            /*User user = new User("Joe", "+123412341234", "123",
                    "no-image");*/

           // appDatabase.userDao().insertAll(user);
            appDatabase.goalDAO().insertGoal(goal);
            //List<User> users = appDatabase.userDao().getAll();
            List<Goal> goals = appDatabase.goalDAO().getAll();

            //System.out.println("### MaGiC: " + users.get(0).username);
            System.out.println("*** " + goals.get(0).goalTitle + " || " + goals.get(0).description);
            return null;
        }
    }
}
