package com.example.foodiepal.ui.blogs

import CommentListAdapter
import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodiepal.R
import com.example.foodiepal.adapter.BlogListAdapter
import com.example.foodiepal.databinding.FragmentBlogsBinding
import java.time.LocalDateTime

class BlogFragment : Fragment() {

    private var _binding: FragmentBlogsBinding? = null

    private lateinit var sharedPreferences: SharedPreferences

    private val blogList = mutableListOf<BlogDataModel>(
        BlogDataModel(
            "Some title 1",
            "Keanu Reaves",
            "The 2021 models had a vast range of reviews feeling that the already powerful processor was made excessively powerful, stating that the processor wasn't being taken advantage of due to iPadOS still being considered too limiting and not having professional apps from macOS.[63][64] Camera placement has been criticized for video conferencing.[65] The Verge has criticized that they should have had multiuser support like the Mac but they gave positive reviews to the Mini-LED and cameras.",
            mutableListOf<CommentDataModel>(
                CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ), CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ), CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ), CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ), CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ), CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ), CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                )
            )
        ),
        BlogDataModel(
            "Some title 2",
            "Gordon Ramsay",
            "The 2021 models had a vast range of reviews feeling that the already powerful processor was made excessively powerful, stating that the processor wasn't being taken advantage of due to iPadOS still being considered too limiting and not having professional apps from macOS.[63][64] Camera placement has been criticized for video conferencing.[65] The Verge has criticized that they should have had multiuser support like the Mac but they gave positive reviews to the Mini-LED and cameras.",
            mutableListOf<CommentDataModel>(
                CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ),
                CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ),
                CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                ),
                CommentDataModel(
                    "This is just a simple comment",
                    "Sunit Bajracharya",
                    LocalDateTime.now()
                )
            )
        )
    )

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(BlogModel::class.java)

        _binding = FragmentBlogsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        sharedPreferences =
            requireActivity().getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE)

        var recyclerView = binding.blogRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val blogListAdapter = BlogListAdapter(
            requireContext(),
            sharedPreferences.getString("username", null).toString(),
            blogList
        )
        recyclerView.adapter = blogListAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}