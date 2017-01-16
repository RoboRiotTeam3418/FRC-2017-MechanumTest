package com.team3418.frc2016;

// import classes used in main robot program
import com.team3418.frc2016.Constants;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;

/**
 * The main robot class, which instantiates all robot parts and helper classes.
 * After initializing all robot parts, the code sets up the autonomous.
 */
public class Robot extends IterativeRobot {
    // Subsystems
	
    // Other parts of the robot
    ControlBoard mControls = ControlBoard.getInstance();
    RobotDrive mDrive = new RobotDrive(Constants.kFrontLeftMotorPWMID, Constants.kRearLeftMotorPWMID, Constants.kFrontRightMotorPWMID, Constants.kRearRightMotorPWMID);
    
	double mNow;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    
    private void stopAllSubsystems(){
	}
    
    private void updateAllSubsystems() {
    }
    
    
    @Override
    public void robotInit() {
    	//set initial wanted states for all subsystems
    	mDrive.setInvertedMotor(MotorType.kFrontLeft, true);
    	mDrive.setInvertedMotor(MotorType.kRearLeft, true);

    	stopAllSubsystems();
    	updateAllSubsystems();
    }
    
    @Override
    public void disabledInit() {
    	stopAllSubsystems();
    	updateAllSubsystems();
    }
    
    @Override
    public void autonomousInit() {
    	stopAllSubsystems();
    	updateAllSubsystems();
    }
    
    @Override
    public void teleopInit() {
    	//set subsystems to state wanted at beginning of teleop
    	stopAllSubsystems();
    	updateAllSubsystems();
    	}
    
    @Override
    public void disabledPeriodic() {
    	
    }
    
    @Override
    public void teleopPeriodic() {
    	//set states of subsystems depending on operator controls or the state of other subsystems
    	
    	mNow = Timer.getFPGATimestamp();
    	
    	
    	    	
    	// simple drive control
    	mDrive.mecanumDrive_Cartesian(-mControls.getXThrottle(),-mControls.getYThrottle(), -mControls.getRotation(), 0);
    	//
    	System.out.println("X (sideways) =" + mControls.getXThrottle());
    	System.out.println("Y (forwards) =" + mControls.getYThrottle());
    	System.out.println("Rotation =" + mControls.getRotation());



    	// update subsystem states
    	updateAllSubsystems();
    	//
    }
    
    @Override
    public void autonomousPeriodic() {
    	
    }
    
    /*
    private void updateDriverFeedback() {
    	
    }
    */
}
