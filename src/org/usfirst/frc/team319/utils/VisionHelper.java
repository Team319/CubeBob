package org.usfirst.frc.team319.utils;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VisionHelper extends Subsystem {

	NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
	NetworkTableEntry tx = table.getEntry("tx");
	NetworkTableEntry ty = table.getEntry("ty");
	NetworkTableEntry ta = table.getEntry("ta");

	public double x;
	public double y;
	public double area;

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
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
