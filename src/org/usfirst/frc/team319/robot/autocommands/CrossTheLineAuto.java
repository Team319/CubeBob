package org.usfirst.frc.team319.robot.autocommands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossTheLineAuto extends CommandGroup {

    public CrossTheLineAuto() {
        
    	addSequential(new AutoDrive(), 3);
    	
    }
}
