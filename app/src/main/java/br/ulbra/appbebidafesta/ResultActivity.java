package br.ulbra.appbebidafesta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView txvAgua, txvRefri, txvSuco;
    Button btVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        txvAgua = findViewById(R.id.txtAgua);
        txvRefri = findViewById(R.id.txtRefri);
        txvSuco = findViewById(R.id.txtSuco);
        btVoltar = findViewById(R.id.btnVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });

        // puxar dados da tela principal//
        int convidados = getIntent().getIntExtra("Convidados:", 0);
        int duracao = getIntent().getIntExtra("Duração:", 0);


        //Calculo água//
        int totalAgua = (convidados * duracao * 500)/1000;
        //Calculo refri//
        int totalRefri = (convidados * duracao * 300)/1000;
        //calculo suco//
        int totalSuco = (convidados * duracao * 200)/1000;


        // textos para os resultados//

        txvAgua.setText("Água: " + totalAgua + " L");
        txvRefri.setText("Refrigerante: " + totalRefri + " L");
        txvSuco.setText("Suco: " + totalSuco + " L");


    }
}











