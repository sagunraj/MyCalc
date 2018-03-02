package com.example.sagunraj.mycalc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberClicked(view: View) {
        if(isNewOp)
            result.setText("")
        isNewOp = false
        var btnID = view as Button
        var btnClickValue:String = result.text.toString()
        when (btnID.id) {
            zerobtn.id -> {
                btnClickValue += "0"
            }
            onebtn.id -> {
                btnClickValue += "1"
            }
            twobtn.id -> {
                btnClickValue += "2"
            }
            threebtn.id -> {
                btnClickValue += "3"
            }
            fourbtn.id -> {
                btnClickValue += "4"
            }
            fivebtn.id -> {
                btnClickValue += "5"
            }
            sixbtn.id -> {
                btnClickValue += "6"
            }
            sevenbtn.id -> {
                btnClickValue += "7"
            }
            eightbtn.id -> {
                btnClickValue += "8"
            }
            ninebtn.id -> {
                btnClickValue += "9"
            }
            pointbtn.id -> {
                if (!btnClickValue.contains("."))
                    btnClickValue +="."
                else
                    btnClickValue = btnClickValue
            }
            pmbtn.id -> {
                btnClickValue = "-" + btnClickValue
            }
        }
        result.setText(btnClickValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true

    fun butOpClick(view: View) {
        var btnID = view as Button
        when (btnID.id) {
            addbtn.id -> {
                op = "+"
            }
            mulbtn.id -> {
                op = "*"
            }
            divbtn.id -> {
                op = "/"
            }
            subbtn.id -> {
                op = "-"
            }
        }

        oldNumber = result.text.toString()
        isNewOp = true
    }
    fun butEqClick(view: View){
        var newNumber = result.text.toString()
        var finalNumber:Double?=null
        when(op){
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }

        }
        result.setText(finalNumber.toString())
        isNewOp = true
    }

    fun percentClick(view: View){
        var number = result.text.toString()
        var finalNumber = number.toDouble() / 100
        result.setText(finalNumber.toString())
        isNewOp = true

    }

    fun acClick(view:View){
        var newNumber = 0
        var oldNumber = 0
        result.setText("0")
        isNewOp = true
    }
}
