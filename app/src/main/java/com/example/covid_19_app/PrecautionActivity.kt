package com.example.covid_19_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_precaution.*

class PrecautionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)

        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(Model(R.drawable.hand_sanitizer,"Hand Sanitizer","Help in protecting you by preventing the spread of both virus and bacteria."))
        precautionsList.add(Model(R.drawable.hand_wash,"Hand Wash","The practice of hand washing at regular intervals is a must, after coughing or sneezing, when caring for the sick, after using the toilet, before eating, while preparing food and after handling animals or animal waste."))
        precautionsList.add(Model(R.drawable.social_distance,"Social Distance","Is crucial for preventing the spread of contagious illnesses such as COVID-19 (coronavirus). COVID-19 can spread through coughing, sneezing and close contact. By minimizing the amount of close contact we have with others, we reduce our chances of catching the virus and spreading it to our loved ones and within our community."))
        precautionsList.add(Model(R.drawable.stay_home,"Stay Home","For people who test positive for COVID-19: Talk to your health care provider and stay home in isolation. Stay away from others. You can help prevent the spread of COVID-19 by notifying your close contacts that they have been exposed."))
        precautionsList.add(Model(R.drawable.wear_mask,"Wear Mask","prevent the wearer from transmitting the COVID-19 virus to others and may provide some protection to the wearer."))


        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerView.adapter = precautionsAdapter
    }
}