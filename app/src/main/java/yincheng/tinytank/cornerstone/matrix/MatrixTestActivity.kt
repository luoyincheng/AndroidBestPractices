package yincheng.tinytank.cornerstone.matrix

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import yincheng.tinytank.R

class MatrixTestActivity : AppCompatActivity() {
    private var matrixView: MatrixView? = null
    private var mSeekbar: SeekBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matrix)
        matrixView = findViewById(R.id.mv_rotate_test)
        mSeekbar = findViewById(R.id.sb)
        mSeekbar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                matrixView?.rotate(progress)
            }

            //
            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })
    }
}
