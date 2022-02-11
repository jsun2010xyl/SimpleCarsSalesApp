package com.example.simplecarssalesapp.data.db.entity


import com.google.gson.annotations.SerializedName

data class RelatedLinks(
    @SerializedName("Fiat 124 Spider Trim Levels")
    val fiat124SpiderTrimLevels: List<Fiat124SpiderTrimLevel>,
    @SerializedName("Similar Cars")
    val similarCars: List<SimilarCar>,
    @SerializedName("Used Fiat 124 Spider by Year")
    val usedFiat124SpiderByYear: List<UsedFiat124SpiderByYear>
)