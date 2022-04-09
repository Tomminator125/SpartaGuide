package com.example.spartaguide3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class LinearSensor extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor linearSensor;
    private float[] velocity = new float[]{0,0,0};
    private float[] position = new float[]{0,0,0};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_sensor);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        linearSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        if (linearSensor != null) {
            sensorManager.registerListener(this, linearSensor,
                    SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION){
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            String sensorValues = ("X: " + x + "Y: " + y + "Z: " + z);
//            velocity[0] += x;
//            velocity[1] += y;
//            velocity[2] += z;
            position[0] += x/2;
            position[1] += y/2;
            position[2] += z/2;
            TextView textview = findViewById(R.id.textView2);
            textview.setText(getPosition());
        }
    }

    private String getPosition(){
        String pos = ("X:" + position[0] + " Y: " + position[1] + " Z: " + position[2]);
        return pos;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        return;
    }

    @Override
    protected void onResume() {
        super.onResume();
        linearSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        if (linearSensor != null) {
            sensorManager.registerListener(this, linearSensor,
                    SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Don't receive any more updates from either sensor.
        sensorManager.unregisterListener(this);
    }
}