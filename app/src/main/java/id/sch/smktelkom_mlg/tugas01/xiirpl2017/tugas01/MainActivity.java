package id.sch.smktelkom_mlg.tugas01.xiirpl2017.tugas01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;



public class MainActivity extends AppCompatActivity {
    EditText etNama, etPesan, etWaktu;
    RadioGroup rgJK;
    Spinner  spK;
    TextView tvHasil, tvh2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        etPesan = (EditText) findViewById(R.id.editTextPesan);
        etWaktu = (EditText) findViewById(R.id.editTextLama);
        rgJK = (RadioGroup) findViewById(R.id.radiogroupJK);
        spK = (Spinner) findViewById(R.id.spinnerKota);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doclick();
            }
        });

    }


    private void doclick() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String pesan = etPesan.getText().toString();
            String waktu = etWaktu.getText().toString();


            String hasil = null;
            if (rgJK.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton) findViewById(rgJK.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }
            if (hasil == null) {
                tvHasil.setText("Belum memilih jenis pemesanan");
            } else {
                tvHasil.setText("Nama :" + nama + "\nPesan :" + pesan + "\nWaktu :" + waktu + "\nJenis pemesanan : " + hasil + "\nAlamat :" + spK.getSelectedItem().toString());

            }
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etPesan.getText().toString();
        String lama = etWaktu.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama Belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        if(tahun.isEmpty())
        {
            etPesan.setError("Tahun belum diisi");
            valid = false;
        }
        else if (tahun.length()!=4)
        {
            etPesan.setError("format tahun bukan yyyy");
            valid = false;
        }
        else
        {
            etPesan.setError(null);
        }
        if(lama.isEmpty())
        {
            etWaktu.setError("Lama hari belum diisi");
            valid = false;
        }
        else
        {
            etWaktu.setError(null);

        }
        return valid;
    }


}
