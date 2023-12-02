package com.example.foodiepal.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal.R
import com.example.foodiepal.ui.planner.MealPlannerDataModel
import java.text.DateFormat
import java.time.format.DateTimeFormatter

class MealPlanListAdapter(
    private val context: Context,
    private val mealPlanList: List<MealPlannerDataModel>
) : RecyclerView.Adapter<MealPlanListAdapter.MealPlannerViewHolder>() {

    class MealPlannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.mealPlannerCardView)
        val mealPlannerAvatar = itemView.findViewById<Button>(R.id.mealPlanAvatar)
        val mealPlanDateView = itemView.findViewById<TextView>(R.id.mealPlanDate)
        val mealPlanDetailView = itemView.findViewById<TextView>(R.id.mealPlanDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlannerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.meal_plan_list, parent, false)
        return MealPlanListAdapter.MealPlannerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealPlanList.size
    }

    override fun onBindViewHolder(holder: MealPlannerViewHolder, position: Int) {
        var mealPlanObj = mealPlanList[position]
        var avatarFormat = DateTimeFormatter.ofPattern("MMM\ndd")
        var weekDayFormat = DateTimeFormatter.ofPattern("EEEE")
        var planDate = mealPlanObj.mealDateTime
        holder.mealPlanDateView.text = planDate.format(weekDayFormat).toString()
        holder.mealPlannerAvatar.setText(planDate.format(avatarFormat).toString())
        val planDetails =
            "Breakfast: ${mealPlanObj.breakfastDetails}\nLunch: ${mealPlanObj.lunchDetails}\nDinner: ${mealPlanObj.dinnerDetails}"
        holder.mealPlanDetailView.text = planDetails
    }
}