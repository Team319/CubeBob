package org.usfirst.frc.team319.robot.pneumatics;

import org.usfirst.frc.team319.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorToggle extends Command {

	public CollectorToggle() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.pneumatics);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.collector.isOpen() == false) {
			Robot.pneumatics.openCollector();
		} else if (Robot.collector.isOpen() == true) {
			Robot.pneumatics.closeCollector();
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
