package org.usfirst.frc.team319.robot.autocommands;

import org.usfirst.frc.team319.models.GameState;
import org.usfirst.frc.team319.models.GameState.Side;
import org.usfirst.frc.team319.robot.commands.acubeulator.CubeCollectorSpit;
import org.usfirst.frc.team319.robot.commands.acubeulator.CubeCollectorStop;
import org.usfirst.frc.team319.robot.commands.drivetrain.DrivetrainStop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndTurnToSwitchRightSide extends CommandGroup {

    public DriveAndTurnToSwitchRightSide(GameState gameState) {
        
    	addSequential(new AutoDrive(), 3);
    	if (gameState.mySwitchSide == Side.RIGHT) {
    		addSequential(new TurnInPlace(Side.LEFT), 0.65);
    		addSequential(new AutoDrive(), 0.75);
        	addSequential(new DrivetrainStop());
        	addSequential(new CubeCollectorSpit(-1.0), 1);
        	addSequential(new CubeCollectorStop());
        	
    	}
  
    }
}
