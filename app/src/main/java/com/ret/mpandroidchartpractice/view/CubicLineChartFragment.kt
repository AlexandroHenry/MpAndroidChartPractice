package com.ret.mpandroidchartpractice.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.ret.mpandroidchartpractice.R
import com.ret.mpandroidchartpractice.databinding.FragmentCubicLineChartBinding
import com.ret.mpandroidchartpractice.databinding.FragmentHomeBinding


class CubicLineChartFragment : Fragment() {
    private var _binding: FragmentCubicLineChartBinding? = null
    private val binding get() = _binding!!

    private val dataList = arrayListOf(
        70800.0, 70900.0, 71000.0, 71200.0, 71200.0, 70900.0,
        71000.0, 70900.0, 71100.0, 71000.0, 71200.0, 71300.0,
        71500.0, 71600.0, 71200.0, 70900.0, 70800.0, 70700.0,
        70800.0, 71000.0
    )

    private lateinit var lineDataSet: LineDataSet

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCubicLineChartBinding.inflate(inflater, container, false)

        with(binding) {
            linearBtn.isChecked = true

            chart1.apply {
                val entryList = arrayListOf<Entry>()

                dataList.forEachIndexed { index, d ->
                    entryList.add(Entry(index.toFloat(), d.toFloat()))
                }

                lineDataSet = LineDataSet(entryList, "Data Set").apply {
                    description.text = "data1"
                    circleRadius = 6.0F
                    circleHoleRadius = 3.0F
                    setCircleColor(ContextCompat.getColor(requireContext(), R.color.blue))
                    circleHoleColor = ContextCompat.getColor(requireContext(), R.color.yellow)
                    valueTextSize = 22.0F
                    valueTextColor = ContextCompat.getColor(requireContext(), R.color.black)
                    lineWidth = 2.0F
                    color = ContextCompat.getColor(requireContext(), R.color.blue)
                }

                data = LineData(listOf(lineDataSet))
                setScaleEnabled(true)
                setPinchZoom(true)
                isDragEnabled = true


                radioGroup.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.linearBtn -> {
                            lineDataSet.apply {
                                mode = LineDataSet.Mode.LINEAR
                                setDrawFilled(false)
                            }
                        }
                        R.id.steppedBtn -> {
                            lineDataSet.apply {
                                mode = LineDataSet.Mode.STEPPED
                                setDrawFilled(false)
                            }
                        }
                        R.id.cubicBezierBtn -> {
                            lineDataSet.apply {
                                mode = LineDataSet.Mode.CUBIC_BEZIER
                                setDrawFilled(true)
                                setFillColor(ContextCompat.getColor(context, R.color.green))
                            }
                        }
                        R.id.horizontalBezierBtn -> {
                            // Gradient 로 채우기
                            binding.chart1.data?.dataSets?.forEach { dataSet ->
                                if (dataSet is LineDataSet) {
                                    dataSet.apply {
                                        mode = LineDataSet.Mode.HORIZONTAL_BEZIER
                                        setDrawFilled(true)
                                        fillDrawable = ContextCompat.getDrawable(requireContext(), R.drawable.gradient)
                                    }
                                }
                            }

                            // Grid
                            binding.chart1.axisRight.setDrawGridLines(false)
                            binding.chart1.axisLeft.setDrawGridLines(false)
                            binding.chart1.xAxis.setDrawGridLines(false)
                        }
                    }
                    binding.chart1.notifyDataSetChanged()
                    binding.chart1.invalidate()
                }
            }
        }

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