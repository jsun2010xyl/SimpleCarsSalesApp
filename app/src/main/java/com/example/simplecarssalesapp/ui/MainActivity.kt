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
                    // TODO
                    val intent = Intent(context, CarDetailActivity::class.java).apply {
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