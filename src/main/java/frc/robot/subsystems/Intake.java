// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // TODO: SET CAN ID
  private final int m_IntakeID = 6;
  // TODO: DECLARE MOTOR (CANSparkMax object)
  private final CANSparkMax m_Intake;
  // set motor current limit
  private static final int INTAKE_CURRENT_LIMIT = 35;

  private int gamePiece = 0; // 0 for cubes, 1 for cones

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER

  public Intake() {
    // TODO: Initialize motor controller
      m_Intake = new CANSparkMax(m_IntakeID, MotorType.kBrushless);
    // TODO: set current limit
    // m_Intake.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);
      m_Intake.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);
    // TODO: set motor in brake mode so that the motor holds position even when not given a command
      m_Intake.setIdleMode(IdleMode.kBrake);
  }

  // TODO: DEFINE & SET POWER TO HOLD CONE OR CUBE IN INTAKE
  // Cubes and cones are fed in from different directions so the roller drive direction will be
  // inverted
  public void setConeHoldPower() {
    m_Intake.set(0.4);
  }

  public void setConeIntakePower() {
    m_Intake.set(0.9);
  }

  public void setConeOuttakePower() {
    m_Intake.set(-0.7);
  }

  public void setCubeHoldPower() {
    m_Intake.set(0);
  }

  public void setCubeIntakePower() {
    m_Intake.set(-0.5);
  }

  public void setCubeOuttakePower() {
    m_Intake.set(0.7);
  }

  public void stopIntake() {
    m_Intake.set(0);
  } // TODO: stop intake (set power to 0)
  // this is only really called by drivers 
  public CommandBase stopIntakeCmd() {
    return runOnce(
        () -> {
          stopIntake();
        });
  }

  public int getGamePieceType() {
    return gamePiece;
  }

  public void setGamePieceType(int setGamePieceInt) {
    gamePiece = setGamePieceInt;
  }

  public boolean hasCone() {
    // TODO: determine if intake has a cone because the current is high
    return false;
  }

  public boolean hasCube() {
    // TODO: determine if intake has a cube because the current is high -- this might be harder to
    // detect
    return false;
  }

  // @Override
  // public void periodic() {
  //   // TODO: update shuffleboard entries
  // }
}
