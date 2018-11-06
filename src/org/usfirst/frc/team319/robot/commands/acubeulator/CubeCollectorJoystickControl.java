package org.usfirst.frc.team319.robot.commands.acubeulator;

import org.usfirst.frc.team319.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CubeCollectorJoystickControl extends Command {

	public CubeCollectorJoystickControl() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.collector);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.collector.setCubeCollector(ControlMode.PercentOutput, Robot.oi.operatorController.rightStick.getY());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
