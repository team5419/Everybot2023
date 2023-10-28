// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

/** An example command that uses an example subsystem. */
public class ZeroArmPosition extends CommandBase {
  //private final Arm arm;

  public ZeroArmPosition(Arm arm) {
    //this.arm = arm;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: START MOVING THE ARM DOWN/BACKWARDS
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // TODO: DETECT WHEN THE ARM HAS BOTTOMED OUT AND START A COUNT
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // TODO: IF NOT INTERRUPTED -- ZERO THE ARM ENCODER AND TURN THE ARM MOTOR OFF
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // TODO: FINISHED WHEN THE COUNT HAS REACHED A CERTAIN THRESHOLD
    return false;
  }
}
