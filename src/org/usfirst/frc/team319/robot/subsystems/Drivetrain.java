package org.usfirst.frc.team319.robot.subsystems;

import org.usfirst.frc.team319.models.BobTalonSRX;
import org.usfirst.frc.team319.models.DriveSignal;
import org.usfirst.frc.team319.models.LeaderBobTalonSRX;
import org.usfirst.frc.team319.models.SRXGains;
import org.usfirst.frc.team319.robot.commands.drivetrain.BobDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drivetrain extends Subsystem {

	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");

	public double x;
	public double y;
	public double area;

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

	}

	public double getVisionX() {
		return this.x;
	}

	public double getVisionY() {
		return this.y;
	}

	public double getVisionArea() {
		return this.area;
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

	public void returnLimelight() {
		double x = tx.getDouble(0);
		double y = ty.getDouble(0);
		double area = ta.getDouble(0);

		this.x = x;
		this.y = y;
		this.area = area;
	}

	public double returnX() {
		return this.x;
	}

	public double returnY() {
		return this.y;
	}

	public double returnArea() {
		return this.area;
	}

	public double track() {
		double moveValue;
		if (area < 90.0 && area > 0.0) {
			moveValue = -0.3 / area;
		} else {
			moveValue = 0.0;
		}
		return moveValue;
	}
	


	@Override
	public void periodic() {
		SmartDashboard.putNumber("X", returnX());
		SmartDashboard.putNumber("Area", returnArea());
	}

}
