/*

package org.usfirst.frc.team319.robot.commands.wristcollectorvisionstuff;

import org.usfirst.frc.team319.robot.Robot;
import org.usfirst.frc.team319.utils.BobDriveHelper;

import edu.wpi.first.wpilibj.command.Command;


public class CollectWhenInRange extends Command {
	
	int collectPosition = Robot.wrist.getCollectPosition();
	private double toClose = 3;
	private double toFar = 5;
	
	BobDriveHelper helper;

    public CollectWhenInRange() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.wrist);
        requires(Robot.collector);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double area = Robot.vision.returnArea();
    	
    	if(area > toClose && area < toFar) {
    	Robot.wrist.setTargetPosition(collectPosition);
    	}

    	
    	
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
*/