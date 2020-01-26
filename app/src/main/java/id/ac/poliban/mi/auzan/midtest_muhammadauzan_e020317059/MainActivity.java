package id.ac.poliban.mi.auzan.midtest_muhammadauzan_e020317059;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String rb;
    String sAgama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arraySpinner = new String[] {
                "", "Islam", "Katholik", "Protestan", "Hindu", "Budha", "Khonghucu", "Atheis"
        };
        Spinner spinner =  findViewById(R.id.spin_Agama);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final EditText etNoPendaftaran = findViewById(R.id.etNoPendaftaran);
        final EditText etNama = findViewById(R.id.etNama);
        final EditText etAlamat = findViewById(R.id.etAlamat);
        final EditText etTelp = findViewById(R.id.etTelp);
        final RadioButton rbPria = findViewById(R.id.rbPria);
        final RadioButton rbWanita = findViewById(R.id.rbWanita);
        RadioGroup rgJenisKelamin = findViewById(R.id.rgJenisKelamin);
        final Spinner spin_Agama = findViewById(R.id.spin_Agama);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);

        rgJenisKelamin.setOnCheckedChangeListener(((group, checkedId) -> {
            if (checkedId == rbPria.getId()) {
                rb = rbPria.getText().toString();
            } else{
                rb =  rbWanita.getText().toString();
            }
        }));

        spin_Agama.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sAgama = spin_Agama.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNama.getText().clear();
                etNoPendaftaran.getText().clear();
                etAlamat.getText().clear();
                etTelp.getText().clear();
                rbPria.setChecked(false);
                rbWanita.setChecked(false);
                spin_Agama.setSelection(0);
            }
        });

        btSubmit.setOnClickListener(v ->
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Info Registrasi :")
                    .setMessage(
                            "No Pendaftaran : " + etNoPendaftaran.getText() + "\n" +
                            "Nama           : " + etNama.getText() + "\n" +
                            "Jenis Kelamin  : " + rb + "\n" +
                            "Agama          : " + sAgama + "\n" +
                            "Alamat         : " + etAlamat.getText() + "\n" +
                            "Telepon        : " + etTelp.getText())
                    .setPositiveButton("OK",null)
                    .show());

        }
    }
