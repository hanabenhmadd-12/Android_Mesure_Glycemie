package com.example.benhmadhana_tp1; // gardez la première ligne de VOTRE fichier si elle est différente

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private static final int VERT = 0xFF2E7D32;
    private static final int ORANGE = 0xFFEF6C00;
    private static final int ROUGE = 0xFFC62828;

    private TextInputEditText etAge, etGlycemie;
    private TextInputLayout tilGlycemie;
    private RadioGroup rgJeune, rgUnite;
    private TextView tvResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAge = findViewById(R.id.etAge);
        etGlycemie = findViewById(R.id.etGlycemie);
        tilGlycemie = findViewById(R.id.tilGlycemie);
        rgJeune = findViewById(R.id.rgJeune);
        rgUnite = findViewById(R.id.rgUnite);
        tvResultat = findViewById(R.id.tvResultat);
        MaterialButton btnConsulter = findViewById(R.id.btnConsulter);
        MaterialButton btnEffacer = findViewById(R.id.btnEffacer);

        // Change le texte d'aide quand on change d'unité
        rgUnite.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbMgdl) {
                tilGlycemie.setHint(getString(R.string.hint_glycemie_mgdl));
            } else {
                tilGlycemie.setHint(getString(R.string.hint_glycemie_gl));
            }
            etGlycemie.setText("");
            tvResultat.setText("");
        });

        btnConsulter.setOnClickListener(v -> consulter());
        btnEffacer.setOnClickListener(v -> effacer());
    }

    private void consulter() {
        boolean enMgdl = rgUnite.getCheckedRadioButtonId() == R.id.rbMgdl;

        // Âge
        int age;
        try {
            age = Integer.parseInt(etAge.getText().toString().trim());
        } catch (NumberFormatException e) {
            etAge.setError(getString(R.string.err_age));
            return;
        }
        if (age < 1 || age > 120) {
            etAge.setError(getString(R.string.err_age));
            return;
        }

        // Jeûne
        if (rgJeune.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, R.string.err_jeune, Toast.LENGTH_SHORT).show();
            return;
        }
        boolean aJeun = rgJeune.getCheckedRadioButtonId() == R.id.rbOui;

        // Glycémie
        String texte = etGlycemie.getText().toString().trim().replace(',', '.');
        double valeur;
        try {
            valeur = Double.parseDouble(texte);
        } catch (NumberFormatException e) {
            etGlycemie.setError(getString(enMgdl ? R.string.err_mgdl : R.string.err_gl));
            return;
        }

        // Conversion en g/L (100 mg/dL = 1 g/L)
        double glycemieGL = enMgdl ? valeur / 100.0 : valeur;
        if (glycemieGL <= 0 || glycemieGL > 10) {
            etGlycemie.setError(getString(enMgdl ? R.string.err_mgdl : R.string.err_gl));
            return;
        }

        interpreter(glycemieGL, aJeun, age);
    }

    /**
     * Interprétation indicative (valeurs en g/L).
     * À jeun  : < 0.70 hypo | 0.70 à seuilNormal normale | jusqu'à 1.26 limite | au-delà élevée
     *           (seuilNormal = 1.00 pour un enfant/adolescent de moins de 18 ans, 1.10 sinon)
     * Non à jeun : < 0.70 hypo | < 1.40 normale | 1.40 à 2.00 limite | >= 2.00 élevée
     */
    private void interpreter(double g, boolean aJeun, int age) {
        String message;
        int couleur;

        if (g < 0.70) {
            message = getString(R.string.res_hypo);
            couleur = ROUGE;
        } else if (aJeun) {
            double seuilNormal = (age < 18) ? 1.00 : 1.10;
            if (g <= seuilNormal) {
                message = getString(R.string.res_normale);
                couleur = VERT;
            } else if (g < 1.26) {
                message = getString(R.string.res_limite);
                couleur = ORANGE;
            } else {
                message = getString(R.string.res_elevee);
                couleur = ROUGE;
            }
        } else {
            if (g < 1.40) {
                message = getString(R.string.res_normale);
                couleur = VERT;
            } else if (g < 2.00) {
                message = getString(R.string.res_limite);
                couleur = ORANGE;
            } else {
                message = getString(R.string.res_elevee);
                couleur = ROUGE;
            }
        }

        tvResultat.setText(message);
        tvResultat.setTextColor(couleur);
    }

    private void effacer() {
        etAge.setText("");
        etGlycemie.setText("");
        etAge.setError(null);
        etGlycemie.setError(null);
        rgJeune.clearCheck();
        rgUnite.check(R.id.rbGL);
        tvResultat.setText("");
        etAge.requestFocus();
    }
}