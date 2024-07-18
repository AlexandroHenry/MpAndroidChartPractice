package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.ScatterData
import com.github.mikephil.charting.data.ScatterDataSet
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentScatterChartBinding

class ScatterChartFragment : Fragment() {
    private var _binding: FragmentScatterChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScatterChartBinding.inflate(inflater, container, false)

        val entries1 = ArrayList<Entry>()
        val entries2 = ArrayList<Entry>()
        val entries3 = ArrayList<Entry>()
        val entries4 = ArrayList<Entry>()

        for (i in 0 until 20) {
            entries1.add(Entry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        for (i in 0 until 20) {
            entries2.add(Entry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        for (i in 0 until 20) {
            entries3.add(Entry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        for (i in 0 until 20) {
            entries4.add(Entry(i.toFloat(), (Math.random() * 100).toFloat()))
        }

        val scatterDataSet1 = ScatterDataSet(entries1, "data1")
        scatterDataSet1.color = ContextCompat.getColor(requireContext(), R.color.red)

        val scatterDataSet2 = ScatterDataSet(entries2, "data2")
        scatterDataSet2.color = ContextCompat.getColor(requireContext(), R.color.orange)

        val scatterDataSet3 = ScatterDataSet(entries3, "data3")
        scatterDataSet3.color = ContextCompat.getColor(requireContext(), R.color.yellow)

        val scatterDataSet4 = ScatterDataSet(entries4, "data4")
        scatterDataSet4.color = ContextCompat.getColor(requireContext(), R.color.green)

        val data = ScatterData(scatterDataSet1, scatterDataSet2, scatterDataSet3, scatterDataSet4)
        binding.scatterChart.data = data

        binding.scatterChart.apply {
            description.text = "Scatter Chart"
            animateY(1500)
            animate()
        }

        return binding.root
    }
}