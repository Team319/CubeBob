package org.usfirst.frc.team319.robot;

import org.usfirst.frc.team319.controllers.BobXboxController;
import org.usfirst.frc.team319.robot.commands.acubeulator.CubeCollectorSpit;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToExchange;
import org.usfirst.frc.team319.robot.commands.wrist.WristGoToSwitch;
import org.usfirst.frc.team319.robot.pneumatics.CollectorToggle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public BobXboxController driverController;
	public BobXboxController operatorController;

	public OI() {

		//Driver Stuff!
		driverController = new BobXboxController(0, 0.20, 0.10);
		
		/*
		driverController.rightTriggerButton.whenPressed(new CollectorToggle());
		driverController.leftTriggerButton.whileHeld(new CubeCollectorSpit());
		
		driverController.aButton.whenPressed(new WristGoToSwitch());
		driverController.bButton.whenPressed(new WristGoToExchange());
		*/
		
		//Operator Stuff!
		
		operatorController = new BobXboxController(0,0.20, 0.10);
		
		operatorController.rightTriggerButton.whenPressed(new CollectorToggle());
		operatorController.leftTriggerButton.whileHeld(new CubeCollectorSpit());
		
		operatorController.aButton.whenPressed(new WristGoToSwitch());
		operatorController.bButton.whenPressed(new WristGoToExchange());

	}
}