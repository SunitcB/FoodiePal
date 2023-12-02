package com.example.foodiepal.ui.contacts

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.foodiepal.R

class ContactsFragment : Fragment() {

    companion object {
        fun newInstance() = ContactsFragment()
    }

    private lateinit var viewModel: ContactsModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_contacts, container, false)
        val phoneCardView = rootView?.findViewById<CardView>(R.id.phoneCardView)
        val emailCardView = rootView?.findViewById<CardView>(R.id.emailCardView)
        val phoneTextView = rootView?.findViewById<TextView>(R.id.phoneTextView)
        val emailTextView = rootView?.findViewById<TextView>(R.id.emailTextView)
        val fbImageView = rootView?.findViewById<ImageView>(R.id.facebookImageView)
        val igImageView = rootView?.findViewById<ImageView>(R.id.igImageView)
        val txImageView = rootView?.findViewById<ImageView>(R.id.twitterxImageView)
        val websiteImageView = rootView?.findViewById<ImageView>(R.id.websiteImageView)

        phoneCardView?.setOnClickListener {
            val phoneNumber = phoneTextView?.text.toString()
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialIntent)
        }

        emailCardView?.setOnClickListener {
            val emailAddress = emailTextView?.text.toString()
            val mailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$emailAddress"))
            startActivity(mailIntent)
        }

        fbImageView?.setOnClickListener {
            var fbProfileName = fbImageView?.contentDescription.toString()
            openFacebookProfile(fbProfileName)
        }

        igImageView?.setOnClickListener {
            var igProfileName = igImageView?.contentDescription.toString()
            openInstagramProfile(igProfileName)
        }

        txImageView?.setOnClickListener {
            var txProfileName = txImageView?.contentDescription.toString()
            openTwitterXProfile(txProfileName)
        }

        websiteImageView?.setOnClickListener {
            var website = websiteImageView?.contentDescription.toString()
            openPortfolioWebsite(website)
        }

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContactsModel::class.java)
    }

    fun openFacebookProfile(fbProfileName: String) {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/$fbProfileName")
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openInstagramProfile(igProfileName: String) {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/$igProfileName")
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openTwitterXProfile(txProfileName: String) {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.twitter.com/$txProfileName")
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun openPortfolioWebsite(website: String) {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(website)
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}