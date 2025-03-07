package com.example.raquete;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
 ProgressBar progressBarCarre,progressBarLigado;
 Button carregar,ligar,usar;
 TextView result;
  int carregado=100;

  int bateria=0;
    boolean isLigado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        carregar = findViewById(R.id.carregar);
        progressBarLigado=findViewById(R.id.progressBarLigado);
        progressBarCarre=findViewById(R.id.progressBarCarre);
        ligar=findViewById(R.id.ligar);
        usar=findViewById(R.id.usar);
        result=findViewById(R.id.result);




        carregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bateria = 100;

                int carregado1 = carregado;
                Toast.makeText(getApplicationContext(),"Carregado "+carregado1,LENGTH_SHORT).show();

                progressBarCarre.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00FF00")));




            }

        });
        ligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Raquete Ligada",LENGTH_SHORT).show();
               isLigado = true;
                progressBarLigado.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#00FF00")));

            }
        });
        usar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isLigado && bateria > 0) {
                    bateria = bateria - 10;  // Subtrai 10 de bateria


                    result.setText("Bateria Restante:" + bateria + "%");


                    if (bateria <= 0) {
                        bateria = 0;  // Garante que a bateria não fique negativa
                        isLigado = false;  // Desliga a raquete
                        progressBarCarre.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FA8072")));
                        progressBarLigado.setProgressBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FA8072")));
                        Toast.makeText(getApplicationContext(), "Desligando a Raquete", LENGTH_SHORT).show();
                    }
                } else {
                    // Se a bateria estiver 0 ou a raquete estiver desligada
                    Toast.makeText(getApplicationContext(), "Você precisa Recarregar Primeiro", LENGTH_SHORT).show();
                }
            }
        });

    }
}