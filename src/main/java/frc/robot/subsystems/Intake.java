// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class Intake extends SubsystemBase {
  // SET CAN ID
  private final int IntakeID = 6;
  // DECLARE MOTOR (CANSparkMax object)
  private final CANSparkMax m_Intake;
  // set motor current limit
  private static final int INTAKE_CURRENT_LIMIT = 30;

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER
  ShuffleboardTab intake = Shuffleboard.getTab("Current wheel power");
  // intake.addNumber("Current wheel power", () -> m_Intake.getWheelPower());

  // DEFINE INTAKE/OUTTAKE/HOLDING POWERS
  private double INTAKE_POWER = 0.1;
  private double OUTTAKE_POWER = 0.1;
  private double HOLDING_POWER = 0.1;
  private int gamePiece = 0; // 0 for cubes, 1 for cones

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER

  public Intake() {
    // Initialize motor controller
    m_Intake = new CANSparkMax(IntakeID, MotorType.kBrushless);
    // set current limit
    m_Intake.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);
    // set motor to brake mode
    m_Intake.setIdleMode(IdleMode.kBrake);
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
        if (m_Intake.getOutputCurrent() >= 10.0 /* dummy value */) {
      return true;
    }
    return false;
  }

  public boolean hasCube() {
    // TODO: determine if intake has a cube because the current is high -- this might be harder to
    // detect
        if (m_Intake.getOutputCurrent() >= 10.0 /* dummy value */) {
      return true;
    }
    return false;
  }

  // @Override
  // public void periodic() {
  //   // TODO: update shuffleboard entries
  // intake.addNumber("Current", () -> m_Intake.getOutputCurrent());
  // }
}
