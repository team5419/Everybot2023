// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.XboxController;

public class Intake extends SubsystemBase {
  // TODO: SET CAN ID
  private int intakeID = 0;

  // TODO: DECLARE MOTOR (CANSparkMax object)
  private CANSparkMax intakeMotor = new CANSparkMax(intakeID, MotorType.kBrushless);

  // set motor current limit
  private static final int INTAKE_CURRENT_LIMIT = 20;

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER

  // TODO: DEFINE INTAKE/OUTTAKE/HOLDING POWERS
  private double INTAKE_POWER;
  private double OUTTAKE_POWER;
  private double HOLDING_POWER;

  private XboxController mControl;

  public Intake() {
    // TODO: Initialize motor controller
    mControl = new XboxController(0);

    // TODO: set current limit
    intakeMotor.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);

    // TODO: set motor in brake mode so that the motor holds position even when not
    // given a command
    intakeMotor.setIdleMode(IdleMode.kBrake);

  }

  // This command requires the Intake subsystem
  public CommandBase setRollerPowerCommand(double power) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          // TODO: set intake power (reference the constant defined above)
          intakeMotor.set(power);
        });
  }

  // // TODO: SET POWER TO HOLD CONE OR CUBE IN INTAKE
  public void setHoldConePower(double power) {
    HOLDING_POWER = power;
  }

  public void setHoldCubePower(double power) {
    HOLDING_POWER = power;
  }

  public CommandBase startConeIntakeCommand() {
    // // TODO: set power based on constant defined above
    return setRollerPowerCommand(INTAKE_POWER);
  }

  public CommandBase startConeOuttakeCommand() {
    // // TODO: set power based on constant defined above
    return setRollerPowerCommand(OUTTAKE_POWER * (-1));
  }

  // // Cubes and cones are fed in from different directions so the roller drive
  // direction will be
  // // inverted
  public CommandBase startCubeIntakeCommand() {
    // TODO: set power based on constant defined above
    return setRollerPowerCommand(INTAKE_POWER * (-1));
  }

  public CommandBase startCubeOuttakeCommand() {
    // // TODO: set power based on constant defined above
    return setRollerPowerCommand(OUTTAKE_POWER);
  }

  public CommandBase stopIntakeCommand() {
    return setRollerPowerCommand(0);
  }

  // public boolean hasCone() {
  // // TODO: determine if intake has a cone because the current is high
  // return false;
  // }

  //public boolean hasCube() {
  // TODO: determine if intake has a cube because the current is high -- this
  //might be harder to
  // detect
  //
  //}

  // @Override
  // public void periodic() {
  // This method will be called once per scheduler run

  // }
}
