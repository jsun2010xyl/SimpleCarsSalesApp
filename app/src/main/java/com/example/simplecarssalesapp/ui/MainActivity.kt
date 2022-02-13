package com.example.simplecarssalesapp.ui

import android.os.Bundle
import com.example.simplecarssalesapp.R
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CarViewModel::class.java)

        bindUI(this)

    }

    private fun bindUI(context: Context) = launch(Dispatchers.Main) {
        val carList = viewModel.carList.await()
        carList.observe(this@MainActivity, Observer {
            if (it == null) {
                return@Observer
            }

            // getting the recyclerview by its id
            recyclerview = findViewById(R.id.recyclerview)
            adapter = CustomAdapter(it,
                { position -> onListItemClick(position) },
                { position -> onCallButtonClick(position)})
            // Setting the Adapter with the recyclerview
            recyclerview.adapter = adapter
            recyclerview.layoutManager = LinearLayoutManager(context)
        })
    }

    private fun onListItemClick(position: Int) {

        val intent = Intent(this, CarDetailActivity::class.java).apply {
        }
        startActivity(intent)
    }

    private fun onCallButtonClick(position: Int) {
        // TODO : make a call

    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}