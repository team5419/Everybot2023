// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/** An example command that uses an example subsystem. */
public class OuttakePiece extends CommandBase {
  private final Intake intake;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public OuttakePiece(Intake intake) {
    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(this.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    int gamePiece = intake.getGamePieceType();
    if( gamePiece == 1 ) {
      intake.setConeOuttakePower();
    } else if( gamePiece == 0 ) {
      intake.setCubeOuttakePower();
    }
    // TODO: apply scoring power
    // TODO: apply power in + or - direction depending on intake.gamePiece int (0 cube, 1 cone)
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // TODO: reduce to a low holding power
    int gamePiece = intake.getGamePieceType();
    if( gamePiece == 1 ) {
      intake.setConeHoldPower();
    } else if( gamePiece == 0 ) {
      intake.setCubeHoldPower();
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // TODO (low priority): use motor current to determine when game piece is secure
    return false;
  }
}
