package com.Jhoseth_Rozo.ecosistemamovil

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.graphics.Color
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "EcosistemaMovil"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Actividad creada exitosamente")

        val scrollView = ScrollView(this)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(48, 48, 48, 48)
        }

        // Título principal
        layout.addView(createTitle("Ecosistema Movil"))
        layout.addView(createSubtitle("Paradigmas de Desarrollo"))

        // Paradigmas
        val paradigmas = listOf(
            Triple(
                "Nativo",
                "Kotlin/Swift",
                "Rendimiento maximo, acceso completo a APIs"
            ),
            Triple(
                "Hibrido",
                "Ionic/Capacitor",
                "Tecnologias web en contenedor nativo"
            ),
            Triple(
                "Multiplataforma",
                "Flutter/React Native",
                "Codigo compartido, rendimiento cercano a nativo"
            )
        )

        paradigmas.forEachIndexed { index, (nombre, tech, desc) ->

            Log.w("ECOSISTEMA_APP", "Procesando paradigma: $nombre")

            if (index == 2) {
                Log.e("ECOSISTEMA_APP", "Error simulado en el paradigma: $nombre")
            }
            Log.i(TAG, "Mostrando paradigma ${index + 1}: $nombre")
            layout.addView(createCard(nombre, tech, desc))
        }

        Log.d(TAG, "onCreate: UI construida con exito")

        scrollView.addView(layout)
        setContentView(scrollView)
    }

    private fun createTitle(text: String): TextView {
        return TextView(this).apply {
            this.text = text
            textSize = 28f
            setTextColor(Color.parseColor("#065A82"))
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 16)
        }
    }

    private fun createSubtitle(text: String): TextView {
        return TextView(this).apply {
            this.text = text
            textSize = 18f
            setTextColor(Color.parseColor("#666666"))
            gravity = Gravity.CENTER
            setPadding(0, 0, 0, 32)
        }
    }

    private fun createCard(
        title: String,
        tech: String,
        desc: String
    ): LinearLayout {

        return LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 24, 32, 24)

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 16, 0, 16)
            }

            layoutParams = params
            setBackgroundColor(Color.parseColor("#E8F4F8"))

            addView(TextView(context).apply {
                text = title
                textSize = 20f
                setTextColor(Color.parseColor("#065A82"))
            })

            addView(TextView(context).apply {
                text = "Tecnologia: $tech"
                textSize = 14f
                setTextColor(Color.parseColor("#1C7293"))
            })

            addView(TextView(context).apply {
                text = desc
                textSize = 14f
                setPadding(0, 8, 0, 0)
            })
        }
    }
}