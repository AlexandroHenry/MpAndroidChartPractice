package com.ret.mpandroidchartpractice.view

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.CandleData
import com.github.mikephil.charting.data.CandleDataSet
import com.github.mikephil.charting.data.CandleEntry
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentBarChartGroupedSetBinding
import com.ret.mpandroidchartpractice.databinding.FragmentCandleStickChartBinding

class CandleStickChartFragment : Fragment() {
    private var _binding: FragmentCandleStickChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCandleStickChartBinding.inflate(inflater, container, false)

        setupCandleStickChart()

        return binding.root
    }

    fun setupCandleStickChart() {
        val entries = ArrayList<CandleEntry>()
        for (i in 0 until 20) {
            val high = (Math.random() * 100).toFloat() + 10
            val low = (Math.random() * 100).toFloat()
            val open = (Math.random() * 100).toFloat()
            val close = (Math.random() * 100).toFloat()
            entries.add(CandleEntry(i.toFloat(), high, low, open, close))
        }

        val candleDataSet = CandleDataSet(entries, "CandleStick Data").apply {
            color = ContextCompat.getColor(requireContext(), R.color.orange)
            shadowColor = ContextCompat.getColor(requireContext(), R.color.black)
            shadowWidth = 1f
            decreasingColor = ContextCompat.getColor(requireContext(), R.color.red)
            decreasingPaintStyle = Paint.Style.FILL
            increasingColor = ContextCompat.getColor(requireContext(), R.color.green)
            increasingPaintStyle = Paint.Style.STROKE
            neutralColor = ContextCompat.getColor(requireContext(), R.color.blue)
            setDrawValues(true)
        }

        val data = CandleData(candleDataSet)
        binding.candleStickChart.apply {
            this.data = data
            description.text = "CandleStick Chart"
            setPinchZoom(true)
            setDrawGridBackground(false)
            animateY(100)
            invalidate()
        }
    }
}