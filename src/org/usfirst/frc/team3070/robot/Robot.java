
package org.usfirst.frc.team3070.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	AnalogInput ultra;
	Gyro gyro;
	Joystick xbox;
	Talon talL;
	Talon talR;
	Encoder enL;
	Encoder enR;
    public void robotInit() {
    	talL = new Talon(0);
    	talR = new Talon(1);
    	ultra = new AnalogInput(0);
    	gyro = new Gyro(1);
    	enL = new Encoder(4,5);
    	enR = new Encoder(2,3);
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        talL.set(xbox.getRawAxis(1)/2);
        talR.set(xbox.getRawAxis(4)/2);
        System.out.println("Left encoder: " + enL.getRate() + " Right encoder: " + enR.getRate());
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
