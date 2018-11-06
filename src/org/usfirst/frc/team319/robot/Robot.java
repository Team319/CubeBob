
package org.usfirst.frc.team319.robot;

import org.usfirst.frc.team319.robot.subsystems.Drivetrain;
import org.usfirst.frc.team319.robot.subsystems.Pneumatics;
import org.usfirst.frc.team319.robot.subsystems.Wrist;
import org.usfirst.frc.team319.robot.subsystems.Acubeulator;
import org.usfirst.frc.team319.robot.subsystems.Collector;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
    
	Command autonomousCommand;
	SendableChooser<String> autoChooser;

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Acubeulator acubeulator = new Acubeulator();
	public static final Wrist wrist = new Wrist();
	public static final Collector collector = new Collector();
	public static final Pneumatics pneumatics = new Pneumatics();
	
	public static OI oi;
	
	


	@Override
	public void robotInit() {
		
		oi = new OI();


		autoChooser = new SendableChooser<String>();
		autoChooser.addDefault("Example Auto", "Example Auto");
		SmartDashboard.putData("Autonomous Chooser", autoChooser);
		
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		//SmartDashboard.putNumber("Driver Left Trigger", Robot.oi.driverController.triggers.getLeft());
		//SmartDashboard.putNumber("Operator Left Stick Y", Robot.oi.operatorController.leftStick.getY());
	}

	@Override
	public void autonomousInit() {

		}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		drivetrain.returnLimelight();


	}

	@Override
	public void testPeriodic() {
	}
}
