package org.usfirst.frc.team319.robot.commands;

import org.usfirst.frc.team319.robot.commands.acubeulator.HoldCube;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToCollectCube;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToSwitch;
import org.usfirst.frc.team319.robot.pneumatics.CloseCollector;
import org.usfirst.frc.team319.robot.pneumatics.OpenCollector;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoCollectCubeOpenedCurrentSensing extends CommandGroup {

	public AutoCollectCubeOpenedCurrentSensing(boolean liftWristAfterCubeCollected) {


		addParallel(new WristGoToCollectCube());
		addParallel(new OpenCollector());
		addSequential(new CloseCollector());

		//addSequential(new CloseCollector());
		addSequential(new WaitCommand(0.2));
		addSequential(new HoldCube());
		
		if (liftWristAfterCubeCollected) {
			addSequential(new WristGoToSwitch());
		}

	}
}