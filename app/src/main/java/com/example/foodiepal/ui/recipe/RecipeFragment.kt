package com.example.foodiepal.ui.recipe

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal.R
import com.example.foodiepal.adapter.RecipeListAdapter
import com.example.foodiepal.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {

    private var _binding: FragmentRecipeBinding? = null

    private val recipeList = mutableListOf<RecipeDataModel>(
        RecipeDataModel(
            "Mango Tango Salad",
            "This refreshing salad is a delightful mix of tropical flavors. Ripe mangoes, creamy avocados, and fresh cilantro come together in a zesty lime dressing.",
            "2 ripe mangoes, diced\n" +
                    "1 ripe avocado, cubed\n" +
                    "1/4 cup fresh cilantro, chopped\n" +
                    "Juice of 2 limes\n" +
                    "Salt and pepper to taste",
            "Combine diced mangoes, cubed avocado, and chopped cilantro in a bowl. In a separate bowl, whisk together lime juice, salt, and pepper. Pour the dressing over the mango-avocado mixture and gently toss. Serve chilled."
        ),
        RecipeDataModel(
            "Saffron-infused Seafood Paella",
            "Transport yourself to the shores of Spain with this aromatic seafood paella. Saffron-infused rice, a medley of fresh seafood, and a symphony of spices create a dish that's as visually stunning as it is delicious.",
            "2 cups Arborio rice\n" +
                    "500g mixed seafood (shrimp, mussels, squid)\n" +
                    "1 teaspoon saffron threads\n" +
                    "1 onion, finely chopped\n" +
                    "3 cloves garlic, minced\n" +
                    "1 teaspoon paprika\n" +
                    "4 cups chicken broth\n" +
                    "Olive oil for cooking",
            "In a paella pan, sauté chopped onions and garlic in olive oil until softened. Add Arborio rice and saffron, stirring to coat the rice. Pour in chicken broth, add paprika, and arrange seafood on top. Cover and simmer until rice is cooked and seafood is done."
        ),
        RecipeDataModel(
            "Sunrise Scramble Wrap",
            "Start your day right with this protein-packed breakfast wrap. Scrambled eggs, sautéed vegetables, and a sprinkle of cheese are wrapped in a tortilla for a quick and wholesome morning meal.",
            "4 large eggs\n" +
                    "1 bell pepper, diced\n" +
                    "1 small onion, chopped\n" +
                    "1/2 cup shredded cheese\n" +
                    "Salt and pepper to taste\n" +
                    "4 whole-grain tortillas",
            "In a pan, sauté diced bell pepper and chopped onion until softened. Whisk eggs, season with salt and pepper, and pour into the pan. Scramble until cooked. Divide the egg mixture among tortillas, sprinkle with cheese, and wrap tightly."
        ),
        RecipeDataModel(
            "Mediterranean Chickpea Salad",
            "A light and vibrant salad inspired by Mediterranean flavors. Chickpeas, cherry tomatoes, cucumber, and feta cheese are tossed in a lemon-herb vinaigrette for a refreshing dish.",
            "1 can chickpeas, drained and rinsed\n" +
                    "1 cup cherry tomatoes, halved\n" +
                    "1 cucumber, diced\n" +
                    "1/2 cup feta cheese, crumbled\n" +
                    "Fresh parsley, chopped\n" +
                    "2 tablespoons olive oil\n" +
                    "Juice of 1 lemon\n" +
                    "Salt and pepper to taste",
            "In a bowl, combine chickpeas, cherry tomatoes, cucumber, and feta cheese. In a small jar, whisk together olive oil, lemon juice, salt, and pepper. Pour the dressing over the salad, add chopped parsley, and toss gently."
        ),
        RecipeDataModel(
            "Balsamic Glazed Chicken with Roasted Vegetables",
            "A savory and sweet delight, this dish features succulent balsamic-glazed chicken paired with a colorful assortment of roasted vegetables.",
            "4 boneless, skinless chicken breasts\n" +
                    "1/2 cup balsamic vinegar\n" +
                    "1/4 cup honey\n" +
                    "2 tablespoons soy sauce\n" +
                    "1 teaspoon Dijon mustard\n" +
                    "1 teaspoon dried thyme\n" +
                    "4 cups mixed vegetables (carrots, bell peppers, zucchini)\n" +
                    "Olive oil for roasting",
            "Preheat the oven to 400°F (200°C). In a bowl, whisk together balsamic vinegar, honey, soy sauce, Dijon mustard, and thyme. Marinate chicken breasts in the mixture for 30 minutes. Place chicken on a baking sheet, surrounded by chopped vegetables. Drizzle with olive oil and roast until chicken is cooked through and vegetables are tender."
        )
    )

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val recipeModel =
            ViewModelProvider(this).get(RecipeModel::class.java)

        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        var addNewRecipeBtn = binding.addNewRecipeBtn
        var recyclerView = binding.recipeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val recipeListAdapter = RecipeListAdapter(requireContext(), recipeList)
        recyclerView.adapter = recipeListAdapter

        addNewRecipeBtn.setOnClickListener {
            val recipeFormBuilder = AlertDialog.Builder(requireContext())
            recipeFormBuilder.setTitle("Add new recipe")

            val recipeFormView = layoutInflater.inflate(R.layout.recipe_form, null)
            recipeFormBuilder.setView(recipeFormView)

            recipeFormBuilder.setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }

            recipeFormBuilder.setPositiveButton("Save Recipe") { dialog, which ->
                val recipeName = recipeFormView.findViewById<EditText>(R.id.recipeNameField)
                val recipeDescription =
                    recipeFormView.findViewById<EditText>(R.id.recipeDescriptionField)
                val recipeIngredients =
                    recipeFormView.findViewById<EditText>(R.id.recipeIngredientsField)
                val recipeInstructions =
                    recipeFormView.findViewById<EditText>(R.id.recipeInstructionField)
                recipeList.add(
                    RecipeDataModel(
                        recipeName.text.toString(),
                        recipeDescription.text.toString(),
                        recipeIngredients.text.toString(),
                        recipeInstructions.text.toString()
                    )
                )
                dialog.dismiss()
                recipeListAdapter.notifyDataSetChanged()
                Toast.makeText(
                    requireContext(),
                    "New recipe for ${recipeName} has been added successfully",
                    Toast.LENGTH_SHORT
                ).show()
            }

            val recipeDialog = recipeFormBuilder.create()
            recipeDialog.show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}