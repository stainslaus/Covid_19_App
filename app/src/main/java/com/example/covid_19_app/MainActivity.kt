package com.example.covid_19_app
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(
            Model(
                R.drawable.cough,
                "Dry Cough",
                "is a common symptom of COVID-19. But, lots of conditions, like allergies and acid reflux."
            )
        )
        symptomsList.add(
            Model(
                R.drawable.fever,
                "Fever",
                "is a common symptom of COVID-19. A body temperature of 100.4 degrees F or higher is generally seen in people with COVID-19, although some people may feel as though they have fever even though their temperature readings are normal."
            )
        )
        symptomsList.add(
            Model(
                R.drawable.headache,
                "HeadAche",
                "is one of the symptoms that people with covid tend to have, especially those infected with the Omicron strain."
            )
        )
        symptomsList.add(
            Model(
                R.drawable.sore_throat,
                "Sore Throat",
                "is an early symptom of COVID, affecting about half of people who have the illness."
            )
        )
        symptomsList.add(
            Model(
                R.drawable.fatigue,
                "Fatigue",
                "is more than just tiredness and can make you feel completely drained, exhausted, and generally unwell, which is common when your body is fighting a viral infection."
            )
        )
        symptomsList.add(
            Model(
                R.drawable.vomiting,
                "Vomiting",
                "COVID can affect all your body's systems, including your neurological system and your digestive system, resulting in gastrointestinal issues like nausea or vomiting."
            )
        )
        symptomsList.add(
            Model(
                R.drawable.running_nose,
                "Running Nose",
                "s one of the most commonly reported symptoms of the omicron variant."
            )
        )

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter

        recyclerViewPrecautions.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(
            Model(
                R.drawable.hand_sanitizer,
                "Hand Sanitizer",
                "Help in protecting you by preventing the spread of both virus and bacteria."
            )
        )
        precautionsList.add(
            Model(
                R.drawable.hand_wash,
                "Hand Wash",
                "The practice of hand washing at regular intervals is a must, after coughing or sneezing, when caring for the sick, after using the toilet, before eating, while preparing food and after handling animals or animal waste."
            )
        )
        precautionsList.add(
            Model(
                R.drawable.social_distance,
                "Social Distance",
                "Is crucial for preventing the spread of contagious illnesses such as COVID-19 (coronavirus). COVID-19 can spread through coughing, sneezing and close contact. By minimizing the amount of close contact we have with others, we reduce our chances of catching the virus and spreading it to our loved ones and within our community."
            )
        )
        precautionsList.add(
            Model(
                R.drawable.stay_home,
                "Stay Home",
                "For people who test positive for COVID-19: Talk to your health care provider and stay home in isolation. Stay away from others. You can help prevent the spread of COVID-19 by notifying your close contacts that they have been exposed."
            )
        )
        precautionsList.add(
            Model(
                R.drawable.wear_mask,
                "Wear Mask",
                "prevent the wearer from transmitting the COVID-19 virus to others and may provide some protection to the wearer."
            )
        )


        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerView.adapter = precautionsAdapter


        txtViewSymptoms.setOnClickListener {
            val intent = Intent(this@MainActivity, SymptomsActivity::class.java)
            startActivity(intent)
        }

        btnKnowMore.setOnClickListener {
            val intent = Intent(this@MainActivity, KnowMoreActivity::class.java)
            startActivity(intent)
        }

        txtViewPrecautions.setOnClickListener {
            val intent = Intent(this@MainActivity, PrecautionActivity::class.java)
            startActivity(intent)
        }

        getMalawiData()
    }

    private  fun getMalawiData(){
        val url="https://github.com/stanulilic/mwcovid-api"

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {

                val jsonObject = JSONObject(it.toString())

                //now set values in textview
                txtConfirmed_cases.text = jsonObject.getString("cases")
                txtRecovered.text = jsonObject.getString("recovered")
                txtDeaths.text = jsonObject.getString("deaths")

            },
            {
                Toast.makeText(this@MainActivity,it.toString(),Toast.LENGTH_LONG).show()
                txtConfirmed_cases.text = "-"
                txtRecovered.text = "-"
                txtDeaths.text = "-"

            }
        )
        val requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)




    }
}