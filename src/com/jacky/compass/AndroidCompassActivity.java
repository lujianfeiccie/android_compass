package com.jacky.compass;

import com.jacky.utilities.MathTool;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class AndroidCompassActivity extends Activity {
    /** Called when the activity is first created. */
	TextView txt_coordinate = null,txt_orientation = null;
	OrientationHandler orientationHandler=null;
	CompassImageView compassRotateView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        compassRotateView = (CompassImageView)findViewById(R.id.view_compass);
        txt_coordinate = (TextView)findViewById(R.id.txt_coordinate);
        txt_orientation = (TextView)findViewById(R.id.txt_orientation);
        orientationHandler = new OrientationHandler(this);
        orientationHandler.setOnMySensorChangedListener(onMySensorChangedListener);
    }
    OnMySensorChangedListener onMySensorChangedListener = new OnMySensorChangedListener() {
		@Override
		public void OnMySensorChanged(float accelX, float accelY, float accelZ) {
			// TODO Auto-generated method stub
			txt_coordinate.setText("("+(int)accelX+","+(int)accelY+","+(int)accelZ+")");
			
			txt_orientation.setText(MathTool.getCurrentOrientation(accelX));
			
			float newAccelX = 360 - accelX;
			
			if(newAccelX==360) newAccelX = 0;
			compassRotateView.updateDirection(newAccelX);
		}
	};
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}
	}
}