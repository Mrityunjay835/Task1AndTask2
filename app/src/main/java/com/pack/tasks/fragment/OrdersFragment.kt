package com.pack.tasks.fragment

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pack.tasks.R
import com.pack.tasks.activity.ActivityPayment
import com.pack.tasks.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {
    lateinit var binding:FragmentOrdersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOrdersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGoToPayment.setOnClickListener{
            startActivity(Intent(requireContext(),ActivityPayment::class.java))
        }
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrdersFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}