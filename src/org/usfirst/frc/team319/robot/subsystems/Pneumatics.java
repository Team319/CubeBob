package org.usfirst.frc.team319.robot.subsystems;

import org.usfirst.frc.team319.robot.Robot;
import org.usfirst.frc.team319.robot.pneumatics.CompressorRun;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Pneumatics extends Subsystem {
	public boolean isForkliftDeployed = false;
	
	Compressor compressor = new Compressor(0);

	DoubleSolenoid elevatorShifter = new DoubleSolenoid(0, 1);
	DoubleSolenoid drivetrainShifter = new DoubleSolenoid(2, 3);
	DoubleSolenoid collectorSolenoid = new DoubleSolenoid(5, 4);
	DoubleSolenoid forkliftsolenoid = new DoubleSolenoid(6, 7);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new CompressorRun());
	}

	public void compressorRun() {
		compressor.setClosedLoopControl(true);
	}
	
	public void openCollector() {
		this.collectorSolenoid.set(DoubleSolenoid.Value.kForward);
		Robot.collector.setIsOpen(true);
	}

	public void closeCollector() {
		this.collectorSolenoid.set(DoubleSolenoid.Value.kReverse);
		Robot.collector.setIsOpen(false);
	}
	
	@Override
	public void periodic() {
		
		SmartDashboard.putBoolean("isForkliftDeployed", isForkliftDeployed);	
	}

}
