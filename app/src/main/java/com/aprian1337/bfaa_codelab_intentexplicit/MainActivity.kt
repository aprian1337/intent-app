package com.aprian1337.bfaa_codelab_intentexplicit

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity : Button
    private lateinit var btnMoveWithData : Button
    private lateinit var btnMoveWithObject : Button
    private lateinit var btnDialNumber : Button
    private lateinit var btnMoveForResult : Button
    private lateinit var tvResult : TextView

    companion object{
        private const val REQUEST = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveWithData = findViewById(R.id.btn_move_activity_with_data)
        btnMoveWithObject = findViewById(R.id.btn_move_activity_with_object)
        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnMoveForResult = findViewById(R.id.btn_move_for_result)
        btnMoveActivity.setOnClickListener(this)
        btnMoveWithData.setOnClickListener(this)
        btnMoveWithObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_move_activity->{
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_with_data->{
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithData::class.java)
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_NAME, "Dwiky")
                moveWithDataIntent.putExtra(MoveWithData.EXTRA_AGE, "20")
                startActivity(moveWithDataIntent)
            }
            R.id.btn_move_activity_with_object->{
                val person = Person(
                        "Dwiky Aprian Ashari",
                        21,
                        "dwikyapriyan@gmail.com",
                        "Banyuwangi"
                )
                val moveWithObjectIntent = Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number->{
                val phoneNumber = "081234569121"
                val dialNumberIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: $phoneNumber"))
                startActivity(dialNumberIntent)
            }
            R.id.btn_move_for_result->{
                val moveForResultIntent = Intent(this@MainActivity, MoveForResultActivity::class.java)
                startActivityForResult(moveForResultIntent, REQUEST)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST){
            if(resultCode == MoveForResultActivity.RESULT_CODE){
                val selectedValue = data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
                tvResult.text = "Hasil : $selectedValue"
            }
        }
    }
}