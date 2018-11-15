package org.usfirst.frc.team319.robot.subsystems;

import org.usfirst.frc.team319.models.BobTalonSRX;
import org.usfirst.frc.team319.models.DriveSignal;
import org.usfirst.frc.team319.models.LeaderBobTalonSRX;
import org.usfirst.frc.team319.models.SRXGains;
import org.usfirst.frc.team319.robot.Robot;
import org.usfirst.frc.team319.robot.commands.drivetrain.BobDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	public LeaderBobTalonSRX leftLead = new LeaderBobTalonSRX(1, new BobTalonSRX(2), new BobTalonSRX(3),
			new BobTalonSRX(4));
	public LeaderBobTalonSRX rightLead = new LeaderBobTalonSRX(7, new BobTalonSRX(8), new BobTalonSRX(9),
			new BobTalonSRX(6));

	public Drivetrain() {
		leftLead.setInverted(false);
		leftLead.setSensorPhase(false);
		leftLead.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

		rightLead.setInverted(true);
		rightLead.setSensorPhase(true);
		rightLead.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
		
		leftLead.enableCurrentLimit(true);
		leftLead.configContinuousCurrentLimit(30);
		rightLead.enableCurrentLimit(true);
		rightLead.configContinuousCurrentLimit(30);

		//time required to ramp up to speed 
		leftLead.configOpenloopRamp(0.25);
		rightLead.configOpenloopRamp(0.25);

		setNeutralMode(NeutralMode.Coast);

	}


	public void initDefaultCommand() {
		setDefaultCommand(new BobDrive());
	}

	public void configGains(SRXGains gains) {
		this.leftLead.setGains(gains);
		this.rightLead.setGains(gains);
	}

	public void drive(ControlMode controlMode, double left, double right) {
		this.leftLead.set(controlMode, left);
		this.rightLead.set(controlMode, right);
	}

	public void drive(ControlMode controlMode, DriveSignal driveSignal) {
		this.drive(controlMode, driveSignal.getLeft(), driveSignal.getRight());
	}
	
	public void setNeutralMode(NeutralMode neutralMode) {
		this.leftLead.setNeutralMode(neutralMode);
		this.rightLead.setNeutralMode(neutralMode);
	}

	


	@Override
	public void periodic() {

	}

}
