package com.example.simplecarssalesapp.ui

import android.os.Bundle
import com.example.simplecarssalesapp.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplecarssalesapp.data.db.entity.Car
import com.example.simplecarssalesapp.ui.base.ScopedActivity
import com.example.simplecarssalesapp.viewmodels.CarViewModel
import com.example.simplecarssalesapp.viewmodels.CarViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

//class MainActivity : AppCompatActivity() {
class MainActivity : ScopedActivity(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: CarViewModelFactory by instance()

    private lateinit var viewModel: CarViewModel
    private lateinit var recyclerview: RecyclerView
    private lateinit var adapter: CustomAdapter

    private lateinit var carList: LiveData<List<Car>>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CarViewModel::class.java)

        bindUI(this)

    }

    private fun bindUI(context: Context) = launch(Dispatchers.Main) {
        carList = viewModel.carList.await()
        carList.observe(this@MainActivity, Observer {
            if (it == null) {
                return@Observer
            }
            // getting the recyclerview by its id
            recyclerview = findViewById(R.id.recyclerview)
            adapter = CustomAdapter(it,
                { position ->
                    val intent = Intent(context, CarDetailActivity::class.java).apply {
                        putExtra("photo", it[position].photo)
                        putExtra("phone", it[position].phone)
                        putExtra("yearMakeModelTrim",
                            getYearMakeModelTrim(it[position].year, it[position].make,
                                it[position].model, it[position].trim))
                        putExtra("location",
                            getLocation(it[position].city, it[position].state))
                        putExtra("price", it[position].currentPrice)
                        putExtra("mileage", it[position].mileage)
                        putExtra("exteriorColor", it[position].exteriorColor)
                        putExtra("interiorColor", it[position].interiorColor)
                        putExtra("driveType", it[position].drivetype)
                        putExtra("transmission", it[position].transmission)
                        putExtra("bodyStyle", it[position].bodytype)
                        putExtra("engine", it[position].engine)
                        putExtra("fuel", it[position].fuel)
                    }
                    startActivity(intent)
                },
                { position ->
                    dialPhoneNumber(it[position].phone)
                })
            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter
            recyclerview.layoutManager = LinearLayoutManager(context)
        })
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

}