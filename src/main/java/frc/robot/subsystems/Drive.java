// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  // Define member variables
  // TODO: SET CAN ID(s)
  private final int leftLeadID = 12;
  private final int leftFollowID = 13;
  private final int rightLeadMotorID = 22;
  private final int rightFollowID = 23;

  private final CANSparkMax leftLeadMotor;
  private final CANSparkMax leftFollowMotor;

  // TODO: add the right follower for the same for the right side
  private final CANSparkMax rightLeadMotor;
  private final CANSparkMax rightFollowMotor;
  DifferentialDrive drivetrain;

  // For odometry in the future:
  // https://github.wpilib.org/allwpilib/docs/release/java/edu/wpi/first/math/kinematics/DifferentialDriveOdometry.html
  // Add gyro
  // Add the odometry class
  // Add math to translate encoder ticks to linear wheel distance
  // Add an update action to the periodic
  // Add accessors to get the current pose
  // Add setters to reset the current pose

  public Drive() {
    // Initialize or "create" the 2 motor controllers + motors
    leftLeadMotor = new CANSparkMax(leftLeadID, MotorType.kBrushless);
    leftFollowMotor = new CANSparkMax(leftFollowID, MotorType.kBrushless);
    rightLeadMotor = new CANSparkMax(rightLeadMotorID, MotorType.kBrushless);
    rightFollowMotor = new CANSparkMax(rightFollowID, MotorType.kBrushless);

    // link the control of the two motors together, since they drive one common gearbox
    leftFollowMotor.follow(leftLeadMotor);
    rightFollowMotor.follow(rightLeadMotor);
    // TODO: Same for right side

    // class that contains all the wpilib control methods
    drivetrain = new DifferentialDrive(leftLeadMotor, rightLeadMotor);
  }

  public void tank(double left, double right) {
    drivetrain.tankDrive(left, right);
  }

  // TODO: other differential drive modes that can be considered later
  // public void arcade() {}
  // public void curvature() {}

  @Override
  public void periodic() {}
}
