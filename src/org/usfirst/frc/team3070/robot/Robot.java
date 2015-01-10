
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final double TAL_SPEED = 0.75;
	// Must be set to the correct value.  
	private static final double VOLTS_TO_INCHES = 1;
	
	private AnalogInput ultraSonic;
	private Talon talLeft;
	private Talon talRight;
	private Gyro gyro;
	
	private Timer timer;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {
    	ultraSonic = new AnalogInput(0);
    	talLeft = new Talon(1);
    	talRight = new Talon(0);
    	gyro = new Gyro(0);
    	
    	timer = new Timer();
    }
    
    public void autonomousInit()
    {
    	timer.reset();
    	timer.start();
    	
    	gyro.reset();
    }

    public void autonomousPeriodic()
    {
    	double voltage = ultraSonic.getVoltage();
    	if(getDistanceFromVoltage(voltage) > 1000000) {
    		turnLeft();
    	}else {
    		moveForward();
    	}
    	
    	if(timer.get() > 500) {
    		System.out.println(gyro.getAngle());
    		timer.reset();
    	}
    }
    
    private void turnLeft()
    {
    	talLeft.set(-TAL_SPEED);
    	talRight.set(TAL_SPEED);
    }
    
    private void moveForward()
    {
    	talLeft.set(TAL_SPEED);
    	talRight.set(TAL_SPEED);
    }

    public void teleopPeriodic() {
        
    }
    
    public void testPeriodic() {
    
    }
    
    public void disabledInit()
    {
    	timer.stop();
    	gyro.reset();
    }
    
    /*
     * This method is to be used if the ultrasonic sensor is plugged into an
     * analog input and not a digital one.  I don't know why we would do such
     * a thing
     */
    private double getDistanceFromVoltage(double voltage)
    {
    	return voltage * VOLTS_TO_INCHES;
    }

}
