package com.example.tp4;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

import model.Employe;
import model.Serialiser;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etPrenom, etAge, etFonction, etDOTI, etCIN;
    private Button buttonNouveauEmploye, buttonDeserialiser;
    private static final String fname = "employee_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialisation des vues et boutons
        etName = findViewById(R.id.EtName);
        etPrenom = findViewById(R.id.EtPrenom);
        etAge = findViewById(R.id.EtAge);
        etFonction = findViewById(R.id.EtFonction);
        etDOTI = findViewById(R.id.EtDOTI);
        etCIN = findViewById(R.id.EtCIN);
        buttonNouveauEmploye = findViewById(R.id.button);
        buttonDeserialiser = findViewById(R.id.button2);

        // Définition de l'action du bouton "Nouveau Employé"
        buttonNouveauEmploye.setOnClickListener(v -> {
            // Création d'un nouvel objet Employee avec les valeurs des EditText
            Employe emp = new Employe(
                    etName.getText().toString(),
                    etPrenom.getText().toString(),
                    etCIN.getText().toString(),
                    etFonction.getText().toString(),
                    Integer.parseInt(etAge.getText().toString()),
                    Integer.parseInt(etDOTI.getText().toString())
            );

            // Création d'un nouvel objet Serialiser
            Serialiser obj_ser = new Serialiser();

            // Serialisation de l'objet Employee
            try {
                obj_ser.serialise(fname, emp, MainActivity.this);
                Log.d("FilePath", getFilesDir().getAbsolutePath() + "/" + fname); // Afficher le chemin du fichier dans les logs
                Toast.makeText(MainActivity.this, "Employé sérialisé avec succès.", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                // Affichage d'un message en cas d'erreur de sérialisation
                Toast.makeText(MainActivity.this, "Erreur lors de la sérialisation de l'employé : " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        // Configuration de l'ajustement des marges en fonction des bords du système
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
