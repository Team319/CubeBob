package org.usfirst.frc.team319.robot.autocommands;

import org.usfirst.frc.team319.models.GameState.Side;
import org.usfirst.frc.team319.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnInPlace extends Command {
	
	private Side _side = Side.RIGHT;

    public TurnInPlace(Side side) {
    	_side = side;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(_side == Side.RIGHT) {
    		Robot.drivetrain.drive(ControlMode.PercentOutput, 0.3, -0.3);
    	}else if (_side == Side.LEFT) {
    		Robot.drivetrain.drive(ControlMode.PercentOutput, -0.3, 0.3);
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
