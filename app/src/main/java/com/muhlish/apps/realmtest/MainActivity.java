package com.muhlish.apps.realmtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muhlish.apps.realmtest.model.Mahasiswa;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    LinearLayout llDataMahasiswa;
    TextView tvNim, tvName, tvDepartment, tvYear;
    String nim, name, department;
    int year;

    Button btInputData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNim = (TextView) findViewById(R.id.tvNim);
        tvName = (TextView) findViewById(R.id.tvName);
        tvDepartment = (TextView) findViewById(R.id.tvDepartment);
        tvYear = (TextView) findViewById(R.id.tvYear);
        btInputData = (Button) findViewById(R.id.btInputData);
        llDataMahasiswa = (LinearLayout) findViewById(R.id.llDataMahasiswa);

        // Create a RealmConfiguration which is to locate Realm file in package's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        // Get a Realm instance for this thread
        Realm realm = Realm.getInstance(realmConfig);

        RealmQuery<Mahasiswa> query = realm.where(Mahasiswa.class);
        // Execute the query:
        RealmResults<Mahasiswa> result1 = query.findAll();

        if (result1.size() == 0) {
            btInputData.setVisibility(View.VISIBLE);
            btInputData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, FormActivity.class);
                    startActivityForResult(i, 100);
                }
            });
        } else {
            llDataMahasiswa.setVisibility(View.VISIBLE);

            nim = result1.get(0).getNim();
            name = result1.get(0).getNama();
            department = result1.get(0).getJurusan();
            year = result1.get(0).getAngkatan();

            Mahasiswa data = new Mahasiswa();
            data.setNim(nim);
            data.setNama(name);
            data.setJurusan(department);
            data.setAngkatan(year);

            tvNim.setText(data.getNim());
            tvName.setText(data.getNama());
            tvDepartment.setText(data.getJurusan());
            tvYear.setText(String.valueOf(data.getAngkatan()));

            for (int i = 0; i < result1.size(); i++) {
                Log.v("Data" + i, result1.get(i).toString());
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.recreate();
    }
}
