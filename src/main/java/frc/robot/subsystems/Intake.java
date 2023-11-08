// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // TODO: SET CAN ID
  private final int m_IntakeID = 6;
  // TODO: DECLARE MOTOR (CANSparkMax object)
  private CANSparkMax m_intake;
  // set motor current limit
  private static final int INTAKE_CURRENT_LIMIT = 20;
  
  private int gamePiece = 0; // 0 for cubes, 1 for cones

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER

  public Intake() {
    // TODO: Initialize motor controller
    m_intake = new CANSparkMax(m_IntakeID, MotorType.kBrushless);
    // TODO: set current limit
    // m_Intake.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);
    m_intake.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);
    // TODO: set motor in brake mode so that the motor holds position even when not given a command
    m_intake.setIdleMode(IdleMode.kBrake);
  }

  // TODO: DEFINE & SET POWER TO HOLD CONE OR CUBE IN INTAKE
  // Cubes and cones are fed in from different directions so the roller drive direction will be
  // inverted
  public void setHoldConePower() {
    m_intake.set(0.1); 
  }

  public void setConeIntakePower() {
    m_intake.set(0.3);
  }

  public void setConeOuttakePower() {
    m_intake.set(-0.3);
  }

  public void setHoldCubePower() {
    m_intake.set(0.1);
  }

  public void setCubeIntakePower() {
    m_intake.set(0.3);
  }

  public void setCubeOuttakePower() {
    m_intake.set(-0.3);
  }

  public void stopIntake() {
    m_intake.set(0);
  } // TODO: stop intake (set power to 0)

  // this is only really called by drivers 
  public CommandBase stopIntakeCmd() {
    return runOnce(
        () -> {
          stopIntake();
        });
  }

  public void getGamePieceType() {
   // return gamePiece 
  }

  public void setGamePieceType(int gp) {
    gamePiece = gp;
  }

  public boolean hasCone() {
    // TODO: determine if intake has a cone because the current is high
    return false; //you must change this DO NOT KEEP IT THIS WAY
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
