package com.example.scratch;



import android.content.Context;
import android.os.AsyncTask;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * AnuntRoomDatabase. Includes code to create the database.
 * After the app creates the database, all further interactions
 * with it happen through the AnuntViewModel.
 */

@Database(entities = {Anunt.class}, version = 1, exportSchema = false)
public abstract class AnuntRoomDatabase extends RoomDatabase {

    public abstract AnuntDao AnuntDao();

    private static AnuntRoomDatabase INSTANCE;

    public static AnuntRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AnuntRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here.
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AnuntRoomDatabase.class, "Anunt_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // This callback is called when the database has opened.
    // In this case, use PopulateDbAsync to populate the database
    // with the initial data set if the database has no entries.
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    // Populate the database with the initial data set
    // only if the database has no entries.

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AnuntDao mDao;

        // Initial data set
        private static Anunt[] Anunts = {new Anunt("llala", (float)90 )};

        PopulateDbAsync(AnuntRoomDatabase db) {
            mDao = db.AnuntDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            // If we have no Anunts, then create the initial list of Anunts.
            if (mDao.getAnyAnunt().length < 1) {
                for (int i = 0; i <= Anunts.length - 1; i++) {
                    Anunt Anunt = new Anunt(Anunts[i]);
                    mDao.insert(Anunt);
                }
            }
            return null;
        }
    }
}