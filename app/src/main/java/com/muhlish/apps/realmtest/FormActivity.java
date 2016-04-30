package com.muhlish.apps.realmtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.muhlish.apps.realmtest.model.Mahasiswa;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class FormActivity extends AppCompatActivity {

    Button btSave;
    EditText etNim, etName, etDepartment, etYear;

    String nim, name, department;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        btSave = (Button) findViewById(R.id.btSave);
        etNim = (EditText) findViewById(R.id.etNim);
        etName = (EditText) findViewById(R.id.etName);
        etDepartment = (EditText) findViewById(R.id.etDepartment);
        etYear = (EditText) findViewById(R.id.etYear);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nim = etNim.getText().toString();
                name = etName.getText().toString();
                department = etDepartment.getText().toString();
                year = Integer.parseInt(etYear.getText().toString());

                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setNim(nim);
                mahasiswa.setNama(name);
                mahasiswa.setJurusan(department);
                mahasiswa.setAngkatan(year);

                // Create a RealmConfiguration which is to locate Realm file in package's "files" directory.
                RealmConfiguration realmConfig = new RealmConfiguration.Builder(FormActivity.this).build();
                // Get a Realm instance for this thread
                Realm realm = Realm.getInstance(realmConfig);

                // Persist your data easily
                realm.beginTransaction();
                realm.copyToRealm(mahasiswa);
                realm.commitTransaction();

                finish();
            }
        });
    }
}
