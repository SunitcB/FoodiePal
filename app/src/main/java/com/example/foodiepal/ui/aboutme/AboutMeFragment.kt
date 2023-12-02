package com.example.foodiepal.ui.aboutme

import android.content.res.Resources
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.foodiepal.R

class AboutMeFragment : Fragment() {

    companion object {
        fun newInstance() = AboutMeFragment()
    }

    private lateinit var viewModel: AboutMeModel

    private val aboutMeContent = "My culinary journey is a mosaic of diverse influences that have shaped her into the accomplished chef she is today. Growing up in a multicultural environment, I was exposed to a myriad of flavors and cooking techniques from an early age. My grandmother's kitchen, filled with the aromas of traditional spices and the sizzle of simmering pots, became the epicenter of her culinary education.\n" +
    "\n" +
    "My informal training began at home, where I honed the skills under the guidance of seasoned chefs, my mom. However, it travels that truly expanded my culinary horizons. From the bustling street markets of Kathmandu to the quaint flat lands of Texas, I absorbed the essence of each locale, infusing my dishes with a global flair." +
    "\n\n"+
    "One of my favorite recipe is 'Keema Noodles' that encapsulates my love for the Italian spaghetti with the spices of my home country and fresh ingredients. This dish is a medley of spicy szechuan pepper, richness of ground pork and Italian spaghetti." +
    "\n\n"+
    "Another standout in my collection is the 'Saffron-infused Seafood Paella', a nod to my love towards Spanish cuisine. The dish is a harmonious blend of succulent seafood, aromatic saffron, and perfectly cooked rice, reflecting my ways of mastering the art of balance in my creations." +
    "\n\n"+
    "I have a deep respect for ingredients and a commitment to culinary craftsmanship. For me, cooking is not just a task; it's an art form that requires intuition, passion, and an understanding of the cultural stories woven into each dish." +
    "\n\n"+
    "I personally believe in celebrating simplicity and elevating the inherent beauty of each ingredient. My philosophy centers around sustainability, supporting local producers, and minimizing food waste. To me, a well-prepared meal is a symphony of flavors that resonates with the soul, leaving a lasting imprint on the diner's memory."

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_about_me, container, false)
        var aboutMeContentTextView = rootView.findViewById<TextView>(R.id.aboutMeContentTextView)
        aboutMeContentTextView?.setText(aboutMeContent)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AboutMeModel::class.java)
        // TODO: Use the ViewModel
    }

}