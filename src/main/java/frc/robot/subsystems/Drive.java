// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  // Define member variables
  // SET CAN ID(s)
  private final int leftLeadID = 12;
  private final int leftFollowID = 13;
  private final int rightLeadID = 22;
  private final int rightFollowID= 23;

  private final CANSparkMax leftLeadMotor;
  private final CANSparkMax leftFollowMotor;
  private final CANSparkMax rightLeadMotor;
  private final CANSparkMax rightFollowMotor;

  // TODO: find actual values
  public int stallLimit = 60;
  public int freeLimit = 60;
  public double rampTime = 0.5;
  private boolean brakeMode = false;

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
    rightLeadMotor = new CANSparkMax(rightLeadID,MotorType.kBrushless);
    rightFollowMotor = new CANSparkMax(rightFollowID, MotorType.kBrushless);

    leftLeadMotor.setSmartCurrentLimit(stallLimit, freeLimit);
    leftLeadMotor.setOpenLoopRampRate(rampTime);
    rightLeadMotor.setSmartCurrentLimit(stallLimit, freeLimit);
    rightLeadMotor.setOpenLoopRampRate(rampTime);

    // link the control of the two motors together, since they drive one common gearbox
    leftFollowMotor.follow(leftLeadMotor);
    rightFollowMotor.follow(rightLeadMotor);

    // set motor inversion as necessary here! (left side)
    leftFollowMotor.setInverted(true);
    
    if( brakeMode ) { 
      setDriveToBrake(); 
    } else { 
      setDriveToCoast();
    }

    // class that contains all the wpilib control methods
    drivetrain = new DifferentialDrive(leftLeadMotor, rightLeadMotor);
  }

  // add arcade drive accessor; add a speed multiplier for slow mode
  public void arcade(double steer, double fwd, boolean slowMode) {
    if (slowMode == true) {
      drivetrain.arcadeDrive(steer * 0.7, fwd * 0.5);
    } else {
      drivetrain.arcadeDrive(steer, fwd);
    }
    // take a look here for syntax: https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html
  }

  public void setDriveToBrake() {
    brakeMode = true;
    leftLeadMotor.setIdleMode(IdleMode.kBrake);
    leftFollowMotor.setIdleMode(IdleMode.kBrake);
    rightLeadMotor.setIdleMode(IdleMode.kBrake);
    rightFollowMotor.setIdleMode(IdleMode.kBrake);
  }

  public void setDriveToCoast() {
    brakeMode = false;
    leftLeadMotor.setIdleMode(IdleMode.kCoast);
    leftFollowMotor.setIdleMode(IdleMode.kCoast);
    rightLeadMotor.setIdleMode(IdleMode.kCoast);
    rightFollowMotor.setIdleMode(IdleMode.kCoast);
  }

  // public CommandBase toggleBrakeModeCmd() {
  //   return runOnce(
  //       () -> {
  //         if( brakeMode ) { setDriveToCoast(); } else { setDriveToBrake(); }
  //       });
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
