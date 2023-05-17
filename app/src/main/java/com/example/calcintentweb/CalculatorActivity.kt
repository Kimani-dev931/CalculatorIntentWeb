package com.example.calcintentweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var  Tv_answer:TextView
    lateinit var edt_firstnumber:EditText
    lateinit var edt_secondnumber:EditText
    lateinit var buttonadd:Button
    lateinit var buttonsub:Button
    lateinit var buttonmultiply:Button
    lateinit var buttondivide:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        Tv_answer=findViewById(R.id.Txt_answer)
        edt_firstnumber=findViewById(R.id.edt_Firstnum)
        edt_secondnumber=findViewById(R.id.editTextNumber2)
        buttonadd=findViewById(R.id.Btn_Add)
        buttonsub=findViewById(R.id.Btn_sub)
        buttonmultiply=findViewById(R.id.btn_mult)
        buttondivide=findViewById(R.id.btn_div)

        buttonadd.setOnClickListener {
            var myfirstnumber=edt_firstnumber.text.toString()
            var mysecondnumber=edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Please fill in all inputs"
            }else{
                //lets now add
                var answer=myfirstnumber.toDouble() + mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }

        }
        buttonsub.setOnClickListener {
            var myfirstnumber=edt_firstnumber.text.toString()
            var mysecondnumber=edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Please fill in all inputs"
            }else{
                //lets now subtract
                var answer=myfirstnumber.toDouble() - mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }

        }
        buttonmultiply.setOnClickListener {
            var myfirstnumber=edt_firstnumber.text.toString()
            var mysecondnumber=edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Please fill in all inputs"
            }else{
                //lets now  multiply
                var answer=myfirstnumber.toDouble() * mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }

        }
        buttondivide.setOnClickListener {
            var myfirstnumber=edt_firstnumber.text.toString()
            var mysecondnumber=edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Please fill in all inputs"
            }else{
                //lets now divide
                var answer=myfirstnumber.toDouble() / mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }

        }





    }
}