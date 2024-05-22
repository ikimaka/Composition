package com.ikimaka.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ikimaka.composition.R
import com.ikimaka.composition.databinding.FragmentGameBinding
import com.ikimaka.composition.domain.entity.GameResult
import com.ikimaka.composition.domain.entity.GameSettings
import com.ikimaka.composition.domain.entity.Level

class GameFragment: Fragment() {

    private lateinit var level: Level

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == nul")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvOption1.setOnClickListener {
                launchGameFinishedFragment(
                    GameResult(
                        true,
                        0,
                        0,
                        GameSettings(0, 0, 0, 0)
                    )
                )
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun parseArgs() {
        requireArguments().getParcelable(KEY_LEVEL, Level::class.java)?.let {
            level = it
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }


    companion object {
        private const val KEY_LEVEL = "level"
        const val NAME = "GameFragment"
        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }
}