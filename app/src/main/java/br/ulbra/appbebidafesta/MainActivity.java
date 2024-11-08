package br.ulbra.appbebidafesta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtConvidados, edtTempo;
    Button btCalcular, btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtConvidados = findViewById(R.id.edtConvidados);
        edtTempo = findViewById(R.id.edtTempo);
        btCalcular = findViewById(R.id.btnCalcular);
        btLimpar = findViewById(R.id.btnLimpar);
        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String convidadosStr = edtConvidados.getText().toString();
                String duracaoStr = edtTempo.getText().toString();

                if (convidadosStr.isEmpty() || duracaoStr.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                int convidados = Integer.parseInt(convidadosStr);
                int duracao = Integer.parseInt(duracaoStr);
                Intent intent = new Intent(MainActivity.this,
                        ResultActivity.class);
                intent.putExtra("Convidados:", convidados);
                intent.putExtra("Duração:", duracao);
                startActivity(intent);

            }
        });

        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtConvidados.setText("");
                edtTempo.setText("");
            }
        });
    }
}