// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Arm extends SubsystemBase {
  private final CANSparkMax arm;

  // TODO: ADD AND SET CAN ID(s)
  private final int CAN_ID = 5;

  // TODO: DECLARE MOTOR (CANSparkMax object)
  private CANSparkMax spark_motor;
  // set motor current limits
  private final int ARM_CURRENT_LIMIT = 20;

  //private final int low_arm_pos;
  //private final int med_arm_pos;
  //private final int high_arm_pos;

  // TODO: DEFINE ARM POSITIONS FOR LOW, MEDIUM, HIGH, AND PLATFORM INTAKE

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR ARM MOTOR TICKS AND ARM PID

  public Arm() {
    
    arm = new CANSparkMax(CAN_ID, MotorType.kBrushless);
    // TODO: Initialize motor controller

    // TODO: set current limit
    arm.setSmartCurrentLimit(ARM_CURRENT_LIMIT);

    // TODO: set motor in brake mode so that the motor holds position even when not given a command
    arm.setIdleMode(IdleMode.kBrake);

    /* TODO; ARM POSITION CONTROL TASK */
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
     /* END TODO; ARM POSITION CONTROL TASK */
  }

  public void setArmPower(double power) {
    arm.set(power);
  }


  /* TODO; ARM POSITION CONTROL TASK */
  // TODO: ADD MOTOR ACCESSORS FOR SETTING TARGET POSITION
  // Other classes/commands do not have access to the private motor object so you have to make it
  // accessible
  public void setArmTarget() {

    
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
  /* END TODO; ARM POSITION CONTROL TASK */
}
