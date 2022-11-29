package jagerfield.mobilecontactslibrary;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;

import jagerfield.mobilecontactslibrary.Contact.Contact;
import jagerfield.mobilecontactslibrary.Utilities.Utilities;


public class ImportContactsAsync extends AsyncTask<Void, Void, ArrayList<Contact>> {
    private Activity activity;
    private ICallback client;

    public ImportContactsAsync(Activity activity, ICallback client) {
        this.activity = activity;
        this.client = client;
    }

    @Override
    protected void onPostExecute(ArrayList<Contact> contacts) {
        client.mobileContacts(contacts);
    }

    @Override
    protected ArrayList<Contact> doInBackground(Void... params) {
        try {
            ImportContacts importContacts = new ImportContacts(activity);
            return importContacts.getContacts();
        } catch (Exception e) {
            Log.e(Utilities.TAG_LIB, e.getMessage());
        }

        return null;
    }


    public interface ICallback {
        void mobileContacts(ArrayList<Contact> contactList);
    }

}

