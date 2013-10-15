package com.davidvu.hello_world;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlienContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alien);

        Button aliensButton = (Button) findViewById(R.id.findAliens);
        aliensButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listAliens();
            }
        });

        Button spockButton = (Button) findViewById(R.id.addSpock);
        spockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToAlliance("Spock");
            }
        });

        Button worfButton = (Button) findViewById(R.id.addWorf);
        worfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToAlliance("Worf");
            }
        });

        Button homeButton = (Button) findViewById(R.id.returnHome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addToAlliance(String newAlien) {
        ContentValues alienContact = new ContentValues();
        alienContact.put(ContactsContract.RawContacts.ACCOUNT_NAME, newAlien);
        alienContact.put(ContactsContract.RawContacts.ACCOUNT_TYPE, newAlien);
        Uri addUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, alienContact);
        long rawContactId = ContentUris.parseId(addUri);
        alienContact.clear();
        alienContact.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        alienContact.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        alienContact.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, newAlien);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, alienContact);
        Toast.makeText(this, "New Alliance Memeber" + newAlien, Toast.LENGTH_SHORT).show();
    }

    private void listAliens() {
        Cursor alienCur = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (alienCur.moveToNext()) {
            String alienName = alienCur.getString(alienCur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
            Toast.makeText(this, alienName, Toast.LENGTH_SHORT).show();
        }
        alienCur.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.alien_contact, menu);
        return true;
    }
    
}
