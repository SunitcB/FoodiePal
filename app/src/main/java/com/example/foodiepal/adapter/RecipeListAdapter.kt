package com.example.foodiepal.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal.R
import com.example.foodiepal.activities.RecipeDetailsActivity
import com.example.foodiepal.ui.recipe.RecipeDataModel
import java.text.DecimalFormat

class RecipeListAdapter(
    private val context: Context,
    private val recipeList: List<RecipeDataModel>
) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeCardView = itemView.findViewById<CardView>(R.id.recipeCardView)
        val foodAvatar = itemView.findViewById<Button>(R.id.foodAvatar)
        val recipeNameView = itemView.findViewById<TextView>(R.id.recipeNameView)
        val recipeDescriptionView = itemView.findViewById<TextView>(R.id.recipeDescriptionView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recipe_list, parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        var recipeObj = recipeList[position]
        holder.recipeNameView.text = recipeObj.recipeName
        var productDesc = recipeObj.recipeDescription.toString()
        if (productDesc.length > 150) {
            productDesc = productDesc.substring(0, 150) + "..."
        }
        holder.recipeDescriptionView.text = productDesc

        val foodInitials = recipeObj.recipeName.toString()
            .split(' ')
            .take(2)
            .mapNotNull { it.firstOrNull()?.toString() }
            .reduce { acc, s -> acc + s }

        holder.foodAvatar.setText(foodInitials)

        holder.recipeCardView.setOnClickListener {
            val intent = Intent(context, RecipeDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("RECIPE_OBJECT", recipeObj)
            intent.putExtras(bundle)
            ContextCompat.startActivity(context, intent, null)
        }
    }
}