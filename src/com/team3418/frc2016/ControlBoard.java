package com.team3418.frc2016;

import edu.wpi.first.wpilibj.Joystick;

/**
 * A basic framework for the control board Like the drive code, one instance of
 * the ControlBoard object is created upon startup, then other methods request
 * the singleton ControlBoard instance.
 */
public class ControlBoard {
    private static ControlBoard mInstance = new ControlBoard();

    public static ControlBoard getInstance() {
        return mInstance;
    }
    
    //create joystick object
    private final Joystick mDriverStick;
    
    
    private final double mStickDeadzone = .15;
    
    //initialize joystick objects
    ControlBoard() {
        mDriverStick = new Joystick(0);
    }
    
    
    
    // return button / axis info
    // EXAMPLES
    /*
    
    public double getThrottle() {
        return -mDriverStick.getY();
    }
    
    public double getTurn() {
        return mOperatorStick.getX();
    }
    
    public double getExclusiveOptions() {
        if (mOtherThingie.getRawButton(11)) {
            return 1.0;
        } else if (mOtherThingie.getRawButton(12)) {
            return -1.0;
        } else {
            return 0.0;
        }
    }
    
    public boolean getRawAxisGreaterThan() {
        return mOtherThingie.getRawAxis(3) > 0.1;
    }
    
    public boolean getRawAxisLessThan() {
        return mOtherThingie.getRawAxis(2) < -0.1;
    }
    
    public boolean getButtonCombo() {
        return mOtherThingie.getRawButton(1) && mOtherThingie.getRawButton(2);
    }
    
    */
    
    
    // DRIVER CONTROLS (mDriverStick)
    public double getXThrottle() {
    	double X = mDriverStick.getRawAxis(4);
    	if (X > mStickDeadzone || X < -mStickDeadzone) {
        	return X;
    	}
    	else return 0;
    }
    
    public double getYThrottle() {
    	double Y = mDriverStick.getRawAxis(5);
    	if (Y > mStickDeadzone || Y < -mStickDeadzone) {
        	return Y;
    	}
    	else return 0;
    }
    
    public double getRotation() {
    	double rot = mDriverStick.getRawAxis(0);
    	if (rot > mStickDeadzone || rot < -mStickDeadzone) {
        	return rot;
    	}
    	else return 0;
    }
    
    
    
}
