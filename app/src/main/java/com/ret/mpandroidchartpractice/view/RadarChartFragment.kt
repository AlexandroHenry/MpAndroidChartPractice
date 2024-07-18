package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.RadarData
import com.github.mikephil.charting.data.RadarDataSet
import com.github.mikephil.charting.data.RadarEntry
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentBubbleChartBinding
import com.ret.mpandroidchartpractice.databinding.FragmentRadarChartBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RadarChartFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RadarChartFragment : Fragment() {
    private var _binding: FragmentRadarChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRadarChartBinding.inflate(inflater, container, false)

        setupRadarChart()

        return binding.root
    }

    fun setupRadarChart() {
        val entries = ArrayList<RadarEntry>()
        for (i in 0 until 6) {
            entries.add(RadarEntry((Math.random() * 100).toFloat()))
        }

        val radarDataSet = RadarDataSet(entries, "Radar Data").apply {
            color = ContextCompat.getColor(requireContext(), R.color.purple)
            fillColor = ContextCompat.getColor(requireContext(), R.color.green)
            setDrawFilled(true)
            valueTextColor = ContextCompat.getColor(requireContext(), R.color.black)
            valueTextSize = 10f
        }

        val data = RadarData(radarDataSet)
        binding.radarChart.apply {
            this.data = data
            description.text = "Radar Chart"
            setDrawWeb(true)
            webLineWidth = 1.5f
            webColor = ContextCompat.getColor(requireContext(), R.color.black)
            webColorInner = ContextCompat.getColor(requireContext(), R.color.blue)
            webLineWidthInner = 1.0f
            webAlpha = 100
            animateY(1500)
            invalidate()
        }
    }

}