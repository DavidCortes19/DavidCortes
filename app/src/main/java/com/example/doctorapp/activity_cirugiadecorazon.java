package com.example.doctorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class activity_cirugiadecorazon extends AppCompatActivity {


        private Spinner healthStatusSpinner;
        private TextView recommendationTextView;
        private Button recommendationButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cirugiadecorazon);

            healthStatusSpinner = findViewById(R.id.healthStatusSpinner);
            recommendationTextView = findViewById(R.id.recommendationButton);
            recommendationButton = findViewById(R.id.recommendationButton);

            // Crear un ArrayAdapter para el Spinner con estados de salud predefinidos
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.health_status_array, // Definir un array en strings.xml con los estados de salud
                    android.R.layout.simple_spinner_item
            );
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            healthStatusSpinner.setAdapter(adapter);

            recommendationButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Obtener el estado de salud seleccionado por el usuario
                    String selectedHealthStatus = healthStatusSpinner.getSelectedItem().toString();

                    // Realizar una lógica para obtener la recomendación según el estado de salud seleccionado
                    String recommendation = obtenerRecomendacion(selectedHealthStatus);

                    // Mostrar la recomendación en el TextView
                    recommendationTextView.setText(recommendation);
                }
            });
        }

        // Método para obtener la recomendación basada en el estado de salud
        private String obtenerRecomendacion(String healthStatus) {
            // Aquí puedes implementar tu lógica para determinar la recomendación
            // Puedes usar un switch o una estructura de control if-else para asignar recomendaciones según el estado de salud
            // Por ejemplo:
            switch (healthStatus) {
                case "Mal Estado":
                    return "Recomendación para cirugía de corazón por el Dr. David Cortés: [Si Selecciono esto esta en peligro!! debe acudir rapido a urgencia para empezar con la cirugia, la cirugia consiste en hacer cambio de corazon por algun cercano y ademas se le debe extraer toda la sangre ]";
                case "Estado Regular":
                    return "Recomendación para cirugía de corazón por el Dr. David Cortés: [Recomendación para estado de salud regular]";
                case "Buena Salud":
                    return "Recomendación para cirugía de corazón por el Dr. David Cortés: [Recomendación para estado de salud bueno]";
                default:
                    return "Seleccione un estado de salud válido.";
            }
        }
    }

