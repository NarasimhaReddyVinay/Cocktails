package com.example.cocktail.model


import com.google.gson.annotations.SerializedName

data class Drink(
    @SerializedName("dateModified")
    val dateModified: String? = "",
    @SerializedName("idDrink")
    val idDrink: String? = "",
    @SerializedName("strAlcoholic")
    val strAlcoholic: String? = "",
    @SerializedName("strCategory")
    val strCategory: String? = "",
    @SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: String? = "",
    @SerializedName("strDrink")
    val strDrink: String? = "",
    @SerializedName("strDrinkAlternate")
    val strDrinkAlternate: Any? = Any(),
    @SerializedName("strDrinkThumb")
    val strDrinkThumb: String? = "",
    @SerializedName("strGlass")
    val strGlass: String? = "",
    @SerializedName("strIBA")
    val strIBA: String? = "",
    @SerializedName("strImageAttribution")
    val strImageAttribution: String? = "",
    @SerializedName("strImageSource")
    val strImageSource: String? = "",
    @SerializedName("strIngredient1")
    val strIngredient1: String? = "",
    @SerializedName("strIngredient10")
    val strIngredient10: Any? = Any(),
    @SerializedName("strIngredient11")
    val strIngredient11: Any? = Any(),
    @SerializedName("strIngredient12")
    val strIngredient12: Any? = Any(),
    @SerializedName("strIngredient13")
    val strIngredient13: Any? = Any(),
    @SerializedName("strIngredient14")
    val strIngredient14: Any? = Any(),
    @SerializedName("strIngredient15")
    val strIngredient15: Any? = Any(),
    @SerializedName("strIngredient2")
    val strIngredient2: String? = "",
    @SerializedName("strIngredient3")
    val strIngredient3: String? = "",
    @SerializedName("strIngredient4")
    val strIngredient4: String? = "",
    @SerializedName("strIngredient5")
    val strIngredient5: String? = "",
    @SerializedName("strIngredient6")
    val strIngredient6: String? = "",
    @SerializedName("strIngredient7")
    val strIngredient7: String? = "",
    @SerializedName("strIngredient8")
    val strIngredient8: Any? = Any(),
    @SerializedName("strIngredient9")
    val strIngredient9: Any? = Any(),
    @SerializedName("strInstructions")
    val strInstructions: String? = "",
    @SerializedName("strInstructionsDE")
    val strInstructionsDE: String? = "",
    @SerializedName("strInstructionsES")
    val strInstructionsES: Any? = Any(),
    @SerializedName("strInstructionsFR")
    val strInstructionsFR: Any? = Any(),
    @SerializedName("strInstructionsIT")
    val strInstructionsIT: String? = "",
    @SerializedName("strInstructionsZH-HANS")
    val strInstructionsZHHANS: Any? = Any(),
    @SerializedName("strInstructionsZH-HANT")
    val strInstructionsZHHANT: Any? = Any(),
    @SerializedName("strMeasure1")
    val strMeasure1: String? = "",
    @SerializedName("strMeasure10")
    val strMeasure10: Any? = Any(),
    @SerializedName("strMeasure11")
    val strMeasure11: Any? = Any(),
    @SerializedName("strMeasure12")
    val strMeasure12: Any? = Any(),
    @SerializedName("strMeasure13")
    val strMeasure13: Any? = Any(),
    @SerializedName("strMeasure14")
    val strMeasure14: Any? = Any(),
    @SerializedName("strMeasure15")
    val strMeasure15: Any? = Any(),
    @SerializedName("strMeasure2")
    val strMeasure2: String? = "",
    @SerializedName("strMeasure3")
    val strMeasure3: String? = "",
    @SerializedName("strMeasure4")
    val strMeasure4: String? = "",
    @SerializedName("strMeasure5")
    val strMeasure5: String? = "",
    @SerializedName("strMeasure6")
    val strMeasure6: String? = "",
    @SerializedName("strMeasure7")
    val strMeasure7: String? = "",
    @SerializedName("strMeasure8")
    val strMeasure8: Any? = Any(),
    @SerializedName("strMeasure9")
    val strMeasure9: Any? = Any(),
    @SerializedName("strTags")
    val strTags: String? = "",
    @SerializedName("strVideo")
    val strVideo: Any? = Any()
)