// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  // TODO: ADD AND SET CAN ID(s)
  private final int armID = 4;
  // TODO: DECLARE MOTOR (CANSparkMax object)
  private final CANSparkMax m_arm;
  private RelativeEncoder m_encoder;
  // set motor current limits
  private final int ARM_CURRENT_LIMIT = 20;

  // TODO: DEFINE ARM POSITIONS FOR LOW, MEDIUM, HIGH, AND PLATFORM INTAKE
  private int LOW; // change later
  private int MEDIUM; // change later
  private int HIGH; // change later
  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR ARM MOTOR TICKS AND ARM PID
  // public static final
  private int armTarget = 0;

  public Arm() {
    // TODO: Initialize motor controller
    m_arm = new CANSparkMax(armID, MotorType.kBrushless);
    m_encoder = m_arm.getEncoder();

    // TODO: set current limit
    // m_Arm.setSmartCurrentLimit(ARM_CURRENT_LIMIT);
    m_arm.setSmartCurrentLimit(30);
    // TODO: set motor in brake mode so that the motor holds position even when not given a command

    m_arm.setIdleMode(IdleMode.kBrake);
    // TODO: SET MOTOR CONTROLLER PID VALUES
    // example syntax
    // // set PID coefficients
    // m_pidController.setP(kP);
    // m_pidController.setI(kI);
    // m_pidController.setD(kD);
    // m_pidController.setIZone(kIz);
    // m_pidController.setFF(kFF);
    // m_pidController.setOutputRange(kMinOutput, kMaxOutput);

    // // display PID coefficients on SmartDashboard
    // SmartDashboard.putNumber("P Gain", kP);
    // SmartDashboard.putNumber("I Gain", kI);
    // SmartDashboard.putNumber("D Gain", kD);
    // SmartDashboard.putNumber("I Zone", kIz);
    // SmartDashboard.putNumber("Feed Forward", kFF);
    // SmartDashboard.putNumber("Max Output", kMaxOutput);
    // SmartDashboard.putNumber("Min Output", kMinOutput);
    // SmartDashboard.putNumber("Set Rotations", 0);

    // TODO: INITIALIZE SHUFFLEBOARD ENTRIES
  }

  // TODO: ADD MOTOR ACCESSORS FOR SETTING TARGET POSITION
  // Other classes/commands do not have access to the private motor object so you have to make it
  // accessible
  public void setArmTarget(int target) {
    armTarget = target;
  }

  public void getArmPosition() {}
  // TODO: ADD MOTOR ACCESSORS FOR ZEROING MOTOR POWER AND MOTOR ENCODER
  public void stopArmInput() {}

  public void zeroArmEncoder() {}

  // TODO: DETECT IF ARM HAS HIT A HARDSTOP (check motor current)
  public boolean hasHitHardstop() {
    return false; // TODO: placeholder -- replace
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // TODO: UPDATE THE SHUFFLEBOARD ENTRIES
  }
}
