package com.example.foodiepal.ui.recipe

import java.io.Serializable

class RecipeDataModel(
    val recipeName: String?,
    val recipeDescription: String?,
    val recipeIngredients: String?,
    val recipeInstructions: String?
) : Serializable