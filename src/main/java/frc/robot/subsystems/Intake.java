// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax.IdleMode;

public class Intake extends SubsystemBase {
  // SET CAN ID
  private final int IntakeID = 6;

  // DECLARE MOTOR (CANSparkMax object)
  private final CANSparkMax m_Intake;

  // set motor current limit
  private static final int INTAKE_CURRENT_LIMIT = 30;

  // TODO: DECLARE SHUFFLEBOARD ENTRIES FOR CURRENT WHEEL POWER

  // TODO: DEFINE INTAKE/OUTTAKE/HOLDING POWERS

  public Intake() {
    // Initialize motor controller
    m_Intake = new CANSparkMax(IntakeID, MotorType.kBrushless);

    // set current limit
    m_Intake.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);

    // set motor to brake mode
    m_Intake.setIdleMode(IdleMode.kBrake);
  }

  // This command requires the Intake subsystem
  public CommandBase setRollerPowerCommand(double power) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          // TODO: set intake power (reference the constant defined above)
        });
  }

  // // TODO: SET POWER TO HOLD CONE OR CUBE IN INTAKE
  // public void setHoldConePower() {}

  // public void setHoldCubePower() {}

  // public CommandBase startConeIntakeCommand() {
  //   // TODO: set power based on constant defined above
  //   return setRollerPowerCommand();
  // }

  // public CommandBase startConeOuttakeCommand() {
  //   // TODO: set power based on constant defined above
  //   return setRollerPowerCommand();
  // }

  // // Cubes and cones are fed in from different directions so the roller drive direction will be
  // // inverted
  public CommandBase startCubeIntakeCommand() {
    // TODO: set power based on constant defined above
    return setRollerPowerCommand(0);
  }

  // public CommandBase startCubeOuttakeCommand() {
  //   // TODO: set power based on constant defined above
  //   return setRollerPowerCommand();
  // }

  // public CommandBase stopIntakeCommand() {
  //   return setRollerPowerCommand(0);
  // }

  // public boolean hasCone() {
  //   // TODO: determine if intake has a cone because the current is high
  //   return false;
  // }

  // public boolean hasCube() {
  //   // TODO: determine if intake has a cube because the current is high -- this might be harder to
  //   // detect
  //   return false;
  // }

  // @Override
  // public void periodic() {
  //   // This method will be called once per scheduler run
  // }
}
