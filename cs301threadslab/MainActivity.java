package edu.up.cs301threadslab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

/**
 * This application displays several animations.  It is used for the threads lab in CS371.
 *
 * @author Andrew Nuxoll
 * @version Fall 2015
 */
public class MainActivity extends Activity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    public AnimationView myAV;
    private Button theButton;
    private SeekBar theSeekBar;
    private thread1 t;
    private StarAnimation SA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup the animations
        myAV = findViewById(R.id.animationArea);
        SA = new StarAnimation(myAV.getMyWidth(), myAV.getMyHeight());
        myAV.addAnimation(SA);

        //Let me know when someone taps the button
        theButton = findViewById(R.id.button);
        theButton.setOnClickListener(this);

        //seekBar listener
        theSeekBar = findViewById(R.id.seekBar);
        theSeekBar.setOnSeekBarChangeListener(this);

        t = new thread1(myAV, SA);
        t.start();
    }//onCreate

    @Override
    public void onClick(View v) {
        myAV.postInvalidate();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        myAV.progressChange(seekBar.getProgress());
        myAV.postInvalidate();
    }

    /** These two methods aren't used */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}
}
