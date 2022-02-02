package com.example.covid_19_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(Model(R.drawable.cough,"Dry Cough", "is a common symptom of COVID-19. But, lots of conditions, like allergies and acid reflux."))
        symptomsList.add(Model(R.drawable.fever,"Fever","is a common symptom of COVID-19. A body temperature of 100.4 degrees F or higher is generally seen in people with COVID-19, although some people may feel as though they have fever even though their temperature readings are normal."))
        symptomsList.add(Model(R.drawable.headache,"HeadAche","is one of the symptoms that people with covid tend to have, especially those infected with the Omicron strain."))
        symptomsList.add(Model(R.drawable.sore_throat,"Sore Throat","is an early symptom of COVID, affecting about half of people who have the illness."))
        symptomsList.add(Model(R.drawable.fatigue,"Fatigue","is more than just tiredness and can make you feel completely drained, exhausted, and generally unwell, which is common when your body is fighting a viral infection."))
        symptomsList.add(Model(R.drawable.vomiting,"Vomiting","COVID can affect all your body's systems, including your neurological system and your digestive system, resulting in gastrointestinal issues like nausea or vomiting."))
        symptomsList.add(Model(R.drawable.running_nose,"Running Nose","s one of the most commonly reported symptoms of the omicron variant."))
        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter
    }
}