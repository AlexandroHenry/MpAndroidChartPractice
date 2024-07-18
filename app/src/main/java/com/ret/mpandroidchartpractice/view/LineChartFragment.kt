package com.ret.mpandroidchartpractice.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentLineChartBinding
import com.ret.mpandroidchartpractice.viewmodel.LineChartViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LineChartFragment : Fragment() {

    private var _binding: FragmentLineChartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: LineChartViewModel by viewModels()

    private val dataList1 = arrayListOf(
        70800.0, 70900.0, 71000.0, 71200.0, 71200.0, 70900.0,
        71000.0, 70900.0, 71100.0, 71000.0, 71200.0, 71300.0,
        71500.0, 71600.0, 71200.0, 70900.0, 70800.0, 70700.0,
        70800.0, 71000.0
    )

    private val dataList2 = arrayListOf(
        70200.0, 70300.0, 70400.0, 70600.0, 70600.0, 70300.0,
        70400.0, 70300.0, 70500.0, 70400.0, 70600.0, 70700.0,
        70900.0, 71000.0, 70600.0, 70300.0, 70200.0, 70100.0,
        70200.0, 70400.0
    )

    private val dataList3 = arrayListOf(
        71000.0, 71100.0, 71200.0, 71400.0, 71400.0, 71100.0,
        71200.0, 71100.0, 71300.0, 71200.0, 71400.0, 71500.0,
        71700.0, 71800.0, 71400.0, 71100.0, 71000.0, 70900.0,
        71000.0, 71200.0
    )

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLineChartBinding.inflate(inflater, container, false)

        val entryList1 = arrayListOf<Entry>()
        val entryList2 = arrayListOf<Entry>()
        val entryList3 = arrayListOf<Entry>()

        dataList1.forEachIndexed { index, value ->
            entryList1.add(Entry(index.toFloat(), value.toFloat()))
        }

        dataList2.forEachIndexed { index, value ->
            entryList2.add(Entry(index.toFloat(), value.toFloat()))
        }

        dataList3.forEachIndexed { index, value ->
            entryList3.add(Entry(index.toFloat(), value.toFloat()))
        }

        val lineDataSet1 = LineDataSet(entryList1, "Data Set 1").apply {
            color = ContextCompat.getColor(requireContext(), R.color.red)
            lineWidth = 2f
            circleRadius = 5f
            setCircleColor(ContextCompat.getColor(requireContext(), R.color.red))
            valueTextColor = ContextCompat.getColor(requireContext(), R.color.red)
            valueTextSize = 10f
            setDrawFilled(true)
            fillColor = ContextCompat.getColor(requireContext(), R.color.red)
        }

        val lineDataSet2 = LineDataSet(entryList2, "Data Set 2").apply {
            color = ContextCompat.getColor(requireContext(), R.color.green)
            lineWidth = 2f
            circleRadius = 5f
            setCircleColor(ContextCompat.getColor(requireContext(), R.color.green))
            valueTextColor = ContextCompat.getColor(requireContext(), R.color.green)
            valueTextSize = 10f
            setDrawFilled(true)
            fillColor = ContextCompat.getColor(requireContext(), R.color.green)
        }

        val lineDataSet3 = LineDataSet(entryList3, "Data Set 3").apply {
            color = ContextCompat.getColor(requireContext(), R.color.blue)
            lineWidth = 2f
            circleRadius = 5f
            setCircleColor(ContextCompat.getColor(requireContext(), R.color.blue))
            valueTextColor = ContextCompat.getColor(requireContext(), R.color.blue)
            valueTextSize = 10f
            setDrawFilled(true)
            fillColor = ContextCompat.getColor(requireContext(), R.color.blue)
        }

        binding.chart1.apply {

            // 터치한 부분의 값을 얻어내기 (aim 중심 값)
            setOnChartValueSelectedListener(
                object : OnChartValueSelectedListener {
                    override fun onValueSelected(e: Entry?, h: Highlight?) {
                        e?.let {
                                viewModel.setPrice(e.y.toInt().toString())
//                            binding.currentDataValue.text = e.y.toInt().toString()
//                                _priceLiveData.value = e.y.toInt().toString()
                        }
                    }

                    override fun onNothingSelected() {

                    }
                }
            )

            // 손을 땠을 경우 해당 좌표점 에 표시된 aim 이 사라짐
            setOnTouchListener { view, motionEvent ->
                if (motionEvent.action == MotionEvent.ACTION_UP) {
                    highlightValue(null)
                }
                false
            }

            data = LineData(listOf(lineDataSet1, lineDataSet2, lineDataSet3))
            description.text = "Multiple Line Chart"
            isDragEnabled = true
            setScaleEnabled(true)
            setPinchZoom(true)
            xAxis.setDrawGridLines(false)
            axisLeft.setDrawGridLines(false)
            axisRight.isEnabled = false

            // Customizing the legend
            legend.apply {
                form = Legend.LegendForm.LINE
                textSize = 12f
                textColor = Color.BLACK
                verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
                horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
                orientation = Legend.LegendOrientation.HORIZONTAL
                setDrawInside(false)
            }

            animateX(1500)
            animateY(1500)
            invalidate()
        }


        viewModel.priceLiveData.observe(viewLifecycleOwner, Observer {
            binding.currentDataValue.text = it
        })

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}