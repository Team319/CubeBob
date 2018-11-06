package org.usfirst.frc.team319.robot.commands.drivetrain;

import org.usfirst.frc.team319.models.DriveSignal;
import org.usfirst.frc.team319.robot.Robot;
import org.usfirst.frc.team319.utils.BobDriveHelper;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BobDriveTracking extends Command {
	
	BobDriveHelper helper;
	private double quickTurnThreshold = 0.2;

    public BobDriveTracking() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        helper = new BobDriveHelper();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = Robot.drivetrain.returnX();
    	
    	double moveValue = Robot.drivetrain.track();
    	//double moveValue = 0.0;
    	
    	double rotateValue = x * 0.01;
    	
    	boolean quickTurn = (moveValue < quickTurnThreshold && moveValue > -quickTurnThreshold);
    	DriveSignal driveSignal = helper.cheesyDrive(-moveValue, rotateValue, quickTurn, false);
    	Robot.drivetrain.drive(ControlMode.PercentOutput, driveSignal);
    	
    	
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
