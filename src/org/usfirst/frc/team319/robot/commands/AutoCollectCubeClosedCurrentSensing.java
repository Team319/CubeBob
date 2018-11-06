package org.usfirst.frc.team319.robot.commands;

import org.usfirst.frc.team319.robot.commands.acubeulator.CubeCollectorCollectCurrentSensing;
import org.usfirst.frc.team319.robot.commands.acubeulator.HoldCube;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToCollectCube;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToSwitch;
import org.usfirst.frc.team319.robot.pneumatics.CloseCollector;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoCollectCubeClosedCurrentSensing extends CommandGroup {

	public AutoCollectCubeClosedCurrentSensing(boolean liftWristAfterCubeCollected) {

		addParallel(new WristGoToCollectCube());
		addParallel(new CloseCollector());
		addSequential(new CubeCollectorCollectCurrentSensing());
		addSequential(new WaitCommand(0.2));
		addSequential(new HoldCube());
		
		if (liftWristAfterCubeCollected) {
			addSequential(new WristGoToSwitch());
		}

	}
}