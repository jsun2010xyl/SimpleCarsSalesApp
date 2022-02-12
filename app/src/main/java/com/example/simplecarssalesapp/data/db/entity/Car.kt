package com.example.simplecarssalesapp.data.db.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cars")
data class Car(

    @SerializedName("photo")
    val photo: String,

    @SerializedName("bodytype")
    val bodytype: String,
    @SerializedName("currentPrice")
    val currentPrice: Double,
    //@SerializedName("")
    //val dealer: Dealer,
    @SerializedName("drivetype")
    val drivetype: String,
    @SerializedName("engine")
    val engine: String,
    @SerializedName("exteriorColor")
    val exteriorColor: String,
    //@SerializedName("images")
    //val images: Images,
    @SerializedName("interiorColor")
    val interiorColor: String,
    @SerializedName("make")
    val make: String,
    @SerializedName("mileage")
    val mileage: Int,
    @SerializedName("model")
    val model: String,
    @SerializedName("transmission")
    val transmission: String,
    @SerializedName("trim")
    val trim: String,
    @SerializedName("vin")
    @PrimaryKey
    val vin: String,
    @SerializedName("year")
    val year: Int,

    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,

    @SerializedName("phone")
    val phone: String


)
