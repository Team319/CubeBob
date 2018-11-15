
package org.usfirst.frc.team319.robot;

import org.usfirst.frc.team319.robot.subsystems.Drivetrain;
import org.usfirst.frc.team319.robot.subsystems.Pneumatics;
import org.usfirst.frc.team319.robot.subsystems.Wrist;
import org.usfirst.frc.team319.models.GameState;
import org.usfirst.frc.team319.robot.autocommands.CrossTheLineAuto;
import org.usfirst.frc.team319.robot.autocommands.DoNothing;
import org.usfirst.frc.team319.robot.autocommands.DriveAndTurnToSwitchLeftSide;
import org.usfirst.frc.team319.robot.autocommands.DriveAndTurnToSwitchRightSide;
import org.usfirst.frc.team319.robot.commands.vision.VisionHelper;
import org.usfirst.frc.team319.robot.subsystems.Acubeulator;
import org.usfirst.frc.team319.robot.subsystems.Collector;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

	Command autonomousCommand;
	SendableChooser<String> autoChooser;
	GameState gameState;

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Acubeulator acubeulator = new Acubeulator();
	public static final Wrist wrist = new Wrist();
	public static final Collector collector = new Collector();
	public static final Pneumatics pneumatics = new Pneumatics();
	public static final VisionHelper vision = new VisionHelper();
	public static OI oi;

	@Override
	public void robotInit() {

		oi = new OI();

		autoChooser = new SendableChooser<String>();
		autoChooser.addDefault("Cross The Line", "CrossTheLine");
		autoChooser.addObject("Do Nothing", "DoNothing");
		autoChooser.addObject("Left SIde Switch Auto", "DriveAndTurnToSwitchLeftSide");
		autoChooser.addObject("Right Side Switch Auto", "DriveAndTurnToSwitchRightSide");
		SmartDashboard.putData("Autonomous Chooser", autoChooser);

	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		Robot.wrist.setTargetPosition(wrist.getCurrentPosition());
		this.gameState = new GameState(DriverStation.getInstance().getGameSpecificMessage());
		// System.out.println(Robot.wrist.getCurrentPosition());
		// SmartDashboard.putNumber("Driver Left Trigger",
		// Robot.oi.driverController.triggers.getLeft());
		// SmartDashboard.putNumber("Operator Left Stick Y",
		// Robot.oi.operatorController.leftStick.getY());
	}

	@Override
	public void autonomousInit() {
		
		String selectedAuto = (String) autoChooser.getSelected();

		switch (selectedAuto) {
			case "CrossTheLine":
				autonomousCommand = new CrossTheLineAuto();
				break;
			case "DoNothing":
				autonomousCommand = new DoNothing();
				break;
			case "DriveAndTurnToSwitchLeftSide":
				autonomousCommand = new DriveAndTurnToSwitchLeftSide(this.gameState);
				break;
			case "DriveAndTurnToSwitchRightSide":
				autonomousCommand = new DriveAndTurnToSwitchRightSide(this.gameState);
				break;
			default:
				autonomousCommand = new CrossTheLineAuto();
		}
	 	
		//autonomousCommand = new CrossTheLineAuto();
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Area", Robot.vision.getVisionArea());

	}

	@Override
	public void testPeriodic() {
	}
}
