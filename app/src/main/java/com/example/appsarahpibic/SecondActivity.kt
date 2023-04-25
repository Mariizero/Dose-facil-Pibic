package com.example.appsarahpibic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {

    private lateinit var btnSeri: Button
    private lateinit var btnGot: Button
    private lateinit var lbProcess: TextView
    private lateinit var txtMassa: EditText
    private lateinit var txtDose: EditText
    private lateinit var txtVol: EditText
    private lateinit var txtMassaMed: EditText
    private lateinit var txtFator: EditText
    private lateinit var btnCalc: Button
    private lateinit var txtResult: TextView
    private lateinit var lbMassa: TextView
    private lateinit var lbDose: TextView
    private lateinit var lbVol: TextView
    private lateinit var lbMassaMed: TextView
    private lateinit var lbFator: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val convert = 0.016

        btnSeri = findViewById(R.id.btnSeri)
        btnGot = findViewById(R.id.btnGot)
        lbProcess = findViewById(R.id.textprocess)
        txtMassa = findViewById(R.id.numberedit1)
        txtDose = findViewById(R.id.numberedit2)
        txtVol = findViewById(R.id.numberedit3)
        txtMassaMed = findViewById(R.id.numberedit4)
        txtFator = findViewById(R.id.numberedit5)
        btnCalc = findViewById(R.id.button)
        txtResult = findViewById(R.id.textResultadoFinal)
        lbMassa = findViewById(R.id.massaRat)
        lbDose = findViewById(R.id.dose1)
        lbVol = findViewById(R.id.volume1)
        lbMassaMed = findViewById(R.id.massMed)
        lbFator = findViewById(R.id.FaG1)



        lbProcess.visibility = View.INVISIBLE
        txtMassa.visibility = View.INVISIBLE
        txtDose.visibility = View.INVISIBLE
        txtVol.visibility = View.INVISIBLE
        txtMassaMed.visibility = View.INVISIBLE
        txtFator.visibility = View.INVISIBLE
        btnCalc.visibility = View.INVISIBLE
        txtResult.visibility = View.INVISIBLE
        lbMassa.visibility = View.INVISIBLE
        lbDose.visibility = View.INVISIBLE
        lbVol.visibility =  View.INVISIBLE
        lbMassaMed.visibility = View.INVISIBLE
        lbFator.visibility = View.INVISIBLE


        btnCalc.isEnabled = false


        /**  Escolhe o tipo de procedimento Seringa*/

        btnSeri.setOnClickListener() {
            lbProcess.text = "Seringa"
            lbProcess.visibility = View.VISIBLE
            txtMassa.visibility = View.VISIBLE
            txtDose.visibility = View.VISIBLE
            txtVol.visibility = View.VISIBLE
            txtMassaMed.visibility = View.VISIBLE
            btnCalc.visibility = View.VISIBLE
            txtResult.visibility = View.VISIBLE
            lbMassa.visibility = View.VISIBLE
            lbDose.visibility = View.VISIBLE
            lbVol.visibility =  View.VISIBLE
            lbMassaMed.visibility = View.VISIBLE
            lbFator.visibility = View.INVISIBLE
            txtFator.visibility = View.INVISIBLE



            btnCalc.isEnabled = true
        }
        /**  Escolhe o tipo de procedimento Gotejamento*/

        btnGot.setOnClickListener() {
            lbProcess.text = "Gotejamento"
            lbProcess.visibility = View.VISIBLE
            txtMassa.visibility = View.VISIBLE
            txtDose.visibility = View.VISIBLE
            txtVol.visibility = View.VISIBLE
            txtMassaMed.visibility = View.VISIBLE
            btnCalc.visibility = View.VISIBLE
            txtResult.visibility = View.VISIBLE
            lbMassa.visibility = View.VISIBLE
            lbDose.visibility = View.VISIBLE
            lbVol.visibility =  View.VISIBLE
            lbMassaMed.visibility = View.VISIBLE
            lbFator.visibility = View.VISIBLE
            txtFator.visibility = View.VISIBLE


            btnCalc.isEnabled = true

        }


        /**  Quando apertar Calcular*/

        btnCalc.setOnClickListener {


            if (lbProcess.text == "Seringa") {
                if (txtMassa.text.isEmpty()) {
                    Toast.makeText(applicationContext,"Digite a Massa do Rato", Toast.LENGTH_SHORT).show()
                } else if (txtDose.text.isEmpty()) {
                    Toast.makeText(applicationContext, "Digite a Dose", Toast.LENGTH_SHORT).show()
                } else if (txtVol.text.isEmpty()) {
                    Toast.makeText(applicationContext, "Digite a Volume", Toast.LENGTH_SHORT).show()
                } else if (txtMassaMed.text.isEmpty()) {
                    Toast.makeText(applicationContext, "Digite a Massa do medicamento", Toast.LENGTH_SHORT).show()
                } else {
                    var auxResult1 = (txtMassa.text.toString().toDouble() * txtDose.text.toString().toDouble())
                    var auxResult2 = auxResult1 / txtMassaMed.text.toString().toDouble()
                    var teste_seringa = auxResult2 * txtVol.text.toString().toDouble()
                    txtResult.text =  txtMassa.text.toString() + " * " + txtDose.text.toString() + " = " + auxResult1.toString() + "\n" + auxResult1.toString() + " / " + txtMassaMed.text.toString() + " = " + auxResult2.toString() + "\n" + auxResult2.toString() + " * " + txtVol.text.toString() + " = " + teste_seringa.toString() + "\n" + "\n" + "A taxa de infusão é " + teste_seringa.toString() + " mL/h"

                }
            }
            if (lbProcess.text == "Gotejamento") {
                if (txtMassa.text.isEmpty()) {
                    Toast.makeText(applicationContext,"Digite a Massa do Rato",Toast.LENGTH_SHORT).show()
                } else if (txtDose.text.isEmpty()) {
                    Toast.makeText(applicationContext, "Digite a Dose", Toast.LENGTH_SHORT).show()
                } else if (txtVol.text.isEmpty()) {
                    Toast.makeText(applicationContext, "Digite a Volume", Toast.LENGTH_SHORT).show()
                } else if (txtMassaMed.text.isEmpty()) {
                    Toast.makeText(applicationContext, "Digite a Massa do medicamento", Toast.LENGTH_SHORT ).show()
                } else if (txtFator.text.isEmpty()) {
                    Toast.makeText(applicationContext, "Digite o Fator de Gotejamento", Toast.LENGTH_SHORT ).show()
                } else {
                    var Result1 = (txtMassa.text.toString().toDouble() * txtDose.text.toString().toDouble())
                    var Result2 = Result1 / txtMassaMed.text.toString().toDouble()
                    var Result3 = Result2 * txtVol.text.toString().toDouble()
                    var teste_gotejamento = Result3 * txtFator.text.toString().toDouble() * convert
                    txtResult.text = txtMassa.text.toString() + " * " + txtDose.text.toString() + " = " + Result1.toString() + "\n" + Result1.toString() + " / " + txtMassaMed.text.toString() + " = " + Result2.toString() + "\n" + Result2.toString() + " * " + txtVol.text.toString() + " = " + Result3.toString() + "\n" + Result3.toString() + " * " + txtFator.text.toString() + " * " + convert + " = " + teste_gotejamento.toString() + "\n" + "\n" + "A taxa de infusão é " + teste_gotejamento.toString() + " gtt/min"

                }
            }
        }
    }
}

