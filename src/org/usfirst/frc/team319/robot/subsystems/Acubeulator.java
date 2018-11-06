package org.usfirst.frc.team319.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Acubeulator extends Subsystem {
	
	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");

	public double x;
	public double y;
	public double area;

	
	public Acubeulator() {

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
	
	public void returnLimelight() {
		double x = tx.getDouble(0);
		double y = ty.getDouble(0);
		double area = ta.getDouble(0);

		this.x = x;
		this.y = y;
		this.area = area;
	}
	
	public double collect() {
		double collectValue;
		if (area < 50.0 && area > 40.0) {
			collectValue = -0.1 / area;
		} else {
			collectValue = 0.0;
		}
		return collectValue;
	}


	public void initDefaultCommand() {
	}

	@Override
	public void periodic() {
	}

}
