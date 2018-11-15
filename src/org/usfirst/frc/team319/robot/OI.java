package org.usfirst.frc.team319.robot;

import org.usfirst.frc.team319.controllers.BobXboxController;
import org.usfirst.frc.team319.robot.commands.AutoCollectCubeClosed;
import org.usfirst.frc.team319.robot.commands.AutoCollectCubeOpened;
import org.usfirst.frc.team319.robot.commands.acubeulator.CubeCollectorSpit;
import org.usfirst.frc.team319.robot.commands.acubeulator.CubeCollectorStop;
import org.usfirst.frc.team319.robot.commands.drivetrain.BobDriveTracking;
import org.usfirst.frc.team319.robot.commands.vision.CollectWhenInRange;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToExchange;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToSwitch;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public BobXboxController driverController;
	public BobXboxController operatorController;

	public OI() {

		//Driver Stuff!
		driverController = new BobXboxController(0, 0.20, 0.20);
		driverController.bButton.whenPressed(new CubeCollectorStop());
		
		driverController.rightTriggerButton.whileHeld(new CollectWhenInRange());
		
		driverController.rightTriggerButton.whileHeld(new BobDriveTracking());

		
		
		//Operator Stuff!
		
		operatorController = new BobXboxController(1, 0.20, 0.20);
		
		operatorController.rightBumper.whenPressed(new AutoCollectCubeClosed(true));
		operatorController.leftBumper.whenPressed(new AutoCollectCubeOpened(true));
		
		operatorController.rightTriggerButton.whenPressed(new CubeCollectorSpit());

		operatorController.bButton.whenPressed(new CubeCollectorStop());
		
		operatorController.aButton.whenPressed(new WristGoToExchange());
		operatorController.xButton.whenPressed(new WristGoToSwitch());
		//operatorController.yButton.whenPressed(new WristGoHome());

	}
}