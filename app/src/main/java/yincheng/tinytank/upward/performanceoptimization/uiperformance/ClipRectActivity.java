package yincheng.tinytank.upward.performanceoptimization.uiperformance;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yincheng.tinytank.view.ClipRectView;

public class ClipRectActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new ClipRectView(this));
    }
}
