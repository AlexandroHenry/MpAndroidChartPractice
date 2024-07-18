package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.data.BubbleData
import com.github.mikephil.charting.data.BubbleDataSet
import com.github.mikephil.charting.data.BubbleEntry
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentBarChartBinding
import com.ret.mpandroidchartpractice.databinding.FragmentBubbleChartBinding
import com.ret.mpandroidchartpractice.databinding.FragmentCandleStickChartBinding

class BubbleChartFragment : Fragment() {
    private var _binding: FragmentBubbleChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBubbleChartBinding.inflate(inflater, container, false)

        setupBubbleChart()

        return binding.root
    }

    fun setupBubbleChart() {
        val entries = ArrayList<BubbleEntry>()
        for (i in 0 until 20) {
            entries.add(BubbleEntry(i.toFloat(), (Math.random() * 100).toFloat(), (Math.random() * 10).toFloat()))
        }

        val bubbleDataSet = BubbleDataSet(entries, "Bubble Data").apply {
            color = ContextCompat.getColor(requireContext(), R.color.red)
            setDrawValues(true)
            valueTextColor = ContextCompat.getColor(requireContext(), R.color.black)
            valueTextSize = 10f
        }

        val data = BubbleData(bubbleDataSet)
        binding.bubbleChart.apply {
            this.data = data
            description.text = "Bubble Chart"
            setPinchZoom(true)
            setDrawGridBackground(false)
            animateY(1500)
            invalidate()
        }
    }
}