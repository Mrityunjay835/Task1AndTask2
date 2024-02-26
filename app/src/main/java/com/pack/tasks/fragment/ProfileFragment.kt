package com.pack.tasks.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pack.tasks.activity.ActivityCheckBenefits
import com.pack.tasks.activity.ActivityPrivacyPolicy
import com.pack.tasks.activity.ActivityTermAndCondition
import com.pack.tasks.adaptor.ProfileItemAdaptor
import com.pack.tasks.databinding.FragmentProfileBinding
import com.pack.tasks.entities.ListModel
import com.pack.tasks.viewmodel.ProfileViewModel

class ProfileFragment : Fragment(), ProfileItemAdaptor.OnYourInfoItemResponse{

    private lateinit var binding: FragmentProfileBinding
    private var ProfileInfoList = mutableListOf<ListModel>()
    private lateinit var profileAdapter: ProfileItemAdaptor

    private val myViewModel by lazy {
        ViewModelProvider(this).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        myViewModel.getProfileList()

        myViewModel.getProfileListData().observe(viewLifecycleOwner, Observer { newData ->
            ProfileInfoList = newData
            updateRecyclerViews()
        })
    }


    private fun setUpRecyclerView() {
        profileAdapter =
            ProfileItemAdaptor(requireContext(), ProfileInfoList, this)

        binding.rvProfileList.adapter = profileAdapter
    }

    private fun updateRecyclerViews() {
        profileAdapter.updateData(ProfileInfoList)
    }

    override fun onYourItemClickListener(position: Int) {
        when (position) {
            0 -> startActivity(Intent(requireContext(), ActivityCheckBenefits::class.java))
            1 -> startActivity(Intent(requireContext(), ActivityPrivacyPolicy::class.java))
            2 -> startActivity(Intent(requireContext(), ActivityTermAndCondition::class.java))
        }
    }


}
