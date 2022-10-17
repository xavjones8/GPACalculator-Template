package com.example.gpacalculator_master

import ClassDetails
import ClassListAdapter
import ClassRowDetails
import GPACalculator
import SemesterDetails
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.gpacalculator_master.R.*

class SemesterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_semester)


        val btnCalculate = findViewById(R.id.btnCalculateGPA) as Button
        val btnClearForm = findViewById(R.id.btnClearForm) as Button
        val lblProjectedGPA = findViewById(R.id.lblProjectedGPA) as TextView
        val lblCurrentGPA = findViewById(R.id.lblCurrentTotalGPA) as TextView

        val gpa: Double = intent?.extras?.getDouble("GPA")!!
        val currentHours: Int = intent?.extras?.getInt("Hours")!!
        val numberOfClasses: Int = intent?.extras?.getInt("Classes")!!

        lblProjectedGPA.text = "Projected GPA: $gpa"
        lblCurrentGPA.text = "Current GPA: $gpa"


        val class_names = mutableListOf<ClassRowDetails>()

        //Populates list view with number of classes
        for(i in 1..numberOfClasses) {
            class_names.add(ClassRowDetails("Class $i", null, null))
        }

        // TODO: A listview isn't the most efficient way of displaying lists of items in Android. Research recycler views and improve this design.
        val listView: ListView = findViewById(R.id.semester_list)
        val listAdapter = ClassListAdapter(this, class_names)
        listView.adapter = listAdapter


        btnCalculate.setOnClickListener() {

        }

        //TODO: Implement the Clear all button!
        btnClearForm.setOnClickListener {
            Toast.makeText(this, "Complete this method!", Toast.LENGTH_SHORT).show()
        }

    }
}