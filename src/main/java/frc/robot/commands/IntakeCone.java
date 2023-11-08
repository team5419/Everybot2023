// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/** An example command that uses an example subsystem. */
public class IntakeCone extends CommandBase {
  private final Intake intake;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeCone(Intake intake) {
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // TODO: set game piece int to 1 for cone
    // TODO: apply cone intake power, which is inverted from cube intake power
    //       use appropriate function from Intake.java class (intake.set__Power)

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // TODO: reduce to a low holding power
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // TODO (low priority): use motor current to determine when game piece is secure
    return false;
  }
}
