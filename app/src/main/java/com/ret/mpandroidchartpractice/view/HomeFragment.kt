package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lineChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_LineChartFragment)
        }

        binding.cubicLineChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_cubicLineChartFragment)
        }

        binding.pieChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_pieFragment)
        }

        binding.barChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_barChartFragment)
        }

        binding.barChartGroupedSetBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_barChartGroupedSetFragment)
        }

        binding.horizontalBarChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_horizontalBarChartFragment)
        }

        binding.combindedChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_combinedChartFragment)
        }

        binding.scatterChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_scatterChartFragment)
        }

        binding.candleStickChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_candleStickChartFragment)
        }

        binding.bubbleChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_bubbleChartFragment)
        }

        binding.radarChartBtn.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_radarChartFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}