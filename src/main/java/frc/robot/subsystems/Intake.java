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
  // TODO: ADD AND SET CAN ID(s)
  private final int intakeID = 6;

  // TODO: DECLARE MOTOR (CANSparkMax object)
  private CANSparkMax intakeMotor; 
  
  // set motor current limit
  private static final int INTAKE_CURRENT_LIMIT = 20;

  private int gamePiece = 0; // 0 for cubes, 1 for cones

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER

  public Intake() {
    // TODO: Initialize motor controller
    intakeMotor = new CANSparkMax(intakeID, MotorType.kBrushless);

    // TODO: set current limit
    intakeMotor.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);

    // TODO: set motor in brake mode so that the motor holds position even when not given a command
    intakeMotor.setIdleMode(IdleMode.kBrake);

    intakeMotor.setInverted(true);
  }

  // TODO: DEFINE & SET POWER TO HOLD CONE OR CUBE IN INTAKE
  // Cubes and cones are fed in from different directions so the roller drive direction will be
  // inverted
  public void setConeHoldPower() {
    intakeMotor.set(0.2);
  }

  public void setConeIntakePower() {
    intakeMotor.set(0.7);
  }

  public void setConeOuttakePower() {
    intakeMotor.set(-0.7);
  }

  public void setCubeHoldPower() {
    intakeMotor.set(0.0);
  }

  public void setCubeIntakePower() {
    intakeMotor.set(-0.5);
  }

  public void setCubeOuttakePower() {
    intakeMotor.set(0.5);
  }

  public void stopIntake() {
    intakeMotor.set(0.0);
  }

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
  public void setGamePieceType(int newGamePiece) {
    gamePiece = newGamePiece;
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
