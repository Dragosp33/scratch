package com.example.scratch;

import android.app.Application;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * This class holds the implementation code for the methods that interact with the database.
 * Using a repository allows us to group the implementation methods together,
 * and allows the AnuntViewModel to be a clean interface between the rest of the app
 * and the database.
 *
 * For insert, update and delete, and longer-running queries,
 * you must run the database interaction methods in the background.
 *
 * Typically, all you need to do to implement a database method
 * is to call it on the data access object (DAO), in the background if applicable.
 */

public class AnuntRepository {

    private AnuntDao mAnuntDao;
    private LiveData<List<Anunt>> mAllAnunts;

    AnuntRepository(Application application) {
        AnuntRoomDatabase db = AnuntRoomDatabase.getDatabase(application);
        mAnuntDao = db.AnuntDao();
        mAllAnunts = mAnuntDao.getAllAnunts();
    }

    LiveData<List<Anunt>> getAllAnunts() {
        return mAllAnunts;
    }

    public void insert(Anunt Anunt) {
        new insertAsyncTask(mAnuntDao).execute(Anunt);
    }

    public void update(Anunt Anunt)  {
        new updateAnuntAsyncTask(mAnuntDao).execute(Anunt);
    }

    public void deleteAll()  {
        new deleteAllAnuntsAsyncTask(mAnuntDao).execute();
    }

    // Must run off main thread
    public void deleteAnunt(Anunt Anunt) {
        new deleteAnuntAsyncTask(mAnuntDao).execute(Anunt);
    }

    // Static inner classes below here to run database interactions in the background.

    /**
     * Inserts a Anunt into the database.
     */
    private static class insertAsyncTask extends AsyncTask<Anunt, Void, Void> {

        private AnuntDao mAsyncTaskDao;

        insertAsyncTask(AnuntDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Anunt... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    /**
     * Deletes all Anunts from the database (does not delete the table).
     */
    private static class deleteAllAnuntsAsyncTask extends AsyncTask<Void, Void, Void> {
        private AnuntDao mAsyncTaskDao;

        deleteAllAnuntsAsyncTask(AnuntDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    /**
     *  Deletes a single Anunt from the database.
     */
    private static class deleteAnuntAsyncTask extends AsyncTask<Anunt, Void, Void> {
        private AnuntDao mAsyncTaskDao;

        deleteAnuntAsyncTask(AnuntDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Anunt... params) {
            mAsyncTaskDao.deleteAnunt(params[0]);
            return null;
        }
    }

    /**
     *  Updates a Anunt in the database.
     */
    private static class updateAnuntAsyncTask extends AsyncTask<Anunt, Void, Void> {
        private AnuntDao mAsyncTaskDao;

        updateAnuntAsyncTask(AnuntDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Anunt... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }
}