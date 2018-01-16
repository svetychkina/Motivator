package com.conscience.motivator;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.conscience.motivator.data.DBTables.AppDatabase;
import com.conscience.motivator.data.DBTables.Goal;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    AppDatabase appDatabase;

    List<Goal> goals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.getAppDB(this.getApplicationContext());
        //new AsyncDbAccess().execute();

        Runnable readFromDB = () -> {
            goals = appDatabase.goalDAO().getAll();
        };
        Thread dbReader = new Thread(readFromDB);
        dbReader.start();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        try {
            dbReader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        adapter = new RecyclerAdapter(goals);
        recyclerView.setAdapter(adapter);
    }

    private class AsyncDbAccess extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            Goal goal = new Goal("new goal", "do things", "19.01.17", "11:00", 0);
            /*User user = new User("Joe", "+123412341234", "123",
                    "no-image");*/

           // appDatabase.userDao().insertAll(user);
            appDatabase.goalDAO().insertGoal(goal);
            //List<User> users = appDatabase.userDao().getAll();
            List<Goal> goals = appDatabase.goalDAO().getAll();

            //System.out.println("### MaGiC: " + users.get(0).username);
            System.out.println("*** " + goals.get(0).goalTitle + " || " + goals.get(0).goalDate);
            return null;
        }
    }
}
