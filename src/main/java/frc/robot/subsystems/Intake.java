// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // TODO: SET CAN ID

  // TODO: DECLARE MOTOR (CANSparkMax object)

  // set motor current limit
  private static final int INTAKE_CURRENT_LIMIT = 20;

  private int gamePiece = 0; // 0 for cubes, 1 for cones

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER

  public Intake() {
    // TODO: Initialize motor controller

    // TODO: set current limit
    // m_Intake.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);

    // TODO: set motor in brake mode so that the motor holds position even when not given a command

  }

  // TODO: DEFINE & SET POWER TO HOLD CONE OR CUBE IN INTAKE
  // Cubes and cones are fed in from different directions so the roller drive direction will be
  // inverted
  public void setHoldConePower() {
    // intakeMotor.set(0.08) // or something
  }

  public void setConeIntakePower() {}

  public void setConeOuttakePower() {}

  public void setHoldCubePower() {}

  public void setCubeIntakePower() {}

  public void setCubeOuttakePower() {}

  public void stopIntake() {} // TODO: stop intake (set power to 0)

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
